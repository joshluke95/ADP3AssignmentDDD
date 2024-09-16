
/*ConsultationService.java
Service for Consultation
Author: Kanya Ramncwana (218297521)
Date: 11 August 2021
*/

package za.ac.cput.Service;

import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Consultation;
import za.ac.cput.Repository.ConsultationRepository;
import za.ac.cput.Repository.IConsultationRepository;

import java.util.Set;

@Service
public class ConsultationService implements IConsultationRepository {

    private static ConsultationService service = null;
    private static ConsultationRepository repository = null;

    private ConsultationService()
    {
        this.repository = ConsultationRepository.getRepository();

    }


    public static ConsultationService getService()
    {
        if (service == null)
        {
            service = new ConsultationService();
        }
        return service;
    }

    @Override
    public Consultation create(Consultation consultation) {

        return this.repository.create(consultation);
    }

    @Override
    public Consultation read(String consultID) {

        return this.repository.read(consultID);
    }

    @Override
    public Consultation update(Consultation consultation) {

        return this.repository.update(consultation);

    }

    @Override
    public boolean delete(String consultID) {

        return this.repository.delete(consultID);

    }

    public Set<Consultation> getAllConsultation()
    {
        return this.repository.getAllConsultation();

    }
}