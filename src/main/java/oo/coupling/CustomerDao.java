package oo.coupling;

public interface CustomerDao {

    Customer findById(long id);

    void create(Customer customer);

    void save(Customer customer);

}
