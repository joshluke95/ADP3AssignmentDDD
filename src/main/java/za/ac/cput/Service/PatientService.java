/* PatientService.java
 Class for the PatientService
 Author: Bilqees Saban (219090866)
  Date: 29 July 2021
*/

package za.ac.cput.Service;

import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Repository.PatientRepository;

import java.util.Set;

@Service
public class PatientService implements IPatientService
{
    private static PatientService service = null;
    private static PatientRepository repository = null;

    private PatientService()
    {
        this.repository = PatientRepository.getRepository();
    }

    public static PatientService getService()
    {
        if (service == null)
        {
            service = new PatientService();
        }
        return service;
    }

    @Override
    public Patient create(Patient patient)
    {
        return this.repository.create(patient);
    }

    @Override
    public Patient read(String patID)
        {
            return this.repository.read(patID);
        }

    @Override
    public Patient update(Patient patient)
    {
        return this.repository.update(patient);
    }

    @Override
    public boolean delete(String patID)
    {
        return this.repository.delete(patID);
    }

    @Override
    public Set<Patient> getAllPatient()
    {
        return this.repository.getAllPatient();
    }
}
