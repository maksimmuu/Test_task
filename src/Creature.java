import java.util.Random;
import java.util.Scanner;

public class Creature {

    protected String name; // имя существа
    protected int attack; // параметр Атака
    protected int defense; // параметр Защита
    protected int health; // Здоровье

    public Creature(String name, int attack, int defense, int health) {
        this.name=name;
        this.health = this.checkHealth(health);
        this.defense=this.checkParameter(defense);
        this.attack=this.checkParameter(attack);

    }

    private int checkParameter(int parameter){
        if (parameter<=30&&parameter>=1){
            return parameter;}
        else {
            int x;
            do{
                Scanner sc = new Scanner(System.in);
                while (true) {
                    System.out.println(this.getClass() + ": Защита должна быть целое число (int) от 1 до 30, введите корректное значение для  " + this.name + ": ");

                    try {
                        x = Integer.parseInt(sc.next());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Необходимо ввести значение типа int !");
                    }
                }
            }
            while (x>30 || x<1);
            return x;
        }
    }

    private int checkHealth(int health){
        if (health>0){
            return health;
        }
        else {
            int x;
            do{
                Scanner sc = new Scanner(System.in);
                while (true) {
                    System.out.println(this.getClass() + ": Здоровье должно быть натуральное число (int) от 1 до N, введите корректное значение для " + this.name + ": ");
                    // 0 ПО ЗАДАНИЮ НЕ ЯВЛЯЕТСЯ НАТУРАЛЬНЫМ ЧИСЛОМ
                    try {
                        x = Integer.parseInt(sc.next());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Необходимо ввести значение типа int !");
                    }
                }
            }
            while (x<=0);
            return x;

        }

    }


    public void attack(Creature target) {
        int modifier = this.attack - target.defense + 1; // модификатор атаки
        int dice = modifier > 0 ? modifier : 1;

        Random random = new Random();
        for (int i = 0; i < dice; i++) {
            if (random.nextInt(6) + 1 > 4) {
                int damage = random.nextInt(this.getMaxDamage() - this.getMinDamage() + 1) + this.getMinDamage();
                System.out.println(this.name + " нанёс " + damage +  " урона " + target.name);
                target.takeDamage(damage);
                break; // удар успешен, больше кубиков бросать не нужно
            }
            else System.out.println("Удар неуспешный \n");
        }
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
            System.out.println("Существо " + this.getName() + " умерло :(");
        }
        System.out.println("У существа " + this.getName() + " осталось " + this.getHealth() + " здоровья \n");
    }

    public int getMinDamage() {
        return 1; // минимальное значение параметра Урон
    }

    public int getMaxDamage() {
        return 6; // максимальное значение параметра Урон
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }
}
