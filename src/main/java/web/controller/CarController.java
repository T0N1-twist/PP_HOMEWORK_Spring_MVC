package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.CarService;

@Controller
@RequestMapping ("/cars")
public class CarController {
   @Autowired
    private CarService carService;

@GetMapping ("/")
    public String showAllCars(ModelMap model) {
    model.addAttribute("cars", carService.getAllCars());
    return "cars";
}

}