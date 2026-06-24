package keba;

import java.util.Scanner;
import java.util.ArrayList;

public class Keba {
    
    static void verHistorico (){
        System.out.println("Ver Historico");
    }
    
    static void analisarFicheiro() {
    Scanner input = new Scanner(System.in);

    String caminho = "dados/emails_entrada.txt";

    // 1. Carregar os emails do ficheiro
    ArrayList<Email> emails = GestorFicheiros.lerEmails(caminho);

    if (emails.isEmpty()) {
        System.out.println("Nenhum email encontrado no ficheiro!");
        return;
    }

    // 2. Carregar palavras suspeitas e dominios negros
    ArrayList<String[]> palavras = AnalisadorPhishing.carregarPalavras();
    ArrayList<String> dominios  = AnalisadorPhishing.carregarDominios();

    // 3. Analisar cada email
    int totalSuspeitos = 0;
    int totalSeguros   = 0;

    System.out.println("\n==============================================");
    System.out.println("      KEBA - RESULTADOS DA ANALISE            ");
    System.out.println("==============================================");

    for (Email email : emails) {
        int pontuacao = AnalisadorPhishing.analisarEmail(email, palavras, dominios);
        String nivel  = AnalisadorPhishing.classificarRisco(pontuacao);

        System.out.println("\nDe: "      + email.getRemetente());
        System.out.println("Assunto: "  + email.getAssunto());
        System.out.println("Pontuacao: " + pontuacao);
        System.out.println("Risco: "    + nivel);

        if (email.isSuspeito()) {
            System.out.println("Estado: SUSPEITO");
            System.out.println("Palavras encontradas: " + 
                               email.getPalavrasEncontradas());
            totalSuspeitos++;
        } else {
            System.out.println("Estado: SEGURO");
            totalSeguros++;
        }
        System.out.println("----------------------------------------------");
    }

    // 4. Mostrar resumo
    System.out.println("\nTOTAL DE EMAILS: "    + emails.size());
    System.out.println("EMAILS SUSPEITOS: "     + totalSuspeitos);
    System.out.println("EMAILS SEGUROS: "       + totalSeguros);
    System.out.println("==============================================\n");
    }
   
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        
        do 
        {
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

            switch(opcao)
            {
                case 1: analisarFicheiro(); break;
                case 2: verHistorico(); break;
                case 3: GestorFicheiros.gerirPalavras(); break;
                case 4: GestorFicheiros.gerirDominios(); break;
                case 5: /* gerarRelatorio(); */ break;
                case 6: /* verEstatisticas(); */break;
                case 0: /* sair(); */break;
                default:
                    System.out.println("Valor Invalido");
                break;
            }
        }while(opcao != 0);   
    }   
}