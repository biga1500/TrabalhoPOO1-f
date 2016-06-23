
package trabalho;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controle extends Funcionario{
    List<String> lista2 = new ArrayList<>();
    List<Funcionario> lista1 = new ArrayList<>();
    File arquivo = new File("teste.txt");
    Gerente g = new Gerente();
    Loja l = new Loja();
    
    
    public void Autenticar() throws IOException{
        Scanner leitura = new Scanner(System.in);
        Atendente a = new Atendente();
        g.setLogin("admin");
        g.setSenha("admin");
        g.setNome("Administrador");
        System.out.printf("\nNome:"+l.getNome()+"\nEndereço:"+l.getEndereco()+"\nCNPJ:"+l.getCnpj());
        System.out.printf("\nLogin: ");
        String login = leitura.next();
        System.out.printf("Senha: ");
        String senha = leitura.next();
        if(login.equals(g.getLogin())&&senha.equals(g.getSenha())){
            System.out.printf("\nSeja bem-vindo %s\n",g.getNome());
            escolhefunc();
            Autenticar();
        }else
            for(int i=0;i<lista1.size();i++){
                    if(lista1.get(i).getLogin().equals(login)&& lista1.get(i).getSenha().equals(senha)){
                        escolhe();
                    }
            }
            Autenticar();    
    }

    public void escolhefunc(){
        Scanner leitor1 = new Scanner(System.in);   
        int op=0;  
        do{
            System.out.printf(
                      "|1 - Adicionar Funcionario|\n"
                    + "|2 - Remover Funcionario|\n"
                    + "|3 - Editar Funcionario|\n"
                    + "|4 - Listar Funcionarios|\n"
                    + "|5 - Sair|\n"+
                    "Digite a opção desejada: ");
            op = leitor1.nextInt();
            switch(op){
                case 1:
                    adicionarAtendente();
                    break;
                case 2:
                    removerAtendente();
                    break;
                case 3:
                    editarAtendente();
                    break;
                case 4:
                    mostrarAtendente();
                    break;
            }
        }while(op!=5);
    }
    
    public void adicionarAtendente(){
        Funcionario f1 = new Atendente();
        System.out.print("Digite o nome do novo atendente: ");
        f1.setNome(leitor.nextLine());
        System.out.print("Digite o login do novo atendente: ");
        f1.setLogin(leitor.nextLine());
        System.out.print("Digite a senha do novo atendente: ");
        f1.setSenha(leitor.nextLine());
        lista1.add(f1);
    }
    
    public void removerAtendente(){
        int cont=0;
        System.out.printf("Digite o nome do atendente que deseja remover: ");
        leitor.nextLine();
        String n = leitor.nextLine();
            for (Funcionario lista11 : lista1) {
                cont++;
                if(n.equals(lista11.getNome())){
                    lista1.remove(lista11);
                    System.out.printf("Atendente removido com sucesso!\n");
                    break;
                }else if(cont==lista1.size()){
                    System.out.printf("Nome não encontrado!");
                }
            }
    }
    
    public void editarAtendente(){
        int cont=0;
        System.out.printf("Digite o nome do atendente que deseja editar:");
        String name = leitor.nextLine();
            for(Funcionario lista11:lista1){
                cont++;
                if(name.equals(lista11.getNome())){
                    System.out.printf("Digite o novo nome: ");
                    lista11.setNome(leitor.next());
                    System.out.printf("\nDigite novo login: ");
                    lista11.setLogin(leitor.next());
                    System.out.printf("Digite a nova senha: ");
                    lista11.setSenha(leitor.next());
                    break;
                }else if(cont==lista1.size()){
                    System.out.printf("Nome não encontrado.");
                }
            }
    }
    
    public void mostrarAtendente(){
        lista1.stream().forEach((lista11)->{
            System.out.printf(
                    "\nNome: " + lista11.getNome() 
                    + "\nLogin: " + lista11.getLogin() 
                    + "\nSenha: " + lista11.getSenha());
        });
    }
    
    public void escolhe() throws IOException{
            
        Controle c = new Controle();    
        int op;
        do{
            System.out.printf("\nDigite a opção desejada:\n"
                    + "|1 - Adicionar Carro|\n"
                    + "|2 - Mostrar Carros Estocados|\n"
                    + "|3 - Mostrar Carros por Fabricante|\n"
                    + "|4 - Editar Carros|\n"
                    + "|5 - Remover Carros por Fabricante|\n"
                    + "|6 - Mostrar Faturamento|\n"
                    + "|7 - Exportar Arquivo|\n"
                    + "|8 - Importar Arquivo|\n"
                    + "|9 - Sair|\n");
            System.out.print("Opção selecionada: ");
            op = leitor.nextInt();
            switch(op){
                case 1:
                    adicionarCarro();
                    break;
                case 2:
                    mostrarCarro();
                    break;
                case 3:
                    mostraFab();
                    break;
                case 4:
                    editarCarro();
                    break;
                case 5:
                    removeporFab();
                    break;
                case 6:
                    mostrarFaturamento();
                    break;
                case 7:
                    exportarArquivo();
                    break;
                case 8:
                    importarArquivo();
                    break;
            }
        }while(op!=9);
    }
    
    public void adicionarCarro(){
        Carro c1 = new Carro();
        System.out.printf("\nDigite o nome do fabricante: ");
        leitor.nextLine();
        c1.setFabricante(leitor.nextLine());
        System.out.printf("\nDigite o modelo do carro: ");
        c1.setModelo(leitor.nextLine());
        System.out.printf("\nDigite o ano: ");
        c1.setAno(leitor.nextInt());
        System.out.printf("\nDigite a quilometragem do carro: ");
        c1.setQuilometros(leitor.nextInt());
        System.out.printf("\nDigite o preço: ");
        c1.setPreco(leitor.nextFloat());
        lista.add(c1);
        System.out.println("Carro adicionado no estoque!");
        
    }
    
    public void mostrarCarro(){
        lista.stream().forEach(
                (lista1)->{System.out.printf(
                        "\nFabricante: " + lista1.fabricante
                        + "\nModelo: " + lista1.modelo
                        + "\nAno: " + lista1.ano
                        + "\nQuilometragem: " + lista1.quilometros
                        + "\nPreço: " + lista1.preco);
                       
                });
    }
    
    public void editarCarro(){
        String carro;
        int cont =0;
        System.out.printf("\nDigite qual o carro deseja editar: ");
        leitor.nextLine();
        carro = leitor.nextLine();
        for (Carro lista1 : lista){
            if(lista1.modelo.equals(carro)){
                System.out.printf("\nDigite o nome do fabricante: ");
                lista1.fabricante = (leitor.nextLine());
                System.out.printf("\nDigite o modelo do carro: ");
                lista1.modelo = (leitor.nextLine());
                System.out.printf("\nDigite o ano: ");
                lista1.ano = (leitor.nextInt());
                System.out.printf("\nDigite a quilometragem do carro: ");
                lista1.quilometros = (leitor.nextInt());
                System.out.printf("\nDigite o preço: ");
                lista1.preco = (leitor.nextFloat());
                break;
            }else
                if(cont == lista.size()){
                    System.out.printf("\nNão foi encontrada essa marca!");
                    break;
                }
        }    
    }
    
    public void mostraFab(){
        int cont=0;
        String fab;
        System.out.printf("Digite o nome do fabricante: ");
        leitor.nextLine();
        fab = leitor.nextLine();
        for(Carro lista1:lista){
            cont++;
            if(lista1.fabricante.equals(fab)){
                System.out.printf(
                        "Fabricante: " + lista1.fabricante
                        + "\nModelo: " + lista1.modelo
                        + "\nAno: " + lista1.ano
                        + "\nQuilometragem: " + lista1.quilometros
                        + "\nPreço: " + lista1.preco);
                break;
            }
            else if(cont==lista.size()){
                System.out.printf("\nNão foi encontrado carro com este fabricante.");
            }  
        }
    }
    
    public void removeporFab(){
        int cont=0;
        String fab;
        System.out.printf("\nDigite o fabricante que deseja deletar do sistema: ");
        leitor.nextLine();
        fab = leitor.nextLine();
        for(Carro lista1:lista){
            cont++;
            if(lista1.fabricante.equals(fab)){
                lista.remove(lista1);
                l.setFaturamento(l.getFaturamento()+lista1.getPreco());
                System.out.printf("\nRemovido com sucesso.");
                break;
            }
            else if(cont==lista.size()){
                System.out.printf("\nNão encontrado.");
            }
        }  
    }
    
    public void mostrarFaturamento(){
         System.out.printf("Faturamento: " + l.getFaturamento());
     }
    
    public void exportarArquivo(){
        boolean teste = false;
        
        try (FileWriter arq = new FileWriter(arquivo)) {
            PrintWriter gravararq = new PrintWriter(arq);
            for (Carro lista1 : lista) {
                if(teste == false){
        
                gravararq.print("" + lista1.getFabricante()
                        + "\r\n" + lista1.getModelo()
                        + "\r\n" + lista1.getAno()
                        + "\r\n" + lista1.getQuilometros()
                        + "\r\n" + lista1.preco);
                        
                teste = true;
                }
                
                else{
                    gravararq.print("\r\n" + lista1.getFabricante()
                        + "\r\n" + lista1.getModelo()
                        + "\r\n" + lista1.getAno()
                        + "\r\n" + lista1.getQuilometros()
                        + "\r\n" + lista1.preco);
                }
        }
         
        } catch (IOException ex){
            Logger.getLogger(Atendente.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    public void importarArquivo() throws IOException{
        try {
            FileReader arq = new FileReader("teste.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            Carro c1 = new Carro();
            int cont = 0;
            String linha = lerArq.readLine();
            while(linha!=null){
             lista2.add(linha);
            //System.out.println(linha);
            linha = lerArq.readLine();

            }
            for(int i=0; i<lista2.size(); i++){
                c1.setFabricante(lista2.get(i)); 
                i++;
                c1.setModelo(lista2.get(i));
                i++;
                c1.setAno(Integer.parseInt(lista2.get(i)));
                i++;
                c1.setQuilometros((int) Float.parseFloat(lista2.get(i)));
                i++;
                c1.setPreco(Float.parseFloat(lista2.get(i)));
                i++;
                lista.add(c1);
            }
            
            
            
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        
    }
}

 