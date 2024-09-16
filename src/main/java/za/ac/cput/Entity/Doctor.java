/*
Doctor.java
Entity for doctor
Author : Liyabona Saki (217120830)
Date : 03 June 2021
 */

package za.ac.cput.Entity;


import javax.persistence.*;

@Entity
@Table(name ="doctors")

public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String lastname;
    private int age;
    private String gender;
    private String phone_number;
    private String address;
    private String username;
    private String password;


    public Doctor() {

    }

    public Doctor(String id, String name, String lastname, int age, String gender, String phone_number, String address, String username, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.phone_number = phone_number;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Doctor(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.lastname = builder.lastname;
        this.age = builder.age;
        this.gender = builder.gender;
        this.phone_number = builder.phone_number;
        this.address = builder.address;
        this.username = builder.username;
        this.password = builder.password;

    }
    @Override
    public String toString() {
        return "Builder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



    public static class Builder {

        private String id;
        private String name;
        private String lastname;
        private int age;
        private String gender;
        private String phone_number;
        private String address;
        private String username;
        private String password;

        public Builder setid(String id) {
            this.id = id;
            return this;
        }

        public Builder setname(String name) {
            this.name = name;
            return this;
        }

        public Builder setlastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder setage(int age) {
            this.age = age;
            return this;
        }

        public Builder setgender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setphone_number(String phone_number) {
            this.phone_number = phone_number;
            return this;
        }

        public Builder setaddres(String address) {
            this.address = address;
            return this;
        }

        public Builder setusername(String username) {
            this.username = username;
            return this;
        }

        public Builder setpassword(String password) {
            this.password = password;
            return this;
        }

        public Doctor build() {
            return new Doctor(this);
        }

        public Builder copy(Doctor d) {

            this.id = d.id;
            this.name = d.name;
            this.lastname = d.lastname;
            this.age = d.age;
            this.gender = d.gender;
            this.phone_number = d.phone_number;
            this.address = d.address;
            this.username = d.username;
            this.password = d.password;

            return this;
        }


        //COPY

    }

}


