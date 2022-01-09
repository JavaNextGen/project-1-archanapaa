package com.revature.repositories;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementRequest;
import com.revature.models.Status;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ReimbursementDAO {

    /**
     * Should retrieve a Reimbursement from the DB with the corresponding id or an empty optional if there is no match.
     */
    public Optional<Reimbursement> getById(int id) {
        return Optional.empty();
    }

    /**
     * Should retrieve a List of Reimbursements from the DB with the corresponding Status or an empty List if there are no matches.
     */
    public List<Reimbursement> getByStatus(Status status) {
        return Collections.emptyList();
    }

    /**
     * <ul>
     *     <li>Should Update an existing Reimbursement record in the DB with the provided information.</li>
     *     <li>Should throw an exception if the update is unsuccessful.</li>
     *     <li>Should return a Reimbursement object with updated information.</li>
     * </ul>
     */
    public Reimbursement update(Reimbursement unprocessedReimbursement) {
    	return null;
    }
    
    
    public int submit(ReimbursementRequest reimbursementRequest) {
    	int reimbursementId = 0;
    	
    	
    	try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			
			String sql = "INSERT INTO ers.ers_reimbursement\r\n"
					+ "(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id)\r\n"
					+ "VALUES(?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS); //we use PreparedStatements for SQL commands with variables
			
			//use the PreparedStatement objects' methods to insert values into the query's ?s
			//the values will come from the Employee object we send in.
			ps.setFloat(1, reimbursementRequest.getAmount());
			ps.setTimestamp(2, getCurrentTimeStamp());
			ps.setString(3, reimbursementRequest.getDescription());
			ps.setInt(4, reimbursementRequest.getAuthor_id());
			ps.setInt(5,reimbursementRequest.getStatus_id());
			ps.setInt(6,reimbursementRequest.getType_id());
			
			
			int insertedRows = ps.executeUpdate(); //we use executeUpdate() for inserts, updates, and deletes. 
			System.out.println("number of inserted rows = " + insertedRows);
			
			ResultSet  generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
				
				reimbursementId = generatedKeys.getInt(1);
				System.out.println(reimbursementId);
			}
			
		} catch(SQLException e) {
			System.out.println("Submit reimbursement failed! ");
			e.printStackTrace();
		}
    	
    	return reimbursementId;
    }
    
    private static java.sql.Timestamp getCurrentTimeStamp() {
    	java.util.Date today = new java.util.Date();
    	return new java.sql.Timestamp(today.getTime());
    }
}
