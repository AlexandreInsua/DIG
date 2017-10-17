package t09_MVC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class BDManager {
	public Connection abrirBD() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/clientes";
		String user = "listador";
		String pass = "Ad1234";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver).newInstance();
			Connection con = DriverManager.getConnection(url, user, pass);
			return con; 
		} catch (InstantiationException | IllegalAccessException | 
				ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		} 
	}
	public void cerrarBD(Connection con) throws SQLException{
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}
	}
	
	public ArrayList<Cliente> listarBD(Connection con) throws SQLException {
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(" SELECT * FROM cliente ");
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				int edad = rs.getInt("edad");
				Cliente c = new Cliente(nombre,apellidos,edad);
				listaClientes.add(c);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}
		return listaClientes;
	}
}
