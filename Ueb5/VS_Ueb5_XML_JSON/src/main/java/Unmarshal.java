import Model.Booking;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

public class Unmarshal {

    public Unmarshal() throws Exception {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(
                new File(this.getClass()
                .getClassLoader()
                .getResource("planeSchmaUniVS.xsd")
                .getFile()));

        JAXBContext jc = JAXBContext.newInstance(Booking.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setSchema(schema);
        Booking booking = (Booking) unmarshaller.unmarshal(new File(this.getClass()
                .getClassLoader()
                .getResource("plane.xml")
                .getFile()));

        new XMLOut(booking);

        unmarshaller.setEventHandler(new MyValidationEventHandler());




    }

}
