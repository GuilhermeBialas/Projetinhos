/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ProdutoBean;
import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Guilherme Bialas
 */
public class ProdutoDAO {

    public int inserir(ProdutoBean produto) {
        Connection conexao = Conexao.obterConexao();
        if (conexao != null) {
            String sql = "INSERT INTO produtos"
                    + "\n(nome,quantidade,peso,categoria)"
                    + "\nVALUES(?,?,?,?)";

            try {
                PreparedStatement preparedStatement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

                preparedStatement.setString(1, produto.getNome());
                preparedStatement.setInt(2, produto.getQuantidade());
                preparedStatement.setDouble(3, produto.getPeso());
                preparedStatement.setString(4, produto.getCategoria());
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            } catch (Exception e) {
            e.printStackTrace();
            }finally{
                Conexao.fecharConexao();
            }
        }
    return 0;
    }
public int excluir(int id){
    String sql = "DELETE FROM produtos WHERE id=?";
    Connection conexao = Conexao.obterConexao();
    try {
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate();
    } catch (SQLException  e) {
        e.printStackTrace();
    }finally{
        Conexao.fecharConexao();
    }
return 0;
}
public boolean alterar(ProdutoBean produto, int codigo){
    Connection conexao = Conexao.obterConexao();
    String sql = "UPDATE produtos SET quantidade = ?"
                +"nome = ?, quantidade =?, peso=?, categoria=?";
    if (conexao!= null) {
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setInt(2,produto.getQuantidade());
            ps.setDouble(3, produto.getPeso());
            ps.setString(4, produto.getCategoria());
            ps.setInt(5, codigo);
            return ps.executeUpdate()==1;
        } catch (SQLException e) {
         e.printStackTrace();
        }finally{
            Conexao.fecharConexao();
        }
    }

return false;
}
}
