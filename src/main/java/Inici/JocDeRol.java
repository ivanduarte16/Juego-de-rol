package Inici;

import Joc.*;

public class JocDeRol {
  public static void main(String[] args) {

    provaFase();

  }
  public static void provaFase(){
    Human humano1 = new Human("Cubanito",60,60,500);
    Alien Alien1 = new Alien("Rubix",100,50,400);
    Warrior guerrero1 = new Warrior("Domi",80,100,500);
    Alien1.attack(humano1);
    guerrero1.attack(Alien1);
    humano1.attack(guerrero1);

    Team Membrillos = new Team("Membrillos");
    guerrero1.add(Membrillos);
    humano1.add(Membrillos);
    System.out.println(Membrillos);
    System.out.println();
    Team Xancleta = new Team("Xancleta");
    Alien1.add(Xancleta);
    humano1.add(Xancleta);
    System.out.println(Xancleta);
  }
}
