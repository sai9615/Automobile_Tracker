package IOT.repository;

import IOT.entity.sensor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface sensorRepository extends MongoRepository<sensor, String> {

    sensor findByVin(String Vin);

}
