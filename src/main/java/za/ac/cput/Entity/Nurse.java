/* Nurse.java
   Entity for the Nurse
   @ author: Joshua Luke Retief (214234169)
   Date: 10 June 2021
 */

package za.ac.cput.Entity;

public class Nurse {
    public String nurseID, nurseUsername, nursePassword, nurseName, nurseGender, nurseAddress,nurseContactNumber;
    public int nurseAge;

    public Nurse() {}

    public Nurse(BuilderNurse builder)
    {
        this.nurseID = builder.nurseID;
        this.nurseUsername = builder.nurseUsername;
        this.nursePassword = builder.nursePassword;
        this.nurseName = builder.nurseName;
        this.nurseGender = builder.nurseGender;
        this.nurseAddress = builder.nurseAddress;
        this.nurseAge = builder.nurseAge;
        this.nurseContactNumber = builder.nurseContactNumber;
    }

    @Override
    public String toString()
    {
        return "Nurse{" +
                "nurseID='" + nurseID + '\'' +
                ", nurseUsername='" + nurseUsername + '\'' +
                ", nursePassword='" + nursePassword + '\'' +
                ", nurseName='" + nurseName + '\'' +
                ", nurseGender='" + nurseGender + '\'' +
                ", nurseAddress='" + nurseAddress + '\'' +
                ", nurseAge=" + nurseAge + '\'' +
                ", nurseContactNumber=" + nurseContactNumber +
                '}';
    }

    public static class BuilderNurse
    {
        public String nurseID, nurseUsername, nursePassword, nurseName, nurseGender, nurseAddress, nurseContactNumber;
        public int nurseAge;

        public BuilderNurse setNurseID(String nurseID) {
            this.nurseID = nurseID;
            return this;
        }

        public BuilderNurse setNurseUsername(String nurseUsername) {
            this.nurseUsername = nurseUsername;
            return this;
        }

        public BuilderNurse setNursePassword(String nursePassword) {
            this.nursePassword = nursePassword;
            return this;
        }

        public BuilderNurse setNurseName(String nurseName) {
            this.nurseName = nurseName;
            return this;
        }

        public BuilderNurse setNurseGender(String nurseGender) {
            this.nurseGender = nurseGender;
            return this;
        }

        public BuilderNurse setNurseAddress(String nurseAddress) {
            this.nurseAddress = nurseAddress;
            return this;
        }

        public BuilderNurse setNurseAge(int nurseAge) {
            this.nurseAge = nurseAge;
            return this;
        }

        public BuilderNurse setNurseContactNumber(String nurseContactNumber) {
            this.nurseContactNumber = nurseContactNumber;
            return this;
        }

        public Nurse build()
        {
            return new Nurse(this);
        }

        public BuilderNurse copy(Nurse nurse)
        {
            this.nurseID = nurse.nurseID;
            this.nurseUsername = nurse.nurseUsername;
            this.nursePassword = nurse.nursePassword;
            this.nurseName = nurse.nurseName;
            this.nurseGender = nurse.nurseGender;
            this.nurseAddress = nurse.nurseAddress;
            this.nurseAge = nurse.nurseAge;
            this.nurseContactNumber = nurse.nurseContactNumber;
            
            return this;
        }
    }
}
