/*
Doctor.java
Factory for doctor
Author : Liyabona Saki (217120830)
Date : 03 June 2021
 */

package za.ac.cput.Factory;

import za.ac.cput.Entity.Doctor;

public class DoctorFactory {

    public static Doctor createDoctor (String id, String  name, String lastname,int age, String gender, String phone_number, String address, String username, String password) {
        Doctor doctor = new Doctor.Builder()
                .setid(id)
                .setname(name)
                .setlastname(lastname)
                .setage(age)
                .setgender(gender)
                .setphone_number(phone_number)
                .setaddres(address)
                .setusername(username)
                .setpassword(password)

                .build();

        return doctor;
    }
}
