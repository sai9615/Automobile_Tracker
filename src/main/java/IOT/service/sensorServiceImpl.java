package IOT.service;

import IOT.entity.alert;
import IOT.entity.sensor;
import IOT.entity.vehicles;
import IOT.repository.alertRepository;
import IOT.repository.sensorRepository;
import IOT.repository.vehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class sensorServiceImpl implements sensorService {

    @Autowired
    private sensorRepository sensorRep;

    @Autowired
    private vehicleRepository vehicleRep;

    @Autowired
    private alertRepository alertRep;

    @Override
    public sensor findByVin(String vin){
        return sensorRep.findByVin(vin);
    }

    @Override
    public void saveOrUpdateSensor(sensor sens){
        vehicles veh = vehicleRep.findByvin(sens.getVin());
        Date date = new Date();
        Timestamp tmp = new Timestamp(date.getTime());
        if(veh != null){
            if(sens.getEngineRPM() > veh.getRedlineRpm()){
                alert alt = new alert();
                alt.setVin(veh.getVin());
                alt.setPriority("HIGH");
                alt.setLatitude(sens.getLatitude());
                alt.setLongitude(sens.getLongitude());
                alt.setTimeStamp(tmp);
                alertRep.save(alt);
                System.out.println("Alert Engine RPM exceeded for vehicle with vin" + veh.getVin() + "with priority HIGH");
            }
            if(sens.getFuelVolume() < 0.1 * veh.getMaxFuelVolume()){
                alert alt = new alert();
                alt.setVin(veh.getVin());
                alt.setPriority("MEDIUM");
                alt.setLatitude(sens.getLatitude());
                alt.setLongitude(sens.getLongitude());
                alt.setTimeStamp(tmp);
                alertRep.save(alt);
                System.out.println("Alert Fuel Volume for vehicle with vin is low" + veh.getVin() + "with priority MEDIUM");
            }
            if(sens.getTires().get("frontLeft") < 32 || sens.getTires().get("frontLeft") > 36 || sens.getTires().get("frontRight") < 32 || sens.getTires().get("frontRight") > 36 || sens.getTires().get("rearLeft") < 32 || sens.getTires().get("rearLeft") > 36 || sens.getTires().get("rearRight") < 32 || sens.getTires().get("rearRight") > 36  ){
                alert alt = new alert();
                alt.setVin(veh.getVin());
                alt.setPriority("LOW");
                alt.setLatitude(sens.getLatitude());
                alt.setLongitude(sens.getLongitude());
                alt.setTimeStamp(tmp);
                alertRep.save(alt);
                System.out.println("Alert tire pressure low for vehicle with vin" + veh.getVin() + "with priority LOW");
            }
            if(sens.isEngineCoolantLow() || sens.isCheckEngineLightOn()){
                alert alt = new alert();
                alt.setVin(veh.getVin());
                alt.setPriority("LOW");
                alt.setLatitude(sens.getLatitude());
                alt.setLongitude(sens.getLongitude());
                alt.setTimeStamp(tmp);
                alertRep.save(alt);
                System.out.println("Alert for vehicle with vin" + veh.getVin() + "with priority LOW");
            }
        }
        sensorRep.save(sens);
    }

    @Override
    public List<sensor> findAll(){
        return sensorRep.findAll();
    }

    @Override
    public void deleteAll(){
         sensorRep.deleteAll();
    }
}
