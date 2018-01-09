public class Main {

    static public class Car{
        String color;
        int number;
        double speedmax;

        void run () {
            System.out.println("run...");
        }
    }

    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        gameWindow.gameLoop();

    }
}
