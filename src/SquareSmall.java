import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SquareSmall {
    public int x;
    public int y;
    public BufferedImage image;

    public SquareSmall(int x,int y,String url){
        this.x = x;
        this.y = y;
        try {
            this.image = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void render(Graphics graphics) {
        graphics.drawImage(this.image,this.x-25,this.y-50,null);
    }
    public void run1(int x, int y,int speedX){
        this.x = x;
        this.y = y;

        x = x + speedX;
        y = y + 2;
        if (x >= 370) {
            speedX = -speedX;
        }
        else if (x <= 5) {
            speedX = -speedX;
        }
    }
}
