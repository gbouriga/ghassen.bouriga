package ejb3.remote.services;

import ejb3.persistence.entities.Customer;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface BankService {
    void addCustomer(String firstName, String lastName);

    Customer findCustomer(int customerId);
    List<Customer> findCustomers();
}
