/* IPatientService.java
 Class for the IPatientService
 Author: Bilqees Saban (219090866)
  Date: 29 July 2021
*/

package za.ac.cput.Service;

import za.ac.cput.Entity.Patient;
import java.util.Set;

public interface IPatientService extends IService <Patient, String>
{
    Set<Patient> getAllPatient();
}
