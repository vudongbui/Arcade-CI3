import java.awt.*;

public class Background extends GameObject {
    public Background(){
        this.image = Utils.loadImage("resources/background/background.png");
    }
    public void render(Graphics graphics){
        graphics.drawImage(this.image, 0, 0, null);
    }
}
