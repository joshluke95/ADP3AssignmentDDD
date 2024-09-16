package za.ac.cput.Service.Impl;

import za.ac.cput.Entity.Doctor;
import za.ac.cput.Service.IService;

import java.util.List;
import java.util.Set;

public interface IDoctorService extends IService <Doctor,String> {
    Doctor create(Doctor doctor);
    Doctor read(String id);
    Doctor update(Doctor doctor);
    boolean delete(String id);

    List<Doctor> getAllDoctor();


}
