class Address1 {
    Location1 location;
    String state;
    String country;

    public Address1(Location1 location, String state, String country) {
        this.location = location;
        this.state = state;
        this.country = country;
    }

}

class Location1 {
    String street;
    String city;

    public Location1(String street, String city) {
        this.street = street;
        this.city = city;
    }

}

class UPIPaymentApps1 implements Cloneable {
    String appName;
    String country;
    int dailyLimit;
    double maxDailyAmount;
    Address1 headOfficeLocation;

    // For shallow copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    String getLocation() {
        return headOfficeLocation.location.street + "," + headOfficeLocation.location.city + ","
                + headOfficeLocation.state + "," + headOfficeLocation.country;
    }

    @Override
    public String toString() {
        return "UPIPaymentApps [appName=" + appName + ", country=" + country + ", dailyLimit=" + dailyLimit
                + ", headOfficeLocation=" + getLocation() + ", maxDailyAmount=" + maxDailyAmount + "]";
    }

    public UPIPaymentApps1(String appName, String country, int dailyLimit, double maxDailyAmount,
            Address1 headOfficeLocation) {
        this.appName = appName;
        this.country = country;
        this.dailyLimit = dailyLimit;
        this.maxDailyAmount = maxDailyAmount;
        this.headOfficeLocation = headOfficeLocation;
    }
}

public class UPI1 {
    public static void main(String[] args) throws Exception {
        Location1 location = new Location1("23rd Street", "Gurugram");
        Address1 address = new Address1(location, "Haryana", "India");
        UPIPaymentApps1 bhim = new UPIPaymentApps1("Bhim", "India", 2000, 10000, address);
        UPIPaymentApps1 gpay = (UPIPaymentApps1) bhim.clone();
        UPIPaymentApps1 phonepe = (UPIPaymentApps1) bhim.clone();
        gpay.appName = "gpay";
        phonepe.appName = "phonepe";
        phonepe.headOfficeLocation.state = "Delhi-NCR";
        System.out.println(" !!!Shallow Copy!!!");
        System.out.println(gpay);
        System.out.println(phonepe);
        System.out.println("-----------------------------------");

    }
}
