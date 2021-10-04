/*INurseService.java
   Class for the Service
   Author: Joshua Retief (214234169)
   Date: 15 August 2021
 */

package za.ac.cput.Services;

import za.ac.cput.Entity.Nurse;
import za.ac.cput.Repository.NurseRepository;

import java.util.Set;

public class NurseService implements INurseService
{
    private static NurseService service = null;

    private NurseService() {
        NurseRepository.getRepository();
    }

    public static NurseService getService(){
        if (service == null) {
            service = new NurseService();
        }
        return service;
    }

    @Override
    public Nurse create(Nurse nurse) {
        return this.service.create(nurse);
    }

    @Override
    public boolean read(String nurseID) {
        return this.service.read(nurseID);
    }

    @Override
    public Nurse update(Nurse nurse) {
        return this.service.update(nurse);
    }

    @Override
    public boolean delete(String nurseID) {
        return this.service.delete(nurseID);
    }

    @Override
    public Set<Nurse> getAllNurse() {
        return this.service.getAllNurse();
    }
}
