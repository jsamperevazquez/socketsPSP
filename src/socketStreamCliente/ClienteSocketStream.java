package socketStreamCliente;

public class ClienteSocketStream {
    public static void main(String[] args) {
        ComunicacionCilente comunicacionCilente = new ComunicacionCilente();
        //comunicacionCilente.socketCliente("localhost",6666,3);
        comunicacionCilente.socketClienteTeclado("localhost",6666);
    }
}
