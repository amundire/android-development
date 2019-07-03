package com.example.weatherapi.data.remote;

public class WeatherModel {

    Coordinates coord;
    MainData main;

    class Coordinates{
        float lon;
        float lat;

        @Override
        public String toString() {
            return "Coordinates{" +
                    "lon=" + lon +
                    ", lat=" + lat +
                    '}';
        }
    }

    class MainData{

        float temp;
        float pressure;

        @Override
        public String toString() {
            return "MainData{" +
                    "temp=" + temp +
                    ", pressure=" + pressure +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WeatherModel{" +
                "coord=" + coord.toString() +
                ", main" + main.toString() +
                '}';
    }
}
