import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


import plane.*;

/**
 * Erstellt von  sebsch on 27.12.16.
 */
public class XMLParser {

    private String xmlfile;
    private String xmlSchema;
    private JAXBContext context;
    private RootElementType booking;
    private Unmarshaller umarsh;
    private FileInputStream file;


    public XMLParser(String filename,  String xmlSchema){

        this.xmlfile = filename;
        this.xmlSchema = xmlSchema;

        booking = new ObjectFactory().createRootElementType();

        try {
            generateJAXBContext();
            generateUmarsh();
            generateFile();
            generateBooking();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void generateJAXBContext() throws JAXBException {
        this.context = JAXBContext.newInstance(RootElementType.class);
    }

    private void generateUmarsh() throws JAXBException {
        umarsh = context.createUnmarshaller();
    }

    private void generateFile() throws FileNotFoundException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        this.file = new FileInputStream(new File(classLoader.getResource(this.xmlfile).getFile()));
        System.out.println(this.file);
    }

    private void generateBooking() throws JAXBException {
        //this.booking = (RootElementType) umarsh.unmarshal(this.file);
        this.booking = ((JAXBElement<RootElementType>) this.context.createUnmarshaller().unmarshal(this.file)).getValue();
    }




}
