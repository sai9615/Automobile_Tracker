package IOT.controller;

import IOT.entity.vehicles;
import IOT.service.vehiclesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@CrossOrigin(origins = "http://mocker.egen.academy")
public class vehicleController {

    @Autowired
    private
    vehiclesService service;

    @RequestMapping(method = RequestMethod.GET, value = "/vehicles/{vin}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Identify vehicle using Vin",
            notes = "Return a single vehicle or throws 404")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public vehicles findByVin(
            @ApiParam(value = "Vin of the vehicle", required = true) @PathVariable("vin") String vin) {
        return service.findByVin(vin);
    }

    @RequestMapping(path = "/vehicles", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Add vehicle data to database",
            notes = "Adds vehicle related data to the database")
    public ResponseEntity<?> saveOrUpdateVehicle(@RequestBody List<vehicles> vehs) {
        try{
            for(vehicles veh : vehs) {
                service.saveOrUpdateVehicle(veh);
            }
        }catch(Exception e){}
        return  new ResponseEntity<>("Vehicle added successfully", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/vehicles",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all the vehicles data present in the DB",
            notes = "Returns all the vehicles or throws 404")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List <vehicles> findAll(){
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/vehicles/removeAll")
    @ApiOperation(value = "Remove all the vehicles from DB")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public void deleteAll(){
        service.deleteAll();
    }
}
