import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel{
    BufferedImage background;
    BufferedImage player;
    BufferedImage square;
    BufferedImage explosion;
    BufferedImage explosion2;

    BufferedImage backBuffered;
    Graphics graphics;
    public int positionPlayerX = 180;
    public int positionPlayerY = 500;
    public int squareX = 180;
    public int squareY = 10;
    public int square1X = 0;
    public int square1Y = 30;
    public int square2X = 10;
    public int square2plus = 10;
    public int explosionY = 20;
    public int explosion3X = 190;
    public int explosion3Y = 20;
    public int explosion3plusX = 2;
    public int explosion1X = 5;
    public int explosion1Y = 35;
    public int explosion1plusX = 3;



    public int square2Y = 10;

    public int plusX = 2;
    public int plusY = 1;
    public int plus1X = 4;
    public int plus1Y = 4;

    public GameCanvas() {
        this.setSize(400, 600);
        this.setVisible(true);

        this.setupBackBuffered();
        this.setupBackground();
        this.setupplayer();
        this.square();

    }
    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(400,600,BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }
    private void setupBackground () {
        try {
            this.background = ImageIO.read(new File("resources/background/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private  void  square (){
        try {
            this.square = ImageIO.read(new File("resources/square/enemy_square_small.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.explosion = ImageIO.read(new File("resources/square/explosion/enemy_square_explosion_particle_3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.explosion2 = ImageIO.read(new File("resources/square/explosion/enemy_square_explosion_particle_5.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private  void  setupplayer() {
        try {
            this.player = ImageIO.read(new File("resources/player/straight.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
//        g.setColor(Color.BLACK);
//        g.drawRect(0,0,40,40);
//        g.drawRect(40,40,60,80);
//        g.drawImage(this.background, 0, 0, null);
//        g.drawImage(this.player, this.positionPlayerX - 25,this.positionPlayerY - 50,null);
//        for (int i = 0; i <100; i++){
//            int x = 0;
//            int y = 0;
//            x = x + 3;
//            y = y + 3;
//            g.drawImage(this.square,x,y,null);
//        }
        g.drawImage(this.backBuffered,0,0,null);
    }
    public  void  renderAll() {
        this.graphics.drawImage(this.background, 0, 0, null);
        this.graphics.drawImage(this.player, this.positionPlayerX - 25,this.positionPlayerY - 50,null);
        this.graphics.drawImage(this.square,this.squareX,this.squareY,null);
        this.graphics.drawImage(this.square,this.square1X,this.square1Y,null);

        for (int i = 0; i <10 ; i ++) {
            square2plus = square2X + 39 * i ;
            if (square2plus >= 390){
                square2plus = square2plus - 390;
            }
            this.graphics.drawImage(this.square,this.square2plus,10,null);
            this.graphics.drawImage(this.explosion2, this.square2plus +10,this.explosionY,null);
        }
        this.graphics.drawImage(this.explosion,this.explosion3X,this.explosion3Y,null);
        this.graphics.drawImage(this.explosion,this.explosion1X,this.explosion1Y,null);

        this.repaint();
    }
}
