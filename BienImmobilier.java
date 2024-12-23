public class BienImmobilier {
    private String id;
    private String type;
    private double Surface;
    private double prix;
    private String localisation;
    private String description;
    private boolean vendu;  // Indicates whether the property is sold
    private AgentImmobilier agent;

    // Constructor
    public BienImmobilier(String id, String type, double taille, double prix, String localisation, String description) {
        this.id = id;
        this.type = type;
        this.Surface = taille;
        this.prix = prix;
        this.localisation = localisation;
        this.description = description;
        this.vendu = false;  // Property is initially not sold
    }

    // Getter and setter methods
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getSurface() {
        return Surface;
    }

    public double getPrix() {
        return prix;
    }

    public String getLocalisation() {
        return localisation;
    }

    public String getDescription() {
        return description;
    }

    public AgentImmobilier getAgent() {
        return agent;
    }

    // Method to check if the property is sold
    public boolean isVendu() {
        return vendu;
    }

    // Method to set the property as sold
    public void setVendu(boolean vendu) {
        this.vendu = vendu;
    }
    public String toString() {
        return "BienImmobilier [ID=" + id + ", Type=" + type + ", Surface=" + Surface + " m², Prix=" + prix + " €, Localisation=" + localisation + ", Description=" + description + "]";
    }
}
