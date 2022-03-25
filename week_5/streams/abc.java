package week_5.streams;

import java.util.*;

interface Client {
    double getCharges();

    double calculatePayment(GregorianCalendar invoiceDate);

    void sendEmail(double payment);
}

abstract class ServiceClient implements Client, Comparable<ServiceClient> {
    int id;
    String name;
    String email;
    double charges;
    GregorianCalendar dateOfAgreement;

    public int compareTo(ServiceClient other) {
        return this.id - other.id;
    }

    public double getCharges() {
        return charges;
    }

    public double calculate(GregorianCalendar invoiceDate) {
        int date = invoiceDate.get(Calendar.DATE);
        int agreementDate = dateOfAgreement.get(Calendar.DATE);
        return (date - agreementDate) * getCharges();
    }

    public void sendEmail(double payment) {
        System.out.println("Pending Payment: " + payment);
    }

}

class Customer extends ServiceClient {

    public Customer(int id, String name, String email, double charges, GregorianCalendar dateOfAgreement) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.charges = charges;
        this.dateOfAgreement = dateOfAgreement;
    }

    @Override
    public String toString() {
        return "Customer [charges=" + charges + ", dateOfAgreement=" + dateOfAgreement.get(Calendar.DATE) + ", email="
                + email + ", id="
                + id + ", name=" + name + "]";
    }

    @Override
    public double calculatePayment(GregorianCalendar invoiceDate) {
        return calculate(invoiceDate);
    }

}

class Business extends ServiceClient {

    double gstRate = 12;

    public Business(int id, String name, String email, double charges, GregorianCalendar dateOfAgreement) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.charges = charges;
        this.dateOfAgreement = dateOfAgreement;
    }

    @Override
    public double calculatePayment(GregorianCalendar invoiceDate) {
        return calculate(invoiceDate) * getGST();
    }

    double getGST() {
        return gstRate * calculate(new GregorianCalendar(2022, 2, 31));
    }

    @Override
    public String toString() {
        return "Business [charges=" + charges + ", dateOfAgreement=" + dateOfAgreement.get(Calendar.DATE) + ", email="
                + email
                + ", gstRate=" + gstRate + ", id=" + id + ", name=" + name + "]";
    }

}

public class abc {
    public static void main(String[] args) {
        ServiceClient c1 = new Customer(12, "Karan", "k@gmail.com", 1000, new GregorianCalendar(2022, 2, 7));
        ServiceClient c2 = new Customer(2, "Shivam", "s@gmail.com", 1000, new GregorianCalendar(2022, 2, 8));
        ServiceClient c3 = new Business(1, "Roger", "r@gmail.com", 2000, new GregorianCalendar(2022, 2, 9));
        ServiceClient c4 = new Business(5, "Sagar", "sc@gmail.com", 2000, new GregorianCalendar(2022, 2, 10));
        List<ServiceClient> clients = new ArrayList<>(Arrays.asList(c1, c2, c3, c4));
        double[] pendingPayments = new double[4];
        for (int i = 0; i < 4; i++) {
            pendingPayments[i] = clients.get(i).calculatePayment(new GregorianCalendar(2022, 2, 30));
        }
        System.out.println(Arrays.toString(pendingPayments));
        for (int i = 0; i < 4; i++) {
            clients.get(i).sendEmail(pendingPayments[i]);
        }
        System.out.println("Sort According to Id");
        Collections.sort(clients);
        clients.forEach(System.out::println);
        System.out.println("Sort According to charges");
        clients.sort((ServiceClient o1, ServiceClient o2) -> (int) (o2.getCharges() - o1.getCharges()));
        // Collections.sort(clients, new Comparator<Clients>() {
        // @Override
        // public int compare(Clients o1, Clients o2) {
        // return (int) (o2.getCharges() - o1.getCharges());
        // }
        // });
        clients.forEach(System.out::println);

        System.out.println("Sort According to date of Agreement");
        clients.sort((ServiceClient o1,
                ServiceClient o2) -> (o1.dateOfAgreement.get(Calendar.DATE) - o2.dateOfAgreement.get(Calendar.DATE)));
        clients.forEach(System.out::println);

    }

}
