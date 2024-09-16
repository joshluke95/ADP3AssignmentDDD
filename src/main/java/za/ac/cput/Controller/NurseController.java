/* NurseController.java
   Class for the NurseController
   Author: Joshua Retief (214234169)
   Date: 15 August 2021
 */

package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Nurse;
import za.ac.cput.Factory.NurseFactory;
import za.ac.cput.Service.NurseService;

import java.util.Set;

@RestController
@RequestMapping("/nurse")
public class NurseController
{
    @Autowired
    private NurseService nurseService;

    //@RequestMapping(value = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public Nurse create (@RequestBody Nurse nurse)
    {
        Nurse newNurse = NurseFactory.createNurse
                (
                        nurse.nurseID,
                        nurse.nurseUsername,
                        nurse.nursePassword,
                        nurse.nurseName,
                        nurse.nurseGender,
                        nurse.nurseAddress,
                        nurse.nurseContactNumber,
                        nurse.nurseAge
                );
        return nurseService.create(newNurse);

    }

    @GetMapping("/read/{NurseId}")
    public Nurse read (@PathVariable String NurseId)
    {
        return nurseService.read(NurseId);
    }

    @PostMapping ("/update")
    public Nurse update (@RequestBody Nurse nurse)
    {
        Nurse update = nurseService.update(nurse);
        return update;
    }

    @DeleteMapping ("/delete/{NurseId}")
    public String delete (@RequestBody Nurse nurse)
    {
        if (nurseService.delete(nurse.nurseID))
            return "Thanx for coming";
        else
            return "I'm still here";
    }

    @GetMapping ("/getall")
    public Set<Nurse> getAll()
    {
        return nurseService.getAllNurse();
    }
}
