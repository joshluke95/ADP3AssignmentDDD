package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Repository.Impl.DoctorRepositoryUpdated;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DoctorService implements IDoctorService {

    private static DoctorService service = null;

    @Autowired
    private DoctorRepositoryUpdated repository;

    @Override
    public Doctor create(Doctor doctor) {
        return this.repository.save(doctor);
    }

    @Override
    public Doctor read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Doctor update(Doctor doctor) {
        if(this.repository.existsById(doctor.getId())){
            return this.repository.save(doctor);
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        if (this.repository.existsById(id))
            return false;
        else
            return true;

    }

    @Override
    public List<Doctor> getAllDoctor() {
        return this.repository.findAll();
    }

    public List<Doctor>getAllDoctorsStartWithA(){
        List<Doctor> doctorWithA = new ArrayList<>();
        List<Doctor> doctors = getAllDoctor();
        for(Doctor doctor : doctors){
            if(doctor.getName().trim().toLowerCase().startsWith("a")){
                doctorWithA.add(doctor);
            }
        }
        return doctorWithA;
    }
}
