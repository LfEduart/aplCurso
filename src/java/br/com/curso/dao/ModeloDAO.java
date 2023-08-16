/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.dao;

import br.com.curso.model.Modelo;
import br.com.curso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ModeloDAO implements GenericDAO{
    private Connection conexao;
    public ModeloDAO()throws Exception{
     conexao = SingleConnection.getConnection();
     }
    @Override
    public boolean cadastrar(Object objeto) {
        Modelo oModelo = (Modelo) objeto;
        boolean retorno=false;
        if (oModelo.getIdModelo()== 0){
            retorno = this.inserir(oModelo);
        }else{
            retorno = this.alterar(oModelo);
        }
        return retorno;    }

    @Override
    public boolean inserir(Object objeto) {
        Modelo oModelo = (Modelo) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into modelo (descricao) values  (?)";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oModelo.getDescricao());
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception ex){
            try{
                System.out.println("Problemas ao cadastrar Modelo! Erro: "+ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            }catch (SQLException e){
                System.out.println("Erro: "+e.getMessage());
                e.printStackTrace();
            }
            return false;
        }  
    }

    @Override
    public boolean alterar(Object objeto) {
           Modelo oModelo = (Modelo) objeto;
           PreparedStatement stmt = null;
           String sql = "Update modelo set descricao=? where idmodelo=?";
           try{
               stmt = conexao.prepareStatement (sql);
               stmt.setString(1, oModelo.getDescricao());
               stmt.setInt(2, oModelo.getIdModelo());
               stmt.execute();
               conexao.commit();
               return true;
           }catch (Exception ex) {
               try{
                   System.out.println("Problemas ao alterar Modelo! Erro:"+ex.getMessage());
                   ex.printStackTrace();
                   conexao.rollback();
               }catch (SQLException e){
                   System.out.println("Erro:"+e.getMessage());
               }
               return false;
           }
    }

    @Override
    public boolean excluir(int numero) {
        int idModelo = numero;
        PreparedStatement stmt = null;
        
        String sql = "delete from modelo where idModelo=?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idModelo);
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception ex){
            try{
                   System.out.println("Problema ao excluir modelo! Erro: " + ex.getMessage());
                   conexao.rollback();
            }catch (SQLException e) {
                System.out.println(" Erro: " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Object carregar(int numero) {
    int idModelo = numero;
     PreparedStatement stmt = null;
     ResultSet rs= null;
     Modelo oModelo = null;
     String sql="select * from modelo where idModelo=?";
     
     try{
         stmt = conexao.prepareStatement (sql);
         stmt.setInt(1, idModelo);
         rs=stmt.executeQuery();
         while (rs.next()) {
             oModelo = new Modelo();
             oModelo.setIdModelo(rs.getInt("idModelo"));
             oModelo.setDescricao(rs.getString("descricao"));
         }
         return oModelo;
     }catch (Exception ex) {
         System.out.println("Problemas ao carregar Modelo! Erro:"+ex.getMessage());
         return false;
     }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null; 
        String sql = "Select * from modelo order by idModelo";
        try{
            stmt = conexao.prepareStatement(sql);
            rs=stmt.executeQuery();
            while (rs.next()){
                Modelo oModelo = new Modelo();
                oModelo.setIdModelo(rs.getInt("idModelo"));
                oModelo.setDescricao(rs.getString("descricao"));
                resultado.add(oModelo);
            }
        }catch (SQLException ex){
            System.out.println("Problemas ao listar Modelo! Erro" 
                    +ex.getMessage());
        }
        return resultado;
        }
    
}
