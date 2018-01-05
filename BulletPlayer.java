import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BulletPlayer {
    public int x;
    public int y;
    public BufferedImage image;
    public  int speed;

    public BulletPlayer(int x,int y, String url,int speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
        try {
            this.image = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public BulletPlayer(){

    }

    public void run() {
        this.y -= this.speed;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image,this.x-15,this.y-50,null);
    }



}
