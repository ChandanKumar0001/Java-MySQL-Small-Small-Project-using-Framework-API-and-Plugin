package Com.jsp.spring.vms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import Com.jsp.spring.vms.entity.Vehicle;
import Com.jsp.spring.vms.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	public ModelAndView addVehicle(Vehicle vehicle) {
		//Resolving the Request - Saving the Vehicle Object
		vehicleRepository.saveVehicle(vehicle);

		//Generating Response - Redirection back to DashBoard
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.jsp");

		return mav;
	}

	public ModelAndView displayAllVehicles() {
		//Resolving Request
		List<Vehicle> vehicle = vehicleRepository.findAllVehicle();

		//Generation Response
		ModelAndView mav = new ModelAndView();
		mav.setViewName("DisplayAllVehicles.jsp");
		mav.addObject("vehicleList", vehicle);

		return mav;
	}

	public ModelAndView findVehicleById(int vehicleId) {
		//Resolving Request
		Vehicle vehicle = vehicleRepository.findById(vehicleId);

		//Generation Response
		ModelAndView mav = new ModelAndView();
		mav.setViewName("UpdateVehicle.jsp");
		mav.addObject("vehicleObject", vehicle);

		return mav;
	}

	public ModelAndView updateVehicle(Vehicle vehicle) {
		//Resolving Request
		vehicleRepository.updateVehicle(vehicle);
		

		//Generation Response
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:display-all-vehicles");

		return mav;	
	}
}
