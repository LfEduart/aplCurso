package br.com.curso.dao;

import br.com.curso.model.Imovel;
import br.com.curso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ImovelDAO implements GenericDAO{

    private Connection conexao;
    
    public  ImovelDAO() throws Exception{
        conexao = SingleConnection.getConnection();
    }
    
    @Override
    public boolean cadastrar(Object objeto) {
        Imovel oImovel = (Imovel) objeto;
        boolean retorno=false;
        if (oImovel.getIdImovel()== 0){
            retorno = this.inserir(oImovel);
        }else{
            retorno = this.alterar(oImovel);
        }
        return retorno;
    }

    @Override
    public boolean inserir(Object objeto) {
        Imovel oImovel = (Imovel) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into imovel (descricaoimovel,valorimovel) values  (?,?)";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oImovel.getDescricaoimovel());
            stmt.setString(2, oImovel.getValorimovel());
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception ex){
            try{
                System.out.println("Problemas ao cadastrar o Imovel! Erro: "+ex.getMessage());
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
           Imovel oImovel = (Imovel) objeto;
           PreparedStatement stmt = null;
           String sql = "Update imovel set descricaoimovel=?,valorimovel=? where idimovel=?";
           try{
               stmt = conexao.prepareStatement (sql);
               stmt.setString(1, oImovel.getDescricaoimovel());
               stmt.setString(2, oImovel.getValorimovel());
               stmt.setInt(3, oImovel.getIdImovel());
               stmt.execute();
               conexao.commit();
               return true;
           }catch (Exception ex) {
               try{
                   System.out.println("Problemas ao alterar o Imovel! Erro:"+ex.getMessage());
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
        int idImovel = numero;
        PreparedStatement stmt = null;
        
        String sql = "delete from imovel where idimovel=?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idImovel);
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception ex){
            try{
                   System.out.println("Problema ao excluir Imovel! Erro: " + ex.getMessage());
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
     int idImovel = numero;
     PreparedStatement stmt = null;
     ResultSet rs= null;
     Imovel oImovel = null;
     String sql="select * from imovel where idImovel=?";
     
     try{
         stmt = conexao.prepareStatement (sql);
         stmt.setInt(1, idImovel);
         rs=stmt.executeQuery();
         while (rs.next()) {
             oImovel = new Imovel();
             oImovel.setIdImovel(rs.getInt("idImovel"));
             oImovel.setDescricaoimovel(rs.getString("descricaoimovel"));
             oImovel.setValorimovel(rs.getString("valorimovel"));
         }
         return oImovel;
     }catch (Exception ex) {
         System.out.println("Problemas ao carregar Imovel! Erro:"+ex.getMessage());
         return false;
     }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null; 
        String sql = "Select * from imovel order by idImovel";
        try{
            stmt = conexao.prepareStatement(sql);
            rs=stmt.executeQuery();
            while (rs.next()){
                Imovel oImovel = new Imovel();
                oImovel.setIdImovel(rs.getInt("idImovel"));
                oImovel.setDescricaoimovel(rs.getString("descricaoimovel"));
                oImovel.setValorimovel(rs.getString("valorimovel"));
                resultado.add(oImovel);
            }
        }catch (SQLException ex){
            System.out.println("Problemas ao listar Imovel! Erro" 
                    +ex.getMessage());
        }
        return resultado;
    }
    
}