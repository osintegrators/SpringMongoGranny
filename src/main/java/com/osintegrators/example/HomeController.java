package com.osintegrators.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

        return "home";
    }


    @RequestMapping(value = "/get/{_id}", method = RequestMethod.GET)
    public @ResponseBody Address get(@PathVariable String _id) {
        logger.debug("in get method");
        return addressService.getAddressById(_id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Address address) {
        logger.debug("in create method");

        address.set_id(null);
        addressService.createAddress(address);

    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Address address) {
        logger.debug("in create method");

        addressService.updateAddress(address);

    }

    @RequestMapping(value = "/delete/{_id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String _id) {
        logger.debug("in delete method");

        addressService.deleteAddress(_id);
    }

    @RequestMapping(value = "/addresses", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Address> list() {
        logger.debug("in create method");

        return addressService.getAllAddresses();
    }

}