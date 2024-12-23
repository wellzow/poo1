import java.util.Date;

public class RendezVous {
    private BienImmobilier bien;
    private Client client;
    private AgentImmobilier agent;
    private Date dateRendezVous;

    public RendezVous(BienImmobilier bien, Client client, AgentImmobilier agent, Date dateRendezVous) {
        this.bien = bien;
        this.client = client;
        this.agent = agent;
        this.dateRendezVous = dateRendezVous;
    }

    public BienImmobilier getBien() {
        return bien;
    }

    public Client getClient() {
        return client;
    }

    public AgentImmobilier getAgent() {
        return agent;
    }

    public Date getDateRendezVous() {
        return dateRendezVous;
    }

    @Override
    public String toString() {
        return "Rendez-vous pour " + bien.getType() + " à " + bien.getLocalisation() +
                " avec " + client.getNom() + " " + client.getPrenom() +
                " le " + dateRendezVous.toString();
    }
}