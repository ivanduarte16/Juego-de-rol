package Joc;

/**
 * Exception oara comprobrar si hay jugadores repetidos en n equipo
 */
public class JugadoresRepetidos extends Exception{
  public JugadoresRepetidos(String message) {
    super(message);
  }
}
