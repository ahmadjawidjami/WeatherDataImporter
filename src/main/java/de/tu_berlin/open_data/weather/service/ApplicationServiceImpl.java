package de.tu_berlin.open_data.weather.service;

import de.tu_berlin.open_data.weather.model.WeatherData;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

/**
 * Created by ahmadjawid on 6/10/17.
 */

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Override
    public String[] getFields(Class<WeatherData> weatherDataClass) {

        Field[] weatherDataClassFields = weatherDataClass.getDeclaredFields();

        String[] fieldsArray = new String[weatherDataClassFields.length];

        for (int index = 0; index < weatherDataClassFields.length; index++)
            fieldsArray[index] = weatherDataClassFields[index].getName();
        return fieldsArray;
    }
}
