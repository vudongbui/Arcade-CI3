import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BulletPlayer extends GameObject {
    public Vector2D velocity;
    private int count = 0;

    public BulletPlayer(){
        this.image = Utils.loadImage("resources/player/player_bullet.png");
        this.velocity = new Vector2D(3,3);
    }
@Override
    public void run() {
        super.run();
        this.position.subtractBy(this.velocity);
    }

}
