package socketStreamServidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ComunicacionServidor {
    private String mensaje;
    private static String mensajeStr;

    public void socketServidor(String direccion, int port, int numeroMensajes) {
        try {
            System.out.println("Creando socket servidor");

            ServerSocket socketServidor = new ServerSocket();

            System.out.println("Realizando el bind");

            InetSocketAddress addr = new InetSocketAddress(direccion, port);
            socketServidor.bind(addr);

            System.out.println("Aceptando conexiones");

            Socket newSocket = socketServidor.accept();

            System.out.println("Conexión recibida");

            InputStream is = newSocket.getInputStream();
            OutputStream os = newSocket.getOutputStream();

            byte[] mensaje = new byte[25];
            String mensajeStr;
            int contador = 0;
            do {
                is.read(mensaje);
                mensajeStr = new String(mensaje, StandardCharsets.UTF_8).trim();
                System.out.println("Mensaje recibido: " + contador + " " + mensajeStr);
                mensajeStr = "";
                contador++;

            } while (contador < numeroMensajes);

            System.out.println("Cerrando el nuevo socket");
            newSocket.close();

            System.out.println("Cerrando el socket servidor");
            socketServidor.close();

            System.out.println("Terminado");

        } catch (IOException e) {
        }
    }

    public void socketServidorTeclado(String direccion, int port) {
        try {
            System.out.println("Creando socket servidor");

            ServerSocket socketServidor = new ServerSocket();

            System.out.println("Realizando el bind");

            InetSocketAddress addr = new InetSocketAddress(direccion, port);
            socketServidor.bind(addr);

            System.out.println("Aceptando conexiones");

            Socket newSocket = socketServidor.accept();

            System.out.println("Conexión recibida");

            InputStream is = newSocket.getInputStream();
            OutputStream os = newSocket.getOutputStream();

            byte[] mensaje = new byte[25];
            do {
                is.read(mensaje);
                mensajeStr = new String(mensaje, StandardCharsets.UTF_8).trim();
                System.out.println("Mensaje recibido: " + mensajeStr);
                if (!mensajeStr.equalsIgnoreCase("fin")) {
                    mensajeStr = "";
                    for (int i = 0; i < mensaje.length; i++) {
                        mensaje[i] = 0;
                    }
                } else {
                    continue;
                }

            } while (!mensajeStr.equalsIgnoreCase("fin"));

            System.out.println("Cerrando el nuevo socket");
            newSocket.close();

            System.out.println("Cerrando el socket servidor");

            socketServidor.close();

            System.out.println("Terminado");

        } catch (IOException e) {
        }
    }

    public void sumarNumerosCliente(String direccion, int port) {
        try {
            System.out.println("Creando socket servidor");

            ServerSocket socketServidor = new ServerSocket();

            System.out.println("Realizando el bind");

            InetSocketAddress addr = new InetSocketAddress(direccion, port);
            socketServidor.bind(addr);

            System.out.println("Aceptando conexiones");

            Socket newSocket = socketServidor.accept();

            System.out.println("Conexión recibida");

            InputStream is = newSocket.getInputStream();

            byte[] mensaje = new byte[25];
            int acumulador = 0;
            String numero;
            for (int i = 0; i < 5 ; i++) {
                is.read(mensaje);
                numero = new String(mensaje,StandardCharsets.UTF_8).trim();
                acumulador += Integer.parseInt(numero);
                numero = "";
            }
            System.out.println("Mensaje recibido: la suma total de números es de  " + acumulador);

            System.out.println("Cerrando el nuevo socket");
            newSocket.close();

            System.out.println("Cerrando el socket servidor");
            socketServidor.close();

            System.out.println("Terminado");

        } catch (IOException e) {
        }
    }
}

