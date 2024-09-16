/*
Doctor.java
DoctorRepository
Author : Liyabona Saki (217120830)
Date : 24 July 2021
 */

package za.ac.cput.Repository.Impl;

import za.ac.cput.Entity.Doctor;
import za.ac.cput.Factory.DoctorFactory;

import java.util.HashSet;
import java.util.Set;

public class DoctorRepository implements IDoctorRepository {

    private static DoctorRepository repository = null;
    private Set<Doctor> doctorDB = null;

    private DoctorRepository(){

        doctorDB = new HashSet<Doctor>();

    }


    public static DoctorRepository getRepository()
    {
        if (repository == null)
        {
            repository = new DoctorRepository();
        }
        return repository;
    }



    @Override
    public Doctor create(Doctor doctor) {
        boolean success = doctorDB.add(doctor);
        if (!success)
            return null;
        return doctor;
    }

    @Override
    public Doctor read(String id) {
        String doctorID = "";
        for (Doctor d : doctorDB)
            if (d.getId().equals(doctorID)) {
                return d;
            }
        return null;
    }

    @Override
    public Doctor update(Doctor doctor) {
        String index = doctor.getId();
        Doctor oldDoctor = read(index);
        System.out.println("oldDoctor: "+ oldDoctor);
        if (oldDoctor != null)
        {
            doctorDB.remove(oldDoctor);
            doctorDB.add(doctor);
            return doctor;
        }
        return doctor;

    }

    @Override
    public boolean delete(String id) {
        Doctor doc = read(id);
        if (doc == null)
            return false;
        doctorDB.remove(doc);
        return true;
    }

    public Set<Doctor> getAllDoctor() {
        return doctorDB;
    }
}
