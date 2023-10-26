package org.example.dataAccessLayer;

import org.example.Model.Clients;
import org.example.Connection.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ClientDAO extends AbstractDAO<Clients> {
    /*
    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());

    private final static String findStatementString = "SELECT * FROM clients where clientsID = ?";
    private final static String findAllStatementString = "SELECT * from clients";

    @Override
    public Clients findById(int clientID) {
        Clients toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, clientID);
            rs = findStatement.executeQuery();
            rs.next();

            String name = rs.getString("clientName");
            String address = rs.getString("clientAddress");
            String email = rs.getString("clientEmail");
            toReturn = new Clients(clientID, name, address, email);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }


    public List<Clients> findAll() {
        List<Clients> list = new ArrayList<>();
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findAllStatement = null;
        ResultSet rs = null;

        try {
            findAllStatement = dbConnection.prepareStatement(findAllStatementString);
            rs = findAllStatement.executeQuery();
            while (rs.next()) {
                Clients c = new Clients(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
                list.add(c);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findAllStatement);
            ConnectionFactory.close(dbConnection);
        }
        return list;
    }

     */
}
