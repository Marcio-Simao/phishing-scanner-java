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
import java.util.ArrayList;
/**
 *
 * @author LENOVO
 */
public class GestorFicheiros {
    //método listar palavras
    static void listarPalavras(){
        String caminhoArquivo = "dados/palavras_suspeitas.txt";
        
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
            leitor.close();
            
        }catch(IOException erro){
            
           System.out.println("Erro ao guardar a palavra: " + erro.getMessage()); 
        }
        
    }
    
    static void adicionarPalavra(){
        
        Scanner input = new Scanner(System.in);
        String caminhoArquivo = "dados/palavras_suspeitas.txt";
        
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
            escritor.close();
            
        }catch(IOException erro){
            
           System.out.println("Erro ao guardar a palavra: " + erro.getMessage()); 
        }
    }   
    static void removerPalavra(){
    String caminhoArquivo = "dados/palavras_suspeitas.txt";
    Scanner input = new Scanner(System.in);
    
    // 1. Ler todas as palavras para a ArrayList
    ArrayList<String> palavras = new ArrayList<>();
    
    try {
        BufferedReader leitor = new BufferedReader(
            new FileReader(caminhoArquivo)
        );
        String linha;
        while ((linha = leitor.readLine()) != null) {
            palavras.add(linha);
        }
        leitor.close();
        
    } catch (IOException erro) {
        System.out.println("Erro ao ler o ficheiro: " + erro.getMessage());
        return; // sai do método se não conseguiu ler
    }
    
    // 2. Mostrar a lista
    System.out.println("\n==============================================");
    System.out.println("      KEBA - REMOVER PALAVRA SUSPEITA         ");
    System.out.println("==============================================");
    
    for (int i = 0; i < palavras.size(); i++) {
        String[] partes = palavras.get(i).split(";");
        System.out.println((i + 1) + ". " + partes[0] + " (peso: " + partes[1] + ")");
    }
    
    // 3. Utilizador escolhe o número
    System.out.print("\nDigite o número da palavra a remover (0 para cancelar): ");
    int escolha = input.nextInt();
    
    if (escolha == 0) {
        System.out.println("Operação cancelada.");
        return;
    }
    
    if (escolha < 1 || escolha > palavras.size()) {
        System.out.println("Número inválido!");
        return;
    }
    
    // 4. Remover da ArrayList
    String removida = palavras.get(escolha - 1).split(";")[0];
    palavras.remove(escolha - 1);
    
    // 5. Escrever tudo de volta no ficheiro
    try {
        BufferedWriter escritor = new BufferedWriter(
            new FileWriter(caminhoArquivo, false) // false = apaga e reescreve
        );
        for (String p : palavras) {
            escritor.write(p);
            escritor.newLine();
        }
        escritor.close();
        System.out.println("Palavra '" + removida + "' removida com sucesso!");
        
    } catch (IOException erro) {
        System.out.println("Erro ao guardar: " + erro.getMessage());
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
                    case 1: listarPalavras(); break;
                    case 2: adicionarPalavra(); break;
                    case 3: removerPalavra(); break;
                    case 0: /* Voltar ao menu principal();*/break;
                    default:
                        System.out.println("Valor Invalido");
                    break;
                }
            }while(opcao !=0);  
    }
    
}
