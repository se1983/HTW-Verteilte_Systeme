import org.apache.commons.io.IOUtils;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import java.io.File;
import java.io.IOException;

class XMLValidator implements ValidatorInterface{

    private Source schemaFile;
    private Schema schema;
    private Source xmlFile;

    public XMLValidator(String schemaFilePath, String xmlFilePath) throws IOException, SAXException {
        this.schemaFile = this.readFileIntoSource(schemaFilePath);
        this.xmlFile = this.readFileIntoSource(xmlFilePath);
        this.schema = generateSchema();
    }

    private  Source readFileIntoSource(String path){
        // https://www.mkyong.com/java/java-read-a-file-from-resources-folder/
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());
        return new StreamSource(file);
    }

    private Schema generateSchema() throws SAXException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        return schemaFactory.newSchema(this.schemaFile);
    }

    public Boolean validate() throws IOException {
        Validator validator = schema.newValidator();

        try { validator.validate(this.xmlFile);
        } catch (SAXException e1) { return false; }
        return true;
    }

}
