package pkgfinal.project;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;

/**
 *
 * @author millc9988
 */
public class GameExperimentation extends JComponent {

    public static void Controls() {
    }

    public static Color RandomCol() {
        double rand1 = (Math.random() * (255 - 0) + 0);
        double rand2 = (Math.random() * (255 - 0) + 0);
        double rand3 = (Math.random() * (255 - 0) + 0);
        int randA = (int) rand1;
        int randB = (int) rand2;
        int randC = (int) rand3;
        Color randCol = new Color(randA, randB, randC);
        return randCol;

    }
    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    //Title of the window
    String title = "Seizure Tag";
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    // YOUR GAME VARIABLES WOULD GO HERE
    int cubeX = 400;
    int cubeY = 300;
    int cube2X = 300;
    int cube2Y = 200;
    boolean up = false;
    boolean down = false;
    boolean left = false;
    boolean right = false;
    boolean up2 = false;
    boolean down2 = false;
    boolean left2 = false;
    boolean right2 = false;
    String one = "1";
    String two = "2";
    int frameCounter = 0;
    int frameToSecond = frameCounter / 60;
    String timeLeft = "60";
    boolean it = true;
    int red1Var = 255;
    int red2Var = 255;
    int green1Var = 255;
    int green2Var = 255;
    Color itCol1 = new Color(red1Var, green1Var, 0);
    Color itCol2 = new Color(red2Var, green2Var, 0);
    int itDelay = 60;
    int it1 = 0;
    int it2 = 0;
    int speed1 = 0;
    int speed2 = 0;
    boolean boost1 = false;
    boolean boost2 = false;
    int boost1Timer = 0;
    int boost2Timer = 0;
    boolean pause = true;
    BufferedImage bob = imageHelper.LoadImage("TitleScreen.jpg");
    BufferedImage winI1 = imageHelper.LoadImage("VictoryOne.png");
    BufferedImage winI2 = imageHelper.LoadImage("VictoryTwo.png");
    String player1It = "Player one has been it for " + it1 / 60 + " seconds";
    String player2It = "Player two has been it for" + it2 / 60 + " seconds";
    boolean charA1 = false;
    boolean charB1 = false;
    boolean charC1 = false;
    boolean charD1 = false;
    boolean charA2 = false;
    boolean charB2 = false;
    boolean charC2 = false;
    boolean charD2 = false;
    int boost1Length = 0;
    int boost2Length = 0;
    int boostMulti1 = 0;
    int boostMulti2 = 0;
    int c1 = 0;
    int c2 = 0;
    boolean win1 = false;
    boolean win2 = false;
    boolean restart = false;

