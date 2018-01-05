import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Square {
    public int x;
    public int y;
    public int speedX;
    public int speedY;
    public BufferedImage image;

    public Square(int x, int y, int speedX,int speedY, String url){
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
        try {
            this.image = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void render(Graphics graphics) {
        graphics.drawImage(this.image,this.x-25,this.y-50,null);
    }
    public void run1(){
        this.x = this.x + this.speedX;
        this.y = this.y + this.speedY;
        if (this.x >= 370) {
            this.speedX = -this.speedX;
        }
        else if (this.x <= 5) {
            this.speedX = -this.speedX;
        }
    }
    public void run2(){
        this.y = this.y + this.speedY;
    }
}
