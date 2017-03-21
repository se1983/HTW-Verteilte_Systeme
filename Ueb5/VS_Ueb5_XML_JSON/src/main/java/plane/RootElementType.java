
package plane;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für RootElementType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RootElementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="originplace" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="destinationplace" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="departure" type="{https://halde.geblubber.org}departureType"/>
 *         &lt;element name="arrival" type="{https://halde.geblubber.org}arrivalType"/>
 *         &lt;element name="passengers" type="{https://halde.geblubber.org}passengersType"/>
 *         &lt;element name="cabinclass" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RootElementType", namespace = "https://halde.geblubber.org", propOrder = {
    "originplace",
    "destinationplace",
    "departure",
    "arrival",
    "passengers",
    "cabinclass",
    "price"
})
public class RootElementType {

    @XmlElement(namespace = "https://halde.geblubber.org", required = true)
    protected String originplace;
    @XmlElement(namespace = "https://halde.geblubber.org", required = true)
    protected String destinationplace;
    @XmlElement(namespace = "https://halde.geblubber.org", required = true)
    protected DepartureType departure;
    @XmlElement(namespace = "https://halde.geblubber.org", required = true)
    protected ArrivalType arrival;
    @XmlElement(namespace = "https://halde.geblubber.org", required = true)
    protected PassengersType passengers;
    @XmlElement(namespace = "https://halde.geblubber.org", required = true)
    protected String cabinclass;
    @XmlElement(namespace = "https://halde.geblubber.org")
    protected float price;

    /**
     * Ruft den Wert der originplace-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginplace() {
        return originplace;
    }

    /**
     * Legt den Wert der originplace-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginplace(String value) {
        this.originplace = value;
    }

    /**
     * Ruft den Wert der destinationplace-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationplace() {
        return destinationplace;
    }

    /**
     * Legt den Wert der destinationplace-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationplace(String value) {
        this.destinationplace = value;
    }

    /**
     * Ruft den Wert der departure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DepartureType }
     *     
     */
    public DepartureType getDeparture() {
        return departure;
    }

    /**
     * Legt den Wert der departure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DepartureType }
     *     
     */
    public void setDeparture(DepartureType value) {
        this.departure = value;
    }

    /**
     * Ruft den Wert der arrival-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ArrivalType }
     *     
     */
    public ArrivalType getArrival() {
        return arrival;
    }

    /**
     * Legt den Wert der arrival-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrivalType }
     *     
     */
    public void setArrival(ArrivalType value) {
        this.arrival = value;
    }

    /**
     * Ruft den Wert der passengers-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PassengersType }
     *     
     */
    public PassengersType getPassengers() {
        return passengers;
    }

    /**
     * Legt den Wert der passengers-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PassengersType }
     *     
     */
    public void setPassengers(PassengersType value) {
        this.passengers = value;
    }

    /**
     * Ruft den Wert der cabinclass-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCabinclass() {
        return cabinclass;
    }

    /**
     * Legt den Wert der cabinclass-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCabinclass(String value) {
        this.cabinclass = value;
    }

    /**
     * Ruft den Wert der price-Eigenschaft ab.
     * 
     */
    public float getPrice() {
        return price;
    }

    /**
     * Legt den Wert der price-Eigenschaft fest.
     * 
     */
    public void setPrice(float value) {
        this.price = value;
    }

}
