
package plane;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mypackage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Root_QNAME = new QName("https://halde.geblubber.org", "root");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RootElementType }
     * 
     */
    public RootElementType createRootElementType() {
        return new RootElementType();
    }

    /**
     * Create an instance of {@link ArrivalType }
     * 
     */
    public ArrivalType createArrivalType() {
        return new ArrivalType();
    }

    /**
     * Create an instance of {@link PassengerType }
     * 
     */
    public PassengerType createPassengerType() {
        return new PassengerType();
    }

    /**
     * Create an instance of {@link DepartureType }
     * 
     */
    public DepartureType createDepartureType() {
        return new DepartureType();
    }

    /**
     * Create an instance of {@link PassengersType }
     * 
     */
    public PassengersType createPassengersType() {
        return new PassengersType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RootElementType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://halde.geblubber.org", name = "root")
    public JAXBElement<RootElementType> createRoot(RootElementType value) {
        return new JAXBElement<RootElementType>(_Root_QNAME, RootElementType.class, null, value);
    }

}
