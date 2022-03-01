package week_2;

class Address {
    Location location;
    String state;
    String country;

    public Address(Location location, String state, String country) {
        this.location = location;
        this.state = state;
        this.country = country;
    }

}

class Location {
    String street;
    String city;

    public Location(String street, String city) {
        this.street = street;
        this.city = city;
    }

}

class UPIPaymentApps implements Cloneable {
    String appName;
    String country;
    int dailyLimit;
    double maxDailyAmount;
    Address headOfficeLocation;

    // For deep copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Location location = new Location(headOfficeLocation.location.street, headOfficeLocation.location.city);
        Address address = new Address(location, headOfficeLocation.state, headOfficeLocation.country);
        return new UPIPaymentApps(appName, country, dailyLimit,
                maxDailyAmount, address);

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

    public UPIPaymentApps(String appName, String country, int dailyLimit, double maxDailyAmount,
            Address headOfficeLocation) {
        this.appName = appName;
        this.country = country;
        this.dailyLimit = dailyLimit;
        this.maxDailyAmount = maxDailyAmount;
        this.headOfficeLocation = headOfficeLocation;
    }
}

public class UPI {
    public static void main(String[] args) throws Exception {
        Location location = new Location("23rd Street", "Gurugram");
        Address address = new Address(location, "Haryana", "India");
        UPIPaymentApps bhim = new UPIPaymentApps("Bhim", "India", 2000, 10000, address);
        System.out.println("-----------------------------------");
        System.out.println("    !!!Deep Copy!!!");
        UPIPaymentApps paytm = (UPIPaymentApps) bhim.clone();
        paytm.headOfficeLocation.state = "Delhi-NCR";
        System.out.println(bhim);
        System.out.println(paytm);
    }
}
