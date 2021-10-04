/* NurseControllerTest.java
   Class for the NurseControllerTest
   Author: Joshua Retief (214234169)
   Date: 15 August 2021
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
import za.ac.cput.Entity.Nurse;
import za.ac.cput.Factory.NurseFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class NurseControllerTest
{
    private static Nurse nurse = NurseFactory.createNurse
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

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/nurse";

    public static Nurse getNurse2()
    {
        return nurse2;
    }

    public static void setNurse2(Nurse nurse2)
    {
        NurseControllerTest.nurse2 = nurse2;
    }

    @Test
    void a_create()
    {
        String url = baseURL + "/create";
        ResponseEntity<Nurse> postResponse = restTemplate.postForEntity(url, nurse, Nurse.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        nurse = postResponse.getBody();
        System.out.println("Saved data: " + nurse);
        assertEquals(nurse.nurseID, postResponse.getBody().nurseID);
    }

    @Test
    void b_read()
    {
        String url = baseURL + "/read/" + nurse.nurseID;
        System.out.println("URL: " + url);
        ResponseEntity<Nurse> response = restTemplate.getForEntity(url, Nurse.class);
        assertEquals(nurse.nurseID, response.getBody().nurseID);
    }

    @Test
    void c_update()
    {
        Nurse updated = new Nurse.BuilderNurse().copy(nurse).setNurseName("Kevin").build();
        String url = baseURL + "/update";
        System.out.println("Post Data: " + updated);
        ResponseEntity<Nurse> response = restTemplate.postForEntity(url, updated, Nurse.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete()
    {
        String url = baseURL + "/delete/" + nurse.nurseID;
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
        System.out.println("show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}