package Joc;

/**
 * Exception para comprobar que un jugador muerto no pueda ser atacado
 */
public class JugadorMuerto extends Exception{
  public JugadorMuerto(String message) {
    super(message);
  }
}
