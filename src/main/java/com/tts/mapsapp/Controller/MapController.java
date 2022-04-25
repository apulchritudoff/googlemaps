package com.tts.mapsapp.Controller;

import com.tts.mapsapp.Location;
import com.tts.mapsapp.Service.MapService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MapController {
    @GetMapping("/home")
public String getDefaultMap(Model model) {
    model.addAttribute(new Location());
    return "index.html";
}

@PostMapping("/home")
public String getMapForLocation(Location location, Model model) {
    MapService.addCoordinates(location);
    model.addAttribute(location);
    return "index.html";
}
}
