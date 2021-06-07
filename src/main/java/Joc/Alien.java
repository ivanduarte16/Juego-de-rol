package Joc;

/**
 * Constructor de alien
 */
public class Alien extends Player{
  public Alien(String name, int attackPoints, int defensePoints, int life) {
    super(name, attackPoints, defensePoints, life);
    System.out.println("Has creado alien");
  }
  /**
   * Metodo que se usará para que un jugador ataque a otro
   * @param B jugador al que queremos atacar
   */
  public void attack(Player B) throws JugadorMuerto, AtacarAsiMismo {
    if (this.getLife()==0 || B.getLife()==0){
      throw new JugadorMuerto("Este jugador la ha palmao");
    }
    if (this.equals(B)){
      throw new AtacarAsiMismo("Este pibe no puede atacarse a si mismo");
    }
    System.out.println();
    System.out.println("ANTES DEL ATAQUE");
    System.out.println("Atacant: "+this);
    System.out.println("Atacat: "+B);
    System.out.println();
    System.out.println("DURANTE EL ATAQUE");
    if (this.getLife()>20){
      this.setAttackPoints(this.getAttackPoints()+3);
      this.setDefensePoints(this.getDefensePoints()-3);
    }
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

}
