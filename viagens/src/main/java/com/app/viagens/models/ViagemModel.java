package com.app.viagens.models;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "viagem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ViagemModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    private DestinoModel destino;
}
