import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgenceImmobiliere agence = new AgenceImmobiliere();

        // Exemple d'ajout d'agents
        AgentImmobilier agent1 = new AgentImmobilier("Alice", "Dupont", new ArrayList<>());
        AgentImmobilier agent2 = new AgentImmobilier("Bob", "Martin", new ArrayList<>());
        AgentImmobilier agent3 = new AgentImmobilier("angela", "white", new ArrayList<>());
        agence.ajouterAgent(agent1);
        agence.ajouterAgent(agent2);
        agence.ajouterAgent(agent3);



        int choix;
        do {
            System.out.println("\n=== Menu de Gestion Immobilière ===");
            System.out.println("1. Ajouter un bien immobilier");
            System.out.println("2. Ajouter un client");
            System.out.println("3. Afficher tous les biens");
            System.out.println("4. Rechercher un bien");
            System.out.println("5. Ajouter un contrat");
            System.out.println("6. Effectuer un paiement");
            System.out.println("7. Proposer un terrain");
            System.out.println("8. Ajouter un rendez-vous");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            switch (choix) {
                case 1: {
                    // Ajouter un bien immobilier
                    System.out.print("ID du bien : ");
                    String id = scanner.nextLine();
                    System.out.print("Type du bien (Appartement/Maison/Terrain) : ");
                    String type = scanner.nextLine();
                    System.out.print("Surface (m²) : ");
                    double surface = scanner.nextDouble();
                    System.out.print("Prix (€) : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine(); // Consommer la ligne restante
                    System.out.print("Localisation : ");
                    String localisation = scanner.nextLine();
                    System.out.print("Description : ");
                    String description = scanner.nextLine();

                    // Associer un bien à un agent
                    System.out.println("Choisissez un agent pour gérer ce bien :");
                    List<AgentImmobilier> agents = agence.getAgents();
                    for (int i = 0; i < agents.size(); i++) {
                        System.out.println((i + 1) + ". " + agents.get(i));
                    }
                    int agentIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (agentIndex >= 0 && agentIndex < agents.size()) {
                        BienImmobilier bien = new BienImmobilier(id, type, surface, prix, localisation, description);
                        agence.ajouterBien(bien, agents.get(agentIndex));
                    } else {
                        System.out.println("Choix invalide.");
                    }
                    break;
                }
                case 2: {
                    // Ajouter un client
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    System.out.print("Téléphone : ");
                    String telephone = scanner.nextLine();

                    Client client = new Client(nom, prenom, email, telephone);
                    agence.ajouterClient(client);
                    break;
                }
                case 3: {
                    // Afficher tous les biens
                    System.out.println("\nListe des biens immobiliers :");
                    for (BienImmobilier bien : agence.getBiens()) {
                        System.out.println(bien);
                    }
                    break;
                }
                case 4: {
                    // Rechercher un bien
                    System.out.print("Type de bien (laisser vide pour ignorer) : ");
                    String type = scanner.nextLine();
                    System.out.print("Surface minimale (0 pour ignorer) : ");
                    double surfaceMin = scanner.nextDouble();
                    System.out.print("Surface maximale (0 pour ignorer) : ");
                    double surfaceMax = scanner.nextDouble();
                    System.out.print("Prix maximum (0 pour ignorer) : ");
                    double prixMax = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Localisation (laisser vide pour ignorer) : ");
                    String localisation = scanner.nextLine();

                    List<BienImmobilier> resultats = agence.rechercherBiens(
                            type.isEmpty() ? null : type,
                            surfaceMin == 0 ? null : surfaceMin,
                            surfaceMax == 0 ? null : surfaceMax,
                            localisation.isEmpty() ? null : localisation,
                            prixMax == 0 ? null : prixMax
                    );

                    System.out.println("\nRésultats de la recherche :");
                    for (BienImmobilier bien : resultats) {
                        System.out.println(bien);
                    }
                    break;
                }
                case 5: {
                    // Ajouter un contrat
                    System.out.print("ID du contrat : ");
                    String idContrat = scanner.nextLine();
                    System.out.print("ID du bien : ");
                    String idBien = scanner.nextLine();
                    BienImmobilier bien = agence.rechercherBienParId(idBien);

                    if (bien == null) {
                        System.out.println("Bien introuvable.");
                        break;
                    }

                    System.out.print("Email du client : ");
                    String emailClient = scanner.nextLine();
                    Client client = agence.rechercherClientParEmail(emailClient);

                    if (client == null) {
                        System.out.println("Client introuvable.");
                        break;
                    }

                    System.out.print("Montant (€) : ");
                    double montant = scanner.nextDouble();
                    scanner.nextLine();
                    Date now = new Date();
                    Contrat contrat = new Contrat(idContrat, bien, client, now, now, null, montant);
                    System.out.println("Contrat ajouté : " + contrat);
                    break;
                }
                case 6: {
                    // Effectuer un paiement
                    System.out.print("ID du contrat : ");
                    String idContrat = scanner.nextLine();

                    // Rechercher le contrat en fonction de l'ID
                    Contrat contrat = agence.rechercherContratParId(idContrat); // Méthode dans AgenceImmobiliere

                    if (contrat == null) {
                        System.out.println("Contrat introuvable.");
                    } else {
                        // Demander le montant à payer
                        System.out.print("Montant à payer : ");
                        double montant = scanner.nextDouble();
                        scanner.nextLine(); // Consommer la ligne restante

                        // Appeler la méthode effectuerPaiement sur le contrat
                        contrat.effectuerPaiement(montant);
                    }
                    break;
                }
                case 7: {
                    // Proposer un terrain
                    System.out.println("Proposer un terrain :");

                    // Demander l'ID du propriétaire
                    System.out.print("ID du propriétaire : ");
                    int ownerId = scanner.nextInt();
                    scanner.nextLine(); // Consommer la ligne restante

                    // Rechercher le propriétaire en fonction de l'ID
                    Owner owner = agence.rechercherOwnerParId(ownerId); // méthode à implémenter dans AgenceImmobiliere
                    if (owner == null) {
                        System.out.println("Propriétaire introuvable.");
                        break;
                    }

                    // Demander les informations sur le terrain
                    System.out.print("ID du bien immobilier : ");
                    String bienId = scanner.nextLine();
                    System.out.print("Type de bien (Terrain) : ");
                    String type = scanner.nextLine();
                    System.out.print("Superficie (m²) : ");
                    double surface = scanner.nextDouble();
                    System.out.print("Prix (€) : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine(); // Consommer la ligne restante
                    System.out.print("Localisation : ");
                    String localisation = scanner.nextLine();
                    System.out.print("Description : ");
                    String description = scanner.nextLine();

                    // Créer un objet BienImmobilier représentant le terrain
                    BienImmobilier terrain = new BienImmobilier(bienId, type, surface, prix, localisation, description);

                    // Proposer le terrain
                    owner.proposerTerrain(terrain); // Ajouter le terrain à la liste du propriétaire
                    break;

                }
                case 8: {
                    // Ajouter un rendez-vous
                    System.out.println("Fonctionnalité de rendez-vous à implémenter.");
                    break;
                }
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 0);

        scanner.close();
    }
}
