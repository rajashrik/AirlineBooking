package airline;

import java.util.Calendar;

/**
 * Created by rajashrk on 8/9/17.
 */
public class Flight {
    private String source;
    private String destination;
    private Plane plane;
    private String number;
    private Calendar departureTime;
    private Calendar arrivalTime;

    public Flight(String source, String destination, Plane plane, String number, Calendar departureTime, Calendar arrivalTime) {
        this.source = source;
        this.destination = destination;
        this.plane = plane;
        this.number = number;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
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


    public Calendar getDepartureTime() {
        return departureTime;
    }

    public Calendar getArrivalTime() {
        return arrivalTime;
    }
}
