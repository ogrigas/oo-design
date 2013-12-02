package oo.coupling;

public class CustomerService {

    private CustomerDao customerDao;
    private CustomerMessageDao customerMessageDao;
    private Audit audit;
    private EmailGateway emailGateway;

    public Customer register(String name, String email) {
        Customer customer = new Customer(99999, name, email);
        customerDao.create(customer);
        audit.log("Customer " + name + " registered");
        return customer;
    }

    public void sendWelcomeLetter(long customerId) {
        Customer customer = customerDao.findById(customerId);
        String message = "Welcome, " + customer.getName() + ", have a nice day!";
        customerMessageDao.addMessage(customerId, message);
        emailGateway.send(getEmail(customer), message);
    }

    public void rename(long customerId, String newName) {
        Customer customer = customerDao.findById(customerId);
        String oldName = customer.getName();
        customer.setName(newName);
        customerDao.save(customer);
        audit.log("Customer " + oldName + " renamed to " + newName);
    }

    public void sendWarningLetter(long customerId) {
        Customer customer = customerDao.findById(customerId);
        String message = "You are about to be terminated, " + customer.getName();
        customerMessageDao.addMessage(customerId, message);
        emailGateway.send(getEmail(customer), message);
    }

    public void sendGoodbyeLetter(long customerId) {
        Customer customer = customerDao.findById(customerId);
        String message = "So long, " + customer.getName() + ", and thanks for all the fish.";
        customerMessageDao.addMessage(customerId, message);
        emailGateway.send(getEmail(customer), message);
    }

    private String getEmail(Customer customer) {
        for (Contact contact : customer.getContacts()) {
            if (contact.getType() == Contact.Type.EMAIL) {
                return contact.getDetails();
            }
        }
        return null;
    }
}
