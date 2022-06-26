public class Vector {

    //Making them private so that it is 'invisible to the outside world'
    private double x;
    private double y;

    // First constructor with values of x and y as input
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Second constructor, no parameters, sets the values of x and y to 0
    public Vector() {
        this.x = 0.;
        this.y = 0.;
    }

    // Setter for X, self-explanatory
    public void setX(double x) { this.x = x; }

    //Setter for Y
    public void setY(double y) { this.y = y; }

    //Getter for X
    public double getX() { return x; }

    //Getter for Y
    public double getY() { return y; }

    //Adds the value from parameter v to the x and y values
    public Vector plus(Vector v) { return new Vector(this.x + v.x, this.y + v.y); }

    //Subtracts v from x and y values
    public Vector minus(Vector v) { return new Vector(this.x - v.x, this.y - v.y); }

    //Conducts dot multiplication, where x-value of v {or v.x} * x. Same for y
    public double dot(Vector v) { return this.x*v.x + v.y*this.y; }

    //Scalar multiplication applied to x and y
    public Vector times(double s) { return new Vector (s*this.x, s*this.y); }

    //Calculating distance using distance formula
    public double distanceTo(Vector v) { return Math.sqrt((this.x-v.x)*(this.x-v.x) + (v.y-this.y)*(v.y-this.y)); }

    //Returning the vector values in String form
    @Override
    public String toString() {
        return "<" + x + ", " + y + '>';
    }

    //Checks if two vectors are equal to each other
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vector Vector = (Vector) obj;
        return Double.compare(Vector.y, y) == 0;
    }
}