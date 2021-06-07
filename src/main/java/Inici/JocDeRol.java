package Inici;

import Joc.Alien;
import Joc.AtacarAsiMismo;
import Joc.EquipoJugador;
import Joc.Human;
import Joc.Item;
import Joc.JugadorMuerto;
import Joc.JugadoresRepetidos;
import Joc.Player;
import Joc.Team;
import Joc.Warrior;
import io.Leer;

import java.util.ArrayList;

public class JocDeRol {

  private static ArrayList<Player> players = new ArrayList<>();
  private static ArrayList<Team> teams = new ArrayList<>();
  private static ArrayList<Item> items = new ArrayList<>();

  /**
   * Programa principal, donde se encuentra el menu
   * @param args
   */
  public static void main(String[] args) {

    Boolean principal = true;

    do {
//      Human bot1 = new Human("bot1", 10, 2, 100);
//      players.add(bot1);
//      Alien bot2 = new Alien("bot2", 25, 10, 100);
//      players.add(bot2);
//      Warrior bot3 = new Warrior("bot3", 35, 7, 100);
//      players.add(bot3);

      Boolean configuracion = true;
      Boolean jugar = true;
      System.out.println();
      System.out.println("JUEGO DE ROL" + "\n");
      System.out.println("1. Configuracion");
      System.out.println("2. Jugar");
      System.out.println("3. Salir" + "\n");
      int respuestaprincpal = Leer.leerEntero("Eliga una opcion: ");
      ClearConsole();
      switch (respuestaprincpal) {
        case 1:
          do {
            Boolean gjugadores = true;
            Boolean gequipos = true;
            Boolean gobjetos = true;
            System.out.println();
            System.out.println("CONFIGURACION" + "\n");
            System.out.println("1. Gestion jugadores");
            System.out.println("2. Gestion equipos");
            System.out.println("3. Gestion objetos");
            System.out.println("4. Sallir" + "\n");
            int respuestaconfiguracion = Leer.leerEntero("Que opcion eliges: ");
            ClearConsole();
            switch (respuestaconfiguracion) {
              case 1:
                do {
                  Boolean creacionjugadores = true;
                  System.out.println();
                  System.out.println("GESTION JUGADORES" + "\n");
                  System.out.println("1. Crear jugadores");
                  System.out.println("2. Mostrar jugadores");
                  System.out.println("3. Borrar jugadores");
                  System.out.println("4. Asignar un jugador a un equipo");
                  System.out.println("5. Asignar un objeto a un jugador");
                  System.out.println("6. Salir" + "\n");
                  int respuestagjugadores = Leer.leerEntero("Que opcion eliges?: ");
                  ClearConsole();
                  switch (respuestagjugadores) {
                    case 1:
                      do {
                        System.out.println();
                        System.out.println("CREACION DE JUGADORES" + "\n");
                        System.out.println("1. Humano");
                        System.out.println("2. Warrior");
                        System.out.println("3. Alien");
                        System.out.println("4. Sallir");
                        System.out.println();
                        int respuestacjugadores = Leer.leerEntero("Dime la opcion que desea: ");
                        ClearConsole();
                        switch (respuestacjugadores) {
                          case 1:
                            Human Humano1 = new Human(Leer.leerTexto("Dime el nombre: "), Leer.leerEntero("Dime los puntos de ataque: "), Leer.leerEntero("Dime los punto de defensa: "), Leer.leerEntero("Dime los puntos de vida: "));
                            players.add(Humano1);
                            break;
                          case 2:
                            Warrior Guerrero1 = new Warrior(Leer.leerTexto("Dime el nombre: "), Leer.leerEntero("Dime los puntos de ataque: "), Leer.leerEntero("Dime los punto de defensa: "), Leer.leerEntero("Dime los puntos de vida: "));
                            players.add(Guerrero1);
                            break;
                          case 3:
                            Alien Alien1 = new Alien(Leer.leerTexto("Dime el nombre: "), Leer.leerEntero("Dime los puntos de ataque: "), Leer.leerEntero("Dime los punto de defensa: "), Leer.leerEntero("Dime los puntos de vida: "));
                            players.add(Alien1);
                            break;
                          case 4:
                            creacionjugadores = false;
                            break;
                          default:
                            System.out.println("Opcion incorrecta");
                        }
                      } while (creacionjugadores);
                      break;
                    case 2:
                      System.out.println();
                      for (Player p : players) {
                        System.out.println(p);
                      }
                      break;
                    case 3:
                      for (Player p : players) {
                        System.out.println(p.getName());
                      }
                      String nomJugador = Leer.leerTexto("Que jugador desea eliminar?: ");
                      Player one = buscar(nomJugador);
                      players.remove(one);
                      System.out.println();
                      for (Team te : teams) {
                        if (te.getMembers().contains(one)) {
                          try {
                            te.remove(one);
                          } catch (EquipoJugador equipoJugador) {
                            equipoJugador.printStackTrace();
                          }
                        }
                      }
                      break;
                    case 4:
                      for (Player p : players) {
                        System.out.println(p.getName());
                      }
                      nomJugador = Leer.leerTexto("Que jugador desea asignar a un equipo?: ");
                      Player two = buscar(nomJugador);
                      System.out.println();
                      for (Team te : teams) {
                        System.out.println(te.getName());
                      }
                      System.out.println();
                      String equipo = Leer.leerTexto("A que equipo desea asignarlo?: ");
                      System.out.println();
                      Team tres = buscarT(equipo);
                      System.out.println();
                      try {
                        two.add(tres);
                      } catch (JugadoresRepetidos jugadoresRepetidos) {
                        jugadoresRepetidos.printStackTrace();
                      }
                      break;
                    case 5:
                      for (Player p : players) {
                        System.out.println(p.getName());
                      }
                      System.out.println();
                      nomJugador = Leer.leerTexto("Que jugador desea asignar a un item?: ");
                      Player cuatro = buscar(nomJugador);
                      System.out.println();
                      for (Item ite : items) {
                        System.out.println(ite.getName());
                      }
                      System.out.println();
                      String item = Leer.leerTexto("Que item desea asignar?: ");
                      Item uno = buscarI(item);
                      cuatro.addItem(uno);
                      System.out.println();
                      break;
                    case 6:
                      gjugadores = false;
                      break;
                    default:
                      System.out.println("Opcion incorrecta");
                  }
                } while (gjugadores);
                break;
              case 2:
                do {
                  System.out.println("GESTION DE EQUIPOS");
                  System.out.println();
                  System.out.println("1. Crear equipo");
                  System.out.println("2. Mostrar equipos");
                  System.out.println("3. Borrar equipo");
                  System.out.println("4. Asignar ");
                  System.out.println("5. Salir");
                  System.out.println();
                  int resouestagequipos = Leer.leerEntero("Dime la opcion: ");
                  ClearConsole();
                  switch (resouestagequipos) {
                    case 1:
                      Team equipo1 = new Team(Leer.leerTexto("Dime el nombre del equipo: "));
                      teams.add(equipo1);
                      break;
                    case 2:
                      System.out.println();
                      for (Team te : teams) {
                        System.out.println(te);
                      }
                      break;
                    case 3:
                      for (Team te : teams) {
                        System.out.println(te.getName());
                      }
                      System.out.println();
                      String equipo = Leer.leerTexto("Que equipo desea eliminar?: ");
                      System.out.println();
                      Team tea = buscarT(equipo);
                      System.out.println();
                      for (Player ml : players) {
                        if (ml.getTeams().contains(tea)) {
                          ml.getItems().remove(tea);
                        }
                      }
                      break;
                    case 4:
                      for (Team te : teams) {
                        System.out.println(te.getName());
                      }
                      System.out.println();
                      equipo = Leer.leerTexto("A que equipo desea asignarlo?: ");
                      System.out.println();
                      Team tres = buscarT(equipo);
                      System.out.println();
                      for (Player p : players) {
                        System.out.println(p.getName());
                      }
                      String nomJugador = Leer.leerTexto("Que jugador desea asignar a un equipo?: ");
                      System.out.println();
                      Player two = buscar(nomJugador);
                      System.out.println();
                      try {
                        two.add(tres);
                      } catch (JugadoresRepetidos jugadoresRepetidos) {
                        jugadoresRepetidos.printStackTrace();
                      }
                      break;
                    case 5:
                      gequipos = false;
                      break;
                    default:
                      System.out.println("Opcion incorrecta");
                  }
                } while (gequipos);
                break;
              case 3:
                do {
                  System.out.println("1. Crear un objeto");
                  System.out.println("2. Mostrar objetos");
                  System.out.println("3. Borrar objeto");
                  System.out.println("4. Asignar objeto a jugador");
                  System.out.println("5. Salir");
                  int respuestaobjeto = Leer.leerEntero("Dime la opcion: ");
                  switch (respuestaobjeto) {
                    case 1:
                      System.out.println();
                      Item objeto1 = new Item(Leer.leerTexto("Dime el nombre: "), Leer.leerEntero("Dime el ataque: "), Leer.leerEntero("Dime los puntos de defensa: "));
                      items.add(objeto1);
                      System.out.println();
                      break;
                    case 2:
                      System.out.println();
                      for (Item ite : items) {
                        System.out.println(ite);
                      }
                      System.out.println();
                      break;
                    case 3:
                      for (Item ite : items) {
                        System.out.println(ite.getName());
                      }
                      System.out.println();
                      String itemo = Leer.leerTexto("Dime el objeto que desea eliminar?: ");
                      System.out.println();
                      Item ck = buscarI(itemo);
                      System.out.println();
                      for (Player po : players) {
                        if (po.getItems().contains(ck)) {
                          po.getItems().remove(ck);
                        }
                      }
                      System.out.println();
                      break;
                    case 4:
                      for (Item ite : items) {
                        System.out.println(ite.getName());
                      }
                      String objeto = Leer.leerTexto("Que objeto desea asignar?: ");
                      System.out.println();
                      Item objt = buscarI(objeto);
                      System.out.println();
                      for (Player p : players) {
                        System.out.println(p.getName());
                      }
                      System.out.println();
                      String nomJugador = Leer.leerTexto("Que jugador desea asignar el objeto: ");
                      Player qw = buscar(nomJugador);
                      System.out.println();
                      qw.addItem(objt);
                      break;
                    case 5:
                      gobjetos = false;
                      break;
                    default:
                      System.out.println("Opcion incorrecta");
                  }
                } while (gobjetos);
                break;
              case 4:
                configuracion = false;
                break;
              default:
                System.out.println("Opcion incorrecta");
            }
          } while (configuracion);
          break;
        case 2:
          System.out.println("A JUGAR!!!!");
          System.out.println();
          Jugar();
          Leer.leerTexto("Hola: ");
          break;
        case 3:
          principal = false;
          break;
        default:
          System.out.println("Opcion incorrecta vuelve a intentarlo");
      }
    } while (principal);
  }

