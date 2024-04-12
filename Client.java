import java.io.*;
import java.net.*;

public class Client {
  public static void main(String[] args) throws IOException {
    if (args.length != 2) {
      System.err.println("Usage: java Client <host name> <port number>");
      System.exit(1);
    }

    String hostName = args[0];
    int portNumber = Integer.parseInt(args[1]);

    try (
        Socket echoSocket = new Socket(hostName, portNumber);
        PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
      Thread receiveThread = new Thread(() -> {
        try {
          String serverMsg;
          while ((serverMsg = in.readLine()) != null) {
        	  System.out.println(serverMsg);
              if (serverMsg.equals("Exiting game. Goodbye!")) {
                  System.exit(0);
              }
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
      receiveThread.start();

      String userInput;
      while ((userInput = stdIn.readLine()) != null) {
        out.println(userInput);
      }
    } catch (UnknownHostException e) {
      System.err.println("Don't know about host " + hostName);
      System.exit(1);
    } catch (IOException e) {
      System.err.println("Couldn't get I/O for the connection to " + hostName);
      System.exit(1);
    }
  }
}
