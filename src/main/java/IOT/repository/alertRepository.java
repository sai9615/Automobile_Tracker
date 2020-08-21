package IOT.repository;

import IOT.entity.alert;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface alertRepository extends MongoRepository<alert, String> {

    List<alert> findByVin(String Vin);
    List<alert> findByPriority(String priority);
}
