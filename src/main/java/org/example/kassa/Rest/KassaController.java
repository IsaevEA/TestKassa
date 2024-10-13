package org.example.kassa.Rest;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.kassa.BD.Model.Translation;
import org.example.kassa.Service.KassaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
