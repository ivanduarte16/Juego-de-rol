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
    return  name + " / PA:" + attackPoints + " / PD:" + defensePoints + " / PV:" + life;
  }

  public void attack(Player B){
    System.out.println();
    System.out.println("ANTES DEL ATAQUE");
    System.out.println("Atacant: "+this);
    System.out.println("Atacat: "+B);
    System.out.println();
    System.out.println("DURANTE EL ATAQUE");
    B.hit(this.getAttackPoints());

    if (B.getLife()>0){
      this.hit(B.getAttackPoints());
    }

    System.out.println();
    System.out.println("Atacant: "+this);
    System.out.println("Atacat: "+B);
    System.out.println();
  }

  protected void  hit(int attackPoints){
    int ataque = attackPoints - this.getDefensePoints();
    int vida = this.getLife()-ataque;
    if(vida<=0){
      System.out.print("El jugador ha muerto");
      this.life=0;
    } else {
      System.out.println(this.getName() + " es golpeado con "+ attackPoints+ " puntos y se defiende con "+this.getDefensePoints()+". Vida: "+vida);
      this.life=vida;
    }
  }
}
