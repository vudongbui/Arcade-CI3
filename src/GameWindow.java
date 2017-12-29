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
                    gameCanvas.plusX = - 3;
                }
                else if (gameCanvas.squareX <= 5) {
                    gameCanvas.plusX = 3;
                }
                if (gameCanvas.squareY >= 550) {
                    gameCanvas.plusY = - 4;
                }
                else if (gameCanvas.squareY <= 5) {
                    gameCanvas.plusY = 4;
                }
//                for (int i = 0; i < 5; i++) {
//                    gameCanvas.graphics.drawImage(this.gameCanvas.square1,gameCanvas.square1X,gameCanvas.square1Y,null);
//                    gameCanvas.square1X = gameCanvas.square1X + 40;
//                }

                gameCanvas.square1Y = gameCanvas.square1Y + gameCanvas.plus1Y;
                if (gameCanvas.square1Y>=530) {
                    gameCanvas.square1Y = 5;
                }



                this.gameCanvas.renderAll();
                this.lastTime = curretTime;
            }
        }
    }
}
