package aula4.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import aula4.ctrl.exception.DbException;
import aula4.model.entities.Disciplina;

public class DB {
	
	public static List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	private static Connection conn = null;
	private static Connection conn1 = null;

	public static Connection getConnection() throws DbException {
		if(conn == null) {
			try {	
			    //conn1 = DriverManager.getConnection("jdbc:mysql://" + host + "/" + db + "?" + "user=" + user + "&password=" + passwd);
			    
			    conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/escola", "root", "S3n@c0r@");
			    			    
				//Properties props = loadProperties();
				//String url = props.getProperty("dburl");
				//conn = (Connection) DriverManager.getConnection(url, props);
			}catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		
		return conn1;
	}

	@SuppressWarnings("unused")
	private static Properties loadProperties() throws DbException {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeConnectoin() throws DbException {
		if(conn != null) {
			try {
				conn.close();
			}catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	
	public static void closeStatment(Statement st) throws DbException {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	
	public static void closeResultSet(ResultSet rs) throws DbException {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
