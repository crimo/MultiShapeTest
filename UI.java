/**
 * @author      Chris Moore <cmoore12@radford.edu>
 * @version     1.0                                   
 * @since       2012-10-04         
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class UI {
	
	/*
	 * Width of created icon
	 */
	private static final int ICON_WIDTH = 400;
	/*
	 * Height of created icon
	 */
	private static final int ICON_HEIGHT = 100;
	/*
	 * Constant width for all shapes created
	 */
	private static final int SHAPE_WIDTH = 100;
	/*
	 * All shapes are added to this icon
	 */
	private static ShapeIcon icon;
	/*
	 * Label which displays the icon
	 */
	private static JLabel label;
	/*
	 * Top panel
	 */
	private static JPanel optionPanel;

	private static JFrame frame;
	private static JCheckBox plane;
	private static JCheckBox boat;
	private static JCheckBox clock;
	
	/*
	 * Creates a new UI
	 */
	public UI(){
		frame = new JFrame();
		frame.setResizable(false);

		JPanel buttonPanel = new JPanel();
		
		/*
		 * Button shows main window when clicked
		 */
		JButton show = new JButton("Show");
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showWindow();
			}	
		});
		buttonPanel.add(show);
		
		/*
		 * Button adds all selected shapes to icon
		 */
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addShapes();
				showWindow();
			}	
		});
		buttonPanel.add(add);
		
		/*
		 *  Button removes last added shape
		 */
		JButton remove = new JButton("Remove");
		buttonPanel.add(remove);
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				icon.remove();
			}	
		});
		
		/*
		 * Button exits program
		 */
		JButton exit = new JButton("Exit");
		buttonPanel.add(exit);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}	
		});
		
		plane = new JCheckBox("Airplane");
		plane.setSelected(true);
		buttonPanel.add(plane);
		
		boat = new JCheckBox("Boat");
		buttonPanel.add(boat);
		
		clock = new JCheckBox("Clock");
		buttonPanel.add(clock);
		
		frame.add(buttonPanel, BorderLayout.NORTH);

		
		/*
		 * Icon is created that holds all the shapes
		 */
		icon = new ShapeIcon( ICON_WIDTH, ICON_HEIGHT);

		/*
		 * Label is created with icon which displays to the screen
		 */
		label = new JLabel(icon);
		
	    frame.add(label, BorderLayout.CENTER);
	
	    /*
	     * Repaints icon on a timer
	     */
	    final int DELAY = 10;
	      // Milliseconds between timer ticks
	      Timer t = new Timer(DELAY, new
	         ActionListener()
	         {
	            public void actionPerformed(ActionEvent event)
	            {
	               icon.translateAll();  //All shapes need to be translated
	               label.repaint();		 //Updates the label with shapes new location
	            }
	         });
	      t.start();

	      	/*
	      	 * Button hides label and sub-menu
	      	 */
			JButton hide = new JButton("Hide");
			hide.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					label.setVisible(false);
				}	
			});
			
			/*
			 * Button removes all shapes and closes sub window
			 */
			JButton exit2 = new JButton("Exit");
			exit2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					destroyWindow();
				}	
			});
			

			optionPanel = new JPanel(); 
			optionPanel.add(hide);
			optionPanel.add(exit2);

			
			frame.add(optionPanel, BorderLayout.SOUTH);

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		hideWindow();
		
		frame.setVisible(true);
	}
	
	/*
	 * Shows sub-window
	 */
	public void showWindow(){
		label.setVisible(true);
		optionPanel.setVisible(true);
		frame.pack();
	}
	
	/*
	 * Hide sub-window
	 */
	public void hideWindow(){
		label.setVisible(false);
		optionPanel.setVisible(false);
		frame.pack();
	}
	
	/*
	 * Hide sub-window and remove all shapes from icon
	 */
	public void destroyWindow(){
		icon.clearAll();
		hideWindow();
	}
	
	/*
	 * Adds checked shapes to icon.
	 * 
	 * Random number determines initial placement of shapes and ensures
	 * 	shape is placed within borders of icon
	 */
	public void addShapes(){
	     Random generator = new Random();
	     int x;
	     int y;
		
		if(plane.isSelected()){
		  do{
			x = generator.nextInt(icon.getIconWidth());
			y = generator.nextInt(icon.getIconHeight());
		  } while(y>icon.getIconHeight()-40);
			PlaneShape planeShape = new PlaneShape(x,y, SHAPE_WIDTH);
		    icon.add(planeShape);
		}
		
		if(boat.isSelected()){
			x = generator.nextInt(icon.getIconWidth());
			y = generator.nextInt(icon.getIconHeight());
			BoatShape boatShape = new BoatShape(x,y, SHAPE_WIDTH);
			icon.add(boatShape);
		}

		if(clock.isSelected()){
			x = generator.nextInt(icon.getIconWidth());
			y = generator.nextInt(icon.getIconHeight());
			ClockShape clockShape = new ClockShape(x,y, SHAPE_WIDTH);
			icon.add(clockShape);
		}
		
	}
}
