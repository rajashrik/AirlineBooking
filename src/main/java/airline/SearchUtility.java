package airline;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rajashrk on 8/9/17.
 */
public final class SearchUtility {

    public static List<Flight> getMatchingFlights(List<Flight> flights, SearchDetails searchDetails){
        List<Flight> matchingFlights = flights.stream()
            .filter(flight ->
                flight.getDestination().equals(searchDetails.getTo()) && flight.getSource().equals(searchDetails.getFrom()))
            .collect(Collectors.toList());

       return matchingFlights;
    }
}
