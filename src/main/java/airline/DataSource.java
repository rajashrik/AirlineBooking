package airline;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by rajashrk on 8/9/17.
 */
public class DataSource {
    final private static DataSource dataSource = new DataSource();
    public static DataSource instance() { return dataSource;}

    public List<String> fetchLocations() {
        List<String> locations = new ArrayList<String>();
        locations.add("Pune");
        locations.add("Hyderabad");
        locations.add("Bangalore");
        return locations;
    }

    public List<Plane> fetchPlanes() {
        List<Plane> planes = new ArrayList<Plane>();
        planes.add(new Plane("Boeing777-200LR(77L)", 238));
        planes.add(new Plane("Airbus A319 V2", 144));
        planes.add(new Plane("Airbus A321", 172));
        return planes;
    }

    public List<Flight> fetchFlights() {
        List<Flight> flights = new ArrayList<Flight>();
        List<Plane> planes = fetchPlanes();
        Calendar departure = new GregorianCalendar(2017,8,10, 9, 10, 0);
        Calendar arrival = new GregorianCalendar(2017,8,10, 10, 10, 0);

        Flight flight1 = new Flight("Hyderabad", "Pune", planes.get(0), "F1",departure,arrival);
        Flight flight2 = new Flight("Hyderabad","Bangalore", planes.get(1),"F2",departure,arrival);
        Flight flight3 = new Flight("Pune","Bangalore", planes.get(2),"F3",departure,arrival);

        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);

        return flights;
    }
}
