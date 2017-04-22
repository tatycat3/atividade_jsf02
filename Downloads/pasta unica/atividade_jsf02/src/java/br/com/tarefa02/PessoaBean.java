package br.com.tarefa02;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="bean")
@SessionScoped

//declaração da Classe
public class PessoaBean {
    
    //declaração do objeto pessoa
    private Pessoa pessoa;
    //declaração do objeto lista
    private List lista;
    
    //método construtor 
    //no construtor é feito a instância dos objetos
    public PessoaBean(){
        pessoa = new Pessoa();
        lista = new ArrayList<Pessoa>();
    }

    //get e set 
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }
    
    //método adicionar
    public void adicionar(){
        lista.add(pessoa);
        pessoa = new Pessoa();
    }
    
    
    
}
