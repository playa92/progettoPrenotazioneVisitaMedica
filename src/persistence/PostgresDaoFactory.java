package persistence;

import persistence.dao.AmministratoreDao;
import persistence.dao.CodiceQRDao;
import persistence.dao.PazienteDao;
import persistence.dao.UniversitaDao;
import persistence.dao.PrenotazioneDao;

public class PostgresDaoFactory extends DaoFactory {

	private static DataSource dataSource = null;
	
	static {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			dataSource = new DataSource("jdbc:postgresql://localhost:5432/Prenotazione","postgres","postgres");
		
		} catch(Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n" + e);
		}
	}

	@Override
	public PazienteDao getPazienteDao() {
		return new PazienteDaoJDBC(dataSource);
	}
	
	@Override
	public AmministratoreDao getAmministratoreDao() {
		return new AmministratoreDaoJDBC(dataSource);
	}

	@Override
	public UniversitaDao getUniversitaDao() {
		return new UniversitaDaoJDBC(dataSource);
	}

	@Override
	public CodiceQRDao getCodiceQRDao() {
		return new CodiceQRDaoJDBC(dataSource);
	}

	@Override
	public PrenotazioneDao getPrenotazioneDao() {
		return new PrenotazioneDaoJDBC(dataSource);
	}
	
	@Override
	public ImpiegatoDaoJDBC getImpiegatoDao() {
		return new ImpiegatoDaoJDBC(dataSource);
	}
	
	@Override
	public SegnalazioneDaoJDBC getSegnalazioneDao() {
		return new SegnalazioneDaoJDBC(dataSource);
	}
	
	@Override
	public UtilDao getUtilDao() {
		return new UtilDao(dataSource);
	}
}
