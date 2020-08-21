package IOT.service;

import IOT.entity.sensor;
import IOT.entity.vehicles;

import java.util.List;

public interface sensorService {

    sensor findByVin(String Vin);
    void saveOrUpdateSensor(sensor sens);
    List<sensor> findAll();
    void deleteAll();

}
