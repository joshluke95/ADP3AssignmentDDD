/*Consultation.java
Entity for Consultation
Author: Kanya Ramncwana (218297521)
Date: 24 May 2021
 */

package za.ac.cput.Entity;

public class Consultation {

    private String consultID,consultDate, consultReport;

    public Consultation(Builder builder) {

        this.consultID = builder.consultID;
        this.consultDate = builder.consultDate;
        this.consultReport = builder.consultReport;

    }

    @Override
    public String toString() {
        return "Consultation{" +
                "consultDate='" + consultDate + '\'' +
                ", consultReport='" + consultReport + '\'' +
                '}';
    }


    public String getConsultID() {

        return consultID;
    }


    public String getConsultDate() {

        return consultDate;
    }

    public String getConsultReport() {

        return consultReport;
    }


    public static class Builder {

        private String consultID, consultDate, consultReport;



        public Builder setConsultID(String consultID) {

            this.consultID = consultID;

            return this;
        }

        public Builder setConsultDate(String consultDate) {

            this.consultDate = consultDate;

            return this;
        }

        public Builder setConsultReport(String consultReport) {

            this.consultReport = consultReport;

            return this;
        }

        public Consultation build() {

            return new Consultation(this);

        }
        public Builder copy(Consultation consult) {

            this.consultDate = consult.consultDate;
            this.consultReport = consult.consultReport;

            return this;
        }
    }
}
