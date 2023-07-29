package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public static void main(String[] args) {

        /* JSONObject из json-строки строки */
        JSONObject jsonEngine = new JSONObject("{\"engine\":\"MDJ.UA, MDJ.UB, MDP.HB\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Horizontally opposed, 4-cylinder");
        list.add("Turbine");
        JSONArray jsonDescriptions = new JSONArray(list);

        /* JSONObject напрямую методом put */
        Porsche porsche = new Porsche(true, 2497,
                "Gasoline", new Engine("MDJ.UA, MDJ.UB, MDP.HB"),
                new String[] {"Horizontally opposed, 4-cylinder", "Turbine"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isCabriolet", porsche.isCabriolet());
        jsonObject.put("engineVolume", porsche.getEngineVolume());
        jsonObject.put("fuel", porsche.getFuel());
        jsonObject.put("engine", porsche.getEngine());
        jsonObject.put("description", porsche.getDescription());

        /* Выведем результат в консоль */
        System.out.println(jsonObject);

        /* Преобразуем объект porsche в json-строку */
        System.out.println(new JSONObject(porsche));
    }
}