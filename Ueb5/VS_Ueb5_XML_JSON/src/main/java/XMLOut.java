import Model.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Erstellt von  sebsch on 31.12.16.
 */
public class XMLOut {
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public XMLOut(Booking booking){

        String originPlace  =  booking.getOriginplace();
        String destinationPlace = booking.getDestinationplace();

        DepartureType departure = booking.getDeparture();
        Date departureDate = departure.getDate();
        String departureTime = departure.getTime();

        ArrivalType arival = booking.getArrival();
        Date arrivalDate = arival.getDate();
        String arivalTime = arival.getTime();

        PassengersType passengers = booking.getPassengers();


        System.out.println("Originplace: \t" + originPlace);
        System.out.println("Destinationplace: \t" + destinationPlace);

        System.out.println("Departure: \t" + dateFormat.format(departureDate) + "\n\t\t\t" + departureTime);
        System.out.println("Arrival: \t" + dateFormat.format(arrivalDate) + "\n\t\t\t" + arivalTime);

        passengers.getPassenger().forEach(p -> System.out.println(p.toString() + "\n"));

        System.out.println("Cabinclass: \t" + booking.getCabinclass());
        System.out.println("Price: \t\t\t" + booking.getPrice());


    }
}
