package airline;

/**
 * Created by rajashrk on 8/9/17.
 */
public class Flight {
    private String source;
    private String destination;
    private Plane plane;
    private String number;

    public Flight(String source, String destination, Plane plane, String number) {
        this.source = source;
        this.destination = destination;
        this.plane = plane;
        this.number = number;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getNumber() {
        return number;
    }
}
