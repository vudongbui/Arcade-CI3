public class Vector2D {

    public double x;
    public double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Vector2D() {
        this.x = 0.0f;
        this.y = 0.0f;
    }


    public Vector2D set(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }
    public Vector2D set(Vector2D vector2D) {
        return this.set(vector2D.x, vector2D.y);
    }


    public Vector2D addUp(double x, double y) {
        this.x += x;
        this.y += y;
        return this;
    }
    public Vector2D addUp(Vector2D vector2D) {
        return this.addUp(vector2D.x, vector2D.y);
    }


    public Vector2D add(double x, double y) {
        return new Vector2D(this.x + x, this.y + y);
    }
    public Vector2D add(Vector2D vector2D) {
        return this.add(vector2D.x, vector2D.y);
    }


    public Vector2D subtractBy(double x, double y) {
        this.x -= x;
        this.y -= y;
        return this;
    }
    public Vector2D subtractBy(Vector2D vector2D) {
        return this.subtractBy(vector2D.x, vector2D.y);
    }


    public Vector2D subtract(double x, double y) {
        return new Vector2D(this.x - x, this.y - y);
    }
    public Vector2D subtract(Vector2D vector2D) {
        return this.add(vector2D.x, vector2D.y);
    }


    public Vector2D multiply(double z, Vector2D vector2D) {
        return new Vector2D(z * this.x, z * this.y);
    }


    public float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }


    public Vector2D clone() {
        Vector2D vector2D = new Vector2D(this.x, this.y);
        return vector2D;
    }

    public Vector2D rotate(double degree){
        double radian = Math.toRadians(degree);
        double a,b;
        a = this.x * Math.cos(radian) - this.y*Math.sin(radian);
        b = this.x * Math.sin(radian) + this.y*Math.cos(radian);
        this.x = a;
        this.y = b;
        return this;
    }
    public Vector2D rotateZ (int z,double degree){
        double radian = Math.toRadians(degree);
        this.x = this.x + (z * Math.cos(radian) - z * Math.sin(radian));
        this.y = this.y + (z * Math.sin(radian) + z * Math.cos(radian));
        return this;
    }
}