package week_3.date;

class AirTicket {
    String passenger;
    String source;
    String destination;

    AirTicket(String passenger, String source, String destination) {
        this.passenger = passenger;
        this.source = source;
        this.destination = destination;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

}

public class PassengerOnboarding {
    public static void main(String[] args) {
        String dateOfJourney;
        AirTicket ticket = new AirTicket("Karan Seth", "Delhi", "Bangalore");
        dateOfJourney = args[0] + "-" + args[1] + "-" + args[2];
        System.out.println(String.format("Passenger Name: %s %nSource : %s %nDestination : %s %nDate of Departure : %s",
                ticket.getPassenger(), ticket.getSource(), ticket.getDestination(),
                dateOfJourney));
    }
}
