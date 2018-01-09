import java.util.Random;

public class SquareMedium extends GameObject {
    public Vector2D velocity;
    private int countBullet = 30;
    private Random random;
    public SquareMedium(){
        this.image = Utils.loadImage("resources/square/enemy_square_medium.png");
        this.velocity = new Vector2D();
    }
    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        if (this.countBullet >=40){
            BulletSquare bulletSquare = new BulletSquare();
            double x = this.position.x;
            double y = this.position.y;
            bulletSquare.position.set(x,y);
            bulletSquare.velocity.set(0,10.0f);
            GameObject.add(bulletSquare);
            this.countBullet = 0;
        }
        else {
            this.countBullet++;
        }

        if (this.position.x>=390||this.position.x<5){
            this.velocity.x = -this.velocity.x;
        }

    }
}
