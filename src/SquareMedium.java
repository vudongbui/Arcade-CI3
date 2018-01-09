public class SquareMedium extends GameObject {
    public Vector2D velocity;
    private int countBullet = 30;
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

    }
}
