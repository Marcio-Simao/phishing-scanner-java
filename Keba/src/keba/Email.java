/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package keba;
import java.util.ArrayList;

/**
 *@author MJ
 */
public class Email {

    private String remetente; //endereco de quem enviou o email
    
    private String destinatario; //enderco de quem recebeu
    
    private String assunto; // titulo possivelmente suspeito
    
    private String corpo; // o texto completo da msg
    
    private String dataEnvio; // guarda a data do envio
    
    private boolean suspeito; // resultado da analise
    
    private int pontuacaoRisco; // pontuacao da analise
    
    private ArrayList<String> palavrasEcontradas; //lista das palavras suspeitas

    public Email(String remetente, String destinatario, String assunto, String corpo, String dataEnvio) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.corpo = corpo;
        this.dataEnvio = dataEnvio;
        this.suspeito = false;
        this.pontuacaoRisco = 0;
        this.palavrasEcontradas = new ArrayList<>();
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public String getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(String dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public boolean isSuspeito() {
        return suspeito;
    }

    public void setSuspeito(boolean suspeito) {
        this.suspeito = suspeito;
    }

    public int getPontuacaoRisco() {
        return pontuacaoRisco;
    }

    public void setPontuacaoRisco(int pontuacaoRisco) {
        this.pontuacaoRisco = pontuacaoRisco;
    }

    public ArrayList<String> getPalavrassEcontradas() {
        return palavrasEcontradas;
    }

    public void setPalavrassEcontradas(ArrayList<String> palavrassEcontradas) {
        this.palavrasEcontradas = palavrassEcontradas;
    }

}
