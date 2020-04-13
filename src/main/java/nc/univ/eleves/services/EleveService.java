package nc.univ.eleves.services;

import com.github.javafaker.Faker;
import nc.univ.eleves.dao.IEleveRepository;
import nc.univ.eleves.exceptions.EleveNotFoundException;
import nc.univ.eleves.models.Eleve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EleveService {

    @Autowired
    private IEleveRepository eleveRepository;
    public IEleveRepository getEleveRepository() { return eleveRepository; }
    public void setEleveRepository(IEleveRepository eleveRepository) { this.eleveRepository = eleveRepository; }

    public ArrayList<Eleve> searchAll() {
        Iterable<Eleve> it = eleveRepository.findAll();
        ArrayList<Eleve> eleves = new ArrayList<>();
        it.forEach(e -> eleves.add(e));
        return eleves;
    }

    public Eleve search(Long id) {
        return eleveRepository.findById(id).get();
    }

    public Eleve save(Eleve eleve){
        return eleveRepository.save(eleve);
    }

    public void update(Eleve eleve, Long id) throws EleveNotFoundException {
        if(!eleve.getId().equals(id)){
            throw new EleveNotFoundException("L'id ne correspond pas à l'élève");
        }
        else if(eleveRepository.findById(id).isPresent()){
            Eleve eleveModifie = eleveRepository.findById(id).get();
            eleveModifie.setId(eleve.getId());
            eleveModifie.setNom(eleve.getNom());
            eleveModifie.setPrenom(eleve.getPrenom());
            eleveModifie.setAge(eleve.getAge());
            eleveModifie.setAdresse(eleve.getAdresse());
            eleveRepository.save(eleveModifie);
        }

    }

    public void delete(Long id){
        eleveRepository.deleteById(id);
    }

    public void generate() {
        Faker faker = new Faker();

        for(int i=0; i<10; i++){
            String nom = faker.name().lastName();
            String prenom = faker.name().firstName();
            Eleve eleve = new Eleve(nom, prenom);
            eleveRepository.save(eleve);
        }

    }

}
