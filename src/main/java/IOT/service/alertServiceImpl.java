package IOT.service;

import IOT.entity.alert;
import IOT.repository.alertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class alertServiceImpl implements alertService {

    @Autowired
    private alertRepository repository;

    @Override
    public List<alert> findAlertUsingPriority(String priority) {
        return repository.findByPriority(priority);
    }

    @Override
    public List<alert> findAlertUsingVin(String Vin){
        return repository.findByVin(Vin);
    }

    @Override
    public void deleteAllAlerts(){
        repository.deleteAll();
    }

    @Override
    public List<String> findLocation(String vin){
        List <alert> test = repository.findByVin(vin);
        List <String> loc = new ArrayList<>();
        Date date = new Date();
        Timestamp totime = new Timestamp(date.getTime());
        for(int i=0; i<test.size(); i++){
            long msc = totime.getTime() - test.get(i).getTimeStamp().getTime();
            int minutes = (int) msc/3600000;
            if(minutes <= 30){
                String longitude = "At time: " + test.get(i).getTimeStamp()  + " Longitude: " + Double.toString(test.get(i).getLongitude()) + " Latitude: " + Double.toString(test.get(i).getLatitude());
                loc.add(longitude);
            }
        }
        return  loc;
    }

}
