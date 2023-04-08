package client ;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

    
public class client2 extends JFrame implements KeyListener, ActionListener {
    Timer clock = new Timer(500,this);
    ObjectInputStream input;
    ObjectOutputStream output;
    Socket S;
    java.awt.Image imgR1, imgR2, imgR3, imgR4, imgR5, imgR6, imgR7, imgR8;
    java.awt.Image imgL1, imgL2, imgL3, imgL4, imgL5, imgL6, imgL7, imgL8;
    java.awt.Image BK, HImage;
    private JFrame Lose, Win;
    public JPanel LoseP, WinP;
    private JLabel LoseL, WinL;
    private JButton LoseB, WinB;
    private int countR = 1, countL = 1,X = 50, Y = 60, XV = 5, YV = 5, XE1 = 200, XE2 = 350, YE1 = 60, YE2 = 310;
    private boolean dirR = false, dirL = false, dirU = false, dirD = false, countE1 = false, countE2 = false, Worning = false, Hide = false;


    public client2() throws IOException
    {

        try{
            S = new Socket("localhost", 9999);
            output = new ObjectOutputStream(S.getOutputStream());
            input = new ObjectInputStream(S.getInputStream());
            System.out.println("Connected");
           
        }catch(Exception e)
        {
            System.err.println("Error With Client");
        }
        
//            finally{
//                 S.close();
//            }

        setVisible(true);
        setSize(1350,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Client Level 2");
        BK = Toolkit.getDefaultToolkit().createImage("EscapeBK.jpg");

        Lose = new JFrame("Lose");
        Win = new JFrame("Win");
        //Lose.setLayout(new GridLayout(2,1));
        //Win.setLayout(new GridLayout(2,1));
        LoseP = new JPanel(new GridLayout(2,1));
        WinP = new JPanel(new GridLayout(2,1));
        LoseL = new JLabel("Loser Ya Loser ... Ya Loser");
        WinL = new JLabel("WInner WInner Chicken Dinner");
        LoseB = new JButton("Loser Ok");
        WinB = new JButton("Winner Winner");

        Lose.setSize(250,90);
        Win.setSize(250,90);

        Lose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        forming();

        imgR1 = Toolkit.getDefaultToolkit().createImage("right\\1.png");
        imgR2 = Toolkit.getDefaultToolkit().createImage("right\\2.png");
        imgR3 = Toolkit.getDefaultToolkit().createImage("right\\3.png");
        imgR4 = Toolkit.getDefaultToolkit().createImage("right\\4.png");
        imgR5 = Toolkit.getDefaultToolkit().createImage("right\\5.png");
        imgR6 = Toolkit.getDefaultToolkit().createImage("right\\6.png");
        imgR7 = Toolkit.getDefaultToolkit().createImage("right\\7.png");
        imgR8 = Toolkit.getDefaultToolkit().createImage("right\\8.png");

        imgL1 = Toolkit.getDefaultToolkit().createImage("left\\1.png");
        imgL2 = Toolkit.getDefaultToolkit().createImage("left\\2.png");
        imgL3 = Toolkit.getDefaultToolkit().createImage("left\\3.png");
        imgL4 = Toolkit.getDefaultToolkit().createImage("left\\4.png");
        imgL5 = Toolkit.getDefaultToolkit().createImage("left\\5.png");
        imgL6 = Toolkit.getDefaultToolkit().createImage("left\\6.png");
        imgL7 = Toolkit.getDefaultToolkit().createImage("left\\7.png");
        imgL8 = Toolkit.getDefaultToolkit().createImage("left\\8.png");

        HImage = Toolkit.getDefaultToolkit().createImage("Hidden.png");

        addKeyListener(this);
        clock.start();
    }
    public void paint(Graphics G)
    {
        super.paint(G);
        G.drawImage(BK,-290,0,1900,700,this);
        G.fillRect(0,0,40,700);
        G.fillRect(1310,0,40,700);
        G.fillRect(0,660,1350,40);
        G.fillRect(0,150,1100,40);
        G.fillRect(250,400,1100,40);
        G.setColor(Color.GRAY);
        G.fillRect(1240,570,50,70);
        G.setColor(Color.decode("#8080ff"));
        G.drawRect(1235,565,60,80); // Blue Border
        G.setColor(Color.DARK_GRAY);
        G.fillRect(450,60,100,90); // Green Area
        G.fillRect(750, 310,100,90); // Green Area
        G.fillRect(350, 310,100,90); // Green Area

        G.setColor(Color.decode("#000000"));
        G.fillRect(XE1,60,40,90); // Black Person
        G.fillRect(XE2,310,40,90); // Black Person


        // First Enemy Moves
        if(XE1 == 200)
            countE1 = true;
        else if(XE1 == 1000)
            countE1 = false;
        if(countE1 == true)
            XE1 += 5;
        else if(countE1 == false)
            XE1 -= 5;
        // End Enemy Moves

        // Second Enemy Moves
        if(XE2 == 300)
            countE2 = true;
        else if(XE2 == 1250)
            countE2 = false;
        if(countE2 == true)
            XE2 += 5;
        else if(countE2 == false)
            XE2 -= 5;
        // End Enemy Moves



        // First of Game Over
        if((XE2 == X && Y == YE2 && Hide == false) || (XE1 == X && Y == YE1 && Hide == false))
            Worning = true;

        if(Worning == true)
        {
            Lose.setVisible(true);
        }
        // End of Game Over

        LoseB.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                countR = 1;
                countL = 1;
                X = 50;
                Y = 60;
                XV = 5;
                YV = 5;
                XE1 = 200;
                XE2 = 350;
                YE1 = 60;
                YE2 = 310;
                dirR = false;
                dirL = false;
                dirU = false;
                dirD = false;
                countE1 = false;
                countE2 = false;
                Worning = false;
                Hide = false;
                Lose.setVisible(false);
            }
        });

        WinB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        if(X == 1240 && Y == 570)
            Win.setVisible(true);

        if(Hide == true)
            G.drawImage(HImage,X,Y,50,90,this);

        if(dirR == true && Hide == false)
        {
            if(countR == 1 && Hide == false)
                G.drawImage(imgR1,X,Y,50,90,this);
            else if(countR == 2)
                G.drawImage(imgR2,X,Y,50,90,this);
            else if(countR == 3)
                G.drawImage(imgR3,X,Y,50,90,this);
            else if(countR == 4)
                G.drawImage(imgR4,X,Y,50,90,this);
            else if(countR == 5)
                G.drawImage(imgR5,X,Y,50,90,this);
            else if(countR == 6)
                G.drawImage(imgR6,X,Y,50,90,this);
            else if(countR == 7)
                G.drawImage(imgR7,X,Y,50,90,this);
            else if(countR == 8)
                G.drawImage(imgR8,X,Y,50,90,this);
            else if(countR == 9)
            {
                countR = 1;
                G.drawImage(imgR1,X,Y,50,90,this);
            }
        }
        else if(dirL == true && Hide == false)
        {
            if(countL == 1)
                G.drawImage(imgL1,X,Y,50,90,this);
            else if(countL == 2)
                G.drawImage(imgL2,X,Y,50,90,this);
            else if(countL == 3)
                G.drawImage(imgL3,X,Y,50,90,this);
            else if(countL == 4)
                G.drawImage(imgL4,X,Y,50,90,this);
            else if(countL == 5)
                G.drawImage(imgL5,X,Y,50,90,this);
            else if(countL == 6)
                G.drawImage(imgL6,X,Y,50,90,this);
            else if(countL == 7)
                G.drawImage(imgL7,X,Y,50,90,this);
            else if(countL == 8)
                G.drawImage(imgL8,X,Y,50,90,this);
            else if(countL == 9)
            {
                countL = 1;
                G.drawImage(imgL1,X,Y,50,90,this);
            }
        }

    }

    public void forming()
    {
        LoseP.add(LoseL);
        LoseP.add(LoseB);
        Lose.add(LoseP);

        WinP.add(WinL);
        WinP.add(WinB);
        Win.add(WinP);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_D)
        {
            if(!(X >= 1260))
            {
                X += XV;
                countR++;
                countL = 1;
                dirL = false;
                dirR = true;
                Send("D");
            }
        }
        else if(key == KeyEvent.VK_A)
        {
            if(!(X <= 45))
            {
                X -= XV;
                countL++;
                countR = 1;
                dirR = false;
                dirL = true;
                Send("A");

            }
        }
        else if(key == KeyEvent.VK_S)
        {
            if(!((Y == 60 && X <= 1095) || Y == 570 || (Y == 310 && X >= 220)))
            {
                Y += YV;
                dirD = true;
                Send("S");
            }
        }
        else if(key == KeyEvent.VK_W)
        {
            Y -= YV;
            dirU = true;
        }
        else if(key == KeyEvent.VK_H)
        {
            if(Y == 60 && (X >= 450 && X <= 550) || (Y == 310 && (X >= 750 && X <= 850)) || (Y == 310 && (X >= 350 && X <= 450)))
            {
                Hide = true;
                Send("H");
            }
        }
        repaint();
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if((Y == 60 && (X >= 450 && X <= 550)) || (Y == 310 && (X >= 750 && X <= 850)) || (Y == 310 && (X >= 350 && X <= 450)) )
        {
            Hide = false;
            Send("Q");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void Send(String Msg)
    {
        try {
            output.writeObject(Msg);
        } catch (IOException e) {

        }
    }

    public void recvMsg() {
        String Msg = null;
        try {
            Msg = (String) input.readObject();
            if (Msg.equals("D")) {
                if (!(X >= 1260)) {
                    X += XV;
                    countR++;
                    countL = 1;
                    dirL = false;
                    dirR = true;
                    repaint();
                }
            }
            else if(Msg.equals("A"))
            {
                if(!(X <= 45))
                {
                    X -= XV;
                    countL++;
                    countR = 1;
                    dirR = false;
                    dirL = true;
                    repaint();
                }
            }
            else if(Msg.equals("H"))
            {
                if(Y == 60 && (X >= 450 && X <= 550) || (Y == 310 && (X >= 750 && X <= 850)) || (Y == 310 && (X >= 350 && X <= 450)))
                {
                    Hide = true;
                    repaint();
                }
            }
            else if(Msg.equals("S"))
            {
                if(!((Y == 60 && X <= 1095) || Y == 570 || (Y == 310 && X >= 220)))
                {
                    Y += YV;
                    dirD = true;
                }
            }
            else if(Msg.equals("Q"))
            {
                if((Y == 60 && (X >= 450 && X <= 550)) || (Y == 310 && (X >= 750 && X <= 850)) || (Y == 310 && (X >= 350 && X <= 450)) )
                {
                    Hide = false;
                }
            }

            } catch (Exception e) {
                System.out.println("Error With Recv in Server");
            }
    }


}

    


