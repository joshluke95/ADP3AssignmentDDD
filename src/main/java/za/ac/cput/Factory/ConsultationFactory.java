package za.ac.cput.Factory;

import za.ac.cput.Entity.Consultation;

public class ConsultationFactory {

    public static Consultation createConsultation(String consultID, String consultDate, String consultReport) {
        Consultation consultation = new Consultation.Builder()

                .setConsultID(consultID)
                .setConsultDate(consultDate)
                .setConsultReport(consultReport)
                .build();

        return consultation;
    }

}
