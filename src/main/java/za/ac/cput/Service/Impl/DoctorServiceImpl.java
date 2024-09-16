package za.ac.cput.Service.Impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Repository.Impl.DoctorRepository;

import java.util.List;
import java.util.Set;

//This is the old service
@Deprecated
@Service
public class DoctorServiceImpl implements IDoctorService {


    private static DoctorServiceImpl service = null;
    private static DoctorRepository repository = null;

    private DoctorServiceImpl(){
        this.repository = DoctorRepository.getRepository();

    }
    public static DoctorServiceImpl getService(){
        if (service == null){
            service = new DoctorServiceImpl();
        }
        return service;

    }

    @Override
    public Doctor create(Doctor doctor) {
        return this.repository.create(doctor);
    }


    @Override
    public Doctor read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Doctor update(Doctor doctor) {
        return this.repository.update(doctor);
    }

    @Override
    public boolean delete(String id) {
        return this.repository.delete(id);
    }

    @Override
    public List<Doctor> getAllDoctor() {
        return (List<Doctor>) this.repository.getAllDoctor();
    }
}

