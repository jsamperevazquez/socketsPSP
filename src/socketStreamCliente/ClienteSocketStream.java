package socketStreamCliente;

public class ClienteSocketStream {
    public static void main(String[] args) {
        String[] numeros = {"50","40","30","20","10"};
        ComunicacionCilente comunicacionCilente = new ComunicacionCilente();
        //comunicacionCilente.socketCliente("localhost",6666,3);
        //comunicacionCilente.socketClienteTeclado("localhost",6666);
        comunicacionCilente.enviarNumerosServidor("localhost",6666,numeros);
    }
}
