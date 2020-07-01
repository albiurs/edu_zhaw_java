package lektion09.rollenspiel.spielfiguren;

import java.util.ArrayList;
import java.util.Random;

import lektion09.rollenspiel.gegenstaende.Gegenstand;
import lektion09.rollenspiel.waffen.Keule;
import lektion09.rollenspiel.waffen.Waffe;


public class Spielfigur {

  private String name;

  private Waffe waffe;

  private double lebenspunkte;

  private int tragkraft;

  private ArrayList<Gegenstand> gegenstaende;

  public Spielfigur(String name) {
    this.name = name;
    this.waffe = new Keule();
    this.lebenspunkte = 100;
  }

  /**
   * Gibt den Kampfwert der aktuellen Waffe zurueck.
   * Der Kampfwert der Waffe wird mit einer Random-Nr. zwischen
   * 0.9 und 1.1 multipliziert.
   * 
   * @return der Kampfwert
   */
  public double getKampfwert() {
    double faktor = (new Random().nextDouble() / 5) + 0.9;
    int waffenKampfwert = waffe.getKampfwert();
    return waffenKampfwert * faktor;
  }
  
  /**
   * Ersetzt die aktive Waffe durch eine neue.
   * @param waffe die Waffe
   */
  public void waffeAufheben(Waffe waffe) {
    this.waffe = waffe;
  }

  /**
   * Nimmt ein Gegenstand auf, jedoch nur, wenn noch genuegend Tragkraft vorhanden ist. 
   * Wird ein Gegenstand aufgenommen, wird die Tragkraft entsprechend reduziert und 
   * <code>true</code> zurueckgegeben. Ist der Gegenstand zu schwer fuer die
   * verbleibende Tragkraft, so wird <code>false</code> zurueckgegeben. 
   * 
   * @param gegenstand der Gegenstand, der aufgenommen werden soll.
   * @return <code>true</code> wenn der Gegenstand aufgenommen wurde, 
   * sonst <code>false</code>.
   */
  public boolean nehmeGegenstand(Gegenstand gegenstand) {
    if (tragkraft > gegenstand.getGewicht()) {
      tragkraft -= gegenstand.getGewicht();
      gegenstaende.add(gegenstand);
      return true;
    }
    return false;
  }
  
  /**
   * Laesst diese Spielfigur gegen eine andere Spielfigur kaempfen.
   * 
   * Gekaempft wird in Runden. Es wird solange gekaempft, bis eine oder beide
   * Spielfiguren keine Lebenspunkte mehr haben. Steht nach 20 Runden noch kein Sieger
   * fest, wird der Kampf abgebrochen.
   * 
   * Bei jeder Runde wird der Kampfwert der einen Spielfigur den Lebenspunkten 
   * des Gegners abgezogen und umgekehrt.
   * 
   * Diejenige Spielfigur mit den meisten verbliebenen Lebenspunkten gewinnt.
   * 
   * @param gegner die andere Spielfigur
   * @return <code>true</code>, falls der Kampf gewonnen wird, sonst <code>false</code>.
   */
  public boolean kaempfeGegen(Spielfigur gegner) {
    
    int runde = 0;
    
    while (getLebenspunkte() > 0 && gegner.getLebenspunkte() > 0 && runde < 20) {
      setLebenspunkte(getLebenspunkte() - gegner.getKampfwert()); 
      gegner.setLebenspunkte(gegner.getLebenspunkte() - getKampfwert());
      runde++;
    }
    
    return getLebenspunkte() > gegner.getLebenspunkte();
  }
  
  public double getLebenspunkte() {
    return lebenspunkte;
  }
  
  private void setLebenspunkte(double lebenspunkte) {
    this.lebenspunkte = lebenspunkte;
  }
}
