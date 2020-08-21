package IOT.controller;

import IOT.entity.sensor;
import IOT.service.sensorService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@ResponseBody
@CrossOrigin(origins = "http://mocker.egen.academy")
public class sensorController {

    @Autowired
    private
    sensorService service;

    @RequestMapping(method = RequestMethod.GET, value = "/sensors/{vin}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Identify sensor of the vehicle using Vin",
            notes = "Return a single vehicle with the particular sensor or throws 404")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public sensor findByVin(
            @ApiParam(value = "Vin of the vehicle", required = true) @PathVariable("vin") String vin) {
        return service.findByVin(vin);
    }

    @PostMapping(value = "/readings")
    @ApiOperation(value = "Add vehicle data to database",
            notes = "Adds vehicle related data to the database")
    public ResponseEntity<?> saveOrUpdateSensor(@RequestBody sensor sens) {
            service.saveOrUpdateSensor(sens);
        return  new ResponseEntity<>("Vehicle added successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/readings")
    @ApiOperation(value = "Get all the vehicles sensor readings present in the DB",
            notes = "Returns all the readings or throws 404")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List <sensor> findAll(){
        return service.findAll();
    }

    @DeleteMapping(value = "/readings")
    public void deleteAll(){
        service.deleteAll();
    }

}
