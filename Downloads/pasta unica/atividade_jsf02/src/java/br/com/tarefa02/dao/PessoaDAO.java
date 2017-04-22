
package br.com.tarefa02.dao;

import br.com.tarefa02.conexao.Conexao;
import br.com.tarefa02.modelo.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PessoaDAO {
    
    
    private Connection con;//obrjeto para estabelecer a conexao BD
    private String sql;//String para digitar o comando SQL
    private PreparedStatement pstm;//objeto responsavel para executar o comando SQL no BD
    private ResultSet rs;//objeto responsavel para armazenar o resultado do select

    
    public boolean insert(Pessoa pessoa){
       sql = "insert into tb_pessoa (nome,email,telefone,"
               + "dtNasc) values (?,?,?,?)"; 
       con = Conexao.conectar(); 
       boolean resultado = false;
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, pessoa.getNome());
            pstm.setString(2, pessoa.getEmail());
            pstm.setString(3, pessoa.getTelefone());
            pstm.setString(4, pessoa.getDtNasc());
            resultado = pstm.execute();
            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return resultado;
        }
       
        
    }// fim do método  insert 
    
    public List<Pessoa> getPessoas(){
        List lista = new ArrayList<Pessoa>();
        Pessoa pessoa;
        sql = "Select * from tb_pessoa";
        try{
            
            con = Conexao.conectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()){
                pessoa = new Pessoa();
                pessoa.setNome(rs.getString("nome"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setDtNasc(rs.getString("dtNasc"));
                lista.add(pessoa);
                
            } //fim while 
            return lista;
        }
            catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        }
        
    }
}
