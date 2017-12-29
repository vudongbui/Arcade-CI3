import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame{

    GameCanvas gameCanvas;
    private long lastTime = 0;

    public GameWindow() {
        this.setSize(400, 600);



        this.setupgameCanvas();
        this.event();
        this.setVisible(true);


//        while (true) {
//            gameCanvas.squareY++;
//            if (gameCanvas.squareY>595) {
//                gameCanvas.squareY = gameCanvas.squareY - 0.1;
//            }
//            else if (gameCanvas.squareY<5){
//                gameCanvas.squareY = gameCanvas.squareY + 1;
//            }
//            this.gameCanvas.repaint();
//        }
    }
    private  void  setupgameCanvas() {
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    private void event() {
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                gameCanvas.positionPlayerX = e.getX();
                gameCanvas.positionPlayerY = e.getY();
//                System.out.println("x: " +e.getX() + " ,y: " +e.getY());
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void gameLoop(){
        while (true) {
            long curretTime = System.nanoTime();
            if ( curretTime - this.lastTime >= 17_000_000) {
                gameCanvas.squareX = gameCanvas.squareX + gameCanvas.plusX;
                gameCanvas.squareY = gameCanvas.squareY + gameCanvas.plusY;

                if (gameCanvas.squareX >= 370) {
                    gameCanvas.plusX = - 2;
                }
                else if (gameCanvas.squareX <= 5) {
                    gameCanvas.plusX = 2;
                }
                if (gameCanvas.squareY >= 550) {
                    gameCanvas.plusY = - 1;
                }
                else if (gameCanvas.squareY <= 5) {
                    gameCanvas.plusY = 1;
                }
//                for (int i = 0; i < 5; i++) {
//                    gameCanvas.graphics.drawImage(this.gameCanvas.square1,gameCanvas.square1X,gameCanvas.square1Y,null);
//                    gameCanvas.square1X = gameCanvas.square1X + 40;
//                }

                gameCanvas.square1Y = gameCanvas.square1Y + gameCanvas.plus1Y;
                if (gameCanvas.square1Y>=530) {
                    gameCanvas.square1Y = 30;
                }

                gameCanvas.square2X = gameCanvas.square2X + 1;
                if (gameCanvas.square2X >=395){
                    gameCanvas.square2X =0;
                }

                gameCanvas.explosionY = gameCanvas.explosionY + 3;
                if (gameCanvas.explosionY >= 595) {
                    gameCanvas.explosionY = 20;
                }

                gameCanvas.explosion3X = gameCanvas.explosion3X + gameCanvas.explosion3plusX;
                gameCanvas.explosion3Y = gameCanvas.explosion3Y + 2;
                if (gameCanvas.explosion3X >=gameCanvas.positionPlayerX){
                    gameCanvas.explosion3plusX = -2;
                }
                else {
                    gameCanvas.explosion3plusX = 2;
                }
                if (gameCanvas.explosion3Y >= gameCanvas.positionPlayerY) {
                    gameCanvas.explosion3Y = gameCanvas.squareY +5;
                    gameCanvas.explosion3X = gameCanvas.squareX +5;
                }
                gameCanvas.explosion1X = gameCanvas.explosion1X + gameCanvas.explosion1plusX;
                gameCanvas.explosion1Y = gameCanvas.explosion1Y + 3;
                if (gameCanvas.explosion1X >=gameCanvas.positionPlayerX){
                    gameCanvas.explosion1plusX = -3;
                }
                else {
                    gameCanvas.explosion1plusX = 3;
                }
                if (gameCanvas.explosion1Y >= gameCanvas.positionPlayerY) {
                    gameCanvas.explosion1Y = gameCanvas.square1Y +5;
                    gameCanvas.explosion1X = gameCanvas.square1X +5;
                }

                this.gameCanvas.renderAll();
                this.lastTime = curretTime;
            }
        }
    }
}
