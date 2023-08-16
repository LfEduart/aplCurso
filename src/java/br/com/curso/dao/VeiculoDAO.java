
package br.com.curso.dao;
import br.com.curso.model.Marca;
import br.com.curso.model.Modelo;
import br.com.curso.model.Veiculo;
import br.com.curso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class VeiculoDAO implements GenericDAO{

    private Connection conexao;
    
    public  VeiculoDAO() throws Exception{
        conexao = SingleConnection.getConnection();
    }
    
    @Override
    public boolean cadastrar(Object objeto) {
        Veiculo oVeiculo = (Veiculo) objeto;
        boolean retorno=false;
        if (oVeiculo.getIdVeiculo()== 0){
            retorno = this.inserir(oVeiculo);
        }else{
            retorno = this.alterar(oVeiculo);
        }
        return retorno;
    }

    @Override
    public boolean inserir(Object objeto) {
    Veiculo oVeiculo = (Veiculo) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into veiculo ( idMarca, idModelo) values (?,?)";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, oVeiculo.getIdMarca().getIdMarca());
            stmt.setInt(2, oVeiculo.getIdModelo().getIdModelo());
             stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception ex){
            try{
                System.out.println("Problemas ao cadastrar a Veiculo ! Erro:"+ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            }catch (SQLException e){
                System.out.println("Erro:"+e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }
    @Override
    public boolean alterar(Object objeto) {
           Veiculo oVeiculo = (Veiculo) objeto;
           PreparedStatement stmt = null;
           String sql = "Update veiculo set marcaveiculo=?,modeloveiculo=? where idveiculo=?";
           try{
               stmt = conexao.prepareStatement (sql);
               stmt.setString(1, oVeiculo.getMarcaveiculo());
               stmt.setString(2, oVeiculo.getModeloveiculo());
               stmt.setInt(3, oVeiculo.getIdVeiculo());
               stmt.execute();
               conexao.commit();
               return true;
           }catch (Exception ex) {
               try{
                   System.out.println("Problemas ao alterar Veiculo! Erro:"+ex.getMessage());
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
        int idVeiculo = numero;
        PreparedStatement stmt = null;
        
        String sql = "delete from veiculo where idveiculo=?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idVeiculo);
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception ex){
            try{
                   System.out.println("Problema ao excluir veiculo! Erro: " + ex.getMessage());
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
     int idVeiculo = numero;
     PreparedStatement stmt = null;
     ResultSet rs= null;
     Veiculo oVeiculo = null;
     String sql="select * from veiculo where idVeiculo=?";
     
     try{
         stmt = conexao.prepareStatement (sql);
         stmt.setInt(1, idVeiculo);
         rs=stmt.executeQuery();
         while (rs.next()) {
             oVeiculo = new Veiculo();
             oVeiculo.setIdVeiculo(rs.getInt("idVeiculo"));
             MarcaDAO oMarcaDAO = new MarcaDAO();
                oVeiculo.setIdMarca((Marca) oMarcaDAO.carregar(rs.getInt("idMarca")));
                
                ModeloDAO oModeloDAO = new ModeloDAO();
                oVeiculo.setIdModelo((Modelo)oModeloDAO.carregar(rs.getInt("idModelo")));
         }
         return oVeiculo;
     }catch (Exception ex) {
         System.out.println("Problemas ao carregar Veiculo! Erro:"+ex.getMessage());
         return false;
     }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null; 
        String sql = "Select * from veiculo order by idVeiculo";
        try{
            stmt = conexao.prepareStatement(sql);
            rs=stmt.executeQuery();
            while (rs.next()){
                Veiculo oVeiculo = new Veiculo();
                oVeiculo.setIdVeiculo(rs.getInt("idVeiculo"));
                
 
                MarcaDAO oMarcaDAO = null;
                ModeloDAO oModeloDAO = null;
                
                try{
                    oMarcaDAO = new MarcaDAO();
                }catch (Exception ex){
                    System.out.println("Erro buscar marca"+ex.getMessage());
                    ex.printStackTrace();
                    
                }try {
                    oModeloDAO = new ModeloDAO();
                } catch (Exception e) {
                    System.out.println("Erro buscar modelo"+e.getMessage());
                    e.printStackTrace();
                    
                }
                
                oVeiculo.setIdMarca((Marca)oMarcaDAO.carregar(rs.getInt("idMarca"))); 
                oVeiculo.setIdModelo((Modelo)oModeloDAO.carregar(rs.getInt("idModelo")));
                
                resultado.add(oVeiculo);
            }
        }catch (SQLException ex){
            System.out.println("Problemas ao listar Cidade! Erro:"+ex.getMessage());
        }
        return resultado;
    }
    
}