  /**
   * Metodo que generara los atauqes entre los jugadores
   */
  public static void Jugar(){
      boolean HOLA = true;
      while (HOLA) {
        int vivos = 0;
        for (Player Atacante : players) {
          Player Defensor;
          do {
            Defensor = Aleatorio();
          } while (Defensor.equals(Atacante));
          try {
            Atacante.attack(Defensor);
            if (Atacante.getLife()<0) {
              System.out.println("El jugador " + Atacante.getName() + " ha muerto!");
            }
            if (Defensor.getLife()<0) {
              System.out.println("El jugador " + Defensor.getName() + " ha muerto!");
            }
          } catch (JugadorMuerto jugadorMuerto) {
            jugadorMuerto.printStackTrace();
          } catch (AtacarAsiMismo atacarAsiMismo) {
            atacarAsiMismo.printStackTrace();
          }
          for (Player player : players) {
            if (player.getLife()>0) {
              vivos++;
            }
          }
          if (vivos == 1) {
            for (Player ganador : players) {
              if (ganador.getLife()>0) {
                System.out.println("El ganador es " + ganador.getName());
              }
            }
            return;
          }
        }
      }
    }

  /**
   * Metodo para coger un jugador aleatorio de la array
   * @return un jugador aleatorio
   */
  public static Player Aleatorio() {
    int hola = (int) (Math.random() * players.size());
    return players.get(hola);
  }

