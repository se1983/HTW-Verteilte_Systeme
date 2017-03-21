import org.xml.sax.SAXException;


import java.io.IOException;
import java.net.URL;

class Main{

    public static void main(String [ ] args){

        System.out.println("XML");

        try {
            new Unmarshal();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("JSON");

        try {
            new JSONOut();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}