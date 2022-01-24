package socketStreamServidor;


public class ServidorSOcketStream {

    public static void main(String[] args) {
        ComunicacionServidor servidor = new ComunicacionServidor();
        // servidor.socketServidor("localhost",6666,3);
        // servidor.socketServidorTeclado("localhost",6666);
        servidor.sumarNumerosCliente("localhost",6666);
    }
}	