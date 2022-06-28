package calcserverapp;


public class CalcNetApp {

	public static void main(String[] args) throws Exception {
		if (args.length < 2) return;
		int portNumber = Integer.parseInt(args[1]);
		if (args[0].equalsIgnoreCase("server")) {
		CalcServer server = new CalcServer(portNumber);
		System.out.println("Server is running");
		
		server.run(); // instrukcja blokuj¹ca		
		//server.start();
		System.out.println("Thread name: " + Thread.currentThread().getName());
		server.close();
		}
}
}
