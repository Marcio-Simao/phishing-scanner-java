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

    public String getRequerete() {
        return requerete;
    }

    public void setRequerete(String requerete) {
        this.requerete = requerete;
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
        return palavrassEcontradas;
    }

    public void setPalavrassEcontradas(ArrayList<String> palavrassEcontradas) {
        this.palavrassEcontradas = palavrassEcontradas;
    }
    private String requerete; //endereco de quem enviou o email
    
    private String destinatario; //enderco de quem recebeu
    
    private String assunto; // titulo possivelmente suspeito
    
    private String corpo; // o texto completo da msg
    
    private String dataEnvio; // guarda a data do envio
    
    private boolean suspeito; // resultado da analise
    
    private int pontuacaoRisco; // pontuacao da analise
    
    private ArrayList<String> palavrassEcontradas; //lista das palavras suspeitas

}
