package org.example.kassa.Service;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.example.kassa.BD.Model.Kassa;
import org.example.kassa.BD.Model.Translation;
import org.example.kassa.BD.Repository.KassaRepository;
import org.example.kassa.BD.Repository.TranslationRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
@Data
@RequiredArgsConstructor
public class KassaService {
    private final KassaRepository kassaRepository;
    private final TranslationRepository translationRepository;


   public List<Translation> findByKassaName(String name) {
       return kassaRepository.findByName(name);
   }

    public List<Translation> getAllTranslations() {
        return kassaRepository.findAllTranslations();
    }

}
