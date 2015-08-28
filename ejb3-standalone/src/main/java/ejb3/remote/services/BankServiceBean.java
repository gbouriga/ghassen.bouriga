package ejb3.remote.services;

import ejb3.persistence.entities.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless(mappedName = "BankService")
public class BankServiceBean implements BankService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankServiceBean.class);
   
   @PersistenceContext
   private EntityManager em;

    public Customer findCustomer(int customerId) {
        Customer customer = getEm().find(Customer.class, customerId);
        if(customer != null){
            LOGGER.info("Customer found {}", customer.getId());
        }else{
            LOGGER.warn("Customer with id {} not found ", customerId);
        }


        return customer;
    }


    @SuppressWarnings("unchecked")
    public List<Customer> findCustomers() {
        Query query = getEm().createNamedQuery(Customer.GET_ALL_CUSTOMER);
        List<Customer> customers = query.getResultList();
        LOGGER.info("Number of customers found {}", customers.size());
        return customers;
    }

    public void addCustomer(String firstName, String lastName) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        getEm().persist(customer);
        LOGGER.info("{} customer added", lastName + " " +firstName);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
