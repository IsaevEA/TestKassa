package org.example.kassa.Rest;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.kassa.BD.DTO.TrnsactionDto;
import org.example.kassa.BD.Model.Translation;
import org.example.kassa.Service.KassaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("kassa/")
@Data
public class KassaController {
    private final KassaService kassaService;


    @GetMapping("/{name}")
    public List<Translation> translations(@PathVariable String name){
        return kassaService.findByKassaName(name);
    }
    @GetMapping("/list")
    public List<Translation> getTranslations(){
        return kassaService.getAllTranslations();
    }

    @GetMapping("/list/status/{name}")
    public List<Translation> getTranslationsStatus(@PathVariable String name){
        return kassaService.findByStatus(name);
    }
    @GetMapping("/list/amount/{name}")
    public List<Translation> getTranslationsAmount(@PathVariable String name){
        return kassaService.findByAmount(name);
    }

    @PostMapping("/list/creatAd/{name}")
    public List<Translation> getTranslationsCreatAd(@PathVariable String name){
        return kassaService.findByCreatedAt(name);
    }


}
