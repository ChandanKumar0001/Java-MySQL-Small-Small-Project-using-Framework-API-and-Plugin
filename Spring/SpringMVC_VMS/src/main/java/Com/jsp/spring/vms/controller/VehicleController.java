package Com.jsp.spring.vms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Com.jsp.spring.vms.entity.Vehicle;
import Com.jsp.spring.vms.service.VehicleService;

@Controller
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value = "/add-vehicle", method = RequestMethod.POST)
	public ModelAndView addVehicle(Vehicle vehicle) {
		return vehicleService.addVehicle(vehicle);
	}
	
	@RequestMapping(value = "/display-all-vehicles", method = RequestMethod.GET )
	public ModelAndView displayAllVehicles() {
		return vehicleService.displayAllVehicles();
	}
	
	@RequestMapping(value = "/find-by-id", method = RequestMethod.GET )
	public ModelAndView findVehicleById(int vehicleId) {
		return vehicleService.findVehicleById(vehicleId);
	}
	
	@RequestMapping(value = "/save-updated-vehicle", method = RequestMethod.POST )
	public ModelAndView updateVehicle(Vehicle vehicle) {
		return vehicleService.updateVehicle(vehicle);
	}
}
