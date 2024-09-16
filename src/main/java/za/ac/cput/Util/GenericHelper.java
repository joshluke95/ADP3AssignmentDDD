/* Nurse.java
   Generate ID for the Nurse
   Global ID Generator inherited in other classes
   @ author: Joshua Luke Retief (214234169)
   Date: 10 June 2021
 */

package za.ac.cput.Util;

import java.util.UUID;

public class GenericHelper {
    public static String generateID()
    {
        return UUID.randomUUID().toString();
    }
}
