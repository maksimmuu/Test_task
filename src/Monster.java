public class Monster extends Creature {
    public Monster(String name, int attack, int defense, int health) {
        super(name, attack, defense, health);
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", defense=" + defense +
                ", health=" + health +
                '}';
    }
}
