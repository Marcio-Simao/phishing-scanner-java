package keba;

import java.util.Scanner;
import java.util.ArrayList;

public class Keba {

    static void verEstatisticas(ArrayList<Email> emails) {
        if (emails == null || emails.isEmpty()) {
            System.out.println("Nenhuma analise realizada ainda. Execute a opcao 1 primeiro.");
            return;
        }

        System.out.println("\n==============================================");
        System.out.println("      KEBA - ESTATISTICAS GERAIS              ");
        System.out.println("==============================================");

        int total = emails.size();
        int suspeitos = 0;
        int seguros = 0;

        // contar suspeitos e seguros
        for (Email email : emails) {
            if (email.isSuspeito()) {
                suspeitos++;
            } else {
                seguros++;
            }
        }

        double percSuspeitos = (suspeitos * 100.0) / total;
        double percSeguros = (seguros * 100.0) / total;

        System.out.println("Total de emails analisados: " + total);
        System.out.println("Emails suspeitos: " + suspeitos + " (" + String.format("%.1f", percSuspeitos) + "%)");
        System.out.println("Emails seguros:   " + seguros + " (" + String.format("%.1f", percSeguros) + "%)");

        // contar palavras mais frequentes
        ArrayList<String> todasPalavras = new ArrayList<>();
        for (Email email : emails) {
            todasPalavras.addAll(email.getPalavrasEncontradas());
        }

        System.out.println("\nPalavras suspeitas mais encontradas:");
        if (todasPalavras.isEmpty()) {
            System.out.println("Nenhuma palavra suspeita encontrada.");
        } else {
            // contar ocorrencias de cada palavra
            ArrayList<String> contadas = new ArrayList<>();
            ArrayList<Integer> contagens = new ArrayList<>();

            for (String palavra : todasPalavras) {
                if (contadas.contains(palavra)) {
                    int idx = contadas.indexOf(palavra);
                    contagens.set(idx, contagens.get(idx) + 1);
                } else {
                    contadas.add(palavra);
                    contagens.add(1);
                }
            }

            // mostrar top 3
            int mostrar = Math.min(3, contadas.size());
            for (int i = 0; i < mostrar; i++) {
                int maxIdx = 0;
                for (int j = 1; j < contagens.size(); j++) {
                    if (contagens.get(j) > contagens.get(maxIdx)) {
                        maxIdx = j;
                    }
                }
                System.out.println((i + 1) + ". " + contadas.get(maxIdx)
                        + " (" + contagens.get(maxIdx) + " vez(es))");
                contagens.set(maxIdx, -1);
            }
        }

        System.out.println("==============================================\n");
    }

    static void gerarRelatorio(ArrayList<Email> emails) {
        if (emails == null || emails.isEmpty()) {
            System.out.println("Nenhuma analise realizada ainda. Execute a opcao 1 primeiro.");
            return;
        }

        StringBuilder conteudo = new StringBuilder();
        conteudo.append("KEBA - RELATORIO DE ANALISE\n");
        conteudo.append("==============================================\n");

        int suspeitos = 0, seguros = 0;
        for (Email email : emails) {
            conteudo.append("\nDe: ").append(email.getRemetente());
            conteudo.append("\nAssunto: ").append(email.getAssunto());
            conteudo.append("\nPontuacao: ").append(email.getPontuacaoRisco());
            conteudo.append("\nEstado: ").append(email.isSuspeito() ? "SUSPEITO" : "SEGURO");
            conteudo.append("\n----------------------------------------------");
            if (email.isSuspeito()) {
                suspeitos++;
            } else {
                seguros++;
            }
        }

        conteudo.append("\n\nTOTAL: ").append(emails.size());
        conteudo.append("\nSUSPEITOS: ").append(suspeitos);
        conteudo.append("\nSEGUROS: ").append(seguros);

        GestorFicheiros.exportarRelatorio(conteudo.toString());
    }

    static void verHistorico() {
        GestorFicheiros.lerHistorico();
    }

