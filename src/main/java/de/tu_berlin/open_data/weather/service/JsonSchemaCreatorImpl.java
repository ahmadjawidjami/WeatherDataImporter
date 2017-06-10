package de.tu_berlin.open_data.weather.service;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import de.tu_berlin.open_data.weather.model.WeatherData;
import org.springframework.stereotype.Service;

/**
 * Created by ahmadjawid on 6/9/17.
 */
@Service
public class JsonSchemaCreatorImpl implements JsonSchemaCreator {
    @Override
    public String create(WeatherData currentWeatherData) {
        JsonNodeFactory nodeFactory = JsonNodeFactory.instance;

        ObjectNode node = nodeFactory.objectNode();

            node.put("source_id", "luftdaten");
            node.put("device", "");
            node.put("timestamp", currentWeatherData.getTimestamp());
            node.put("timestamp_data", currentWeatherData.getTimestamp());


            ObjectNode firstLevelChild = nodeFactory.objectNode();

            firstLevelChild.put("lat", currentWeatherData.getLat());
            firstLevelChild.put("lon", currentWeatherData.getLon());

            node.set("location", firstLevelChild);

            node.put("license", "");

            ArrayNode arrayNode = nodeFactory.arrayNode();

            ObjectNode arrayNodeMember = nodeFactory.objectNode();
            arrayNodeMember.put("sensor", "");
            arrayNodeMember.put("observation_type", "pressure");
            arrayNodeMember.put("observation_value", currentWeatherData.getPressure());
            arrayNode.add(arrayNodeMember);

            arrayNodeMember.put("sensor", "");
            arrayNodeMember.put("observation_type", "altitude");
            arrayNodeMember.put("observation_value", currentWeatherData.getAltitude());
            arrayNode.add(arrayNodeMember);

            arrayNodeMember.put("sensor", "");
            arrayNodeMember.put("observation_type", "pressure_sealevel");
            arrayNodeMember.put("observation_value", currentWeatherData.getPressureSeaLevel());
            arrayNode.add(arrayNodeMember);

            arrayNodeMember.put("sensor", "");
            arrayNodeMember.put("observation_type", "temperature");
            arrayNodeMember.put("observation_value", currentWeatherData.getTemperature());
            arrayNode.add(arrayNodeMember);

            arrayNodeMember.put("sensor", "");
            arrayNodeMember.put("observation_type", "humidity");
            arrayNodeMember.put("observation_value", currentWeatherData.getHumidity());
            arrayNode.add(arrayNodeMember);

            node.set("sensors", arrayNode);
     //   }



        return node.toString();
    }
}
