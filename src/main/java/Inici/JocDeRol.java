package Inici;

import Joc.Alien;
import Joc.Human;
import Joc.Player;
import Joc.Warrior;

public class JocDeRol {
  public static void main(String[] args) {

    Human humano1 = new Human("Humano1",60,60,700);
    Alien Alien1 = new Alien("Ete",100,50,400);
    Warrior guerrero1 = new Warrior("Hercules",80,100,500);
    Alien1.attack(humano1);
    guerrero1.attack(Alien1);
    humano1.attack(guerrero1);

  }
  public void provaFase(){

  }
}
