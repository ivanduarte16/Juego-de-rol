package Joc;

public class Human extends Player{

  /**
   * Constructor de la Humano
   * @param name nombre del humano
   * @param attackPoints puntos de ataques
   * @param defensePoints puntos de defensa
   * @param life puntos de vida
   */
  public Human(String name, int attackPoints, int defensePoints, int life) {
    super(name, attackPoints, defensePoints, life);
    System.out.println("Has creado un humano");
    if(life>100){
      super.setLife(100);
    }
  }
}
