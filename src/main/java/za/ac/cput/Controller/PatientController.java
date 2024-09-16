/* PatientController.java
   Class for the PatientController
   Author: Bilqees Saban (219090866)
   Date: 13 August 2021
 */

package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Factory.PatientFactory;
import za.ac.cput.Service.PatientService;

import java.util.Set;

@RestController
@RequestMapping("/patient")
public class PatientController
{
    @Autowired
    private PatientService patientService;

    //@RequestMapping(value = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public Patient create (@RequestBody Patient patient)
    {
        Patient newPatient = PatientFactory.createPatient
                (
                        patient.getPatID(),
                        patient.getPatFirstName(),
                        patient.getPatLastName(),
                        patient.getPatGender(),
                        patient.getPatAddress(),
                        patient.getPatAge(),
                        patient.getPatContactNumber(),
                        patient.getPatBloodType(),
                        patient.getPatCovidStatus()
                );
        return patientService.create(newPatient);
    }

    @GetMapping("/read/{PatID}")
    public Patient read (@PathVariable String PatID)
    {
        return patientService.read(PatID);
    }

    @PostMapping ("/update")
    public Patient update (@RequestBody Patient patient)
    {
        Patient update = patientService.update(patient);
        return update;
    }

    @DeleteMapping ("/delete/{PatID}")
    public String delete (@RequestBody Patient patient)
    {
        if (patientService.delete(patient.getPatID()))
            return "Bye-Bye";
        else
            return "I'm still here";
    }

    @GetMapping ("/getall")
    public Set<Patient> getAll()
    {
        return patientService.getAllPatient();
    }
}