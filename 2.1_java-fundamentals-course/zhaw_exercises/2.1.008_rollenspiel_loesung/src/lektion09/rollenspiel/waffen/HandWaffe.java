package lektion09.rollenspiel.waffen;

public class HandWaffe extends Waffe {

  private int verteidungswert;

  public HandWaffe(int angriffswert, int verteidigungswert) {
    super(angriffswert);
    this.verteidungswert = verteidigungswert;
  }

  public int getVerteidigunswert() {
    return verteidungswert;
  }
  
  public int getKampfwert() {
    return super.getKampfwert() + (verteidungswert/2);
  }
}
