package com.jkxy.car.api.service.Impl;

import com.jkxy.car.api.dao.CarDao;
import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("carService")
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public Car findById(int id) {
        return carDao.findById(id);
    }

    @Override
    public List<Car> findByCarName(String carName) {
        return carDao.findByCarName(carName);
    }

    @Override
    public void deleteById(int id) {
        carDao.deleteById(id);
    }

    @Override
    public void updateById(Car car) {
        carDao.updateById(car);
    }

    @Override
    public void insertCar(Car car) {
        carDao.insertCar(car);
    }

    @Override
    public void purchaseCar(Car car) {
        try {
            carDao.purchaseCar(car);
        } catch (Exception e) {
            throw new RuntimeException("库存不足!");
        }
    }

    @Override
    public List<Car> searchCarByBrand(Car car) {
        List<Car> list = new ArrayList<>();
        try {
            list = carDao.searchCarByBrand(car);
        } catch (Exception e) {
            throw new RuntimeException("系统错误!");
        }
        return list;
    }
}
