package t15_GenerarAleatorioLOG;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class FormateadorPersonalizado extends Formatter{

	@Override
	public String format(LogRecord registro) {
		StringBuffer salida = new StringBuffer();
		salida.append("LOG: ");
		salida.append(registro.getLevel());
		salida.append(" ");
		salida.append( pasarMilisendosAFecha( registro.getMillis() ) );
		salida.append(" ");
		salida.append(registro.getMessage());
		salida.append("\n");
		
		return salida.toString();
	}
	
	private String pasarMilisendosAFecha(long milisegundos) {
		// mm minutos
		// HH horas
		// dd dias
		// MM meses
		// MMM abreviatura del mes (ENE, FEB, ...=
		// yy años  (17)
		// yyyy años (2017)
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd/MM/yyyy HH:mm");
		Date fecha = new Date(milisegundos);
		return sdf.format(fecha);		
	}

	

	
	

}
