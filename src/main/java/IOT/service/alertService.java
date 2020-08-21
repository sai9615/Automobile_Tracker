package IOT.service;

import IOT.entity.alert;

import java.util.List;

public interface alertService {

    List<alert> findAlertUsingPriority(String priority);
    List<alert> findAlertUsingVin(String vin);
    void  deleteAllAlerts();
    List<String> findLocation(String vin);

}
