import java.util.ArrayList;
import java.util.List;

public class AgenceImmobiliere {
    private List<BienImmobilier> biens;
    private List<AgentImmobilier> agents;
    private List<Contrat> contrats;
    private List<Transaction> transactions;
    private List<RendezVous> rendezVous;
    private List<Client> clients;
    private List<Owner> owners;  // Liste des propriétaires

    // Liste des clients ajoutée

    public AgenceImmobiliere() {
        this.biens = new ArrayList<>();
        this.agents = new ArrayList<>();
        this.contrats = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.rendezVous = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.owners = new ArrayList<>();// Initialisation de la liste des clients
    }

    // Ajouter un client
    public void ajouterClient(Client client) {
        if (client != null) {
            clients.add(client);
            System.out.println("Client ajouté : " + client);
        } else {
            System.out.println("Erreur : Client non valide.");
        }
    }


    // Rechercher un client par son email
    public Client rechercherClientParEmail(String email) {
        for (Client client : clients) {
            if (client.getEmail().equalsIgnoreCase(email)) {
                return client;
            }
        }
        return null;
    }

    // Rechercher un bien par son ID
    public BienImmobilier rechercherBienParId(String id) {
        for (BienImmobilier bien : biens) {
            if (bien.getId().equals(id)) {
                return bien;
            }
        }
        return null;
    }

    // Ajouter un bien immobilier
    public void ajouterBien(BienImmobilier bien, AgentImmobilier agent) {
        if (bienExistant(bien.getId())) {
            System.out.println("Erreur : Le bien avec l'ID " + bien.getId() + " existe déjà.");
        } else {
            biens.add(bien);
            agent.ajouterBien(bien);
            System.out.println("Bien ajouté à l'agent " + agent + ": " + bien);
        }
    }

    // Vérifie si un bien existe déjà
    private boolean bienExistant(String id) {
        for (BienImmobilier bien : biens) {
            if (bien.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    // Ajouter un agent immobilier
    public void ajouterAgent(AgentImmobilier agent) {
        agents.add(agent);
        System.out.println("Agent ajouté : " + agent);
    }

    // Rechercher un bien immobilier en fonction de critères
    public List<BienImmobilier> rechercherBiens(String typeBien, Double surfaceMin, Double surfaceMax, String localisation, Double prixMax) {
        List<BienImmobilier> resultats = new ArrayList<>();

        for (BienImmobilier bien : biens) {
            boolean correspond = true;

            // Vérifier le type de bien
            if (typeBien != null && !bien.getType().equalsIgnoreCase(typeBien)) {
                correspond = false;
            }

            // Vérifier la localisation
            if (localisation != null && !bien.getLocalisation().equalsIgnoreCase(localisation)) {
                correspond = false;
            }

            // Vérifier le prix maximum
            if (prixMax != null && bien.getPrix() > prixMax) {
                correspond = false;
            }

            // Ajouter le bien si toutes les conditions sont remplies
            if (correspond) {
                resultats.add(bien);
            }
        }

        return resultats;
    }
    public Owner rechercherOwnerParId(int idOwner) {
        for (Owner owner : owners) { // owners étant la liste des propriétaires
            if (owner.getId() == idOwner) {
                return owner;
            }
        }
        return null; // Si le propriétaire n'est pas trouvé, on retourne null
    }
    public Contrat rechercherContratParId(String idContrat) {
        for (Contrat contrat : contrats) {
            if (contrat.getId().equals(idContrat)) {
                return contrat;
            }
        }
        return null; // Si le contrat n'est pas trouvé, on retourne null
    }










    // Autres méthodes pour gestion de transactions, contrats, paiements, etc.

    public List<Client> getClients() {
        return clients;
    }

    public List<AgentImmobilier> getAgents() {
        return agents;
    }

    public List<BienImmobilier> getBiens() {
        return biens;
    }
}
