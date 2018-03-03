package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Email;
import persistence.dao.EmailDao;

public class EmailDaoJDBC implements EmailDao {

	private DataSource dataSource;
	
	public EmailDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Email email) {
		
		Connection connection = dataSource.getConnection();
		try {
			String insert = "insert INTO email(admin, messaggio, emittente, destinatario) values(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, email.getAdmin());
			statement.setString(2, email.getMessaggio());
			statement.setString(3, email.getEmittente());
			statement.setString(4, email.getDestinatario());
			statement.executeUpdate();
			
		} catch(SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			
			try {
				connection.close();
			} catch(SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public List<Email> findAll() {
		
		Connection connection = dataSource.getConnection();
		List<Email> emails = new ArrayList<>();
		Email email = null;
		try {
			String query = "select * FROM email";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				
				email = new Email();
				email.setAdmin(result.getString(1));
				email.setMessaggio(result.getString(2));
				email.setEmittente(result.getString(3));
				email.setDestinatario(result.getString(4));
				emails.add(email);
			}
		} catch(SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			
			try {
				connection.close();
			} catch(SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return emails;
	}
}
