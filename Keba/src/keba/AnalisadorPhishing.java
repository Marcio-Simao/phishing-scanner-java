package keba;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AnalisadorPhishing {

    // carrega as palavras suspeitas do ficheiro
    static ArrayList<String[]> carregarPalavras() {
        ArrayList<String[]> palavras = new ArrayList<>();
        try {
            BufferedReader leitor = new BufferedReader(
                new FileReader("dados/palavras_suspeitas.txt")
            );
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] partes = linha.split(";");
                palavras.add(partes);
            }
            leitor.close();
        } catch (IOException erro) {
            System.out.println("Erro ao carregar palavras: " + erro.getMessage());
        }
        return palavras;
    }

    // carrega os dominios negros do ficheiro
    static ArrayList<String> carregarDominios() {
        ArrayList<String> dominios = new ArrayList<>();
        try {
            BufferedReader leitor = new BufferedReader(
                new FileReader("dados/dominios_negros.txt")
            );
            String linha;
            while ((linha = leitor.readLine()) != null) {
                dominios.add(linha.trim());
            }
            leitor.close();
        } catch (IOException erro) {
            System.out.println("Erro ao carregar dominios: " + erro.getMessage());
        }
        return dominios;
    }

    // analisa um email e calcula a pontuacao de risco
    static int analisarEmail(Email email, ArrayList<String[]> palavras,
                                          ArrayList<String> dominios) {
        int pontuacao = 0;
        String textoCompleto = (email.getAssunto() + " " + 
                                email.getCorpo()).toLowerCase();

        // verifica palavras suspeitas
        for (String[] p : palavras) {
            String palavra = p[0].toLowerCase();
            int peso = Integer.parseInt(p[1]);
            if (textoCompleto.contains(palavra)) {
                pontuacao += peso;
                email.getPalavrassEcontradas().add(p[0]); //getPalavrassEcontradas o que devia ser o correto getPalavrasEncontradas
            }
        }

        // verifica dominio na lista negra
        String remetente = email.getRemetente().toLowerCase();
        for (String dominio : dominios) {
            if (remetente.contains(dominio.toLowerCase())) {
                pontuacao += 50;
                break;
            }
        }

        // classifica o email
        email.setPontuacaoRisco(pontuacao);
        email.setSuspeito(pontuacao >= 30);

        return pontuacao;
    }

    // classifica o nivel de risco
    static String classificarRisco(int pontuacao) {
        if (pontuacao >= 81) return "CRITICO";
        else if (pontuacao >= 51) return "ALTO";
        else if (pontuacao >= 21) return "MEDIO";
        else return "BAIXO";
    }
}