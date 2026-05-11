/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package keba;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author LENOVO
 */
public class GestorFicheiros {
    
    static void ListarPalavras(){
        Scanner input = new Scanner(System.in);
        String caminhoArquivo = "C:/Users/LENOVO/Documents/NetBeansProjects/phishing-scanner-java/dados/palavras_suspeitas.txt";
        
        System.out.println("\n==============================================");
        System.out.println("      KEBA - LISTA DE PALAVRAS SUSPEITAS      ");
        System.out.println("==============================================");
        
        try{
            FileReader fileReader = new FileReader(caminhoArquivo);
            BufferedReader leitor = new BufferedReader(fileReader);
            String linha;
            int contador = 1;
            
            while((linha = leitor.readLine()) != null){
                String[] partes = linha.split(";");
                String palavra = partes[0];
                String peso    = partes[1];
                System.out.println(contador + ". " + palavra + " (peso: " + peso + ")");
                contador++;
            }
            
        }catch(IOException erro){
            
           System.out.println("Erro ao guardar a palavra: " + erro.getMessage()); 
        }
        
    }
    
    static void AdicionarPalavra(){
        
        Scanner input = new Scanner(System.in);
        String caminhoArquivo = "C:/Users/LENOVO/Documents/NetBeansProjects/phishing-scanner-java/dados/palavras_suspeitas.txt";
        
        System.out.print("Digite a palavra suspeita: ");
        String palavra = input.nextLine();
        
        System.out.print("Digite o peso (ex: 20, 30, 40): ");
        int peso = input.nextInt();
        
        try{
            FileWriter fileWriter = new FileWriter(caminhoArquivo, true);
            
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
