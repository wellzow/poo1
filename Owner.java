import java.util.List;
import java.util.ArrayList;
public class Owner {
    private int id;
    private String nom;
    private String contact;
    private List<BienImmobilier> terrains;

    public Owner(int id, String nom, String contact, List<BienImmobilier> terrains) {
        this.id = id;
        this.nom = nom;
        this.contact = contact;
        this.terrains = new ArrayList<>();
    }
    public int getId() {
        return id;
    }

    // Ajouter un terrain proposé
    public void proposerTerrain(BienImmobilier terrain) {
        if (terrain.getType().equalsIgnoreCase("Terrain")) {
            terrains.add(terrain);
            System.out.println("Terrain proposé par le propriétaire: " + nom + "\n" + terrain);
        } else {
            System.out.println("Seuls les terrains peuvent être proposés.");
        }
    }

    public List<BienImmobilier> getTerrains() {
        return terrains;
    }

    public String toString() {
        return "ID: " + id + ", Nom: " + nom + ", Contact: " + contact;
    }
}

