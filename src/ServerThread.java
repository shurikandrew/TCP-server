import java.io.*;
import java.net.*;


public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        super();
        this.socket = socket;
    }

    public void run() {
        String thread_ID = Long.toString(currentThread().getId()); // DEBUG
        System.out.println("THREAD " + thread_ID + " starting"); // DEBUG

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String line = in.readLine();
            //while((line = in.readLine()) != null && !line.isEmpty())
            //{
                System.out.println("THREAD " + thread_ID + " received line: " + line);
            //}

            out.println(line.toUpperCase());
            //out.println();

        } catch (IOException e1) {
            // do nothing
        }

        try {
            socket.close();
        } catch (IOException e) {
            // do nothing
        }

        System.out.println("THREAD " + thread_ID + " exiting"); // DEBUG
    }
}