package lektion09.rollenspiel.waffen;

public class Waffe {

  private int angriffswert;
  
  public Waffe(int angriffswert) {
    this.angriffswert = angriffswert;
  }

  public int getAngriffswert() {
    return angriffswert;
  }
  
  /**
   * Gibt den Kampfwert zuruek.
   * @return den Kampfwert.
   */
  public int getKampfwert() {
    return angriffswert;
  }

}
