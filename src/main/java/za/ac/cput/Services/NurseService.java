/*INurseService.java
   Class for the Service
   Author: Joshua Retief (214234169)
   Date: 15 August 2021
 */

package za.ac.cput.Services;

import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Nurse;
import za.ac.cput.Repository.NurseRepository;

import java.util.Set;

@Service
public class NurseService implements INurseService
{
    private static NurseService service = null;
    private static NurseRepository repository = null;

    private NurseService() {
        repository = NurseRepository.getRepository();
    }

    public static NurseService getService(){
        if (service == null) {
            service = new NurseService();
        }
        return service;
    }

    @Override
    public Nurse create(Nurse nurse)
    {
        return repository.create(nurse);
    }

    @Override
    public boolean read(String nurseID)
    {
        return repository.read(nurseID);
    }

    @Override
    public Nurse update(Nurse nurse)
    {
        return repository.update(nurse);
    }

    @Override
    public boolean delete(String nurseID) {
        return repository.delete(nurseID);
    }

    @Override
    public Set<Nurse> getAllNurse()
    {
        return repository.getAllNurse();
    }
}
