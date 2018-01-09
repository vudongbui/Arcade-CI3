import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class GameCanvas extends JPanel{
    Background background;
    Player player;
    BulletPlayer bulletPlayer;
    Square squareMedium;
    BufferedImage explosion;
    BufferedImage explosion2;
    BufferedImage backBuffered;
    Graphics graphics;
//    BulletPlayer bulletPlayer;
    Vector <BulletPlayer> vectorBulletPlayer;
    Vector <Square> vectorSquareSmall;
    Vector <Square> vectorSquareMedium;
    Squareborn squareborn;
//    Vector <BulletSquare> vectorBulletSquareMedium;
    BulletSquare bulletSquareMedium;
    public Vector2D positionPlayer = new Vector2D();
    Vector vector;


    int countBulletPlayer;
//    int countBulletSquareMedium;
    int countSquareSmall;
    int countSquareMedium;

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
        this.background = new Background();
        GameObject.add(background);
    }
    private  void  square (){
        GameObject.add(new Squareborn());
    }
    private  void  setupplayer() {
        this.player = new Player();
        GameObject.add(player);
        this.bulletPlayer = new BulletPlayer();
        GameObject.add(bulletPlayer);
//        this.vector = new Vector();
//        this.vectorBulletPlayer = new Vector<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered,0,0,null);
    }
    public  void  renderAll() {
//        this.graphics.drawImage(this.background, 0, 0, null);
        this.background.render(graphics);
        GameObject.renderAll(graphics);
        this.repaint();
    }
    public void runAll() {
        this.player.position.set(this.positionPlayer);
        GameObject.runAll();
//        if (this.countBulletPlayer ==20){
//            BulletPlayer bulletPlayer = new BulletPlayer();
//            bulletPlayer.position.set(this.positionPlayer);
//            bulletPlayer.velocity.set(0.0f,5.0f);
//            this.vector.add(bulletPlayer);
//            this.countBulletPlayer = 0;
//        }else {
//            this.countBulletPlayer++;
//        }
//        this.squareborn.run();
////        if (this.countSquareSmall ==40){
//            Random random = new Random();
//            int randomSquareSmallX = random.nextInt(394);
//            int randomSpeedSquareSmallY = random.nextInt(2)+2;
//            Square squareSmall = new Square(new Vector2D(randomSquareSmallX,5),new Vector2D(),"resources/square/enemy_square_small.png");
//            this.vectorSquareSmall.add(squareSmall);
//            this.countSquareSmall = 0;
//        }else {
//            this.countSquareSmall++;
//        }
//        if (this.countSquareMedium ==100){
//            Random random = new Random();
//            int randomSquareMediumX = random.nextInt(369);
//            int randomSpeedSquareMediumX = random.nextInt(2)+2;
//            int randomSpeedSquareMediumY = random.nextInt(2)+2;
//            Square squareMedium = new Square(new Vector2D(randomSquareMediumX,5),new Vector2D(),"resources/square/enemy_square_medium.png");
//            this.vectorSquareMedium.add(squareMedium);
//            this.countSquareMedium = 0;
//        }else {
//            this.countSquareMedium++;
//        }
    }
}
