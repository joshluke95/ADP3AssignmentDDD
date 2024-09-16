package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Factory.DoctorFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class DoctorServiceImplTest {

    private static DoctorServiceImpl service = DoctorServiceImpl.getService();
    private static Doctor doctor1 = DoctorFactory.createDoctor(
            "d01","Liyabona","Saki",23,"male","078358874","Cape Town","root","master"
    );

    private static Doctor doctor2 = DoctorFactory.createDoctor(
            "d02","Emihle","Menzo",22,"female","078358874","Cape Town","mihle","mihle"
    );


    @Test
    void getService() {
        DoctorServiceImpl doctorService = DoctorServiceImpl.getService();
    }

    @Test
    void create() {
        Doctor created = service.create(doctor1);
        Doctor created2 = service.create(doctor2);
        assertEquals(created.getId(), doctor1.getId());
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        Doctor read = service.read(doctor1.getId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        Doctor updated = new Doctor.Builder().copy(doctor1).setname("Liya").build();
        assertNotNull(service.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete() {
        boolean success = service.delete(doctor1.getId());
        assertTrue (success);
        System.out.println("Delete: " + success);
    }

    @Test
    void getAllDoctor() {
        System.out.println("Show All:");
        System.out.println(service.getAllDoctor());
    }
}