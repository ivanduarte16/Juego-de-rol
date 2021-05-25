package Inici;

import Joc.*;

public class JocDeRol {
  public static void main(String[] args) {

    provaFase();

  }

  public static void provaFase() {


    Human humano1 = new Human("Cubanito", 110, 60, 500);
    Alien Alien1 = new Alien("Rubix", 200, 50, 400);
    Warrior guerrero1 = new Warrior("Domi", 120, 100, 500);

    Team Membrillos = new Team("Membrillos");
    Item Espada = new Item("Espada", 100, 20);
    Item Escudo = new Item("Escudo", 20, 100);
    Item Palo = new Item("Palo", 70, 70);

    humano1.addItem(Palo);
    humano1.addItem(Espada);
    humano1.addItem(Escudo);
    guerrero1.addItem(Escudo);
    Alien1.addItem(Palo);

    Alien1.attack(humano1);
    guerrero1.attack(Alien1);
    humano1.attack(guerrero1);

    guerrero1.add(Membrillos);
    humano1.add(Membrillos);
    System.out.println(Membrillos);

    Team Xancleta = new Team("Xancleta");
    Alien1.add(Xancleta);
    humano1.add(Xancleta);

    System.out.println(Xancleta);
  }
}
