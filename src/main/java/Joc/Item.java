package Joc;

public class Item {
  private String name;
  private int attackBonus;
  private int defenseBonus;

  public Item(String name, int attackBonus, int defenseBonus) {
    this.setName(name);
    this.setAttackBonus(attackBonus);
    this.setDefenseBonus(defenseBonus);
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAttackBonus() {
    return attackBonus;
  }

  public void setAttackBonus(int attackBonus) {
    this.attackBonus = attackBonus;
  }

  public int getDefenseBonus() {
    return defenseBonus;
  }

  public void setDefenseBonus(int defenseBonus) {
    this.defenseBonus = defenseBonus;
  }

  @Override
  public String toString() {
    return " - " + this.name + " BA: " + this.attackBonus + " /" +" BD: " + this.defenseBonus;
  }
}
