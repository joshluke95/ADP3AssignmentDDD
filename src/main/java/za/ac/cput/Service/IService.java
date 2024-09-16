/*
This is a global service interface class which needs to be implemented
 */

package za.ac.cput.Service;

public interface IService <T,ID>{
    public T create(T t);
    public T read(ID id);
    public T update(T t);
    public boolean delete(ID id);
}
