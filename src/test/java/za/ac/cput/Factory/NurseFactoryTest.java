/* Nurse.java
   FactoryTest for the Nurse
   @ author: Joshua Luke Retief (214234169)
   Date: 10 June 2021
 */

package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Assertions;
import za.ac.cput.Entity.Nurse;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class NurseFactoryTest {

    @Test
    public void createNurse()
    {
        Nurse nurse = NurseFactory.createNurse
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
        System.out.println(nurse);
    }


   private Nurse.BuilderNurse build1;
   private Nurse.BuilderNurse build2;

   @BeforeEach
    void setUp(){
       build1 = new Nurse.BuilderNurse();
       build2 = new Nurse.BuilderNurse();
       build1 = build2;
   }

   @Test
    void testObjectEquality(){
       Assertions.assertEquals(build1, build2);
   }

   @Test
    void testObjectIdentity()
   {
       if (build1!= build2){
           assertNotSame(build1, build2);
           return;
       }
       assertSame(build1, build2);
   }

   @Test
    void fail(){
       System.out.println("This test is meant to fail");
   }

   @Test
   @Timeout(5)
    void PopulateFields() throws InterruptedException
   {
       try {
           TimeUnit.SECONDS.sleep(4);
           if (build1 != null) {
           build1.setNurseID("950501");
           build1.setNurseUsername("joshluke95");
           build1.setNursePassword("jl95_1878");
           build1.setNurseName("Joshua Retief");
           build1.setNurseGender("Male");
           build1.setNurseAddress("212 CWI 7654");
           build1.setNurseContactNumber("0645432156");
           build1.setNurseAge(26);

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
