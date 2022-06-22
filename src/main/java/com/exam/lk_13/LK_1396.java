package com.exam.lk_13;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LK_1396 {
    public static void main(String[] args) {

    }

    class UndergroundSystem {

        private Map<Integer, Pair<String, Integer>> user;

        private Map<String, List<Integer>> station;

        public UndergroundSystem() {
            user = new HashMap<>();
            station = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            user.put(id, new Pair<>(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            Pair<String, Integer> pair = user.get(id);
            String startStation = pair.getKey();
            int startTime = pair.getValue();
            String key = startStation + "-" + stationName;
            List<Integer> list = station.getOrDefault(key, new ArrayList<>());
            list.add(t - startTime);
            station.put(key, list);
        }

        public double getAverageTime(String startStation, String endStation) {
            String key = startStation + "-" + endStation;
            List<Integer> list = station.getOrDefault(key, new ArrayList<>());
            if (list.size() == 0) {
                return 0;
            }
            double sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            return sum / list.size();
        }
    }

}
