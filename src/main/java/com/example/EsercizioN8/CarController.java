package com.example.EsercizioN8;

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
    public boolean getCarById(@PathVariable Long id){
      return carRepository.existsById(id);
  }
  @PutMapping("/update/{id}")
  public boolean updateCarType(@PathVariable Long id, @RequestParam String type) {
    CarEntity carEntity = carRepository.findById(id).orElse(null);
    if(carEntity != null){
      carEntity.setType(type);
      return carRepository.existsById(id);
    }
    return false;
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
