package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.Consultation;
import za.ac.cput.Factory.ConsultationFactory;


import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ConsultationFactoryTest {

    private Consultation consultation1;
    private Consultation consultation2;

    {
        consultation1 = ConsultationFactory.createConsultation("021", "21 June 2021", "Covid 19 test: Negative");

        consultation2 = ConsultationFactory.createConsultation("456", "01 July 2021", "High Blood Pressure");

        consultation2 = consultation1;

    }

    @Test
    void testIdentity()
    {
        assertSame (consultation1, consultation2);

    }

    @Test
    void testEquality()
    {
        assertEquals(consultation1, consultation2);
    }

    @Timeout(value = 4, unit = TimeUnit.MILLISECONDS)
    @Test
    void timeouts()
    {
        assertEquals(consultation1, consultation2);
    }



}