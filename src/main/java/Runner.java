import db.DBCustomer;
import db.DBOrder;
import models.Customer;
import models.Order;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Customer customer1 = new Customer("John", "Woods");
        DBCustomer.save(customer1);

        Customer customer2 = new Customer("Margaret", "Woods");
        DBCustomer.save(customer2);

        DBCustomer.delete(customer1);
        List<Customer> customers = DBCustomer.getCustomer();

        Order order1 = new Order("BMX", 500.00);
        DBOrder.save(order1);

        Order order2 = new Order("PS4", 500.00);
        DBOrder.save(order2);
    }

}