  /**
   * Metodo que busca un jugador en una arraylist
   * @param jugador nombre del jugador que le pasamos
   * @return un jugador si lo ha encontrado
   */
  public static Player buscar(String jugador) {
    for (Player c : players) {
      if (c.getName().equalsIgnoreCase(jugador)) {
        return c;
      }
    }
    return null;
  }

  /**
   * Metodo para buscar un Equipo
   * @param team nombre del equipo que le pasamos
   * @return el equipo que le hayamos pasado si lo encuentra
   */
  public static Team buscarT(String team) {
    for (Team t : teams) {
      if (t.getName().equalsIgnoreCase(team)) {
        return t;
      }
    }
    return null;
  }

  /**
   * Metodo para buscar un objeto
   * @param objeto nombre de objeto que queremos buscar
   * @return el objeto si lo ha encontrado
   */
  public static Item buscarI(String objeto) {
    for (Item i : items) {
      if (i.getName().equalsIgnoreCase(objeto)) {
        return i;
      }
    }
    return null;
  }

  public static void ClearConsole() {
    try {
      String operatingSystem; //Check the current operating system
      operatingSystem = System.getProperty("os.name");

      if (operatingSystem.contains("Windows")) {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
        Process startProcess = pb.inheritIO().start();
        startProcess.waitFor();
      } else {
        ProcessBuilder pb = new ProcessBuilder("clear");
        Process startProcess = pb.inheritIO().start();

        startProcess.waitFor();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
