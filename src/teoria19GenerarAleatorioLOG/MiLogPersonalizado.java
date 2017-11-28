package teoria19GenerarAleatorioLOG;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public abstract class MiLogPersonalizado {
	public static void configurar() {
		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		
		//No queremos que los mensajes salgan por la pantalla(salida estandar)
		Logger rootLogger = Logger.getLogger("");
		for(Handler h: rootLogger.getHandlers()) {
			if(h instanceof ConsoleHandler) {
				rootLogger.removeHandler(h);
			}
		}

		// Añado 
		try {
			FileHandler fh1 = new FileHandler("log1.txt", true);
			fh1.setFormatter(new SimpleFormatter());
			logger.addHandler(fh1);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {  
			e.printStackTrace();
		}
		
		try {
			FileHandler fh1 = new FileHandler("log2.txt", true);
			fh1.setFormatter(new FormateadorPersonalizado());
			logger.addHandler(fh1);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
