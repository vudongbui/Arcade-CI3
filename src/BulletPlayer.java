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
    public int z;

    public BulletPlayer(int x,int y, String url,int speed,int z){
        this.x = x;
        this.y = y;
        this.z = z;
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
        this.z++;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image,this.x-15 + z,this.y-50,null);
        graphics.drawImage(this.image,this.x-15 - z,this.y-50,null);
    }



}
