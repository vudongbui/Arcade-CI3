import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class GameCanvas extends JPanel{
    BufferedImage background;
    Player player;
    Square squareMedium;
    BufferedImage explosion;
    BufferedImage explosion2;
    BufferedImage backBuffered;
    Graphics graphics;
//    BulletPlayer bulletPlayer;
    Vector <BulletPlayer> vectorBulletPlayer;
    Vector <Square> vectorSquareSmall;
    Vector <Square> vectorSquareMedium;
//    Vector <BulletSquare> vectorBulletSquareMedium;
    BulletSquare bulletSquareMedium;

    public int positionPlayerX = 180;
    public int positionPlayerY = 500;

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
        try {
            this.background = ImageIO.read(new File("resources/background/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private  void  square (){
        this.vectorSquareSmall = new Vector<>();
        this.vectorSquareMedium = new Vector<>();
//        this.vectorBulletSquareMedium = new Vector<>();
    }
    private  void  setupplayer() {
        this.player = new Player(positionPlayerX,positionPlayerY,"resources/player/straight.png");
        this.vectorBulletPlayer = new Vector<>();
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
        for (BulletPlayer bulletPlayer : this.vectorBulletPlayer) {
            bulletPlayer.render(this.graphics);
        }
        for (Square squareSmall : this.vectorSquareSmall) {
            squareSmall.render(this.graphics);
        }
        for (Square squareMedium : this.vectorSquareMedium) {
            squareMedium.render(this.graphics);
        }
//        for (BulletSquare bulletSquareMedium : this.vectorBulletSquareMedium) {
//            bulletSquareMedium.render(this.graphics);
//        }
        this.repaint();
    }
    public void runAll() {
        if (this.countBulletPlayer ==20){
            BulletPlayer bulletPlayer = new BulletPlayer(this.player.x,this.player.y,"resources/player/player_bullet.png",3,0);
            this.vectorBulletPlayer.add(bulletPlayer);
            this.countBulletPlayer = 0;
        }else {
            this.countBulletPlayer++;
        }
        if (this.countSquareSmall ==40){
            Random random = new Random();
            int randomSquareSmallX = random.nextInt(394);
            int randomSpeedSquareSmallY = random.nextInt(2)+2;
            Square squareSmall = new Square(randomSquareSmallX,5,0,randomSpeedSquareSmallY,"resources/square/enemy_square_small.png");
            this.vectorSquareSmall.add(squareSmall);
            this.countSquareSmall = 0;
        }else {
            this.countSquareSmall++;
        }
        if (this.countSquareMedium ==100){
            Random random = new Random();
            int randomSquareMediumX = random.nextInt(369);
            int randomSpeedSquareMediumX = random.nextInt(2)+2;
            int randomSpeedSquareMediumY = random.nextInt(2)+2;
            Square squareMedium = new Square(randomSquareMediumX,5,randomSpeedSquareMediumX,randomSpeedSquareMediumY,"resources/square/enemy_square_medium.png");
            this.vectorSquareMedium.add(squareMedium);
            this.countSquareMedium = 0;
        }else {
            this.countSquareMedium++;
        }


//        if (this.bulletPlayer !=null){
//            this.bulletPlayer.run();
//        }
        for (BulletPlayer bulletPlayer:this.vectorBulletPlayer) {
            bulletPlayer.run();
        }
        for (Square squareSmall:this.vectorSquareSmall) {
            squareSmall.run2();
        }
        for (Square squareMedium:this.vectorSquareMedium) {
            squareMedium.run1();
        }
//        bulletSquareMedium.run();
//        for (BulletSquare bulletSquareMedium:this.vectorBulletSquareMedium) {
//            bulletSquareMedium.run();
//        }



    }
}
