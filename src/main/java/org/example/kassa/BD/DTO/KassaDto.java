package org.example.kassa.BD.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;
import lombok.Getter;

@Getter
public class KassaDto {
    private Long id;
}
