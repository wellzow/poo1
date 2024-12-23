public class Client {
    private String nom;
    private String prenom;
    private String email;
    private String telephone;

    // Constructor
    public Client(String nom, String prenom, String email, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
    }

    // Getters and Setters
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    // Method to buy a property
    public void acheterBien(BienImmobilier bien) {
        if (bien.isVendu()) {
            System.out.println("Le bien immobilier " + bien.getId() + " est déjà vendu.");
        } else {
            bien.setVendu(true);  // Mark the property as sold
            System.out.println("Le bien immobilier " + bien.getId() + " a été acheté par " + this.nom + " " + this.prenom + ".");
        }
    }

    public String toString() {
       return nom + " " + prenom + " " + email + " " + telephone;
    }
}