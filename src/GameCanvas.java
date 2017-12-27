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
    BufferedImage backBuffered;
    Graphics graphics;
    public int positionPlayerX = 180;
    public int positionPlayerY = 500;
    public int squareX = 180;
    public int squareY = 10;
    public GameCanvas() {
        this.setSize(400, 600);
        this.setVisible(true);

        this.setupBackBuffered();
        this.setupBackground();
        this.setupplayer();

        try {
            this.square = ImageIO.read(new File("resources/square/enemy_square_small.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        this.repaint();
    }
}
