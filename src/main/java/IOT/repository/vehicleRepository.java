package IOT.repository;

import IOT.entity.vehicles;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface vehicleRepository extends MongoRepository <vehicles, String>  {

    vehicles findByvin(String Vin);
    void deleteAll();

}
