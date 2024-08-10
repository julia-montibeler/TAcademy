package com.app.viagens.controllers;

import com.app.viagens.dtos.DestinoRecordDto;
import com.app.viagens.models.DestinoModel;
import com.app.viagens.repositories.DestinoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/destinos")
public class DestinoController {
    @Autowired
    DestinoRepository destinoRepository;


    @GetMapping
    public ResponseEntity<List<DestinoRecordDto>> getAllDestinos(){
        return ResponseEntity.status(HttpStatus.OK).body(destinoRepository.findAll()
                .stream()
                .map(destino -> new DestinoRecordDto(destino.getId(), destino.getNome())).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDestinoById(@PathVariable(value="id") Long id ){
        Optional<DestinoModel> destinoO = destinoRepository.findById(id);
        if(destinoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado");
        }else {
            DestinoRecordDto destinoDto = new DestinoRecordDto(destinoO.get().getId(), destinoO.get().getNome());
            return ResponseEntity.status(HttpStatus.OK).body(destinoDto);
        }
    }

    @PostMapping
    public ResponseEntity<DestinoModel> addDestino(@RequestBody @Valid DestinoRecordDto destinoRecordDto){
        DestinoModel destinoModel =  new DestinoModel();
        BeanUtils.copyProperties(destinoRecordDto, destinoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(destinoRepository.save(destinoModel));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteDestino(@PathVariable(value="id") Long id){
        Optional<DestinoModel> destinoO = destinoRepository.findById(id);
        if(destinoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado");
        }else {
            destinoRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Destino deletado com sucesso!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDestino(@PathVariable(value = "id") Long id, @RequestBody @Valid DestinoRecordDto destinoRecordDto){
        Optional<DestinoModel> destinoO = destinoRepository.findById(id);
        if(destinoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado");
        }else {
            var destinoModel = destinoO.get();
            BeanUtils.copyProperties(destinoRecordDto, destinoModel);
            return ResponseEntity.status(HttpStatus.OK).body(destinoRepository.save(destinoModel));
        }
    }
}
