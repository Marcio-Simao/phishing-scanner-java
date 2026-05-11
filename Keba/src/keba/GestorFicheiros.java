/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package keba;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author LENOVO
 */
public class GestorFicheiros {
    
    static void ListarPalavras(){
        
    }
    
    static void AdicionarPalavra(){
        
        Scanner input = new Scanner(System.in);
        
        
        System.out.print("Digite a palavra suspeita: ");
        String palavra = input.nextLine();
        
        System.out.print("Digite o peso (ex: 20, 30, 40): ");
        int peso = input.nextInt();
        
        try{
            FileWriter fileWriter = new FileWriter("C:/Users/LENOVO/Documents"
            + "/NetBeansProjects/phishing-scanner-java/dados/"
            + "palavras_suspeitas.txt", true);
            
            BufferedWriter escritor = new BufferedWriter(fileWriter);
            
            escritor.write(palavra + ";" + peso);
            escritor.newLine();
            escritor.close();
            System.out.println("Palavra adicionada com sucesso!");
            
        }catch(IOException erro){
            
           System.out.println("Erro ao guardar a palavra: " + erro.getMessage()); 
        }
        
    }
    
    static void gerirPalavras(){ 
       Scanner input = new Scanner(System.in);
       int opcao = 0;
       do{
            System.out.println(" ");
            System.out.println("==============================================");
            System.out.println("KEBA - PALAVRAS SUSPEITAS");
            System.out.println("==============================================");
            System.out.println("1. Listar palavras");
            System.out.println("2. Adicionar palavra");
            System.out.println("3. Remover palavra");
            System.out.println("0. Voltar ao menu principal");
            System.out.println("==============================================");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
       
            switch(opcao)
                {
                    case 1: ListarPalavras(); break;
                    case 2: AdicionarPalavra(); break;
                    case 3: /*Remover palavra();*/ break;
                    case 0: /* Voltar ao menu principal();*/break;
                    default:
                        System.out.println("Valor Invalido");
                    break;
                }
            }while(opcao !=0);  
    }
    
}
