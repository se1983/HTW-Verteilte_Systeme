import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * Erstellt von  sebsch on 06.01.17.
 */
public class JSONOut {

    private JSONObject booking;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");



    public JSONOut() throws IOException {
        booking = new JSONObject(this.readFileIntoString("plane.json"));

        this.out();
    }

    private String readFileIntoString(String path) throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());


        String content = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
        return content;
    }

    private void out(){

        String originPlace = booking.getString("originplace");
        String destinationPlace = booking.getString("destinationplace");
        String departureDate = booking.getJSONObject("departure").getString("date");
        String departureTime = booking.getJSONObject("departure").getString("time");
        String arrivalDate = booking.getJSONObject("arrival").getString("date");
        String arivalTime = booking.getJSONObject("arrival").getString("time");
        JSONArray passengers = booking.getJSONArray("passengers");
        String cabinClass = booking.getString("cabinclass");
        Double price = booking.getDouble("price");

        System.out.println("Originplace: \t" + originPlace);
        System.out.println("Destinationplace: \t" + destinationPlace);
        System.out.println("Departure: \t" + departureDate + "\n\t\t\t" + departureTime);
        System.out.println("Arrival: \t" + arrivalDate + "\n\t\t\t" + arivalTime);
        System.out.println("\n");

        for (int i = 0; i < passengers.length(); i++) {

            JSONObject passenger = passengers.getJSONObject(i);

            System.out.println("Name : \t " + passenger.getString("name"));
            System.out.println("Sex : \t " + passenger.getString("sex"));
            System.out.println("Country : \t " + passenger.getString("country"));
            String laguage = (!passenger.getBoolean("Packages")) ? "no" : "";
            System.out.println("has " + laguage + " laguage");
            System.out.println("\n");

        }

        System.out.println("Cabinclass: \t" + cabinClass);
        System.out.println("Price: \t\t\t" + price);

    }
}
