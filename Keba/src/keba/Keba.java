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
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        
        do 
        {
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
                case 1:
                
                break;
                case 2:
                
                break;
                case 3:
                
                break;
                case 4:
                
                break;
                case 5:
                
                break;
                case 6:
                
                break;
                case 0:
                
                break;
                default:
                    System.out.println("Valor Invalido");
                break;
            }
        }while(opcao == 0);
        
    }
    
}
