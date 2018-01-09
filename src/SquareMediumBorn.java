import java.util.Random;

public class SquareMediumBorn extends GameObject{
    private int count = 0;
    private Random random;
    public SquareMediumBorn(){
        this.random = new Random();
    }
    @Override
    public void run(){
        super.run();
        if (this.count >=50){
            SquareMedium squareMedium = new SquareMedium();
            squareMedium.position.set(random.nextInt(400),0.0f);
            squareMedium.velocity.set(random.nextInt(7)-3,random.nextInt(3)+3);
            GameObject.add(squareMedium);
            this.count =0;
        }
        else {
            this.count++;
        }
    }
}
