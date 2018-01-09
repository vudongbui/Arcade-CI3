public class SquareRing extends GameObject {
    public Vector2D velocity;
    public SquareRing(){
        this.image = Utils.loadImage("resources/square/enemy_square_small.png");
        this.velocity = new Vector2D();
    }
    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
    }
}
