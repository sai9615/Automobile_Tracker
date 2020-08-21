package IOT.service;

import IOT.entity.vehicles;

import java.util.List;

public interface vehiclesService {

    vehicles findByVin(String Vin);
    void saveOrUpdateVehicle(vehicles veh);
    List<vehicles> findAll();
    void deleteAll();
}
