package Joc;

/**
 * Constructor de la clase Warrior
 */
public class Warrior extends Human{
  public Warrior(String name, int attackPoints, int defensePoints, int life) {
    super(name, attackPoints, defensePoints, life);
    super.setLife(life);
    System.out.println("He creado un guerrero");
  }

  @Override
  /**
   * Metodo que se utilizara para calcular los puntos de ataque, la defensa, y la vida durante la pelea
   * @param attackPoints puntos de ataque del jugador
   */
  protected void  hit(int attackPoints){
    int defensa = this.getDefensePoints();
    for (Item i: this.getItems()){
      defensa+= i.getDefenseBonus();
    }
    int ataque = attackPoints - defensa;
    if(ataque<5){
      System.out.print("El Guerrero reduce el daño a 0. ");
      ataque=0;
    }
    int vida = this.getLife()-ataque;
    if(vida<=0){
      System.out.print("El jugador "+this.getName()+ " ha muerto");
      this.setLife(0);
      System.out.println();
    } else {
      System.out.println(this.getName() + " es golpeado con "+ attackPoints+ " puntos y se defiende con "+this.getDefensePoints()+". Vida: "+this.getLife()+ " - " + ataque+" = "+vida);
      this.setLife(vida);
    }
  }
}
