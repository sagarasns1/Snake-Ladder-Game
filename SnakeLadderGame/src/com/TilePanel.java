package com;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * Created on October 10, 2009, 3:15 PM
 * @author Sagara Sumathipala
 */
public class TilePanel extends JPanel {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image img1;
    TilePanel(){
       img1=new ImageIcon("../SnakeLadderGame/bin/com/s900000mghjh9.jpg").getImage();
//        this.setBackground(new Color(255,200,255)); // NOI18N
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                setVisible(true);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
    
    	@SuppressWarnings("deprecation")
		public static void main(String []ad){
		
		JFrame f=new JFrame();
		f.setSize(505,405);
		f.add(new TilePanel());
		f.show();	
		
	}
}
