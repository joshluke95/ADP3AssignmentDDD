/*
Author Liyabona Saki (217120830)
 */

package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Factory.DoctorFactory;
import za.ac.cput.Service.Impl.DoctorService;
import za.ac.cput.Service.Impl.DoctorServiceImpl;

import java.util.List;
import java.util.Set;


@Controller
//@RestController
//@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    /*
    THYMELEAF IMPLEMENTATION
     */
    @GetMapping("getAll")
    public String viewHomePage(Model model) {
        //display a list of doctors
        model.addAttribute("listDoctors", doctorService.getAllDoctor());
        return "index";
    }

    @GetMapping("/create")
    //create model attribute to bind form data
    public String showNewDoctorForm(Model model) {
        Doctor doctor = new Doctor();
        model.addAttribute("doctor", doctor);
        return "new_doctor";

    }

    @PostMapping ("/saveDoctor")
    public String saveDoctor(@ModelAttribute("doctor") Doctor doctor) {
        //save doctor to database
        doctorService.create(doctor);
        return "redirect:/";
    }

    @GetMapping("/deleteDoctor/{id}")
    public String deleteDoctor(@PathVariable(value = "id") String id) {
        //call delete doctor method
        this.doctorService.delete(id);
        return "redirect:/";
    }




    //RestController Implementation
    //Create
    /*
        @RequestMapping(value = "/create",method = RequestMethod.POST)
    public Doctor create(Doctor doctor){
        Doctor newDoctor = DoctorFactory.createDoctor(doctor.getId(),
                doctor.getName(),
                doctor.getLastname(),
                doctor.getAge(),
                doctor.getPhone_number(),
                doctor.getAddress(),
                doctor.getGender(),
                doctor.getUsername(),
                doctor.getPassword());
        return doctorService.create(newDoctor);
    }

     */

    //    Read
    @GetMapping("/read/{id}")
    public Doctor read(@PathVariable Doctor doctor){
        return doctorService.read(doctor.getId());
    }

    //Update
    @PostMapping("/update")
    public Doctor update(@RequestBody Doctor doctor){
        return this.doctorService.update(doctor);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Doctor doctor){
        return doctorService.delete(doctor.getId());
    }

    //List all
//    @GetMapping("/getAll")
//    public List<Doctor> getAllDoctors(){
//        return doctorService.getAllDoctor();
//    }


}
