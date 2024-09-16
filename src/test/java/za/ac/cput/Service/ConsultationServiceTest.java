/*ConsultationServiceTest.java
Test for ConsultationService
Author: Kanya Ramncwana (218297521)
Date: 11 August 2021
*/

package za.ac.cput.Service;

import org.junit.jupiter.api.MethodOrderer;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Consultation;
import za.ac.cput.Factory.ConsultationFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class ConsultationServiceTest {

    private static ConsultationService service = ConsultationService.getService();

    private static Consultation consultation1 = ConsultationFactory.createConsultation("741", "12 August 2021", "Covid19 Test");

    private static Consultation consultation2 = ConsultationFactory.createConsultation("963", "15 August 2021", "High Blood Pressure");


    @Test
    void getService() {
    }

    @Test
    void create() {

        Consultation creation1 = service.create(consultation1);
        Consultation creation2 = service.create(consultation2);
        assertEquals(creation1.getConsultID(), consultation1.getConsultID());
        System.out.println("Create: " + creation1);

    }

    @Test
    void read() {

        Consultation read = service.read(consultation2.getConsultID());
        assertNotNull(read);
        System.out.println("Read: " + read);

    }

    @Test
    void update() {

        Consultation update = new Consultation.Builder().copy(consultation1).setConsultReport("Family Plannning").build();
        assertNotNull(service.update(update));
        System.out.println("Update: " + update);
    }

    @Test
    void delete() {

        boolean deleted = service.delete(consultation2.getConsultID());
        assertTrue (deleted);
        System.out.println("Delete:" + deleted);
    }

    @Test
    void getAllConsultation() {

        System.out.println("Display All Consultations:");
        System.out.println(service.getAllConsultation());

    }
}