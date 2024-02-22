package com.example.EsercizioN8;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cars")
public class CarController {
    @Autowired
    CarRepository carRepository;
  @PostMapping("/create")
    public CarEntity createCar(@RequestBody CarEntity carEntity){
      return carRepository.save(carEntity);
  }
  @GetMapping("/carsList")
    public List<CarEntity> getListCars(){
      return carRepository.findAll();
  }
  @GetMapping("/car/{id}")
    public CarEntity getCarById(@PathVariable Long id){
      boolean exist = carRepository.existsById(id);
   if(exist){
    return carRepository.findById(id).orElse(null);
   }
    return new CarEntity();
  }
  @PutMapping("/update/{id}")
  public CarEntity updateCarType(@PathVariable Long id, @RequestParam String type) {
    boolean exist = carRepository.existsById(id);
    if(exist){
     CarEntity carEntity = carRepository.findById(id).orElse(null);
      carEntity.setType(type);
      carRepository.save(carEntity);
    return carEntity;
    }
    return new CarEntity() ;
  }
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
    if (carRepository.existsById(id)) {
      carRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
  }
    @DeleteMapping("allCarDelete")
    public ResponseEntity<Void> deletecar(){
      carRepository.deleteAll();
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
