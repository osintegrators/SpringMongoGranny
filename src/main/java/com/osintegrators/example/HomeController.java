package com.osintegrators.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	AddressService addressService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.debug("in home method");

		addModelElements(model);
		return "home";
	}
	

	/*@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get(Model model, @RequestParam String oldName, @RequestParam String selectedIndex) {
	        logger.debug("in get method");
	        Address address = addressService.getAddressByName(oldName);
	                
	        model.addAttribute("selectedIndex",selectedIndex);
	        model.addAttribute("address", address);
	        addModelElements(model);
	        return "home";
	}*/
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Address address) {
	        logger.debug("in create method");

		addressService.createAddress(address);

	}
	
	/*@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String delete(Model model, @RequestParam String name) {
	        logger.debug("in delete method");
	                
	        Address add = addressService.getAddressByName(name);
	        addressService.deleteAddress(add);
	        addModelElements(model);
	                
	        model.addAttribute("status","deleted");
	                
	        return "home";
	}*/

	private void addModelElements(Model model) {
		List<Address> addresses = addressService.getAllAddresses();
		model.addAttribute("addresses", addresses);
	}

}
