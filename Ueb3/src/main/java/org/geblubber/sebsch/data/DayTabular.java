package org.geblubber.sebsch.data;


import org.geblubber.sebsch.calc.TemperatureCalculator;

import java.util.ArrayList;
import java.util.HashMap;


public class DayTabular implements TemperatureTabular {

    private ArrayList<Integer> temperatures;
    private HashMap<String, String> tab;
    private Integer max;
    private Integer min;
    private double avg;
    private ArrayList<String[]> tempAtTime;
    private TemperatureCalculator calc;
    private csvParser csv;

    public DayTabular(csvParser csv) {
        this.csv = csv;
        this.generateAggregates();
        this.temperatures = this.csv.getTemperatures();
        this.tempAtTime = this.csv.getTempAtTime();
        this.tab = new HashMap<>();
        this.generateTabular();
    }

    @Override
    public String getString() {

        final String[] rcv = {""};
        this.tab.forEach((k, v) -> rcv[0] += k + ":\t" + v + "\n");

        return rcv[0];
    }

    @Override
    public String compare(TemperatureTabular tab2) {
        if (this.temperatures.equals(tab2.getTemperatures()))
            return ("Alles unverändert!");
        return this.getString();
    }

    private void generateTabular() {
        for (int i = 0; i < temperatures.size(); i++) {
            this.tab.put(this.tempAtTime.get(i)[0], this.tempAtTime.get(i)[1]);
        }
        this.tab.put("max", String.valueOf(this.max));
        this.tab.put("min", String.valueOf(this.min));
        this.tab.put("avg", String.valueOf(this.avg));
    }

    @Override
    public HashMap<String, String> getTabular() {
        return this.tab;
    }

    @Override
    public ArrayList<Integer> getTemperatures() {
        return this.temperatures;
    }

    private void generateAggregates() {
        calc = new TemperatureCalculator(csv.getTemperatures());
        this.min = calc.min();
        this.max = calc.max();
        this.avg = calc.avg();
    }
}
