package pongreloaded;

import java.awt.*;
import java.awt.event.*;

/**
 * @author Mcat12
 */
public class MultiplayerMenu implements Screen {
	// Buttons
	Button connectButton;
	Button hostButton;
	Button multiToMainButton;
    
    // Hover
    boolean connectHover;
    boolean hostHover;
    boolean multiToMainHover;
    
    // Game
    Dimension screenSize;
    int winScore;
    boolean isHost = false;
	
	public MultiplayerMenu(Dimension screenSize, int winScore) {
		this.screenSize = screenSize;
		this.winScore = winScore;
		connectButton = new Button(50, 170, 100, 25, "Connect", screenSize);
		hostButton = new Button(250, 140, 100, 25, "Host", screenSize);
		multiToMainButton = new Button(25, 250, 100, 25, "Back", screenSize);
	}
	
	public Screens getScreenType() {
		return Screens.MULTIMENU;
	}
	
	public Screen getScreen() {
		return this;
	}
	
	public void displayOutput(Graphics g) {
		// Multiplayer Header
        g.setFont(new Font("Arial", Font.BOLD, 26));
        g.setColor(Color.WHITE);
        g.drawString("Multiplayer", 130, 75);
        
        // IP Address Input
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString("Enter Ip Address & Port", 37, 100);
        
        // Connect Button
        connectButton.draw(g);
        
        // Host Port Input
        g.setColor(Color.WHITE);
        g.drawString("Enter Port Number", 250, 100);
        
        // Host Button
        hostButton.draw(g);
        
        // Back Button (Multiplayer to Main)
        multiToMainButton.draw(g);
	}
	
	public Screen respondToUserInput(KeyEvent key) {
		return this;
	}
	
	public Screen respondToUserInputReleased(KeyEvent key) {
		return this;
	}
	
	public Screen respondToUserInputHover(MouseEvent mouse) {
		int mx = mouse.getX();
        int my = mouse.getY();
		
        connectButton.adjustHover(mx, my);
        hostButton.adjustHover(mx, my);
        multiToMainButton.adjustHover(mx, my);
        
        return this;
	}
	
	public Screen respondToUserInputClick(MouseEvent mouse) {
		int mx = mouse.getX();
        int my = mouse.getY();
        
        if(connectButton.intersects(mx, my)) {
            if(!isHost) {
                return new MultiplayerGame(Pong.ipText.getText(), Integer.parseInt(Pong.connectPortText.getText()), winScore);
            }
            else
                Pong.ipText.setText("You are host");
        }
        
        if(hostButton.intersects(mx, my)) {
        	if(Pong.hostPortText.getText().equals(""))
        		System.out.println("Please enter a valid port");
        	else
        		return new MultiplayerGame(Integer.parseInt(Pong.hostPortText.getText()), winScore);
        }
        
        if(multiToMainButton.intersects(mx, my))
            return new MainMenu(screenSize);
        
        return this;
	}
	
	public Screen respondToUserInput(MouseWheelEvent mouse) {
		return this;
	}
	
	public Screen windowClosingEvent(WindowEvent window) {
		return this;
	}
}
