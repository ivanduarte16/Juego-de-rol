package Joc;

public class Warrior extends Human{
  public Warrior(String name, int attackPoints, int defensePoints, int life) {
    super(name, attackPoints, defensePoints, life);
    System.out.println("He creado un guerrero");
  }

  @Override
  protected void  hit(int attackPoints){
    int ataque = attackPoints - this.getDefensePoints();
    if(ataque<5){
      System.out.print("El Guerrero reduce el daño a 0");
      ataque=0;
    }
    int vida = this.getLife()-ataque;

    if(vida<=0){
      System.out.print("El jugador ha muerto");
      this.setLife(0);
    } else {
      System.out.println(this.getName() + " es golpeado con "+ attackPoints+ " puntos y se defiende con "+this.getDefensePoints()+". Vida: "+vida+ " - " + ataque+" = "+vida);
      this.setLife(vida);
    }

  }
}
