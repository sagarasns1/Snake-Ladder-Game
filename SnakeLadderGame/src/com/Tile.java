/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sagara
 */
public class Tile extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image img1;
    Tile(){
       img1= null;
//       visibleTrue();
       
//        this.setBackground(new Color(255,200,255)); // NOI18N
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                setVisible(true);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img1,15,25,30,30,this);
                    
		
    }
    
    	@SuppressWarnings("deprecation")
		public static void main(String []ad){
		
		JFrame f=new JFrame();
		f.setSize(505,405);
		f.add(new Tile());
		f.show();	
		
	}
        
        public void visibleFalse1(){
            img1=null;
            repaint();
        }
        
      public void visibleTrue1(){
            img1=new ImageIcon("../SnakeLadderGame/bin/com/pB.gif").getImage();

            repaint();
        }
      
      public void visibleFalse2(){
          img1=null;
          repaint();
      }
      
    public void visibleTrue2(){
          img1=new ImageIcon("../SnakeLadderGame/bin/com/pG.gif").getImage();

          repaint();
      }

}
