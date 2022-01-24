package socketStreamCliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ComunicacionCilente {
    String mensaje = "";

    public void socketCliente(String direccion, int port, int numeroMensajes) {
        try {
            InetSocketAddress address = new InetSocketAddress(direccion, port);
            System.out.println("Creando socket cliente");
            Socket socketCliente = new Socket();
            System.out.println("Estableciendo la conexión");
            socketCliente.connect(address);

            InputStream is = socketCliente.getInputStream();
            OutputStream os = socketCliente.getOutputStream();
            System.out.println("Enviando mensaje \n");
            mensaje = "Mensaje desde cliente";
            int contador = 0;
            do {
                os.write(mensaje.getBytes(StandardCharsets.UTF_8));
                System.out.println(mensaje + " " + contador);
                contador++;
            } while (contador < numeroMensajes);
            System.out.println("\nCerrando el socket cliente");

            socketCliente.close();

            System.out.println("Terminado");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void socketClienteTeclado(String direccion, int port) {
        try {
            Scanner in = new Scanner(System.in);
            InetSocketAddress address = new InetSocketAddress(direccion, port);
            System.out.println("Creando socket cliente");
            Socket socketCliente = new Socket();
            System.out.println("Estableciendo la conexión");
            socketCliente.connect(address);

            InputStream is = socketCliente.getInputStream();
            OutputStream os = socketCliente.getOutputStream();
            int contador = 0;
            do {
                System.out.println("Escriba mensaje, Mensaje para fin de comunicacion: fin \n");
                mensaje = in.next().trim();
                System.out.println("Enviando mensaje");
                os.write(mensaje.getBytes(StandardCharsets.UTF_8));
                System.out.println(mensaje);
            } while (!mensaje.equalsIgnoreCase("fin"));
            System.out.println("\nCerrando el socket cliente");

            socketCliente.close();

            System.out.println("Terminado");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enviarNumerosServidor(String direccion, int port, String[] numeros) {

        try {
            InetSocketAddress address = new InetSocketAddress(direccion, port);
            System.out.println("Creando socket cliente");
            Socket socketCliente = new Socket();
            System.out.println("Estableciendo la conexión");
            socketCliente.connect(address);

            OutputStream os = socketCliente.getOutputStream();
            System.out.println("Enviando mensaje \n");
            System.out.println("Enviado numeros");
            String numero;
            for (int i = 0; i < 5 ; i++) {
                    numero = numeros[i];
                    os.write(numero.getBytes(StandardCharsets.UTF_8));
                System.out.println("Número  " + numero + " enviado");
            }


            System.out.println("\nCerrando el socket cliente");

            socketCliente.close();

            System.out.println("Terminado");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

