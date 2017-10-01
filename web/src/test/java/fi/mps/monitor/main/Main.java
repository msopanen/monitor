package fi.mps.monitor.main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {

	public static void main(String[] args) throws Exception {
		WebAppContext cntx = new WebAppContext();
		cntx.setContextPath("/");
		cntx.setResourceBase("src/main/webapp");

		Server server = new Server(8080);
		server.setHandler(cntx);

		server.start();
		server.join();
	}

}
