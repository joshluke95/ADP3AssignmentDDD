/*ConsultationController.java
Controller for Consultation
Author: Kanya Ramncwana (218297521)
Date: 18 August 2021
 */

package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Consultation;
import za.ac.cput.Factory.ConsultationFactory;
import za.ac.cput.Service.ConsultationService;
import za.ac.cput.Service.PatientService;

import java.util.Set;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    //@RequestMapping(value = "/create", method = RequestMethod.POST)

    @PostMapping("/create")
    public Consultation create (@RequestBody Consultation consultation)
    {
        Consultation newConsultation = ConsultationFactory.createConsultation
                (
                        consultation.getConsultID(),
                        consultation.getConsultDate(),
                        consultation.getConsultReport()
                );
        return consultationService.create(newConsultation);
    }

    @GetMapping("/read/{consultReport}")
    public Consultation read (@PathVariable String consultReport)
    {
        return consultationService.read(consultReport);
    }

    @PostMapping ("/update")
    public Consultation update (@RequestBody Consultation consultation)
    {
        Consultation update = consultationService.update(consultation);

        return update;
    }

    @DeleteMapping ("/delete/{consultID}")
    public String delete (@RequestBody Consultation consultation)
    {
        if (consultationService.delete(consultation.getConsultID()))

            return "Deleted";
        else
            return "Not Deleted";
    }

    @GetMapping ("/getall")
    public Set<Consultation> getAll()
    {
        return consultationService.getAllConsultation();
    }
}


