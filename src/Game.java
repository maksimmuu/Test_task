public class Game {
    public static void main(String[] args) {

        Player player1 = new Player("Player1", 40, 15, 1, 200);
        System.out.println(player1);

        //attack 40 не удовлетворяет условиям задания, необходимо ввести корректное значение через консоль

        Player player2 = new Player("Player2", 20, 20,-1,150);
        System.out.println(player2);

        //health -1 не удовлетворяет условиям задания, необходимо ввести корректное значение через консоль

        Monster monster1 = new Monster("Monster1", 20, 250, 300);
        System.out.println(monster1);

        //defense 250 не удовлетворяет условиям задания, необходимо ввести корректное значение через консоль

        Monster monster2 = new Monster("Monster2", 25, 15, 400);
        System.out.println(monster2);

        player1.attack(monster1);
        player1.attack(player2);
        player1.attack(player2);

        player2.heal();
        player2.heal();

        monster1.attack(player2);
        monster1.attack(player2);

        player2.heal();
        player2.heal();
        player2.heal(); // 5ый хил не сработал

        monster2.attack(player1); // если удар успешный player1 умирает
    }
}