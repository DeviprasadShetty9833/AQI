package com.ecogauge.aqi.repository;

import com.ecogauge.aqi.model.AqiData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AqiRepository extends JpaRepository<AqiData, Long> {
    List<AqiData> findByCity(String city);
    List<AqiData> findByStation(String station);
}
