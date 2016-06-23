
package trabalho;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Funcionario extends Loja{
    String nome;
    private String login;
    private String senha;
    
    Scanner leitor = new Scanner(System.in);
    
    List<Carro> lista = new ArrayList<>();

    public void setLogin(String login){
        this.login = login;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getLogin(){
        return login;
    }

    public String getSenha(){
        return senha;
    }

    @Override
    public String getNome(){
        return nome;
    }

    @Override
    public void setNome(String nome){
        this.nome = nome;
    }
    
}
