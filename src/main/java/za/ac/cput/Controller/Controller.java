/*Controller.java
   Class for the Controller
   Author: Joshua Retief (214234169)
   Date: 15 August 2021
 */

package za.ac.cput.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller
{
    @GetMapping("/")
    public String index()
    {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<title>Hospital Management System</title>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"w3-container w3-center w3-animate-bottom\">\n" +
                "  <h1>The Treat Hospital Management System!</h1>\n" +
                "  <p>Welcome to Hospital Management System</p>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
    }
}
