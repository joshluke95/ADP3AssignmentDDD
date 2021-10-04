/*IService.java
   Interface for the Repository
   Author: Joshua Retief (214234169)
   Date: 15 August 2021
 */

package za.ac.cput.Repository;

public interface IRepository<T, ID>
{
    public T create (T t);
    public boolean read (ID id);
    public T update (T t);
    public boolean delete (ID id);

}
