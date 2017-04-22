package br.com.tarefa02.bean;

import br.com.tarefa02.dao.PessoaDAO;
import br.com.tarefa02.modelo.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

//ManagedBean faz a ligação do xml com a classe java
@ManagedBean (name ="bean")

//SessionScoped dá a duração das informações adicionadas
@SessionScoped

//declaração da Classe
public class PessoaBean {
    
    //declaração do objeto pessoa
    private Pessoa pessoa;
    //declaração do objeto lista
    private List lista;
    //declaração do objeto pessoaDAO
    private PessoaDAO pessoaDAO;
    
    //método construtor
    //no construtor é feito a instâcia dos objetos
    public PessoaBean(){
        pessoa = new Pessoa();
        pessoaDAO = new PessoaDAO();
        lista = pessoaDAO.getPessoas();
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
        boolean res = pessoaDAO.insert(pessoa);
        lista.add(pessoa);
        pessoa = new Pessoa();
    }
    
}
