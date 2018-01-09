import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BulletSquare extends GameObject{
    public Vector2D velocity;

    public BulletSquare(){
        this.velocity = new Vector2D(2,2);
        this.image = Utils.loadImage("resources/square/enemy_square_bullet.png");
    }

    @Override

    public void run(){
        super.run();
        this.position.addUp(this.velocity);
    }
}
