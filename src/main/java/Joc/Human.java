package Joc;

public class Human extends Player{

  public Human(String name, int attackPoints, int defensePoints, int life) {
    super(name, attackPoints, defensePoints, life);
    System.out.println("Has creado un humano");

    if(life>100){
      super.setLife(100);
    }

  }
}
