import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class GameCanvas extends JPanel{
    BufferedImage background;
    Player player;
    SquareSmall squareSmall;
    BufferedImage explosion;
    BufferedImage explosion2;
    BufferedImage backBuffered;
    Graphics graphics;
//    BulletPlayer bulletPlayer;
    Vector <BulletPlayer> vector;

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

    int count;

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
        this.squareSmall = new SquareSmall(20,20, "resources/square/enemy_square_small.png");
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
        this.player = new Player(positionPlayerX,positionPlayerY,"resources/player/straight.png");
        this.vector = new Vector<>();
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
        player.render(this.graphics);
        squareSmall.render(this.graphics);
        for (BulletPlayer bulletPlayer : this.vector) {
            bulletPlayer.render(this.graphics);
        }
        this.repaint();

//        this.graphics.drawImage(this.square,this.square1X,this.square1Y,null);
//        for (int i = 0; i <10 ; i ++) {
//            square2plus = square2X + 39 * i ;
//            if (square2plus >= 390){
//                square2plus = square2plus - 390;
//            }
//            this.graphics.drawImage(this.square,this.square2plus,10,null);
//            this.graphics.drawImage(this.explosion2, this.square2plus +10,this.explosionY,null);
//        }
//        this.graphics.drawImage(this.explosion,this.explosion3X,this.explosion3Y,null);
//        this.graphics.drawImage(this.explosion,this.explosion1X,this.explosion1Y,null);
    }
    public void runAll() {
//        squareSmall.run1(squareX,squareY,2);
//        this.squareX = this.squareX + this.plusX;
//        this.squareY = this.squareY + this.plusY;
//
//        if (this.squareX >= 370) {
//            this.plusX = - 2;
//        }
//        else if (this.squareX <= 5) {
//            this.plusX = 2;
//        }
//        if (this.squareY >= 550) {
//            this.plusY = - 1;
//        }
//        else if (this.squareY <= 5) {
//            this.plusY = 1;
//        }
////                for (int i = 0; i < 5; i++) {
////                    gameCanvas.graphics.drawImage(this.gameCanvas.square1,gameCanvas.square1X,gameCanvas.square1Y,null);
////                    gameCanvas.square1X = gameCanvas.square1X + 40;
////                }
//
//        this.square1Y = this.square1Y + this.plus1Y;
//        if (this.square1Y>=530) {
//            this.square1Y = 30;
//        }
//
//        this.square2X = this.square2X + 1;
//        if (this.square2X >=395){
//            this.square2X =0;
//        }
//
//        this.explosionY = this.explosionY + 3;
//        if (this.explosionY >= 595) {
//            this.explosionY = 20;
//        }
//
//        this.explosion3X = this.explosion3X + this.explosion3plusX;
//        this.explosion3Y = this.explosion3Y + 2;
//        if (this.explosion3X >=this.positionPlayerX){
//            this.explosion3plusX = -2;
//        }
//        else {
//            this.explosion3plusX = 2;
//        }
//        if (this.explosion3Y >= this.positionPlayerY) {
//            this.explosion3Y = this.squareY +5;
//            this.explosion3X = this.squareX +5;
//        }
//        this.explosion1X = this.explosion1X + this.explosion1plusX;
//        this.explosion1Y = this.explosion1Y + 3;
//        if (this.explosion1X >=this.positionPlayerX){
//            this.explosion1plusX = -3;
//        }
//        else {
//            this.explosion1plusX = 3;
//        }
//        if (this.explosion1Y >= this.positionPlayerY) {
//            this.explosion1Y = this.square1Y +5;
//            this.explosion1X = this.square1X +5;
//        }

        if (this.count ==20){
            BulletPlayer bulletPlayer = new BulletPlayer(this.player.x,this.player.y,"resources/player/player_bullet.png",3);
            this.vector.add(bulletPlayer);
            this.count = 0;
        }else {
            this.count++;
        }
//        if (this.bulletPlayer !=null){
//            this.bulletPlayer.run();
//        }
        for (BulletPlayer bulletPlayer:this.vector) {
            bulletPlayer.run();
        }


    }
}
