package Joc;

import java.util.ArrayList;

//Atributos
public abstract class Player {
  private String name;
  private int attackPoints;
  private int defensePoints;
  private int life;
  private ArrayList<Team> teams;

  //Constructor
  public Player(String name, int attackPoints, int defensePoints, int life) {
    this.setName(name);
    this.setAttackPoints(attackPoints);
    this.setDefensePoints(defensePoints);
    this.setLife(life);
    teams = new ArrayList<>();
  }

  public void add (Team t){
    this.getTeams().add(t);
    if(!t.getPlayers().contains(this)){
      t.add(this);
    }
  }

  public void remove (Team t){
    teams.remove(t);
    if(t.getPlayers().contains(this)){
      t.remove(this);
    }
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

  @Override
  public String toString() {
    return  name + " / PA:" + attackPoints + " / PD:" + defensePoints + " / PV:" + life + " ( pertenece a "+teams.size()+" equipos )";
  }

  public void attack(Player B){
    System.out.println("ANTES DEL ATAQUE :");
    System.out.println("Atacant: "+this);
    System.out.println("Atacat: "+B);
    System.out.println();
    System.out.println("DURANTE EL ATAQUE");
    B.hit(this.getAttackPoints());
    if (B.getLife()>0){
      this.hit(B.getAttackPoints());
    }
    System.out.println();
    System.out.println("DESPUES DEL ATAQUE");
    System.out.println("Atacant: "+this);
    System.out.println("Atacat: "+B);
    System.out.println();
  }

  protected void  hit(int attackPoints){
    int ataque = attackPoints - this.getDefensePoints();
    int vida = this.getLife()-ataque;
    if(vida<=0){
      System.out.print("El jugador ha muerto");
      this.setLife(0);
    } else {
      System.out.println(this.getName() + " es golpeado con "+ attackPoints+ " puntos y se defiende con "+this.getDefensePoints()+". Vida: "+this.life+ " - " + ataque+" = "+vida);
      this.setLife(vida);
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
}
