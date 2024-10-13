package org.example.kassa.BD.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.kassa.BD.DTO.KassaDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "kassa")
public class Kassa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Column(unique = true)
    private String name;

    @JsonIgnore
    private String address;

    @JsonIgnore
    @Column(scale = 2)
    private BigDecimal balance;

    @OneToMany(mappedBy = "sourceKassa")
    @JsonIgnore
    private List<Translation> outgoingTranslations = new ArrayList<>();

    @OneToMany(mappedBy = "targetKassa")
    @JsonIgnore
    private List<Translation> incomingTranslations = new ArrayList<>();

    public Kassa(KassaDto kassaDto) {
        this.id = kassaDto.getId();
    }
    public Kassa() {};
}
