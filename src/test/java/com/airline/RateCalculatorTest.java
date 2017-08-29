package com.airline;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by rajashrk on 8/11/17.
 */
public class RateCalculatorTest {

    private FlightTestData data;

    @Before
    public void setUp() throws Exception {
        data = new FlightTestData();
    }

    @Test
    public void shouldReturnCorrectPrice() throws Exception {
        Double expectedValueForEconomyClass = 12000.0;
        Double expectedValueForBusinessClass = 26000.0;
        Double expectedValueForFirstClass = 40000.0;
        Flight flight1 = data.flight1;
        Assert.assertEquals(expectedValueForEconomyClass,new RateCalculator()
                .getPrice(flight1.getTravelClassFromClassType("Economy"),2));
        Assert.assertEquals(expectedValueForBusinessClass,new RateCalculator()
                .getPrice(flight1.getTravelClassFromClassType("business"),2));
        Assert.assertEquals(expectedValueForFirstClass,new RateCalculator()
                .getPrice(flight1.getTravelClassFromClassType("first"),2));
    }


    @Test
    public void shouldReturnCorrectPriceMap() throws Exception {
        Double expectedFlightPriceValue = 12000.0;
        Map<String, Double> priceMap = new RateCalculator().getPriceMap(data.flights, "Economy", 2);
        Assert.assertEquals(expectedFlightPriceValue, priceMap.get("F1"));
        Assert.assertEquals(expectedFlightPriceValue, priceMap.get("F2"));
        Assert.assertEquals(expectedFlightPriceValue, priceMap.get("F3"));
    }

    @Test
    public void extra30PercentPriceForSeatsLessThan60Percent() throws Exception {
        Double expectedValueForEconomyClass = 15600.0;
        TravelClass travelClass = mock(TravelClass.class);
        when(travelClass.getClassType()).thenReturn(ClassType.ECONOMY);
        when(travelClass.getAvailableSeats()).thenReturn(55);
        when(travelClass.getTotalSeats()).thenReturn(100);
        when(travelClass.getBasePrice()).thenReturn(6000.0);
        Assert.assertEquals(expectedValueForEconomyClass,new RateCalculator().getPrice(travelClass, 2));
    }

    @Test
    public void extra60PercentPriceForSeatsLessThan10Percent() throws Exception {
        Double expectedValueForEconomyClass = 19200.0;
        TravelClass travelClassEconomy = spy(new TravelClass(ClassType.ECONOMY, 100, 6000.0));
        when(travelClassEconomy.getAvailableSeats()).thenReturn(9);
        Assert.assertEquals(expectedValueForEconomyClass,new RateCalculator().getPrice(travelClassEconomy, 2));
    }
}
