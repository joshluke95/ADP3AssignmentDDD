/*ConsultationRepository.java
Repository for Consultation
Author: Kanya Ramncwana (218297521)
Date: 24 July 2021
 */

package za.ac.cput.Repository;

import za.ac.cput.Entity.Consultation;


import java.util.HashSet;
import java.util.Set;

public class ConsultationRepository implements IConsultationRepository
{
    private static ConsultationRepository repository = null;
    private  Set<Consultation> consultationDB;

    private ConsultationRepository() {

        consultationDB = new HashSet<Consultation>();

    }

    public static ConsultationRepository getRepository(){
        if (repository == null)
        {
            repository = new ConsultationRepository();
        }
        return repository;
    }


    @Override
    public Consultation create(Consultation consultation) {

        boolean success = consultationDB.add(consultation);
        if (!success)
            return null;
        return consultation;
    }

    @Override
    public Consultation read(String id) {

        String consultID = "";

        for (Consultation consult: consultationDB)
            if (consult.getConsultID().equals(consultID))
            {
                return consult;
            }
        return null;
    }

    @Override
    public Consultation update(Consultation consultation) {

        String index = consultation.getConsultID();
        Consultation prevConsult = read(index);
        System.out.println("Previous Consultation: "+prevConsult);
        if (prevConsult != null)
        {
            consultationDB.remove(prevConsult);
            consultationDB.add(consultation);
            return consultation;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        String consultationID = "";
        Consultation consultationDelete = read(consultationID);
        if (consultationDelete == null)
            return false;
        consultationDB.remove(consultationDelete);
        return true;
    }

    public Set<Consultation> getAllConsultation()
    {
        return consultationDB;
    }
}