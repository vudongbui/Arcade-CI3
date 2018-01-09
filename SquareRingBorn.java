import java.util.Random;

public class SquareRingBorn extends GameObject {
    private int count = 0;
    private Random random;
    public SquareRingBorn(){
        this.random = new Random();
    }
    @Override
    public void run(){
        super.run();
        if (this.count >=100){
            int randomX;
            randomX = random.nextInt(300);
            for (int i = 0; i <12 ; i++) {
                SquareRing squareRing = new SquareRing();
                squareRing.position.set(randomX+50+50*Math.cos(0.2618*2*i)-50*Math.sin(0.2618*2*i),50*Math.sin(0.2618*2*i)+50*Math.cos(0.2618*2*i));
                squareRing.velocity.set(3.0f, 3.0f);
                GameObject.add(squareRing);
                this.count = 0;
            }
        }
        else {
            this.count++;
        }
    }
}
