package IOT.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Document(collection = "sensor")
public class sensor {

    @Id private String vin;
    private double latitude;
    private double longitude;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date timeStamp;
    private double fuelVolume;
    private int speed;
    private int engineHP;
    private boolean checkEngineLightOn;
    private  boolean engineCoolantLow;
    private boolean cruiseControlOn;
    private  int engineRPM;
    private HashMap<String, Integer> tires;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEngineHP() {
        return engineHP;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
    public void setEngineHP(int engineHP) {
        this.engineHP = engineHP;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public int getEngineRPM() {
        return engineRPM;
    }

    public void setEngineRPM(int engineRPM) {
        this.engineRPM = engineRPM;
    }

    public HashMap<String, Integer> getTires() {
        return tires;
    }

    public void setTires(HashMap<String, Integer> tires) {
        this.tires = tires;
    }

    @Override
    public String toString() {
        return "sensor{" +
                "vin='" + vin + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude=" + longitude +
                ", timestamp='" + timeStamp + '\'' +
                ", fuelVolume=" + fuelVolume +
                ", speed=" + speed +
                ", engineHP=" + engineHP +
                ", checkEngineLightOn=" + checkEngineLightOn +
                ", engineCoolantLow=" + engineCoolantLow +
                ", cruiseControlOn=" + cruiseControlOn +
                ", engineRPM=" + engineRPM +
                ", tires=" + tires +
                '}';
    }
}
