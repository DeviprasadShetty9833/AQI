package com.ecogauge.aqi.controller;

import com.ecogauge.aqi.model.AqiData;
import com.ecogauge.aqi.service.AqiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.http.HttpStatus; // Import this
import org.springframework.http.ResponseEntity; // Import this
import org.springframework.web.bind.annotation.GetMapping; // Make sure this is imported
import org.springframework.web.bind.annotation.RequestParam; 

@RestController
@RequestMapping("/api/aqi")
@CrossOrigin(origins = "*") // allow frontend requests
public class AqiController {

    private final AqiService service;

    public AqiController(AqiService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<AqiData> getAll() {
        return service.getAllData();
    }

    @GetMapping("/city/{city}")
    public List<AqiData> getByCity(@PathVariable String city) {
        return service.getByCity(city);
    }

    @GetMapping("/station/{station}")
    public List<AqiData> getByStation(@PathVariable String station) {
        return service.getByStation(station);
    }

    // Add this new endpoint
@GetMapping("/fetch")
public ResponseEntity<?> fetchAqiForCoordinates(
        @RequestParam double lat,
        @RequestParam double lon) {
    try {
        // You'll need to implement this service method
        Object aqiData = service.fetchAqiFromExternalApi(lat, lon);
        return ResponseEntity.ok(aqiData);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching data");
    }
}

    @PostMapping("/add")
    public AqiData addData(@RequestBody AqiData data) {
        return service.save(data);
    }
}
