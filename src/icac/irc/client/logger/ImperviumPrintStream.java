package icac.irc.client.logger;

import icac.irc.client.Client;

import java.io.PrintStream;

public class ImperviumPrintStream extends PrintStream {

	public ImperviumPrintStream(PrintStream stream) {
		super(stream);
	}
	
	@Override
	public void println(String value) {
		String message = Client.logger.buildPrefix(LogType.INFO) + value;
		super.println(message);
		Client.logger.writeTofile(message);
	}
}