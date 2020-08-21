package IOT.controller;

import IOT.entity.alert;
import IOT.service.alertService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
@CrossOrigin(origins = "http://mocker.egen.academy")
public class alertController {

    @Autowired
    private alertService service;

    @RequestMapping(method = RequestMethod.GET, value = "/{priority}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get the vehicles based on priorities",
            notes = "Return all the alerts for the vehicles based on priority or throws 404")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<alert> findByPriority(
            @ApiParam(value = "Alert priority", required = true) @PathVariable("priority") String priority) {
        return service.findAlertUsingPriority(priority);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/vehicle/{Vin}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get the vehicle's all historical alerts using their vin",
            notes = "Return all the alerts for the vehicle using vin or throws 404")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<alert> findByVin(
            @ApiParam(value = "Vin of the vehicle", required = true) @PathVariable("Vin") String Vin) {
        return service.findAlertUsingVin(Vin);
    }


    @DeleteMapping(value = "/delete")
    public void deleteAllAlerts(){
        service.deleteAllAlerts();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/location/{vin}")
    @ApiOperation(value = "Get the vehicle's GeoLocation since last 30 minutes using their vin",
            notes = "Return all the coordinates of the vehicle using vin or throws 404")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<String> findLocation(
            @ApiParam(value = "Vin of the vehicle", required = true) @PathVariable("vin") String vin) {
        return service.findLocation(vin);
    }

}
