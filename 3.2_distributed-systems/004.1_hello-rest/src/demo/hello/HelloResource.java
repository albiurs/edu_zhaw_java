/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
package demo.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {
	public HelloResource() {
	}
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getPlainMessage() {
		return "Hello World!";
	}
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHtmlMessage() {
		return "<html><body><h1>Hello World!<h1></body></html>";
	}
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String getXmlMessage() {
		return "<?xml version=\"1.0\"?><hello>Hello World!</hello>";
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getJsonMessage() {
		return "{\"message\":\"Hello World!\"}";
	} 
}
