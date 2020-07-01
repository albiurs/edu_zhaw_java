package lektion09.rollenspiel.waffen;

public class Schwert extends HandWaffe {
  
  private static final int ANGRIFFSWERT = 7;
  private static final int VERTEIDIGUNGSWERT = 4;
  
  public Schwert() {
    super(ANGRIFFSWERT, VERTEIDIGUNGSWERT);
  }

}
