/**
 * TCPServer.java
 * Aluno: Bruno Villas Boas da Costa
 * RA:317527
 */
package tcpclient;

import java.net.*;

class TCPServer {

    public static void main(String argv[]) throws Exception {
        /*É criado um objeto ServerSocket com o número da porta que o servidor
        receberá as requisições dos clientes*/
        ServerSocket welcomeSocket = new ServerSocket(6789);
        System.out.println("Server: Aguardando na porta "
                + welcomeSocket.getLocalPort());
        /*Cria e inicia 10 objetos da classe thread, passando como parâmetro o nome
        do objeto e o ServerSocket criado*/
        for (int i = 1; i < 11; i++) {
            new thread("t" + Integer.toString(i), welcomeSocket).start();
        }
    }
}