    // GAME VARIABLES END HERE   
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public GameExperimentation() {
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        Mouse m = new Mouse();

        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE

        if (pause) {

            g.drawImage(bob, 0, 0, this);
            g.drawString(timeLeft, 750, 25);
        }
        if (!pause) {
            g.setColor(RandomCol());
            g.fillRect(0, 0, 200, 200);
            g.setColor(RandomCol());
            g.fillRect(0, 200, 200, 200);
            g.setColor(RandomCol());
            g.fillRect(0, 400, 200, 200);

            g.setColor(RandomCol());
            g.fillRect(200, 0, 200, 200);
            g.setColor(RandomCol());
            g.fillRect(200, 200, 200, 200);
            g.setColor(RandomCol());
            g.fillRect(200, 400, 200, 200);

            g.setColor(RandomCol());
            g.fillRect(400, 0, 200, 200);
            g.setColor(RandomCol());
            g.fillRect(400, 200, 200, 200);
            g.setColor(RandomCol());
            g.fillRect(400, 400, 200, 200);

            g.setColor(RandomCol());
            g.fillRect(600, 0, 200, 200);
            g.setColor(RandomCol());
            g.fillRect(600, 200, 200, 200);
            g.setColor(RandomCol());
            g.fillRect(600, 400, 200, 200);
            g.setColor(itCol1);
            g.fillRect(cubeX, cubeY, 20, 20);
            g.setColor(itCol2);
            g.fillRect(cube2X, cube2Y, 20, 20);
            g.setColor(Color.BLACK);
            g.drawString(one, cubeX + 10, cubeY + 15);
            g.drawString(two, cube2X + 10, cube2Y + 15);
            g.drawString(timeLeft, 750, 25);
            g.drawString(player1It, 10, 25);
            g.drawString(player2It, 10, 50);
        }
        if (win1) {
            g.drawImage(winI1, 0, 0, this);
        }
        if (win2) {
            g.drawImage(winI2, 0, 0, this);
        }
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;

        preSetup();

        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {

            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            //restarting the game
            if (restart&&(win1||win2)) {
                 cubeX = 400;
                 cubeY = 300;
                 cube2X = 300;
                 cube2Y = 200;
                 up = false;
                 down = false;
                 left = false;
                 right = false;
                 up2 = false;
                 down2 = false;
                 left2 = false;
                 right2 = false;
                 one = "1";
                 two = "2";
                 frameCounter = 0;
                 frameToSecond = frameCounter / 60;
                 timeLeft = "60";
                 it = true;
                 red1Var = 255;
                 red2Var = 255;
                 green1Var = 255;
                 green2Var = 255;
                 itCol1 = new Color(red1Var, green1Var, 0);
                 itCol2 = new Color(red2Var, green2Var, 0);
                 itDelay = 60;
                 it1 = 0;
                 it2 = 0;
                 speed1 = 0;
                 speed2 = 0;
                 boost1 = false;
                 boost2 = false;
                 boost1Timer = 0;
                 boost2Timer = 0;
                 pause = true;
                 bob = imageHelper.LoadImage("TitleScreen.jpg");
                 winI1 = imageHelper.LoadImage("VictoryOne.png");
                 winI2 = imageHelper.LoadImage("VictoryTwo.png");
                 player1It = "Player one has been it for " + it1 / 60 + " seconds";
                 player2It = "Player two has been it for" + it2 / 60 + " seconds";
                 charA1 = false;
                 charB1 = false;
                 charC1 = false;
                 charD1 = false;
                 charA2 = false;
                 charB2 = false;
                 charC2 = false;
                 charD2 = false;
                 boost1Length = 0;
                 boost2Length = 0;
                 boostMulti1 = 0;
                 boostMulti2 = 0;
                 c1 = 0;
                 c2 = 0;
                 win1 = false;
                 win2 = false;
                System.out.println("game should restart here");
            }
            //character stats



            if (charA1) {
                charB1 = false;
                charC1 = false;
                charD1 = false;
                speed1 = 5;
                boostMulti1 = 2;
                boost1Length = 60;
                c1++;
            }
            if (charB1) {
                charC1 = false;
                charA1 = false;
                charD1 = false;
                speed1 = 5;
                boostMulti1 = 5;
                boost1Length = 30;
                c1++;
            }
            if (charC1) {
                charB1 = false;
                charA1 = false;
                charD1 = false;
                speed1 = 7;
                boostMulti1 = 0;
                boost1Length = 0;
                c1++;
            }
            if (charD1) {
                charB1 = false;
                charC1 = false;
                charA1 = false;
                speed1 = 4;
                boostMulti1 = 3;
                boost1Length = 240;
                c1++;
            }

            if (charA2) {
                charB2 = false;
                charC2 = false;
                charD2 = false;
                speed2 = 5;
                boostMulti2 = 2;
                boost2Length = 120;
                c2++;
            }
            if (charB2) {
                charA2 = false;
                charC2 = false;
                charD2 = false;
                speed2 = 5;
                boostMulti2 = 5;
                boost2Length = 30;
                c2++;
            }
            if (charC2) {
                charB2 = false;
                charA2 = false;
                charD2 = false;
                speed2 = 7;
                boostMulti2 = 0;
                boost2Length = 0;
                c2++;
            }
            if (charD2) {
                charB2 = false;
                charC2 = false;
                charA2 = false;
                c2++;
                speed2 = 4;
                boostMulti2 = 3;
                boost2Length = 240;
            }
            //character stats done

            if (!pause && c1 > 0 && c2 > 0) {

                player1It = "Player one has been it for " + it1 / 60 + " seconds";
                player2It = "Player two has been it for " + it2 / 60 + " seconds";

                if (it2 / 60 >= 31) {
                    pause = true;
                    win1 = true;
                }
                if (it1 / 60 >= 31) {
                    pause = true;
                    win2 = true;
                }

                itCol1 = new Color(red1Var, green1Var, 0);
                itCol2 = new Color(red2Var, green2Var, 0);
                if (it) {
                    green1Var = 0;
                    red1Var = 255;
                    green2Var = 255;
                    red2Var = 0;
                    it1++;
                }
                if (!it) {
                    green1Var = 255;
                    red1Var = 0;
                    green2Var = 0;
                    red2Var = 255;
                    it2++;
                }
                frameToSecond = frameCounter / 60;
                int timeRemaining = 60 - frameToSecond;
                timeLeft = Integer.toString(timeRemaining);
                if (frameCounter >= 3600) {
                    done = true;
                    if (it2 > it1) {
                        System.out.println("Player 1 wins!");
                    } else {
                        System.out.println("Player 2 wins!");
                    }
                }

                //boost controls
                if (boost1 && boost1Timer < boost1Length) {

                    speed1 = speed1 * boostMulti1;
                    boost1Timer++;
                }
                if (boost2 && boost2Timer < boost2Length) {
                    speed2 = speed2 * boostMulti2;
                    boost2Timer++;
                }
                if (boost1Timer > 0) {
                    boost1Timer++;
                    if (boost1Timer > boost1Length) {
                        boost1 = false;
                    }

                    if (boost1Timer > 300) {
                        boost1Timer = 0;
                    }
                }
                if (boost2Timer > 0) {
                    boost2Timer++;
                    if (boost2Timer > boost2Length) {
                        boost2 = false;
                    }

                    if (boost2Timer > 300) {
                        boost2Timer = 0;
                    }
                }
                //moving the first cube
                if (up) {
                    cubeY = cubeY - speed1;
                }
                if (down) {
                    cubeY = cubeY + speed1;
                }
                if (left) {
                    cubeX = cubeX - speed1;
                }
                if (right) {
                    cubeX = cubeX + speed1;

                }
                if (cubeX > WIDTH) {
                    cubeX = WIDTH - 25;
                }
                if (cubeX < 0) {
                    cubeX = 5;
                }
                if (cubeY > HEIGHT) {
                    cubeY = HEIGHT - 25;
                }
                if (cubeY < 0) {
                    cubeY = 5;
                }

                //moving the second cube
                if (up2) {
                    cube2Y = cube2Y - speed2;
                }
                if (down2) {
                    cube2Y = cube2Y + speed2;
                }
                if (left2) {
                    cube2X = cube2X - speed2;
                }
                if (right2) {
                    cube2X = cube2X + speed2;
                }
                if (cube2X > WIDTH) {
                    cube2X = WIDTH - 25;
                }
                if (cube2X < 0) {
                    cube2X = 5;
                }
                if (cube2Y > HEIGHT) {
                    cube2Y = HEIGHT - 25;
                }
                if (cube2Y < 0) {
                    cube2Y = 5;
                }

                //hit detection
                if (cubeX <= cube2X && cubeX + 20 >= cube2X && cubeY <= cube2Y && cubeY + 20 >= cube2Y) {

                    if (itDelay >= 60) {
                        itDelay = 1;

                        if (it) {
                            it = false;
                        } else {
                            it = true;
                        }
                    }
                }
                if (cubeX <= cube2X + 20 && cubeX + 20 >= cube2X + 20 && cubeY <= cube2Y + 20 && cubeY + 20 >= cube2Y + 20) {
                    if (itDelay >= 60) {
                        itDelay = 1;

                        if (it) {
                            it = false;
                        } else {
                            it = true;
                        }
                    }

                }
                if (cubeX <= cube2X && cubeX + 20 >= cube2X && cubeY <= cube2Y + 20 && cubeY + 20 >= cube2Y + 20) {
                    if (itDelay >= 60) {
                        itDelay = 1;

                        if (it) {
                            it = false;
                        } else {
                            it = true;
                        }
                    }
                }
                if (cubeX <= cube2X + 20 && cubeX + 20 >= cube2X + 20 && cubeY <= cube2Y && cubeY + 20 >= cube2Y) {
                    if (itDelay >= 60) {
                        itDelay = 1;

                        if (it) {
                            it = false;
                        } else {
                            it = true;
                        }
                    }

                }
                if (itDelay > 0) {
                    itDelay++;
                }

                frameCounter++;

            }

            // GAME LOGIC ENDS HERE 
            // update the drawing (calls paintComponent)
            repaint();

            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try {
                if (deltaTime > desiredTime) {
                    //took too much time, don't wait
                    Thread.sleep(1);
                } else {
                    // sleep to make up the extra time
                    Thread.sleep(desiredTime - deltaTime);
                }
            } catch (Exception e) {
            };


        }
        repaint();
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {
        // if a mouse button has been pressed down

        @Override
        public void mousePressed(MouseEvent e) {
        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {
        // if a key has been pressed down

        @Override
        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();

            if (code == KeyEvent.VK_UP) {
                up = true;
            }
            if (code == KeyEvent.VK_DOWN) {
                down = true;
            }
            if (code == KeyEvent.VK_LEFT) {
                left = true;
            }
            if (code == KeyEvent.VK_RIGHT) {
                right = true;
            }
            if (code == KeyEvent.VK_W) {
                up2 = true;
            }
            if (code == KeyEvent.VK_S) {
                down2 = true;
            }
            if (code == KeyEvent.VK_A) {
                left2 = true;
            }
            if (code == KeyEvent.VK_D) {
                right2 = true;
            }
            if (code == KeyEvent.VK_T) {
                boost2 = true;
            }
            if (code == KeyEvent.VK_SHIFT) {
                boost1 = true;
            }
            if (code == KeyEvent.VK_SPACE) {
                pause = false;
            }
            if (code == KeyEvent.VK_P) {
                pause = true;
            }
            if (c1 == 0) {


                if (code == KeyEvent.VK_NUMPAD1) {
                    charA1 = true;
                }
                if (code == KeyEvent.VK_NUMPAD2) {
                    charB1 = true;
                }
                if (code == KeyEvent.VK_NUMPAD3) {
                    charC1 = true;
                }
                if (code == KeyEvent.VK_NUMPAD4) {
                    charD1 = true;
                }
            }
            if (c2 == 0) {


                if (code == KeyEvent.VK_1) {
                    charA2 = true;
                }
                if (code == KeyEvent.VK_2) {
                    charB2 = true;
                }
                if (code == KeyEvent.VK_3) {
                    charC2 = true;
                }
                if (code == KeyEvent.VK_4) {
                    charD2 = true;
                }
            }
            if (code == KeyEvent.VK_O) {
                win2 = true;
            }
            if (code == KeyEvent.VK_K) {
                win1 = true;
            }
            if (code == KeyEvent.VK_R) {
                restart = true;
            }
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            int code = e.getKeyCode();
            if (code == KeyEvent.VK_UP) {
                up = false;
            }
            if (code == KeyEvent.VK_DOWN) {
                down = false;
            }
            if (code == KeyEvent.VK_LEFT) {
                left = false;
            }
            if (code == KeyEvent.VK_RIGHT) {
                right = false;
            }
            if (code == KeyEvent.VK_W) {
                up2 = false;
            }
            if (code == KeyEvent.VK_S) {
                down2 = false;
            }
            if (code == KeyEvent.VK_A) {
                left2 = false;
            }
            if (code == KeyEvent.VK_D) {
                right2 = false;
            }
            if (code == KeyEvent.VK_R) {
                restart = false;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        GameExperimentation game = new GameExperimentation();

        // starts the game loop
        game.run();
    }
}
