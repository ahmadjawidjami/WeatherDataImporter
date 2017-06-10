package de.tu_berlin.open_data.weather.service;

import de.tu_berlin.open_data.weather.model.WeatherData;

/**
 * Created by ahmadjawid on 6/10/17.
 */
public interface ApplicationService {
    String [] getFields(Class<WeatherData> weatherDataClass);
}
