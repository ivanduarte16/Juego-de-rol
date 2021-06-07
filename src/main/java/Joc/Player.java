package Joc;

import io.Leer;

import java.util.ArrayList;

//Atributos
public abstract class Player {
  private String name;
  private int attackPoints;
  private int defensePoints;
  private int life;
  private ArrayList<Team> teams;
  private  ArrayList<Item> items;

  public Player(String name, int attackPoints, int defensePoints, int life) {
    this.setName(name);
    this.setAttackPoints(attackPoints);
    this.setDefensePoints(defensePoints);
    this.setLife(life);
    teams = new ArrayList<>();
    items = new ArrayList<>();
  }

  /**
   * Metodo para añadir un jugador a un equipo
   * @param t es el equipo que le pasamos
   */
  public void add (Team t) throws JugadoresRepetidos{

    if(this.teams.contains(t)){
      throw new JugadoresRepetidos("Error, jugador repetido");
    }
    this.teams.add(t);
    if(!t.getMembers().contains(this)){
      t.add(this);
      System.out.println("Se ha añadido correctamente el jugador al equipo");
    }
  }

  public ArrayList<Item> getItems() {
    return items;
  }

  public String getName() {
    return name;
  }

  public int getAttackPoints() {
    return attackPoints;
  }

  public int getDefensePoints() {
    return defensePoints;
  }

  public int getLife() {
    return life;
  }

  /**
   * Metodo que se usará para que un jugador ataque a otro
   * @param B jugador al que queremos atacar
   */
  public void attack(Player B) throws JugadorMuerto, AtacarAsiMismo {
    if (this.getLife()<=0 || B.getLife()<=0){
      throw new JugadorMuerto("Este jugador la ha palmao");
    }
    if (this.equals(B)){
      throw new AtacarAsiMismo("Este jugador no puede atacarse a si mismo");
    }
    System.out.println("ANTES DEL ATAQUE :");
    System.out.println("Atacant: "+this);
    System.out.println("Atacat: "+B);
    System.out.println();
    System.out.println("DURANTE EL ATAQUE");
    int ataque = this.getAttackPoints();
    for (Item i : this.items){
      ataque+=i.getAttackBonus();
    }
    B.hit(ataque);
    if (B.getLife()>0){
      int ataqueB = B.getAttackPoints();
      for (Item i : B.items){
        ataqueB+=i.getAttackBonus();
      }
      this.hit(ataqueB);
    }
    System.out.println();
    System.out.println("DESPUES DEL ATAQUE");
    System.out.println("Atacant: "+this);
    System.out.println("Atacat: "+B);
  }

  /**
   * Metodo que se utilizara para calcular los puntos de ataque, la defensa, y la vida durante la pelea
   * @param attackPoints puntos de ataque del jugador
   */
  protected void  hit(int attackPoints){
    int defensa = this.getDefensePoints();
    for (Item i: this.items){
      defensa+= i.getDefenseBonus();
    }
    int ataque = attackPoints - defensa;
    if (ataque<0){
      ataque = 0;
    }
    int vida = this.getLife()-ataque;
    if(vida<=0){
      System.out.print("El jugador "+this.getName()+" ha muerto");
      this.setLife(0);
      System.out.println();
    } else {
      System.out.println(this.getName() + " es golpeado con "+ attackPoints+ " puntos y se defiende con "+defensa+". Vida: "+this.life+ " - " + ataque+" = "+vida);
      this.setLife(vida);
    }
  }

  /**
   * Metodo para asignarle un item a un jugador
   * @param i objeto que queremos asignar
   */
  public void addItem(Item i){
    this.items.add(i);
  }

  /**
   * Metodo para eliminar un objeto de un jugador
   * @param i objeto que queremos eliminar
   */
  public void removeItem(Item i){
    this.items.remove(i);
  }

  /**
   * Metodo para eliminar un jugador de un equipo
   * @param t equipo del que queremos eliminar el jugador
   * @throws EquipoJugador exepcion para comprobar si el jugador esta en ese equipo
   */
  public void remove (Team t) throws EquipoJugador {
    if(!t.getPlayers().contains(this)){
      throw new EquipoJugador("Este jugador no esta en el equipo");
    }
    teams.remove(t);
    if(t.getPlayers().contains(this)){
      t.remove(this);
    }
  }

  public void setLife(int life) {
    this.life = life;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAttackPoints(int attackPoints) {
    this.attackPoints = attackPoints;
  }

  public void setDefensePoints(int defensePoints) {
    this.defensePoints = defensePoints;
  }

  public ArrayList<Team> getTeams() {
    return teams;
  }

  @Override
  public String toString() {
    String cadena = "";
    for (Item t : this.items){
      cadena+=" "+t+"\n";
    }
    return  name + " / PA:" + attackPoints + " / PD:" + defensePoints + " / PV:" + life + " ( pertenece a "+teams.size()+" equipos )"+" tiene los items: "+"\n"+cadena;
  }

}
