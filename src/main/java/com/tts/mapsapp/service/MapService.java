package com.tts.mapsapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MapService {
    @Value("${api_key}")
    private String apiKey;

    public void addCoordinates(Location location) {
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + location.getCity() + ","
                + location.getState() + "&key=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
        Location coordinates = response.getResults().get(0).getGeometry().getLocation();

        location.setLat(coordinates.getLat());
        location.setLng(coordinates.getLng());

    }
}

public class GeocodingReponse {
    private List<Geocoding> results;
}

public class Geocoding {
    private Geometry geometry;
}

public class Geometry {
    private Location location;
}

public class Location {
    private String city;
    private String state;
    private String lat;
    private String lng;
}