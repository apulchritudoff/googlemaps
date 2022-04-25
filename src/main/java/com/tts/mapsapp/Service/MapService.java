package com.tts.mapsapp.Service;

import org.springframework.stereotype.Service;

import com.tts.mapsapp.GeocodingReponse;
import com.tts.mapsapp.Location;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

@Service
public class MapService {
    @Value("${api_key}")
    private static String apiKey;

    public static void addCoordinates(Location location) {

        String url = "https://maps.googleapis.com/maps/api/geocode/json?";
        url += "address=" + location.getCity() + "," + location.getState();
        url += "&key=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        GeocodingReponse response = restTemplate.getForObject(url, GeocodingReponse.class);
        Location coordinates = response.getResults().get(0).getGeometry().getLocation();
        location.setLat(coordinates.getLat());
        location.setLng(coordinates.getLng());
    }
}