
package client;

import java.io.IOException;


public class mainOfClient {
    
    
    public static void main(String[] args) throws IOException {
        client2 L = new client2();
        while(true)  // Meaning TCP
        {
            L.Send("i");
            L.repaint();
            L.recvMsg();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

    



