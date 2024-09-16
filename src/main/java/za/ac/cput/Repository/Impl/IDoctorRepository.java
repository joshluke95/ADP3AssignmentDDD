/*
Doctor.java
IDoctorRepository for doctor
Author : Liyabona Saki (217120830)
Date : 24 July 2021
 */

package za.ac.cput.Repository.Impl;

import za.ac.cput.Entity.Doctor;
import za.ac.cput.Repository.IRepository;

public interface IDoctorRepository extends IRepository<Doctor,String> {

    public Doctor create(Doctor doctor);
    public Doctor read(String id);
    public Doctor update(Doctor doctor);
    public boolean delete(String id);
}
