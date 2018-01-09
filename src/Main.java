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

//        Car CarHonda = new Car();
//        CarHonda.color = "red";
//        CarHonda.number = 4;
//        CarHonda.speedmax = 100.0;
//
//        CarHonda.run();

    }
}
