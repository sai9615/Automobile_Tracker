package IOT.service;

import IOT.entity.vehicles;
import IOT.repository.vehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class vehiclesServiceImpl implements vehiclesService {

    @Autowired
    private vehicleRepository repository;

    @Override
    public vehicles findByVin(String vin){
        return repository.findByvin(vin);
    }

    @Override
    public void saveOrUpdateVehicle(vehicles veh){
        repository.save(veh);
    }

    public List<vehicles> findAll(){
     return repository.findAll();
    }

    @Override
    public void deleteAll(){
        repository.deleteAll();
    }

}
