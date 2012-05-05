/**
 * thread.java
 * Aluno: Bruno Villas Boas da Costa
 * RA:317527
 */
package tcpclient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.*;

public class thread extends Thread {

    private ServerSocket welcomeSocket;
    private Socket connectionSocket;//socket para aceitar a conexão
    private String clientSentence;//sentença recebida do cliente
    private String capitalizedSentence;/*sentença transformada para enviar ao cliente*/

    /** Construtor de thread:  construtor de thread passando o nome da thread e o ServerSocket como parâmetro */
    public thread(String threadName, ServerSocket s) {

        super(threadName);
        welcomeSocket = s;
    }

    /** método sobrescrito run(): apresenta o comportamento da thread. 
     * Este método será chamado pelo método start() da classe Thread */
    @Override
    public void run() {
        while (true) {
            try {
                connectionSocket = welcomeSocket.accept();
                BufferedReader inFromClient =
new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient =
                      new DataOutputStream(connectionSocket.getOutputStream());
                /*recebe a linha que o cliente escreveu (no caso ele escreve 
                "teste: i", sendo i um inteiro)*/
                clientSentence = inFromClient.readLine();
                /*tranforma a linha recebida para maiúsculo e adiciona o nome 
                da thread q tratou a requisição*/
capitalizedSentence = clientSentence.toUpperCase() + "  ,pela thread " + getName() + '\n';
                /*passa para o cliente a sentença modificada*/
                outToClient.writeBytes(capitalizedSentence);
            } catch (IOException ex) {
/*excessões*/	           Logger.getLogger(thread.class.getName()).log(Level.SEVERE,       null, ex);
            }
        }
    }
}