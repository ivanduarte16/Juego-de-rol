package Joc;

/**
 * Exceotion oara comprobar si un jugador se ataca a si mismo
 */
public class AtacarAsiMismo extends Exception{
  public AtacarAsiMismo(String message) {
    super(message);
  }
}
