package com.app.viagens.controllers;

import com.app.viagens.dtos.DestinoRecordDto;
import com.app.viagens.dtos.ViagemRecordDto;
import com.app.viagens.models.DestinoModel;
import com.app.viagens.models.ViagemModel;
import com.app.viagens.repositories.DestinoRepository;
import com.app.viagens.repositories.ViagemRepository;
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
@RequestMapping("/viagens")
public class ViagemController {
    @Autowired
    DestinoRepository destinoRepository;

    @Autowired
    ViagemRepository viagemRepository;


    @GetMapping
    public ResponseEntity<List<ViagemRecordDto>> getAllViagens(){
        return ResponseEntity.status(HttpStatus.OK).body(viagemRepository.findAll()
                .stream()
                .map(viagem -> new ViagemRecordDto(viagem.getId(), viagem.getDestino())).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getViagemById(@PathVariable(value="id") Long id ){
        Optional<ViagemModel> viagemO = viagemRepository.findById(id);
        if(viagemO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Viagem não encontrada");
        }else {
            ViagemRecordDto viagemRecordDto = new ViagemRecordDto(viagemO.get().getId(), viagemO.get().getDestino());
            return ResponseEntity.status(HttpStatus.OK).body(viagemRecordDto);
        }
    }

    @PostMapping
    public ResponseEntity<ViagemModel> addViagem(@RequestBody @Valid ViagemRecordDto viagemRecordDto){
        ViagemModel viagemModel =  new ViagemModel();
        BeanUtils.copyProperties(viagemRecordDto, viagemModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(viagemRepository.save(viagemModel));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteViagem(@PathVariable(value="id") Long id){
        Optional<ViagemModel> viagemO = viagemRepository.findById(id);
        if(viagemO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Viagem não encontrada");
        }else {
            viagemRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Viagem deletada com sucesso!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateViagem(@PathVariable(value = "id") Long id, @RequestBody @Valid ViagemRecordDto viagemRecordDto){
        Optional<ViagemModel> viagemO = viagemRepository.findById(id);
        if(viagemO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Viagem não encontrada");
        }else {
            var viagemModel = viagemO.get();
            BeanUtils.copyProperties(viagemRecordDto, viagemModel);
            return ResponseEntity.status(HttpStatus.OK).body(viagemRepository.save(viagemModel));
        }
    }

    @GetMapping("/destinos/{id}/viagens")
    public ResponseEntity<Object> getByDestino (@PathVariable(value="id") Long id) {
        List<ViagemModel> viagemO = viagemRepository.findByDestinoId(id);
        if(viagemO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma viagem encontrada para esse destino");
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(viagemO
                    .stream()
                    .map(viagem -> new ViagemRecordDto(viagem.getId(), viagem.getDestino())).collect(Collectors.toList()));
        }
    }
}
