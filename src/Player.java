public class Player extends Creature {
    private int COUNT_HEAL;
    private int maxHealth; // максимальное значение Здоровья

    public Player(String name, int attack, int defense, int health, int maxHealth) {
        super(name, attack, defense, health);
        this.maxHealth = maxHealth;
    }

    public void heal() {
        COUNT_HEAL++;
        if (COUNT_HEAL<=4) {
            int healAmount = (int) (maxHealth * 0.3); // излечиваем 30% от максимального Здоровья
            if (healAmount > 0) {
                health += healAmount;
                if (health > maxHealth) {
                    health = maxHealth;
                }
            }
            System.out.println("Количество использованных хилов: " + COUNT_HEAL);
        }
        else System.out.println("Количество хилов для игрока не может превышать 4 ");
        System.out.println("Здоровье " + this.getName() + " = " + this.getHealth() + "\n");

    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", defense=" + defense +
                ", health=" + health +
                ", maxHealth=" + maxHealth +
                '}';
    }
}
