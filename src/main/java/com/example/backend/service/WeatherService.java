package com.example.backend.service;

import com.example.backend.model.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class WeatherService {

    private final String apiKey = "45ed1681b8257e2e5929122fb70f1d62";

    public WeatherResponse getWeather(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city +
                "&appid=" + apiKey + "&units=metric";

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        if (response == null || response.get("main") == null) {
            throw new RuntimeException("City not found");
        }

        Map<String, Object> main = (Map<String, Object>) response.get("main");
        Map<String, Object> wind = (Map<String, Object>) response.get("wind");
        Map<String, Object> coord = (Map<String, Object>) response.get("coord");
        Map<String, Object> sys = (Map<String, Object>) response.get("sys");

        return new WeatherResponse(
                (String) response.get("name"),
                (String) sys.get("country"),
                ((Number) main.get("temp")).doubleValue(),
                ((Number) main.get("humidity")).doubleValue(),
                ((Number) wind.get("speed")).doubleValue(),
                ((Number) coord.get("lat")).doubleValue(),
                ((Number) coord.get("lon")).doubleValue()
        );
    }
}
