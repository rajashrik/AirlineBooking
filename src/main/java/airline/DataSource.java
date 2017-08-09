package airline;

import java.util.ArrayList;
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

}
