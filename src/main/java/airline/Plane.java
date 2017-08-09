package airline;

/**
 * Created by rajashrk on 8/9/17.
 */
public class Plane {
    private String type;
    private Integer numberOfSeats;

    public Plane(String type, Integer numberOfSeats) {
        this.type = type;
        this.numberOfSeats = numberOfSeats;
    }

    public String getType() {
        return type;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

}
