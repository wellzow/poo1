import java.util.Date;

public class Transaction {
    private String id;
    private BienImmobilier bien;
    private Client client;
    private Date dateTransaction;
    private double montant;
    private String typeTransaction; // "Vente" ou "Location"
    private String statut; // "En attente", "Terminé", etc.
    private double montantPaye; // Montant déjà payé
    private Date dateDernierPaiement; // Date du dernier paiement

    public Transaction(String id, BienImmobilier bien, Client client, Date dateTransaction, double montant, String typeTransaction) {
        this.id = id;
        this.bien = bien;
        this.client = client;
        this.dateTransaction = dateTransaction;
        this.montant = montant;
        this.typeTransaction = typeTransaction;
        this.statut = "En attente"; // Initialement, la transaction est en attente
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

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public double getMontant() {
        return montant;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public String getStatut() {
        return statut;
    }

    public double getMontantPaye() {
        return montantPaye;
    }

    public Date getDateDernierPaiement() {
        return dateDernierPaiement;
    }

    // Ajouter un paiement à la transaction
    public void effectuerPaiement(double montant) {
        if (montant <= 0) {
            System.out.println("Le montant du paiement doit être positif.");
        } else if (montantPaye + montant > this.montant) {
            System.out.println("Le montant payé dépasse le montant de la transaction.");
        } else {
            montantPaye += montant;
            dateDernierPaiement = new Date();
            if (montantPaye == montant) {
                statut = "Terminé"; // La transaction est terminée si le montant total est payé
            }
            System.out.println("Paiement de " + montant + "€ effectué. Montant total payé : " + montantPaye + "€.");
        }
    }

    @Override
    public String toString() {
        return "Transaction [ID: " + id + ", Bien: " + bien + ", Client: " + client + ", Montant: " + montant + "€, Statut: " + statut + ", Montant payé: " + montantPaye + "€]";
    }
}

