package com.tts.mapsapp;

import java.util.List;

import lombok.Data;

@Data
public class GeocodingReponse {
    private List<Geocoding> results;
}
