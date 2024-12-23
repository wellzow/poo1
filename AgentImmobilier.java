import java.util.ArrayList;
import java.util.List;

public class AgentImmobilier {
    private String nom;
    private String prenom;
    private List<BienImmobilier> biens;

    // Constructeur avec nom, prenom et une liste de biens
    public AgentImmobilier(String nom, String prenom, List<BienImmobilier> biens) {
        this.nom = nom;
        this.prenom = prenom;
        this.biens = biens != null ? biens : new ArrayList<>();
    }

    // Ajouter un bien à l'agent
    public void ajouterBien(BienImmobilier bien) {
        biens.add(bien);
        System.out.println("Bien ajouté à l'agent : " + bien);
    }

    // Obtenir la liste des biens gérés par cet agent
    public List<BienImmobilier> getBiens() {
        return biens;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public String toString() {
        return nom + " " + prenom;
    }
}