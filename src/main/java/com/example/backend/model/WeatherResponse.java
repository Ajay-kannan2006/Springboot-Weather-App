package com.example.backend.model;

public class WeatherResponse {
    public String city;
    public String country;
    public double temp;
    public double humidity;
    public double wind;
    public double lat;
    public double lon;

    public WeatherResponse(String city, String country, double temp, double humidity, double wind, double lat, double lon) {
        this.city = city;
        this.country = country;
        this.temp = temp;
        this.humidity = humidity;
        this.wind = wind;
        this.lat = lat;
        this.lon = lon;
    }
}
