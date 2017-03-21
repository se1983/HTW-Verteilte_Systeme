package data;

/**
 * Created by sebsch on 28.10.16.
 */
public class Main {
    public static void main(String[] args) {
        csvParser p = new csvParser("./temps.csv", "2016-10-28");
        p.getTempAtTime().forEach(t -> System.out.println(t[0] + t[1]));
    }
}
