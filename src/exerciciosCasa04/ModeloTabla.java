package exerciciosCasa04;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	private final ArrayList<String> columnasNombres;
	private ArrayList<Participante> datos;

	public ModeloTabla() {
		super();
		columnasNombres = new ArrayList<String>();
		columnasNombres.add("Amigo Invisible");
		columnasNombres.add("Regala");
		
		datos= new ArrayList<Participante>();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnasNombres.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datos.size();
	}
	
	@Override
	public String getColumnName(final int columna){
		return columnasNombres.get(columna);
	}

	@Override
	public Object getValueAt(final int fila, final int columna) {
	final Participante participante = datos.get(fila);

	switch (columna) {
	case 0:
		return participante.getNombre();
	case 1:
		return participante.getRegalarA();
	
	}
	return participante;
	}

	public void cargarDatos(final ArrayList<Participante> listado) {
		datos=listado;
	}

}
