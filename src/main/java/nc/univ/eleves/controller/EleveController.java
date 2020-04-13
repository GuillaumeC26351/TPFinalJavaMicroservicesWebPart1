package nc.univ.eleves.controller;

import nc.univ.eleves.exceptions.EleveNotFoundException;
import nc.univ.eleves.models.Eleve;
import nc.univ.eleves.services.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(name = "/eleves")
public class EleveController {

    @Autowired
    private EleveService eleveService;
    public EleveService getEleveService() { return eleveService; }
    public void setEleveService(EleveService eleveService) { this.eleveService = eleveService; }

    @GetMapping("/eleves")
    public ArrayList<Eleve> allEleves() {
        return eleveService.searchAll();
    }

    @GetMapping("/eleves/{id}")
    public Eleve searchEleve(@PathVariable String id) {
        Long eleveId = Long.parseLong(id);
        return eleveService.search(eleveId);
    }

    @PostMapping("/eleves")
    public Eleve newEleve(@RequestBody Eleve eleve) {
        return eleveService.save(eleve);
    }

    @PutMapping("/eleves/{id}")
    public void updateEleve(@RequestBody Eleve eleve, @PathVariable String id) throws EleveNotFoundException {
        Long eleveId = Long.parseLong(id);
        eleveService.update(eleve, eleveId);
    }

    @DeleteMapping("/eleves/{id}")
    public void deleteEleve(@PathVariable String id) {
        Long eleveId = Long.parseLong(id);
        eleveService.delete(eleveId);
    }

    @GetMapping("/eleves/generate10")
    public void generateTenEleves() {
        eleveService.generate();
    }



}
