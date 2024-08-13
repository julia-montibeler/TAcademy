package com.app.d.e.v.s.controllers;

import com.app.d.e.v.s.dtos.MutanteRecordDto;
import com.app.d.e.v.s.models.MutanteModel;
import com.app.d.e.v.s.repositories.MutanteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.MutableAttributeSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/devs")
public class MutanteController {

    @Autowired
    MutanteRepository mutanteRepository;

    @GetMapping
    public ResponseEntity<List<MutanteModel>> getAllMutantes(){
        return ResponseEntity.status(HttpStatus.OK).body(mutanteRepository.findAll());
    }

    @GetMapping("/espada/{id}")
    public ResponseEntity<String> getStatusEspadaById(@PathVariable(value="id") Long id) {
        Optional<MutanteModel> mutanteModelO = mutanteRepository.findById(id);
        if(mutanteModelO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }else {
            if (mutanteModelO.get().getAliensMortos() > 20) {
                return ResponseEntity.status(HttpStatus.OK).body(mutanteModelO.get().getNome()+" está convidado a participar da E.S.P.A.D.A");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(mutanteModelO.get().getNome()+" não está apto a participar da E.S.P.A.D.A");
            }
        }
    }

    @GetMapping("/numeroAlunosPresentes")
    public ResponseEntity<String> getNumeroAlunosPresentes() {
        return ResponseEntity.status(HttpStatus.OK).body(""+mutanteRepository.countByNaInstituicao(true));
    }

    @GetMapping("/alunosPresentes")
    public ResponseEntity<List<MutanteModel>> getAlunosPresentes() {
        return ResponseEntity.status(HttpStatus.OK).body(mutanteRepository.findByNaInstituicao(true));
    }


    @PutMapping("/entrar/{id}")
    public ResponseEntity<Object> entrar(@PathVariable(value = "id") long id){
        Optional<MutanteModel> mutanteO = mutanteRepository.findById(id);
        if(mutanteO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }else {
            if (mutanteO.get().isNaInstituicao()) {
                return ResponseEntity.status(HttpStatus.OK).body("Aluno já está na instituição");
            }
            mutanteO.get().setNaInstituicao(true);
            return ResponseEntity.status(HttpStatus.OK).body(mutanteRepository.save(mutanteO.get()));
        }
    }

    @PutMapping("/sair/{id}")
    public ResponseEntity<Object> sair(@PathVariable(value = "id") long id){
        Optional<MutanteModel> mutanteO = mutanteRepository.findById(id);
        if(mutanteO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }else {
            if (!mutanteO.get().isNaInstituicao()) {
                return ResponseEntity.status(HttpStatus.OK).body("Aluno já está fora da instituição");
            }
            mutanteO.get().setNaInstituicao(false);
            return ResponseEntity.status(HttpStatus.OK).body(mutanteRepository.save(mutanteO.get()));
        }
    }
    @PostMapping
    public ResponseEntity<MutanteModel> addMutante(@RequestBody @Valid MutanteRecordDto mutanteRecordDto){
        MutanteModel mutanteModel =  new MutanteModel();
        BeanUtils.copyProperties(mutanteRecordDto, mutanteModel);
        mutanteModel.setAliensMortos((int)Math.floor(mutanteRecordDto.inimigosMortos()*0.268));
        mutanteModel.setDemoniosMortos((int)Math.floor(mutanteRecordDto.inimigosMortos()*0.432));
        return ResponseEntity.status(HttpStatus.CREATED).body(mutanteRepository.save(mutanteModel));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteProduct(@PathVariable(value="id") long id){
        Optional<MutanteModel> mutanteO = mutanteRepository.findById(id);
        if(mutanteO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }else {
            mutanteRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso!");
        }
    }
}
