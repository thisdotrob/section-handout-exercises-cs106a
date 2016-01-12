import acm.graphics.*;
import acm.program.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class BoxDiagram extends GraphicsProgram {
	
	// constants
	private static final double BOX_WIDTH = 120;
	private static final double BOX_HEIGHT = 50;
	
	public void init() {
		canvasItems = new HashMap<String,GCompound>();
		addControlBar();
		addActionListeners();	
		addMouseListeners();
	}

	/** adds the control bar to the bottom of the screen */
	private void addControlBar() {
	
		// add label
		add(new JLabel("Name"), SOUTH);
		
		// add text box
		tF = new JTextField(30);
		add(tF, SOUTH);
		tF.addActionListener(this);
		
		// add "add" button
		addBut = new JButton("Add");
		add(addBut, SOUTH);
		
		// add "remove" button
		removeBut = new JButton("Remove");
		add(removeBut, SOUTH);
		
		// add "clear" button
		clearBut = new JButton("Clear");
		add(clearBut, SOUTH);
	}
	
	/** records the coordinates and object at which the mouse is pressed */
	public void mousePressed(MouseEvent e) {
		last = new GPoint(e.getPoint());
		gobj = getElementAt(last);
	}
	
	/** drags the object at which the mouse is pressed */
	public void mouseDragged(MouseEvent e) {
		if (gobj != null) {
			gobj.move(e.getX() - last.getX(), e.getY() - last.getY());
			last = new GPoint(e.getPoint());
		}
	}
	
	/** performs actions according to which button has been clicked */
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == addBut || e.getSource() == tF) {
			addBox( tF.getText() );
		} else if ( e.getSource() == removeBut ) {
			removeBox( tF.getText() );
		} else if ( e.getSource() == clearBut ) {
			clearBoxes();
		}
	}
	
	/** clears the canvas of all boxes */
	private void clearBoxes() {
		for ( String key: canvasItems.keySet() ) {
			remove (canvasItems.get(key));
		}
		canvasItems.clear();		
	}

	/** removes the box from the canvas with name equal to that typed into the text field */
	private void removeBox(String key) {
		if (canvasItems.get(key) != null) {
			remove ( canvasItems.get(key) );
			canvasItems.remove(key);
		}
				
	}

	/** adds a box to the canvas, with name equal to that typed into the text field */
	private void addBox(String key) {
		
		// create GRect and GLabel
		GRect rect = new GRect( BOX_WIDTH, BOX_HEIGHT );
		GLabel label = new GLabel(key);
		
		// set location on canvas for GRect and GLabel
		double rectX = ( getWidth() - rect.getWidth() ) / 2 ;
		double rectY = ( getHeight() - rect.getHeight() ) / 2 ;
		double labelX = ( getWidth() - label.getWidth() ) / 2 ;
		double labelY = ( getHeight() + label.getAscent() ) / 2 ;
		label.setLocation( labelX, labelY);
		rect.setLocation( rectX, rectY);
		
		// add the GRect and GLabel into a single GCompound
		GCompound comp = new GCompound();
		comp.add(rect);
		comp.add(label);
		
		// add the GCompound to the canvas, and to the HashMap
		canvasItems.put(key,comp);			
		add(comp);		
	}

	// instance variables
	private JTextField tF;
	private JButton addBut;
	private JButton removeBut;
	private JButton clearBut;
	private HashMap<String,GCompound> canvasItems;
	private GObject gobj;
	private GPoint last;
}