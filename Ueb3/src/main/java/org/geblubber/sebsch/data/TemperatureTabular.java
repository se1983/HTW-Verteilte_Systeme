package org.geblubber.sebsch.data;

import java.util.ArrayList;
import java.util.HashMap;

public interface TemperatureTabular {
    String getString();

    String compare(TemperatureTabular tab2);

    HashMap<String, String> getTabular();

    ArrayList<Integer> getTemperatures();

}
