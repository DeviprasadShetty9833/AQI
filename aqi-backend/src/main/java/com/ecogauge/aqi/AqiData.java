package com.ecogauge.aqi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "aqi_data")
public class AqiData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String station;
    private double latitude;
    private double longitude;
    private int aqi;
    private String category;
    private LocalDateTime timestamp;

    // Constructors
    public AqiData() {}
    public AqiData(String city, String station, double latitude, double longitude, int aqi, String category, LocalDateTime timestamp) {
        this.city = city;
        this.station = station;
        this.latitude = latitude;
        this.longitude = longitude;
        this.aqi = aqi;
        this.category = category;
        this.timestamp = timestamp;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getStation() { return station; }
    public void setStation(String station) { this.station = station; }
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    public int getAqi() { return aqi; }
    public void setAqi(int aqi) { this.aqi = aqi; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
