package t13_BD_ListadoClientesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public abstract class BDManager {
	public static Connection abrirBD() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/clientes?useSSL=false";
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
	public static void cerrarBD(Connection con) throws SQLException{
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}
	}
	
	public static ArrayList<t13_BD_ListadoClientesBD.Cliente> listarBD(Connection con) throws SQLException {
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(" SELECT * FROM cliente ");
			while(rs.next()) {
				long id = rs.getLong("id");
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				int edad = rs.getInt("edad");
				Cliente c = new Cliente(id, nombre,apellidos,edad);
				listaClientes.add(c);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}
		return listaClientes;
	}
	
	public static void addCliente(Connection con, Cliente cli) throws SQLException{
		if(con == null) {
			throw new SQLException("La conexión no está abierta");
		}
		if(cli == null) {
			throw new SQLException("El cliente no está definido");
		}
		try {
			String query = "INSERT INTO cliente(nombre,apellidos,edad) VALUES(?,?,?) ";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
			 ps.setString(1, cli.getNombre());
			 ps.setString(2, cli.getApellidos());
			 ps.setInt(3, cli.getEdad());
			 ps.executeUpdate();
			 
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e.getSQLState());
		}
	}
	public static void borrarCliente(Connection con, long idCliente) throws SQLException {
		try {
			String query = "DELETE FROM cliente WHERE id=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
			ps.setLong(1, idCliente);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e.getSQLState());
		}
		
	}
	
	
}
