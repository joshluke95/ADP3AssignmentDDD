/* NurseRepositoryTest.java
   NurseRepositoryTest for the Nurse
   @ author: Joshua Luke Retief (214234169)
   Date: 10 June 2021
 */

package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import za.ac.cput.Entity.Nurse;
import za.ac.cput.Factory.NurseFactory;

import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class NurseRepositoryTest {
    private static final NurseRepository repository = NurseRepository.getRepository();

    private static final Nurse nurse1 = NurseFactory.createNurse
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

    private static final Nurse nurse2 = NurseFactory.createNurse
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
    void Create() {
        Nurse created1 = repository.create(nurse1);
        Nurse created2 = repository.create(nurse2);

        assertNotNull(created1);
        assertNotNull(created2);

        out.println("Create: " + created1);
        out.println("Create: " + created2);
    }

    @Test
    void Read() {
        boolean read1 = repository.read(nurse1.nurseID);
        assertTrue(read1);
        out.println("Read: " + read1);

        boolean read2 = repository.read(nurse2.nurseID);
        assertTrue(read2);
        out.println("Read: " + read2);
    }

    @Test
    void Update() {
        Nurse updated = new Nurse.BuilderNurse().copy(nurse2).setNurseName("Wesley").build();
        assertNotNull(repository.update(updated));
        out.println("Update: " + updated);
    }

    @Test
    void Delete() {
        boolean success = repository.delete(nurse1.nurseID);
        assertTrue(success);
        out.println("Delete: " + success);
    }

    @Test
    void GetAllNurse() {
        out.println("Show All:");
        out.println(repository.getAllNurse());
    }
}