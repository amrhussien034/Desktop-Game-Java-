
package escape_game;

import java.io.IOException;

public class Escape_Game {

        
    public static void main(String[] args) throws IOException {
        Server L = new Server();
        while(true)  // meaning tcp 
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

    
    

