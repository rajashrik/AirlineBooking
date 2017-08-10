package com.airline;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by rajashrk on 8/10/17.
 */
public class searchUtilityTest {

    private Plane plane;
    private Calendar departure;
    List<Flight> flights = new ArrayList<Flight>();
    Flight flight1;
    Flight flight2;
    Flight flight3;
    SearchDetails searchDetails;

    @Before
    public void setUp() throws Exception {
        plane = new Plane("Airbus A319 V2",70);
        departure = new GregorianCalendar(2017,0,1,1,2,3);

        flight1 = new Flight("Pune", "Kolkata",plane,"F1",departure,departure);
        flight2 = new Flight("Pune", "Kolkata",plane,"F2",departure,departure);
        flight3 = new Flight("Hyderabad", "Nashik",plane,"F1",departure,departure);

        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);

        searchDetails = new SearchDetails();
        searchDetails.setTo("Kolkata");
        searchDetails.setFrom("Pune");
        searchDetails.setDepartureDate("2017-01-01");
    }

    @Test
    public void shouldSearchFlightsBySourceAndDestination() throws Exception {
        int expectedListCount = 2;
        Assert.assertEquals(expectedListCount,(SearchFlights.bySourceAndDestination(flights,searchDetails).size()));
    }

    @Test
    public void shouldSearchByDepartureDate() throws Exception {
        int expectedListCount = 3;
        Assert.assertEquals(expectedListCount,(SearchFlights.byDepartureDate(flights,searchDetails).size()));
    }


    @Test
    public void shouldReturnFlightsBySourceAndDestination() throws Exception {
        List<Flight> matchedFlights = SearchFlights.bySourceAndDestination(flights,searchDetails);
        Assert.assertEquals("Pune", matchedFlights.get(0).getSource());
        Assert.assertEquals("Kolkata", matchedFlights.get(0).getDestination());
    }

    @Test
    public void shouldReturnByDepartureDate() throws Exception {
        List<Flight> matchedFlights = SearchFlights.bySourceAndDestination(flights,searchDetails);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Assert.assertEquals("20170101", dateFormat.format(matchedFlights.get(0).getDepartureTime().getTime()));
    }
}