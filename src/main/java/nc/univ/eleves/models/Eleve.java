package nc.univ.eleves.models;

import org.springframework.data.annotation.Persistent;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Persistent
@Entity
public class Eleve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    private String nom;
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    private String prenom;
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    private int age;
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    private String adresse;
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }


    public Eleve(){

    }

    public Eleve(String nom, String prenom){
        this();
        this.nom = nom;
        this.prenom = prenom;
    }

    public Eleve(String nom, String prenom, int age, String adresse){
        this(nom, prenom);
        this.age = age;
        this.adresse = adresse;
    }


    @Override
    public String toString() {
        return "id: " + id + "\nNom: " + nom + "\nPrénom: " + prenom + "\nÂge: " + age + "\nAdresse: " + adresse + "\n";
    }
}
