package Model;
/**
 * Erstellt von  sebsch on 30.12.16.
 */
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Booking {

    private String originplace;
    private String destinationplace;
    private String cabinclass;
    private double price;
    private DepartureType departure;
    private ArrivalType arrival;
    private PassengersType passengers;

    public String getDestinationplace() {
        return destinationplace;
    }

    public void setDestinationplace(String destinationplace) {
        this.destinationplace = destinationplace;
    }

    public String getCabinclass() {
        return cabinclass;
    }

    public void setCabinclass(String cabinclass) {
        this.cabinclass = cabinclass;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDeparture(DepartureType departure) {
        this.departure = departure;
    }

    public ArrivalType getArrival() {
        return arrival;
    }

    public void setArrival(ArrivalType arrival) {
        this.arrival = arrival;
    }

    public PassengersType getPassengers() {
        return passengers;
    }

    public void setPassengers(PassengersType passengers) {
        this.passengers = passengers;
    }

    public String getOriginplace() {
        return originplace;
    }

    public void setOriginplace(String originplace) {
        this.originplace = originplace;
    }

    @XmlElement(name="departure")
    public DepartureType getDeparture(){
        return this.departure;
    }

}
