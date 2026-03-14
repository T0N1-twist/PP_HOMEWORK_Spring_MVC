package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarServiceImpl carServiceImpl;

    public CarController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping
    public String showAllCars(@RequestParam(required = false) Integer count,
                          ModelMap model) {

        if (count == null) {
            model.addAttribute("cars", carServiceImpl.getAllCars());
        } else {
            model.addAttribute("cars", carServiceImpl.getCarsLimited(count));
        }

        return "cars";
    }

}