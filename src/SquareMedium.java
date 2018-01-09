public class SquareMedium extends GameObject {
    public Vector2D velocity;

    public SquareMedium(){
        this.image = Utils.loadImage("resources/square/enemy_square_medium.png");
        this.velocity = new Vector2D();
    }
    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);

    }
}
