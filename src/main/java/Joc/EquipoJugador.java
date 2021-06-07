package Joc;

/**
 * Exception para comprobar si un jugador no esta en un equipo
 */
public class EquipoJugador extends Exception{
  public EquipoJugador(String message) {
    super(message);
  }
}
