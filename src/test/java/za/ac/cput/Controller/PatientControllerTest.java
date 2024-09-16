/* PatientControllerTest.java
   Class for the PatientControllerTest
   Author: Bilqees Saban (219090866)
   Date: 13 August 2021
 */

package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Factory.PatientFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PatientControllerTest
{
    private static Patient patient = PatientFactory.createPatient
            (
                    "P01",
                    "Bilqees",
                    "Saban",
                    "Female",
                    "1 Cape Town",
                    "20",
                    "0579845671",
                    "O",
                    "Negative"
            );

    private static Patient patient2 = PatientFactory.createPatient
            (
                    "P02",
                    "Rick",
                    "Allen",
                    "Female",
                    "2 Cape Town",
                    "60",
                    "0579985671",
                    "A",
                    "Positive"
            );

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/patient";

    public static Patient getPatient2() {
        return patient2;
    }

    public static void setPatient2(Patient patient2)
    {
        PatientControllerTest.patient2 = patient2;
    }

    @Test
    void a_create()
    {
        String url = baseURL + "/create";
        ResponseEntity<Patient> postResponse = restTemplate.postForEntity(url, patient , Patient.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        patient = postResponse.getBody();
        System.out.println("Saved data: " + patient);
        assertEquals(patient.getPatID(), postResponse.getBody().getPatID());
    }

    @Test
    void b_read()
    {
        String url = baseURL + "/read/" + patient.getPatID();
        System.out.println("URL: " + url);
        ResponseEntity<Patient> response = restTemplate.getForEntity(url, Patient.class);
        assertEquals(patient.getPatID(), response.getBody().getPatID());
    }

    @Test
    void c_update()
    {
        Patient updated = new Patient.Builder().copy(patient).setPatFirstName("Henry").build();
        String url = baseURL + "/update";
        System.out.println("Post data: " + updated);
        ResponseEntity<Patient> response = restTemplate.postForEntity(url, updated, Patient.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete()
    {
        String url = baseURL + "/delete/" + patient.getPatID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void e_getAll()
    {
        String url = baseURL + "/getall/";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity <String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }

}