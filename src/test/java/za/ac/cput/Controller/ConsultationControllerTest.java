/*ConsultationControllerTest.java
Test Class for ConsultationController
Author: Kanya Ramncwana (218297521)
Date: 18 August 2021
 */

package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Consultation;
import za.ac.cput.Factory.ConsultationFactory;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConsultationControllerTest {

    private static Consultation consultation = ConsultationFactory.createConsultation("021","17 August 2021","Tooth removal");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/consultation";

    public static Consultation getConsultation() {

        return consultation;

    }

    public static void setConsultation(Consultation consultation) {

        ConsultationControllerTest.consultation = consultation;
    }

    @Test
    void create() {

        String url = baseURL + "/create";
        ResponseEntity<Consultation> postResponse = restTemplate.postForEntity(url, consultation , Consultation.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        consultation = postResponse.getBody();
        System.out.println("Saved: " + consultation);
        assertEquals(consultation.getConsultID(), postResponse.getBody().getConsultID());

    }

    @Test
    void read() {

        String url = baseURL + "/read/" + consultation.getConsultID();
        System.out.println("URL: " + url);
        ResponseEntity<Consultation> response = restTemplate.getForEntity(url, Consultation.class);
        assertEquals(consultation.getConsultID(), response.getBody().getConsultID());
    }

    @Test
    void update() {

        Consultation update = new Consultation.Builder().copy(consultation).setConsultReport("Fever").build();
        String url = baseURL + "/update";
        System.out.println("Updated: " + update);
        ResponseEntity<Consultation> response = restTemplate.postForEntity(url, update, Consultation.class);
        assertNotNull(response.getBody());
    }

    @Test
    void delete() {

        String url = baseURL + "/delete/" + consultation.getConsultID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void getAll() {

        String url = baseURL + "/getall/";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Consultation> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Display All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}