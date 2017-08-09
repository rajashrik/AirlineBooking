package airline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rajashrk on 8/8/17.
 */
@Controller
@SpringBootApplication
@EnableAutoConfiguration
public class FlightController {

    public static void main(String []args) {
        SpringApplication.run(FlightController.class,args);
    }

    @RequestMapping("/")
    public String welcomeMessage(Model model) {
        model.addAttribute("locations",DataSource.instance().fetchLocations());
        return "flightSearch";
    }

    @RequestMapping(value= "/search", method = RequestMethod.POST)
    public String searchFlights(@ModelAttribute(value="searchDetails") SearchDetails searchDetails, Model model) {
        model.addAttribute("locations",DataSource.instance().fetchLocations());
        model.addAttribute("to",searchDetails.getTo());
        return "flightSearch";
    }


}
