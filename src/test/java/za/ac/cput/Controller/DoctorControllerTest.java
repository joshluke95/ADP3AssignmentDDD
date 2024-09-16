package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Repository.Impl.DoctorRepository;
import za.ac.cput.Service.Impl.DoctorService;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment  = SpringBootTest.WebEnvironment.RANDOM_PORT)


class DoctorControllerTest {

    private static DoctorRepository repository = null;
    private static DoctorService service = null;

    private void getService(){

    }

    @Test
    void create() {
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }



    @Test
    void delete() {
        if(service != null)return;{
            this.getService();
        }
    }

    @Test
    void getAllDoctors() {
    }
}