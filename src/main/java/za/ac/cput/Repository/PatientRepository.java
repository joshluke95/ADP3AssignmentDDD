/* PatientRepository.java
 Class for the PatientRepository
 Author: Bilqees Saban (219090866)
  Date: 24 July 2021
*/

package za.ac.cput.Repository;

import za.ac.cput.Entity.Patient;
import java.util.HashSet;
import java.util.Set;

public class PatientRepository implements IPatientRepository
{
    private static PatientRepository repository = null;
    private Set<Patient> patientDB = null; // data structure as our data store

    private PatientRepository()
    {
        patientDB = new HashSet <Patient>();
    }

    public static PatientRepository getRepository()
    {
        if (repository == null)
        {
            repository = new PatientRepository();
        }
        return repository;
    }

    @Override
    public Patient create(Patient patient)
    {
        boolean success = patientDB.add(patient);
        if (!success)
            return null;
        return patient;
    }

    @Override
    public Patient read(String patID)
    {
        for (Patient p : patientDB)
            if (p.getPatID().equals(patID))
            {
                return p;
            }
        return null;
    }

    @Override
    public Patient update(Patient patient)
    {
        String index = patient.getPatID();
        Patient oldPatient = read(index);
        System.out.println("oldPatient: "+oldPatient);
        if (oldPatient != null)
        {
            patientDB.remove(oldPatient);
            patientDB.add(patient);
            return patient;
        }
        return null;
    }

    @Override
    public boolean delete(String patID)
    {
        Patient patientToDelete = read(patID);
        if (patientToDelete == null)
            return false;
        patientDB.remove(patientToDelete);
        return true;
    }

    public Set<Patient> getAllPatient()
    {
        return patientDB;
    }
}
