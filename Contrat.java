import java.util.Date;

public class Contrat {
    private String id;
    private BienImmobilier bien;
    private Client client;
    private Date dateSignature;
    private Date dateDebut;
    private Date dateFin;
    private double montant;
    private double montantPaye; // Montant payé pour ce contrat
    private Date dateDernierPaiement; // Date du dernier paiement

    public Contrat(String id, BienImmobilier bien, Client client, Date dateSignature, Date dateDebut, Date dateFin, double montant) {
        this.id = id;
        this.bien = bien;
        this.client = client;
        this.dateSignature = dateSignature;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.montant = montant;
        this.montantPaye = 0.0;
        this.dateDernierPaiement = null;
    }

    public String getId() {
        return id;
    }

    public BienImmobilier getBien() {
        return bien;
    }

    public Client getClient() {
        return client;
    }

    public Date getDateSignature() {
        return dateSignature;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public double getMontant() {
        return montant;
    }

    public double getMontantPaye() {
        return montantPaye;
    }

    public Date getDateDernierPaiement() {
        return dateDernierPaiement;
    }

    // Ajouter un paiement à ce contrat
    public void ajouterPaiement(double montant) {
        if (montant <= 0) {
            System.out.println("Le montant du paiement doit être positif.");
        } else if (montantPaye + montant > this.montant) {
            System.out.println("Le montant payé dépasse le montant du contrat.");
        } else {
            montantPaye += montant;
            dateDernierPaiement = new Date();
            System.out.println("Paiement de " + montant + "€ effectué. Montant total payé : " + montantPaye + "€.");
        }
    }
    public void effectuerPaiement(double montant) {
        if (montant <= 0) {
            System.out.println("Le montant du paiement doit être positif.");
        } else if (montantPaye + montant > this.montant) {
            System.out.println("Le montant payé dépasse le montant du contrat.");
        } else {
            montantPaye += montant;
            dateDernierPaiement = new Date();
            if (montantPaye == montant) {
                // Si le montant payé est égal au montant total, marquer le contrat comme terminé
                System.out.println("Le contrat est désormais terminé.");
            }
            System.out.println("Paiement de " + montant + "€ effectué. Montant total payé : " + montantPaye + "€.");
        }
    }



    @Override
    public String toString() {
        return "Contrat [ID: " + id + ", Bien: " + bien + ", Client: " + client + ", Montant: " + montant + "€, Dates: " + dateDebut + " à " + dateFin + ", Montant payé: " + montantPaye + "€]";
    }
}