    static ArrayList<Email> analisarFicheiro() {
        Scanner input = new Scanner(System.in);

        String caminho = "dados/emails_entrada.txt";

        // 1. Carregar os emails do ficheiro
        ArrayList<Email> emails = GestorFicheiros.lerEmails(caminho);

        if (emails.isEmpty()) {
            System.out.println("Nenhum email encontrado no ficheiro!");
            return new ArrayList<>();
        }

        // 2. Carregar palavras suspeitas e dominios negros
        ArrayList<String[]> palavras = AnalisadorPhishing.carregarPalavras();
        ArrayList<String> dominios = AnalisadorPhishing.carregarDominios();

        // 3. Analisar cada email
        int totalSuspeitos = 0;
        int totalSeguros = 0;

        System.out.println("\n==============================================");
        System.out.println("      KEBA - RESULTADOS DA ANALISE            ");
        System.out.println("==============================================");

        for (Email email : emails) {
            int pontuacao = AnalisadorPhishing.analisarEmail(email, palavras, dominios);
            String nivel = AnalisadorPhishing.classificarRisco(pontuacao);

            System.out.println("\nDe: " + email.getRemetente());
            System.out.println("Assunto: " + email.getAssunto());
            System.out.println("Pontuacao: " + pontuacao);
            System.out.println("Risco: " + nivel);

            if (email.isSuspeito()) {
                System.out.println("Estado: SUSPEITO");
                System.out.println("Palavras encontradas: " + email.getPalavrasEncontradas());
                totalSuspeitos++;
            } else {
                System.out.println("Estado: SEGURO");
                totalSeguros++;
            }
            System.out.println("----------------------------------------------");
        }

        // 4. Mostrar resumo
        System.out.println("\nTOTAL DE EMAILS: " + emails.size());
        System.out.println("EMAILS SUSPEITOS: " + totalSuspeitos);
        System.out.println("EMAILS SEGUROS: " + totalSeguros);
        System.out.println("==============================================\n");

        // guardar no historico
        java.time.LocalDateTime agora = java.time.LocalDateTime.now();
        String dataHora = agora.getDayOfMonth() + "/"
                + agora.getMonthValue() + "/"
                + agora.getYear() + " "
                + agora.getHour() + ":"
                + agora.getMinute();

        RegistoAnalise registo = new RegistoAnalise(
                dataHora,
                "dados/emails_entrada.txt",
                emails.size(),
                totalSuspeitos,
                totalSeguros
        );

        GestorFicheiros.guardarHistorico(registo);
        System.out.println("Analise guardada no historico!");

        return emails;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        ArrayList<Email> ultimaAnalise = new ArrayList<>();

        do {
            System.out.println(" ");
            System.out.println("==============================================");
            System.out.println("KEBA - SCANNER DE PHISHING");
            System.out.println("Menu Principal");
            System.out.println("==============================================");
            System.out.println("1. Analisar um ficheiro de emails");
            System.out.println("2. Ver histórico de análises");
            System.out.println("3. Gerir lista de palavras suspeitas");
            System.out.println("4. Gerir lista negra de domínios");
            System.out.println("5. Gerar relatório (exportar para ficheiro)");
            System.out.println("6. Ver estatísticas gerais");
            System.out.println("0. Sair");
            System.out.println("==============================================");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    ultimaAnalise = analisarFicheiro();
                    break;
                case 2:
                    verHistorico();
                    break;
                case 3:
                    GestorFicheiros.gerirPalavras();
                    break;
                case 4:
                    GestorFicheiros.gerirDominios();
                    break;
                case 5:
                    gerarRelatorio(ultimaAnalise);
                    break;
                case 6:
                    verEstatisticas(ultimaAnalise);
                    break;
                case 0:
                    System.out.println("\n==============================================");
                    System.out.println("   A encerrar o KEBA - Scanner de Phishing... ");
                    System.out.println("   Todos os dados foram guardados.            ");
                    System.out.println("   Até à próxima!                              ");
                    System.out.println("==============================================");
                    break;
                default:
                    System.out.println("Valor Invalido");
                    break;
            }
        } while (opcao != 0);
    }
}
