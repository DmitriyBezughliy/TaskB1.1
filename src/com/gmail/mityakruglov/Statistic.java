package com.gmail.mityakruglov;

import java.util.HashMap;
public class Statistic {
    private HashMap<String, Integer> voiceMap = new HashMap<>();
    private static Statistic stat = new Statistic();
    private static Statistic stat2 = new Statistic();
    private Statistic() {
        super();
    }
    public static Statistic getInstance() {
        return stat;
    }
    public static Statistic getInstance2() {
        return stat2;
    }

    public synchronized void addVoice(String voice) {
        if (voiceMap.containsKey(voice)) {
            Integer voiceCount = voiceMap.get(voice);
            voiceMap.put(voice, voiceCount + 1);
        } else {
            voiceMap.put(voice, 1);
        }
    }


    public synchronized String toString() {
        StringBuilder sb = new StringBuilder();
        voiceMap.forEach((key, value) ->
                sb.append(key).append("\t").append(value).append("<br>"));
        return sb.toString();
    }

}