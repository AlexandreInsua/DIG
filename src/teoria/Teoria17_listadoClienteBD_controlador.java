package teoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public abstract class Teoria17_listadoClienteBD_controlador {
	public static Connection abrirBD() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/Teoria17_listadoClienteBD_Clientes?useSSL=false";
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
	
	public static ArrayList<Teoria17_listadoClienteBD_Cliente> listarBD(Connection con) throws SQLException {
		ArrayList<Teoria17_listadoClienteBD_Cliente> listaTeoria17_listadoClienteBD_Clientes = new ArrayList<Teoria17_listadoClienteBD_Cliente>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(" SELECT * FROM Teoria17_listadoClienteBD_Cliente ");
			while(rs.next()) {
				long id = rs.getLong("id");
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				int edad = rs.getInt("edad");
				Teoria17_listadoClienteBD_Cliente c = new Teoria17_listadoClienteBD_Cliente(id, nombre,apellidos,edad);
				listaTeoria17_listadoClienteBD_Clientes.add(c);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}
		return listaTeoria17_listadoClienteBD_Clientes;
	}
	
	public static void addCliente(Connection con, Teoria17_listadoClienteBD_Cliente cli) throws SQLException{
		if(con == null) {
			throw new SQLException("La conexión no está abierta");
		}
		if(cli == null) {
			throw new SQLException("El Teoria17_listadoClienteBD_Cliente no está definido");
		}
		try {
			String query = "INSERT INTO Teoria17_listadoClienteBD_Cliente(nombre,apellidos,edad) VALUES(?,?,?) ";
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
	public static void borrarCliente(Connection con, long idTeoria17_listadoClienteBD_Cliente) throws SQLException {
		try {
			String query = "DELETE FROM Teoria17_listadoClienteBD_Cliente WHERE id=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
			ps.setLong(1, idTeoria17_listadoClienteBD_Cliente);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e.getSQLState());
		}
		
	}
	
	
}
