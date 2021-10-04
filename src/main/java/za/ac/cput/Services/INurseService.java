/*INurseService.java
   Interface for the NurseService
   Author: Joshua Retief (214234169)
   Date: 15 August 2021
 */

package za.ac.cput.Services;

import za.ac.cput.Entity.Nurse;
import za.ac.cput.Repository.IRepository;

import java.util.Set;

public interface INurseService extends IService<Nurse, String>
{
    public Set<Nurse> getAllNurse();
}
