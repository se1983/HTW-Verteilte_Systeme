package Model;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Erstellt von  sebsch on 30.12.16.
 */
public class PassengersType {
    List <PassengerType> passengers;

    @XmlElement
    public List<PassengerType> getPassenger() {
        return passengers;
    }

    public void setPassenger(List<PassengerType> passengers) {
        this.passengers = passengers;
    }

}
