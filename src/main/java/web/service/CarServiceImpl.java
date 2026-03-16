package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarServiceImpl implements CarService{
    private List<Car> cars = new ArrayList<>();

    public CarServiceImpl() {
        cars.add(new Car("BMW", "red", 2010));
        cars.add(new Car("Mazda", "yellow", 2023));
        cars.add(new Car("Mercedes", "black", 1999));
        cars.add(new Car("BMW", "blue", 2022));
    }

    public List<Car> getCarsLimited(int count) {
        if (count == null || count <= 0) {
            return new ArrayList<>(cars);
        }

        int limit = Math.min(count, cars.size());
        return new ArrayList<>(cars.subList(0, limit));
    }



}
