package buch.quizkarte;

import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizKartenAutor {
	
	private JTextArea frage;
	private JTextArea antwort;
	private ArrayList<buch.quizkarte.QuizKarte> kartenListe;
	private JFrame frame;
	
	public static void main (String[] args) {
		QuizKartenAutor editor = new QuizKartenAutor();
		editor.los();
	}
	
	public void los() {
		// GUI erstellen
		frame = new JFrame("Quizkarten-Autor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		JPanel mainPanel = new JPanel();
		Font bigFont = new Font("sanserif", Font.BOLD, 24);
		frage = new JTextArea(6,20);
		frage.setLineWrap(true);
		frage.setWrapStyleWord(true);
		frage.setFont(bigFont);
		
		JScrollPane fScroller = new JScrollPane(frage);
		fScroller.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		fScroller.setHorizontalScrollBarPolicy(
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		antwort = new JTextArea(6,20);
		antwort.setLineWrap(true);
		antwort.setWrapStyleWord(true);
		antwort.setFont(bigFont);
		
		JScrollPane aScroller = new JScrollPane(antwort);
		aScroller.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aScroller.setHorizontalScrollBarPolicy(
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton naechsteKarteButton = new JButton("N�chste Karte");
		kartenListe = new ArrayList<buch.quizkarte.QuizKarte>();
		JLabel fLabel = new JLabel("Die Frage lautet:");
		JLabel aLabel = new JLabel("Die Antwort lautet:");
		
		mainPanel.add(fLabel);
		mainPanel.add(fScroller);
		mainPanel.add(aLabel);
		mainPanel.add(aScroller);
		mainPanel.add(naechsteKarteButton);
		naechsteKarteButton.addActionListener(new NaechsteKarteListener());
		JMenuBar menueleiste = new JMenuBar();
		JMenu menueDatei = new JMenu("Datei");
		JMenuItem menuePunktNeu = new JMenuItem("Neu");
		
		JMenuItem menuePunktSpeichern = new JMenuItem("Speichern");
		menuePunktNeu.addActionListener(new MenueNeuListener());
		menuePunktSpeichern.addActionListener(new MenueSpeichernListener());
		
		menueDatei.add(menuePunktNeu);
		menueDatei.add(menuePunktSpeichern);
		menueleiste.add(menueDatei);
		frame.setJMenuBar(menueleiste);
		
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(500,600);
		frame.setVisible(true);        
	}
	
	
	public class NaechsteKarteListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			QuizKarte karte = new QuizKarte(frage.getText(), antwort.getText());
			kartenListe.add(karte);
			karteAbraeumen();
			
		}
	}
	
	public class MenueSpeichernListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			QuizKarte karte = new QuizKarte(frage.getText(), antwort.getText());
			kartenListe.add(karte);
			
			JFileChooser dateiWahl = new JFileChooser();
			dateiWahl.showSaveDialog(frame);
			dateiSpeichern(dateiWahl.getSelectedFile());
		}
	}
	
	public class MenueNeuListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			kartenListe.clear();
			karteAbraeumen();           
		}
	}
	
	
	private void karteAbraeumen() {
		frage.setText("");
		antwort.setText("");
		frage.requestFocus();
	}
	
	private void dateiSpeichern(File datei) {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(datei));
//			Iterator kartenIterator = kartenListe.iterator();
//			while (kartenIterator.hasNext()) {
//			QuizKarte karte = (QuizKarte) kartenIterator.next();
//			writer.write(karte.getFrage() + "/");
//			writer.write(karte.getAntwort() + "\n");
//			} TODO: Dies war die Fassung im Internet, im Buch wurde die
//			neue foreach-Schleife verwendet:
			
			for (QuizKarte karte:kartenListe) {
				writer.write(karte.getFrage() + "/");
				writer.write(karte.getAntwort() + "\n");
			}
			writer.close();
			
			
		} catch(IOException ex) {
			System.out.println("konnte die kartenliste nicht schreiben");
			ex.printStackTrace();
		}
		
	} // Methode schlie�en
}




