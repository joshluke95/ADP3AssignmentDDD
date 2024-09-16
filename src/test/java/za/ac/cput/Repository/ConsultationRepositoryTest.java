
package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Consultation;
import za.ac.cput.Factory.ConsultationFactory;
import za.ac.cput.Repository.ConsultationRepository;


import static org.junit.jupiter.api.Assertions.*;

class ConsultationRepositoryTest {

    private static ConsultationRepository repository = ConsultationRepository.getRepository();
    // private static Consultation consultation= createConsultation();

    private static Consultation consultation = ConsultationFactory.createConsultation("852", "12 June 2021","Covid 19 Test Results");

    private static Consultation consultation2 = ConsultationFactory.createConsultation("357", "21 June 2021", "Pap Smear Test Results");


    @Test
    void create() {

        Consultation created = repository.create(consultation);
        Consultation created2 = repository.create(consultation2);
        assertEquals(created.getConsultID(), created2.getConsultID());
        System.out.println("Create: " + created);
        System.out.println("Create: " + created2);
    }

    @Test
    void read() {

        Consultation read = repository.read(consultation.getConsultID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {

        Consultation update = new Consultation.Builder().copy(consultation).setConsultReport("HIV Reports").build();
        assertNotNull(repository.update(update));
        System.out.println("Update:" + update);
    }

    @Test
    void delete() {

        boolean success = repository.delete(consultation.getConsultID());
        assertTrue (success);
        System.out.println("Delete:" + success);
    }

}