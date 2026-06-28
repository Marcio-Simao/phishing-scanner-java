package keba;

public class RegistoAnalise {
    
    private String dataAnalise;
    private String ficheiroAnalisado;
    private int totalEmails;
    private int emailsSuspeitos;
    private int emailsSeguros;
    
    // Construtor
    public RegistoAnalise(String dataAnalise, String ficheiroAnalisado, 
                          int totalEmails, int emailsSuspeitos, int emailsSeguros) {
        this.dataAnalise = dataAnalise;
        this.ficheiroAnalisado = ficheiroAnalisado;
        this.totalEmails = totalEmails;
        this.emailsSuspeitos = emailsSuspeitos;
        this.emailsSeguros = emailsSeguros;
    }
    
    // Getters
    public String getDataAnalise() { return dataAnalise; }
    public String getFicheiroAnalisado() { return ficheiroAnalisado; }
    public int getTotalEmails() { return totalEmails; }
    public int getEmailsSuspeitos() { return emailsSuspeitos; }
    public int getEmailsSeguros() { return emailsSeguros; }
    
    // Setters
    public void setDataAnalise(String dataAnalise) { this.dataAnalise = dataAnalise; }
    public void setFicheiroAnalisado(String f) { this.ficheiroAnalisado = f; }
    public void setTotalEmails(int t) { this.totalEmails = t; }
    public void setEmailsSuspeitos(int e) { this.emailsSuspeitos = e; }
    public void setEmailsSeguros(int e) { this.emailsSeguros = e; }
    
    @Override
    public String toString() {
        return "Data: " + dataAnalise + 
               " | Ficheiro: " + ficheiroAnalisado +
               " | Total: " + totalEmails +
               " | Suspeitos: " + emailsSuspeitos +
               " | Seguros: " + emailsSeguros;
    }
}
