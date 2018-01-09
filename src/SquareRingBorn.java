import java.util.Random;

public class SquareRingBorn extends GameObject {
    private Random random;
    public SquareRingBorn(){
        this.random = new Random();
    }
    @Override
    public void run(){
        super.run();
        SquareRing squareRing = new SquareRing();
        squareRing.velocity.set(0.0f,0.1f);
        for(int i = 0; i < 8; i++){
            squareRing.position.set(10.0f+50.0f * Math.cos(0.5236*i)-50.0f*Math.sin(0.5236*i),10.0f+50.0f * Math.sin(0.5236*i)+50.0f*Math.cos(0.5236*i));
            GameObject.add(squareRing);
        }
    }
}
