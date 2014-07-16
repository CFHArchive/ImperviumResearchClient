package icac.irc.client.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	private SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd-MM-yyyy");
	private SimpleDateFormat enhancedFormatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.S");
	
	File logDirectory = new File("Logs");
	File logFile = new File("Logs/" + getSimpleLogDate(new Date()) + ".txt");
	
	public Logger() {
		System.setOut(new ImperviumPrintStream(System.out));
		if(!logDirectory.exists()) {
			logDirectory.mkdir();
		}
		if(!logFile.exists()) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void Log(String message) {
		Log(message, LogType.INFO);
	}
	
	public void Log(Throwable t) {
		StringBuilder builder = new StringBuilder();
		for(StackTraceElement element : t.getStackTrace()) {
			builder.append(element);
			builder.append("\n");
		}
		Log(builder.toString(), LogType.ERROR);
	}
	
	public void Log(String message, LogType type) {
		String prefix = buildPrefix(type);
		System.out.print(prefix + message + System.getProperty("line.separator"));
		writeTofile(prefix + message);
	}
	
	public void writeTofile(String message) {
		try {
			FileWriter logWriter = new FileWriter(this.logFile, true);
			logWriter.write(message + System.getProperty("line.separator"));
			logWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String getSimpleLogDate(Date date) {
		return new String(simpleFormatter.format(new Date()));
	}
	
	private String getEnhancedLogDate(Date date) {
		return new String(enhancedFormatter.format(new Date()));
	}
	
	public String buildPrefix(LogType type) {
		return "[" + type.getPrefix() + "][" + getEnhancedLogDate(new Date()) + "]";
	}
}
