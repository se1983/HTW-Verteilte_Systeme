package data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by sebsch on 28.10.16.
 */
public class csvParser {

    private Stream<String> lines;
    private ArrayList<String[]> filteredLines;
    private String date;
    private String file;

    public csvParser(String file, String date) {
        this.file = file;
        this.date = date;
        filteredLines = new ArrayList<String[]>();
        readFile();
        extractLines();
    }

    public Boolean validate() {
        if (this.filteredLines.size() <= 0) {
            return false;
        }
        if (!this.date.contains("-")) {
            return false;
        }
        return true;
    }

    private void readFile() {
        Path path = Paths.get(this.file);

        try {
            lines = Files.lines(path);
        } catch (IOException ex) {
            System.err.println("Could not open file!");
            ex.printStackTrace();
        }
    }

    private void filter(String l, String pattern) {
        if (l.contains(pattern)) {
            filteredLines.add(l.split(","));
        }
    }

    private void extractLines() {
        this.lines.forEach(s -> this.filter(s, this.date));
    }

    public ArrayList<String[]> getTempAtTime() {
        ArrayList<String[]> vals = new ArrayList<>();
        for (String[] val : filteredLines) {

            String[] tuple = new String[2];
            tuple[0] = val[1];
            tuple[1] = val[2];

            vals.add(tuple);
        }
        return vals;
    }


    public ArrayList<Integer> getTemperatures() {
        ArrayList<Integer> vals = new ArrayList<>();

        for (String[] val : filteredLines) {
            vals.add(Integer.parseInt(val[2]));
        }

        return vals;
    }


}
