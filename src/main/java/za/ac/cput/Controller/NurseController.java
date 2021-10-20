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
import za.ac.cput.Services.NurseService;

import java.util.Set;

@RestController
@RequestMapping("/nurse")
public class NurseController
{
    @Autowired
    private NurseService nurseService;

    //Create
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

    //Read
    @GetMapping("/read/{id}")
    public boolean read (@PathVariable Nurse id)
    {
        return nurseService.read(id.nurseID);
    }

    //Update
    @PostMapping ("/update")
    public Nurse update (@RequestBody Nurse nurse)
    {
        return this.nurseService.update(nurse);

    }

    //Delete
    @DeleteMapping ("/delete/{id}\"")
    public boolean delete (@PathVariable Nurse id)
    {
        return nurseService.delete(id.nurseID);
    }

    //Get All
    @GetMapping ("/getall")
    public Set<Nurse> getAll()
    {
        return nurseService.getAllNurse();
    }
}
