package br.com.alura.jpa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.jpa.model.Account;

public class AccountDao {
    private Connection cnn;

    public AccountDao() {
        try {
            this.cnn = DriverManager.getConnection("mysql://localhost/alura_jdbc", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void adiciona(Account account) {
        try {
            String sql = "insert into account(agency, number, holder) values (?,?,?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setLong(1, account.getAgency());
            ps.setLong(2, account.getNumber());
            ps.setString(3, account.getHolder());

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
