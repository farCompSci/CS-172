public class Starship {

    private String name;
    private Vector position;
    private Vector velocity;

    // Constructor 1 with parameters
    public Starship(String n, Vector p) {
        this.name = n;
        this.position = p;
        this.velocity = new Vector();
    }

    // Constructor with no parameters
//    public Starship() {
//        this.velocity = new Vector(0,0);
//    }


    public String getName() {
        return name;
    }

    public Vector getPosition() {
        return position;
    }

    public Vector getVelocity() {
        return velocity;
    }

    @Override
    public String toString() {
        return name + " at " + position + " moving " + velocity;
    }

    public Vector accelerate(Vector j) {
        velocity= velocity.plus(j);
        return velocity;
    }

    public Vector drift() {
        position= position.plus(velocity);
        return position;
    }
}