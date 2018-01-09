public class Square extends GameObject{
    public Vector2D verolity;

    public Square(){
//        super();
        this.image = Utils.loadImage("resources/square/enemy_square_small.png");
        this.verolity = new Vector2D();
    }
    @Override
    public void run(){
        super.run();
        this.position.addUp(this.verolity);
    }
}
