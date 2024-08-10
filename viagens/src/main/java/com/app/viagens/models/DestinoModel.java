package com.app.viagens.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "destino")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DestinoModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @JsonBackReference
    @OneToMany(mappedBy = "destino")
    private List<ViagemModel> viagens;
}
