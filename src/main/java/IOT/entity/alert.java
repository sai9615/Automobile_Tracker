package IOT.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "alerts")
public class alert {

    @Id private String id;

    private String vin;

    private String priority;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date timeStamp;

    private double longitude;

    private double latitude;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "alert{" +
                "id='" + id + '\'' +
                ", Vin='" + vin + '\'' +
                ", priority='" + priority + '\'' +
                ", timeStamp=" + timeStamp +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
