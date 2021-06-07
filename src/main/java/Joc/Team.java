package Joc;

import java.util.ArrayList;

public class Team {
  private String name;
  private ArrayList<Player> players;

  public Team(String name) {
    this.setName(name);
    players = new ArrayList<>();
  }

  public void add(Player p) throws JugadoresRepetidos{
    if (this.players.contains(p)){
      throw new JugadoresRepetidos("Error, jugador repetido");
    }
    players.add(p);
    if (!p.getTeams().contains(this)) {
      p.add(this);
    }
  }

  public ArrayList<Player> getPlayers() {
    return players;
  }

  public void remove(Player p) throws EquipoJugador {
    if (!p.getTeams().contains(this)) {
      throw new EquipoJugador("Este jugador no esta en el equipo");
    }
    players.remove(p);
    if (p.getTeams().contains(this)) {
      p.remove(this);
    }
  }

  public boolean equals(Team t) {
    if (this.getName().compareTo(t.getName()) == 0 && this.players == t.players){
      return true;
    }
    return false;
  }

  public ArrayList<Player> getMembers() {
    return players;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    String cadena = "";
    for (Player p : players) {
      cadena += "   " + p + "\n";
    }
    return "Equipo " + name + " \n" + cadena;
  }
}
