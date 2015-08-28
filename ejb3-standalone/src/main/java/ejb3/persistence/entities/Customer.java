package ejb3.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = Customer.GET_ALL_CUSTOMER, query = "select c from Customer c")
})
public class Customer implements Serializable {

    public static final String GET_ALL_CUSTOMER = "Customer.getAllCustomer";

    @Id
    @Column(name ="ID")
    @SequenceGenerator(name="SEQ_CUSTOMER", sequenceName="SEQ_CUSTOMER", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CUSTOMER")
    private int id;

    @Column(name ="FIRST_NAME")
    private String firstName;

    @Column(name ="LAST_NAME")
    private String lastName;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
      return "[Customer Id =" + id + ",first name=" + firstName + ",last name=" 
              + lastName + "]";   
   }

}
