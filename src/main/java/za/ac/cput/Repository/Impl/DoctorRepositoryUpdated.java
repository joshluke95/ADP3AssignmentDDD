package za.ac.cput.Repository.Impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Doctor;

@Repository
public interface DoctorRepositoryUpdated extends JpaRepository <Doctor,String> {

}
