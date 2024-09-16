/*
Doctor.java
DoctorRepository Test
Author : Liyabona Saki (217120830)
Date : 03 June 2021
 */

package za.ac.cput.Repository.Impl;

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Factory.DoctorFactory;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class DoctorRepositoryTest {

    private static DoctorRepository repository = DoctorRepository.getRepository();

    private static Doctor doctor1 = DoctorFactory.createDoctor(
            "d01","Liyabona","Saki",23,"male","078358874","Cape Town","root","master"
    );

    private static Doctor doctor2 = DoctorFactory.createDoctor(
            "d02","Emihle","Menzo",22,"female","078358874","Cape Town","mihle","mihle"
    );


    @Test
    void createDoctor() {
        System.out.println("================= Creating objects =============== ");
        Doctor created1 = repository.create(doctor1);
        Doctor created2 = repository.create(doctor2);
        assertEquals(created1.getId(), doctor1.getId());
        assertEquals(created2.getId(), doctor2.getId());

        System.out.println("Create: " + created1);
        System.out.println("Create: " + created2);


    }

    @Test
    void readDoctor() {
        System.out.println("================= Reading objects =============== ");
        Doctor read1 = repository.read(doctor1.getId());
        assertNotNull(read1);
        System.out.println("Read: " + read1);

        Doctor read2 = repository.read(doctor2.getId());
        assertNotNull(read2);
        System.out.println("Read: " + read2);

    }

    @Test
    void update() {
        System.out.println("================= Updating objects =============== ");

        Doctor updateInfo = new Doctor.Builder().copy(doctor1).setname("Master").build();
        assertNotNull(repository.update(updateInfo));
        System.out.println("Updated:" + updateInfo);
    }

    @Test
    void delete() {
        System.out.println("================= Deleting objects =============== ");
        boolean success = repository.delete(doctor2.getId());
        assertTrue (success);
        System.out.println("Deleted:" + true);


    }

    @Test
    void getAllDoctor(){

        System.out.println("Show All:");
        System.out.println(repository.getAllDoctor());
    }


}
