package buch.quizkarte;

import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizKartenPlayer {
	
	private JTextArea anzeige;
	private ArrayList<buch.quizkarte.QuizKarte> kartenListe;
	private buch.quizkarte.QuizKarte aktuelleKarte;
	private int aktuelleKarteIndex;
	private JFrame frame;
	private JButton naechsteKarteButton;
	private boolean istAntwortAngezeigt;
	
	public static void main (String[] args) {
		QuizKartenPlayer reader = new QuizKartenPlayer();
		reader.los();
	}
	
	public void los() {
		
		//GUI aufbauen
		
		frame = new JFrame("Quizkarten-Player");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel hauptPanel = new JPanel();
		Font bigFont = new Font("sanserif", Font.BOLD, 24);
		
		anzeige = new JTextArea(10,20);
		anzeige.setFont(bigFont);
		
		anzeige.setLineWrap(true);
		anzeige.setEditable(false);
		
		JScrollPane fScroller = new JScrollPane(anzeige);
		fScroller.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		fScroller.setHorizontalScrollBarPolicy(
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		naechsteKarteButton = new JButton("Frage zeigen");
		hauptPanel.add(fScroller);
		hauptPanel.add(naechsteKarteButton);
		naechsteKarteButton.addActionListener(new NaechsteKarteListener());
		
		JMenuBar menueleiste = new JMenuBar();
		JMenu menueDatei = new JMenu("Datei");
		JMenuItem menuePunktLaden = new JMenuItem("Kartensatz laden");
		menuePunktLaden.addActionListener(new MenueOeffnenListener());
		menueDatei.add(menuePunktLaden);
		menueleiste.add(menueDatei);
		frame.setJMenuBar(menueleiste);
		frame.getContentPane().add(BorderLayout.CENTER, hauptPanel);
		frame.setSize(500,600);
		frame.setVisible(true); 
		
	} // los schliessen
	
	
	public class NaechsteKarteListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			if (istAntwortAngezeigt) {
				// die Antwort anzeigen, weil die Frage schon gezeigt wurde
				anzeige.setText(aktuelleKarte.getAntwort());
				naechsteKarteButton.setText("N�chste Karte");
				istAntwortAngezeigt = false;
			} else {
				// naechste Frage zeigen
				if (aktuelleKarteIndex < kartenListe.size()) {
					
					naechsteKarteZeigen();
					
				} else {
					// es gibt keine Karten mehr!
					anzeige.setText("Das war die letzte Karte.");
					naechsteKarteButton.setEnabled(false);
				}
			} 
		} 
	} 
	
	public class MenueOeffnenListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			JFileChooser dateioeffnen = new JFileChooser();
			dateioeffnen.showOpenDialog(frame);
			dateiLaden(dateioeffnen.getSelectedFile());
		}
	}
	
	private void dateiLaden(File datei) {
		
		kartenListe = new ArrayList<buch.quizkarte.QuizKarte>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(datei));
			String zeile = null;
			while ((zeile = reader.readLine()) != null) {
				karteErstellen(zeile);
			}
			reader.close();
			
		} catch(Exception ex) {
			System.out.println("konnte Kartendatei nicht lesen");
			ex.printStackTrace();
		}
		
		// Fangen wir an und zeigen die erste Karte:
		naechsteKarteZeigen();
	}
	
	private void karteErstellen(String zuParsendeZeile) {
		String[] ergebnis = zuParsendeZeile.split("/");
		buch.quizkarte.QuizKarte karte = new buch.quizkarte.QuizKarte(ergebnis[0], ergebnis[1]);
		kartenListe.add(karte);
		System.out.println("Karte erstellt");
	}
	
	private void naechsteKarteZeigen() {
		aktuelleKarte = kartenListe.get(aktuelleKarteIndex);
		aktuelleKarteIndex++;
		anzeige.setText(aktuelleKarte.getFrage());
		naechsteKarteButton.setText("Antwort zeigen");
		istAntwortAngezeigt = true;
	}
} // Klasse schliessen




