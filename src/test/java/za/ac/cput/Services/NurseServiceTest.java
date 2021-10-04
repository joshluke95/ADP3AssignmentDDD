/* NurseServiceTest.java
   NurseServiceTest for the Nurse
   @ author: Joshua Luke Retief (214234169)
   Date: 10 June 2021
 */

package za.ac.cput.Services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Nurse;
import za.ac.cput.Factory.NurseFactory;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
class NurseServiceTest {
    private static NurseService service = NurseService.getService();
    private static Nurse nurse1 = NurseFactory.createNurse
            (
                    "950501",
                    "joshluke95",
                    "jl95_1878",
                    "Joshua Retief",
                    "Male",
                    "212 CWI 7654",
                    "0645432156",
                    26
            );

    private static Nurse nurse2 = NurseFactory.createNurse
            (
                    "950812",
                    "wesmichael95",
                    "wm95_1536",
                    "Wesley Retief",
                    "Male",
                    "212 WJT 8001",
                    "0840873716",
                    26
            );

    @Test
    void a_create()
    {
        Nurse created = service.create(nurse1);
        Nurse created2 = service.create(nurse2);

        assertNotNull(created);
        assertNotNull(created2);

        System.out.println("Create: " + created);
        System.out.println("Create: " + created2);
    }

    @Test
    void b_read() {
        Nurse read = service.read(nurse1.nurseID);
        Assertions.assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update()
    {
        Nurse updated = new Nurse.BuilderNurse().copy(nurse2).setNurseName("Melanie").build();
        Assertions.assertNotNull(service.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void d_delete()
    {
        boolean success = service.delete(nurse1.nurseID);
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void e_getAllNurse()
    {
        System.out.println("Show All: ");
        System.out.println(service.getAllNurse());
    }
}