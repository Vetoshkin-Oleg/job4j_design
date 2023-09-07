package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String input = in.readLine();
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    if (input.contains("msg=Hello")) {
                        out.write("Hello\r\n\r\n".getBytes());
                    } else if ((input).startsWith("msg=What", 6)
                            && input.length() == 23) {
                        out.write("What\r\n\r\n".getBytes());
                    } else if (input.contains("msg=Exit")) {
                        server.close();
                    } else {
                        out.write(input.getBytes());
                        out.write("\r\n\r\n".getBytes());
                    }
                    out.flush();
                }
            }
        } catch (IOException e) {
            LOG.error("Error", e);
        }
    }
}