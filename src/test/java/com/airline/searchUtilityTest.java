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

    private FlightTestData data;


    @Before
    public void setUp() throws Exception {
        data = new FlightTestData();
    }

    @Test
    public void shouldSearchFlightsBySourceAndDestination() throws Exception {
        int expectedListCount = 2;
        Assert.assertEquals(expectedListCount,(SearchFlights.bySourceAndDestination(data.flights,data.searchDetails).size()));
    }

    @Test
    public void shouldSearchByDepartureDate() throws Exception {
        int expectedListCount = 3;
        Assert.assertEquals(expectedListCount,(SearchFlights.byDepartureDate(data.flights,data.searchDetails).size()));
    }


    @Test
    public void shouldReturnFlightsBySourceAndDestination() throws Exception {
        List<Flight> matchedFlights = SearchFlights.bySourceAndDestination(data.flights,data.searchDetails);
        Assert.assertEquals("Pune", matchedFlights.get(0).getSource());
        Assert.assertEquals("Kolkata", matchedFlights.get(0).getDestination());
    }

    @Test
    public void shouldReturnByDepartureDate() throws Exception {
        List<Flight> matchedFlights = SearchFlights.bySourceAndDestination(data.flights,data.searchDetails);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Assert.assertEquals("20170101", dateFormat.format(matchedFlights.get(0).getDepartureTime().getTime()));
    }

    @Test
    public void ShouldHaveFlightCountAsNonZeroIfSeatsAvailableInGivenClass() throws Exception {
        int expectedCount = 1;
        List<Flight> matchedFlights = SearchFlights.byAvailableSeats(data.flights,data.searchDetails);
        Assert.assertEquals(expectedCount,matchedFlights.size());

    }

    @Test
    public void ShouldHaveFlightCountAsZeroIfNoAvailableSeatsInGivenClass() throws Exception {
        int expectedCount = 0;
        data.searchDetails.setNumberOfPassengers(11);
        List<Flight> matchedFlights = SearchFlights.byAvailableSeats(data.flights,data.searchDetails);
        Assert.assertEquals(expectedCount,matchedFlights.size());
    }
}
