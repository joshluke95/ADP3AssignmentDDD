/*
DoctorTest.java
Factory for doctor
Author : Liyabona Saki (217120830)
Date : 09 June 2021
 */

package za.ac.cput.Factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

import za.ac.cput.Entity.Doctor;

import java.util.concurrent.TimeUnit;

class DoctorTest {

    private Doctor.Builder build1;
    private Doctor.Builder build2;

    @BeforeEach
    void setUp() {
        build1 = new Doctor.Builder();
        build2 = new Doctor.Builder();
        build1 = build2;

    }
    @Test
    void testEquality(){
        Assertions.assertEquals(build1, build2);

    }

    @Test
    void testIdentity(){
        //Early exits
        if(build1!= build2){
            assertNotSame(build1,build2);
            return;
        }
        assertSame(build1 , build2);
    }

    @Test
    void fail(){

    }

    @Test
    @Timeout(5)
    void PopulateFields() throws  InterruptedException{
        try{
            TimeUnit.SECONDS.sleep(4);
            if (build1 != null){
                build1.setid("d01");
                build1.setname("Liyabona");
                build1.setlastname("Saki");
                build1.setage(23);
                build1.setaddres("Cape town");
                build1.setgender("male");
                build1.setphone_number("025566589");
                build1.setusername("liyabona");
                build1.setpassword("liyabona@98");

                assertNotNull(build1.build());
                System.out.println(build1.toString());
            }else {
                assertNull(build1.build());
            }
        }catch (Exception e){
            e.getStackTrace();
        }

    }

}