/* NurseRepositoryTest.java
   NurseRepositoryTest for the Nurse
   @ author: Joshua Luke Retief (214234169)
   Date: 10 June 2021
 */

package za.ac.cput.Repository;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import za.ac.cput.Entity.Nurse;
import za.ac.cput.Factory.NurseFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class NurseRepositoryTest {
    private static NurseRepository repository = NurseRepository.getRepository();

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
    void create()
    {
        Nurse created1 = repository.create(nurse1);
        Nurse created2 = repository.create(nurse2);

        assertNotNull(created1);
        assertNotNull(created2);
        //assertEquals(created.getClass(), nurse.nurseID);
        System.out.println("Create: " + created1);
        System.out.println("Create: " + created2);

    }

    @Test
    void read()
    {
        Nurse read1 = repository.read(nurse1.nurseID);
        Assertions.assertEquals(read1.nurseID, nurse1);
        System.out.println("Read: " + read1);

        Nurse read2 = repository.read(nurse2.nurseID);
        Assertions.assertEquals(read1.nurseID, nurse2);
        System.out.println("Read: " + read2);
    }

    @Test
    void update()
    {
        Nurse updated = new Nurse.BuilderNurse().copy(nurse2).setNurseName("Wesley").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete()
    {
        boolean success = repository.delete(nurse1.nurseID);
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void getAllNurse()
    {
        System.out.println("Show All:");
        System.out.println(repository.getAllNurse());
    }
}