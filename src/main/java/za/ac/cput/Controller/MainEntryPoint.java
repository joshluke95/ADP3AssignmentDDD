/* MainEntryPoint.java
   Class for the MainEntryPoint
   Author: Joshua Retief (214234169)
   Date: 15 August 2021
 */

package za.ac.cput.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class MainEntryPoint
{
   @RequestMapping({"/", "/home"})
   public String home() { return "Hospital Management System"; }
}
