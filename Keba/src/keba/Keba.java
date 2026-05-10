/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package keba;
import java.util.Scanner;
/**
 *
 * @author LENOVO
 */
public class Keba {

    /**
     * @param args the command line arguments
     */
    
    static void verHistorico (){
     
        System.out.println("Ver Historico");
    }
    static void gerirPalavras(){
       System.out.println("==============================================");
       System.out.println("KEBA - PALAVRAS SUSPEITAS");
       System.out.println("==============================================");
       System.out.println("1. Listar palavras");
       System.out.println("2. Adicionar palavra");
       System.out.println("3. Remover palavra");
       System.out.println("0. Voltar ao menu principal");
       System.out.println("==============================================");
       System.out.print("Escolha uma opção: ");
        
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
                case 1: /*analisarFicheiro();*/ break;
                case 2: verHistorico(); break;
                case 3: gerirPalavras(); break;
                case 4: /* gerirListaNegra(); */break;
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
