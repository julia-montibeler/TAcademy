package com.app.norway.controllers;

import com.app.norway.dtos.PlaceDto;
import com.app.norway.models.Place;
import com.app.norway.repositories.PlaceRepository;
import lombok.Getter;
import lombok.Value;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("place")
public class PlaceController {
    @Autowired
    PlaceRepository placeRepository;

    @GetMapping
    public ResponseEntity<List<PlaceDto>> getAllPlaces() {
        List<PlaceDto> placesDtos = new ArrayList<>();
        List<Place> places = placeRepository.findAll();

        BeanUtils.copyProperties(places, placesDtos);
        return ResponseEntity.status(HttpStatus.OK).body(placesDtos);
    }

    @GetMapping("/city")
    public ResponseEntity<List<PlaceDto>> getPlacesByCity(@PathVariable(value="city") String city) {
        List<PlaceDto> placesDtos = new ArrayList<>();
        List<Place> places = placeRepository.findByCity(city);

        BeanUtils.copyProperties(places, placesDtos);
        return ResponseEntity.status(HttpStatus.OK).body(placesDtos);
    }

    @GetMapping("/id")
    public ResponseEntity<PlaceDto> getPlaceById(@PathVariable(value="id") Long id) {
        PlaceDto placeDto = new PlaceDto("","","");
        Optional<Place> place = placeRepository.findById(id);

        BeanUtils.copyProperties(place, placeDto);
        return ResponseEntity.status(HttpStatus.OK).body(placeDto);
    }

}
