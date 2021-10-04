/*NurseRepository.java
   Class for the NurseRepository
   Author: Joshua Retief (214234169)
   Date: 15 August 2021
 */

package za.ac.cput.Repository;

import za.ac.cput.Entity.Nurse;

import java.util.HashSet;
import java.util.Set;

public class NurseRepository implements INurseRepository
{
    public static NurseRepository repository = null;
    public Set<Nurse> nurseDB = null;

    public NurseRepository()
    {
        nurseDB = new HashSet<Nurse>();
    }

    public static NurseRepository getRepository()
    {
        if (repository == null)
        {
            repository = new NurseRepository();
        }
        return repository;
    }


    @Override
    public Nurse create(Nurse nurse)
    {
        boolean success = nurseDB.add(nurse);
        if(!success)
                return null;
        return nurse;
    }

    @Override
    public Nurse read(String nurseID) {
        for (Nurse nurse : nurseDB)
            if (nurse.nurseID.equals(nurseID)) {
                return nurse;
            }
        return null;
    }



    @Override
    public Nurse update(Nurse nurse)
    {
        Nurse oldNurse = read(nurse.nurseID);
        if (oldNurse != null){
            nurseDB.remove(oldNurse);
            nurseDB.add(nurse);
            return null;
        }
        return nurse;
    }

    @Override
    public boolean delete(String nurseID)
    {
        Nurse nurseToDelete = read(nurseID);
        if(nurseToDelete == null)
            return  true;
        nurseDB.remove(nurseToDelete);
        return false  ;
    }

    public Set<Nurse> getAllNurse()
    {
        return nurseDB;
    }
}

