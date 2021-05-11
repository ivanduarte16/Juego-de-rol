package Joc;

//Atributos
public abstract class Player {
  private String name;
  private int attackPoints;
  private int defensePoints;
  private int life;

  //Constructor
  public Player(String name, int attackPoints, int defensePoints, int life) {
    this.name = name;
    this.attackPoints = attackPoints;
    this.defensePoints = defensePoints;
    this.life = life;
  }
}
