/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Omar
 */
public class DatabaseOperations {
    
    static Connection conn = DatabaseConnection.getConnection();
    
    public DatabaseOperations(){
        
    }
    
    public static void setDocument(String title, String author, String location)throws SQLException{
        String sql = "INSERT INTO document ( title, author, location) VALUES (?, ?, ?)";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, title);
        statement.setString(2, author);
        statement.setString(3, location);
        
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("\nA new document was added successfully to the db!");
        }
        statement.close();
    }
    public static void setTerm(String term) throws SQLException {
        String sql = "INSERT  INTO term (text) VALUES (?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, term);
        statement.executeUpdate();
        statement.close();
    }
    public static void serAppearance(int term_id, int doc_id, int num) throws SQLException {
        String sql = "INSERT INTO appearances (term_id, doc_id, num) VALUES (?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1,term_id);
        statement.setInt(2, doc_id);
        statement.setInt(3, num);
        statement.executeUpdate();
        statement.close();
    }
    public List<String> getTerms() throws SQLException {
        List<String> termsList = new ArrayList<>();
        String sql = "SELECT text FROM term";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String term = resultSet.getString("text");
            termsList.add(term);
        }
        resultSet.close();
        statement.close();
        return termsList;
    }
    public int getNextId() throws SQLException{
        String sql = "SELECT MAX(document_id) FROM document";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        int count =0;
        if (resultSet.next()) {
            count = resultSet.getInt(1);
        }
        return count;
    }
    

    public int getTermId(String text)throws SQLException{
        String sql = "SELECT term_id FROM term WHERE text = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, text);
        ResultSet resultSet = statement.executeQuery();
        int id =0;
        if (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        resultSet.close();
        statement.close();
        return id;
    }
    
    
}
