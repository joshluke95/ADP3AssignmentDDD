/*IConsultationService.java
Interface Service for Consultation
Author: Kanya Ramncwana (218297521)
Date: 11 August 2021
*/
package za.ac.cput.Service;

import za.ac.cput.Entity.Consultation;

import java.util.Set;

public interface IConsultationService extends IService <Consultation, String>
{
    Set<Consultation> getAllConsultation();
}