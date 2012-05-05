/**
 * TCPServer.java
 * Aluno: Bruno Villas Boas da Costa
 * RA:317527
 */
package tcpclient;

import java.net.*;

class TCPServer {

    public static void main(String argv[]) throws Exception {
        /*� criado um objeto ServerSocket com o n�mero da porta que o servidor
        receber� as requisi��es dos clientes*/
        ServerSocket welcomeSocket = new ServerSocket(6789);
        System.out.println("Server: Aguardando na porta "
                + welcomeSocket.getLocalPort());
        /*Cria e inicia 10 objetos da classe thread, passando como par�metro o nome
        do objeto e o ServerSocket criado*/
        for (int i = 1; i < 11; i++) {
            new thread("t" + Integer.toString(i), welcomeSocket).start();
        }
    }
}