/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
package ch.zhaw.soe.eicw.webserver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.concurrent.Executors;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.TrustManagerFactory;

import com.sun.net.httpserver.*;

public class SimpleWebserver {
	private static final String LOG_FILE = "http.log";
	private HttpsServer server;

	public SimpleWebserver(File root, int port, boolean log) throws IOException {
		char[] storepass = "secret".toCharArray();
		char[] keypass = "secret".toCharArray();

		try {
			// load certificate
			URL certURL = this.getClass().getClassLoader().getResource("keystore.jks");
			InputStream fIn = certURL.openStream();
			KeyStore keystore = KeyStore.getInstance("JKS");
			keystore.load(fIn, storepass);

			// display certificate
			// Certificate cert = keystore.getCertificate("demo");
			// System.out.println(cert);

			// setup the key manager factory
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			kmf.init(keystore, keypass);

			// setup the trust manager factory
			TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
			tmf.init(keystore);

			// create https server
			server = HttpsServer.create(new InetSocketAddress(port), 0);
			// create ssl context
			SSLContext sslContext = SSLContext.getInstance("TLS");

			// setup the HTTPS context and parameters
			sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
			server.setHttpsConfigurator(new HttpsConfigurator(sslContext) {
				public void configure(HttpsParameters params) {
					try {
						// initialise the SSL context
						SSLContext c = SSLContext.getDefault();
						SSLEngine engine = c.createSSLEngine();
						params.setNeedClientAuth(false);
						params.setCipherSuites(engine.getEnabledCipherSuites());
						params.setProtocols(engine.getEnabledProtocols());

						// get the default parameters
						SSLParameters defaultSSLParameters = c.getDefaultSSLParameters();
						params.setSSLParameters(defaultSSLParameters);
					} catch (Exception ex) {
						ex.printStackTrace();
						System.out.println("Failed to create HTTPS server");
					}
				}
			});

			HttpContext context = server.createContext("/", new SimpleHttpHandler(root, log));
			server.setExecutor(Executors.newCachedThreadPool());
			context.setAuthenticator(new BasicAuthenticator("secure") {
				@Override
				public boolean checkCredentials(String user, String pwd) {
					return user.equals("secret") && pwd.equals("secret");
				}
			});

		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}

		if (log)
			HttpLog.initializeLogger(new File(LOG_FILE));

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				shutdown();
			}
		});
	}

	public void start() {
		if (server != null)
			server.start();
	}

	public void shutdown() {
		if (server != null) {
			server.stop(0);
		}

		if (HttpLog.logger != null) {
			HttpLog.logger.close();
		}
	}
}
