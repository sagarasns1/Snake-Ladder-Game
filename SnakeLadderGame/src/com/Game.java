/*
 * Game.java
 *
 * Created on October 10, 2009, 3:15 PM
 * @author Sagara Sumathipala
 */
package com;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author  sagara
 */
public class Game extends javax.swing.JFrame implements ActionListener {

    Image img1;
    /** Creates new form Game */
    JPanel tilePanel, tile, basePanel;
    JLabel lblNumber;
    Map tileMap, snakeMap, LadderMap;
    JButton btnGuess,btnStart;
    JLabel lblLadder1, lblLadder2, lblLadder3, lblLadder4;
    JLabel lblSnake1, lblSnake2, lblSnake3, lblSnake4, lblSnake5;
    JLabel lblD1, lblD2, lblD3, lblTurn, lblD5, lblD6;
    double randomNumber,randomNumber2;
    int roundNumber,roundNumber2;
    JLayeredPane layers;
    static int steps,steps2;
    ImageIcon imgD1 = new ImageIcon("../SnakeLadderGame/bin/com/d1.gif");
    ImageIcon imgD2 = new ImageIcon("../SnakeLadderGame/bin/com/d2.gif");
    ImageIcon imgD3 = new ImageIcon("../SnakeLadderGame/bin/com/d3.gif");
    ImageIcon imgD4 = new ImageIcon("../SnakeLadderGame/bin/com/d4.gif");
    ImageIcon imgD5 = new ImageIcon("../SnakeLadderGame/bin/com/d5.gif");
    ImageIcon imgD6 = new ImageIcon("../SnakeLadderGame/bin/com/d6.gif");
    ImageIcon imgBoy = new ImageIcon("../SnakeLadderGame/bin/com/boy.gif");
    ImageIcon imgFall = new ImageIcon("../SnakeLadderGame/bin/com/scared.gif");
    ImageIcon imgNormal = new ImageIcon("../SnakeLadderGame/bin/com/normal.gif");
    ImageIcon imgWon = new ImageIcon("../SnakeLadderGame/bin/com/won.gif");
    boolean isGameStarted=false;
    int player;
    public Game() {

        JLayeredPane layers = getLayeredPane();

        steps = 1;
        steps2 = 1;

        basePanel = new JPanel();
        basePanel.setBounds(0, 0, 800, 800);
        this.setSize(810, 810);

        basePanel.setLayout(null);

        tilePanel = new TilePanel();
        tileMap = new HashMap();
        tilePanel.setBounds(0, 0, 600, 600);
        tilePanel.setBackground(new Color(255, 255, 255));

        tilePanel.setLayout(null);
        setTile(tilePanel);
        basePanel.setBackground(new Color(255, 200, 255));
        tilePanel.setVisible(true);
        basePanel.setVisible(true);

        initComponents();

        btnGuess = new JButton("ROLL DIES");
        btnGuess.setBounds(650, 105, 100, 40);
        btnGuess.addActionListener(this);
        btnGuess.setEnabled(false);
        btnStart = new JButton("START");
        btnStart.setBounds(650, 25, 100, 60);
        btnStart.addActionListener(this);
        ImageIcon imgDice = new ImageIcon("../SnakeLadderGame/bin/com/dice.gif");

        basePanel.add(btnGuess);
        basePanel.add(btnStart);

        ImageIcon imgLadder1 = new ImageIcon("../SnakeLadderGame/bin/com/ladder1.gif");
        ImageIcon imgLadder2 = new ImageIcon("../SnakeLadderGame/bin/com/ladder2.gif");
        ImageIcon imgLadder3 = new ImageIcon("../SnakeLadderGame/bin/com/ladde3.gif");
        ImageIcon imgLadder4 = new ImageIcon("../SnakeLadderGame/bin/com/ladder4.gif");

        lblLadder1 = new JLabel();
        lblLadder1.setIcon(imgLadder1);
        lblLadder1.setBounds(350, 100, 300, 400);

        lblLadder2 = new JLabel();
        lblLadder2.setIcon(imgLadder2);
        lblLadder2.setBounds(55, 250, 300, 400);

        lblLadder3 = new JLabel();
        lblLadder3.setIcon(imgLadder3);
        lblLadder3.setBounds(40, -150, 300, 400);

        lblLadder4 = new JLabel();
        lblLadder4.setIcon(imgLadder4);
        lblLadder4.setBounds(550, 0, 300, 400);

        ImageIcon imgSnake1 = new ImageIcon("../SnakeLadderGame/bin/com/snake1.gif");
        ImageIcon imgSnake2 = new ImageIcon("../SnakeLadderGame/bin/com/snake2.gif");
        ImageIcon imgSnake3 = new ImageIcon("../SnakeLadderGame/bin/com/snake3.gif");
        ImageIcon imgSnake4 = new ImageIcon("../SnakeLadderGame/bin/com/snake4.gif");
        ImageIcon imgSnake5 = new ImageIcon("../SnakeLadderGame/bin/com/SAA0414.gif");


        lblSnake1 = new JLabel();
        lblSnake1.setIcon(imgSnake1);
        lblSnake1.setBounds(425, 330, 300, 400);

        lblSnake2 = new JLabel();
        lblSnake2.setIcon(imgSnake2);
        lblSnake2.setBounds(260, 185, 300, 400);

        lblSnake3 = new JLabel();
        lblSnake3.setIcon(imgSnake3);
        lblSnake3.setBounds(25, 120, 300, 400);

        lblSnake4 = new JLabel();
        lblSnake4.setIcon(imgSnake4);
        lblSnake4.setBounds(440, -140, 300, 400);

        lblSnake5 = new JLabel();
        lblSnake5.setIcon(imgSnake5);
        lblSnake5.setBounds(95, -80, 300, 400);

        layers.add(lblLadder1, 1);
        layers.add(lblLadder2, 2);
        layers.add(lblLadder3, 3);
        layers.add(lblLadder4, 4);

        layers.add(lblSnake1, 5);
        layers.add(lblSnake2, 6);
        layers.add(lblSnake3, 7);
        layers.add(lblSnake4, 8);
        layers.add(lblSnake5, 9);


        snakeMap = new HashMap();
        LadderMap = new HashMap();

        snakeMap.put(13, 9);
        snakeMap.put(45, 25);
        snakeMap.put(58, 41);
        snakeMap.put(92, 88);
        snakeMap.put(83, 79);

        LadderMap.put(2, 43);
        LadderMap.put(33, 67);
        LadderMap.put(50, 90);
        LadderMap.put(82, 99);


        lblD1 = new JLabel();
        lblD2 = new JLabel();
        lblD3 = new JLabel("");
        lblTurn = new JLabel();
        lblD5 = new JLabel();
        lblD6 = new JLabel();

        lblD1.setIcon(imgD1);
        lblD1.setBounds(650, -50, 300, 500);

        lblD2.setBounds(670, 90, 300, 500);

        lblD3.setBounds(650, 30, 300, 500);
        
        lblTurn.setText("");
        lblTurn.setBounds(660, 150, 300, 500);

        layers.add(lblD1, 10);
        layers.add(lblD2, 11);
        layers.add(lblD3, 12);
        layers.add(lblTurn, 13);
        layers.add(tilePanel, 14);
        layers.add(basePanel, 15);

    }

    public void setTile(JPanel panel) {
        int i = 100;
        int s = 81;
        int j = 1;
        int tileH = (panel.getSize().height) / 10;
        int posW = 0;
        for (int a = 0; a < 10; a = a + 2) {
            posW = 0;
            for (int b = 0; b < 10; b++) {
                Tile tile = new Tile();
                tile.setBounds(posW * tileH, 60 * a, tileH, tileH);
                tile.setBackground(new Color(255, 255, 255)); // NOI18N

                lblNumber = new JLabel(i + "");
                tile.setName(i + "");
                lblNumber.setBounds(5, 5, 5, 5);
                tile.add(lblNumber);
                panel.add(tile);
                tileMap.put(i, tile);
                posW++;
                i--;
            }
            i = i - 10;
        }
        i = 81;
        for (int a = 1; a < 11; a = a + 2) {
            int e = i;
            posW = 0;
            for (int b = 0; b < 10; b++) {
                Tile tile = new Tile();
                tile.setBounds(posW * tileH, 60 * a, tileH, tileH);
                lblNumber = new JLabel(i + " ");
                tile.setBackground(new Color(200, 200, 255)); // NOI18N

                tile.setName("tile");
                lblNumber.setBounds(5, 5, 5, 5);
                tile.add(lblNumber);
                panel.add(tile);
                tileMap.put(i, tile);
                posW++;
                i++;
            }
            i = e - 20;
        }
    }

    public void loadDies(int dieSide) {

        ImageIcon[] dies = {imgD1, imgD2, imgD3, imgD4, imgD5, imgD6};
        lblD1.setIcon(dies[dieSide - 1]);
        repaint();

    }

    @SuppressWarnings("deprecation")
	public void loadState(int state) {
        if (state == 1) {
            System.out.println("INSIDE STATE 1");
            lblD3.setText("YAA LADDER..");
            lblD2.setIcon(imgFall);
            repaint();
        } else if (state == 2) {
            lblD3.setText("OHH SNAKE..");
            lblD2.setIcon(imgFall);
            repaint();
        } else {
            lblD3.setText("I'M FINE..");
            lblD2.setIcon(imgNormal);
            repaint();
        }
        
        if(((steps-1)>=100) || ((steps2-1)>=100) ){
        	if(player==1){
        		 lblD3.setText("PLAYER ONE WON..");
        		 btnGuess.setEnabled(false);
        		 btnStart.setEnabled(true);
        	}else{
        		lblD3.setText("PLAYER TWO WON..");
        		btnGuess.setEnabled(false);
        		btnStart.setEnabled(true);
        	}
            
            lblD2.setIcon(imgWon);
               repaint();
        }else{
        }
    }

    public boolean move(int playerNo) {
    	
    	if(playerNo==1){
            int i = steps;
            if (steps <= 100) {
                Tile tileMoveF = (Tile) tileMap.get(i);
                Tile tileMoveB = (Tile) tileMap.get(i - 1);
                if (tileMoveB != null) {
                    tileMoveB.visibleFalse1();

                    tileMoveF.repaint();
                    tileMoveB.repaint();
                }
                tileMoveF.visibleTrue1();
                steps++;
            }else{
            	isGameStarted=false;
            }   
            return true;
    	}else{
            int i = steps2;
            if (steps2 <= 100) {
                Tile tileMoveF = (Tile) tileMap.get(i);
                Tile tileMoveB = (Tile) tileMap.get(i - 1);
                if (tileMoveB != null) {
                    tileMoveB.visibleFalse2();

                    tileMoveF.repaint();
                    tileMoveB.repaint();
                }
                tileMoveF.visibleTrue2();
                steps2++;
            }else{
            	isGameStarted=false;
            }   
            return true;
    	}
    	


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

      setSize(800,655);
      setResizable(false);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == btnStart){
    	    Tile tileMoveB1 = (Tile) tileMap.get(steps - 1);
            if (tileMoveB1 != null) {
                tileMoveB1.visibleFalse1();
                tileMoveB1.repaint();
            }
            Tile tileMoveB2 = (Tile) tileMap.get(steps2 - 1);
            if (tileMoveB2 != null) {
                tileMoveB2.visibleFalse1();
                tileMoveB2.repaint();
            }
    		player=1;
    		steps=1;
    		steps2=1;
    		move(1);
    		isGameStarted=true;
    		lblTurn.setText("PLAYER 1 TURN");
    		btnGuess.setEnabled(true);
    		repaint();
    	}

        if (e.getSource() == btnGuess) {
        	if(isGameStarted){
        		btnStart.setEnabled(false);
        	}else{
        		btnStart.setEnabled(true);
        	}
        	if(player==1){
        		randomNumber = Math.random() * 6;
            int roundNumber1 = (int) Math.round(randomNumber);
            while (roundNumber1 == 0) {
//                System.out.println("Zero random no :"+roundNumber1);
                randomNumber = Math.random() * 6;
                roundNumber1 = (int) Math.round(randomNumber);
            }
            boolean isConuted = false;
            loadDies(roundNumber1);
            roundNumber = 0;
            for (int j = 0; j < roundNumber1; j++) {
                ++roundNumber;
                isConuted = move(1);
                try {
                    Thread.sleep(100);

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            boolean isMeetSnake = snakeMap.containsKey(steps - 1);
            boolean isMeetLaddre = LadderMap.containsKey(steps - 1);

            if (isMeetLaddre) {
                loadState(1);
                lblD2.setIcon(imgBoy);
                repaint();
                meetLadder((steps - 1),1);
            } else if (isMeetSnake) {
                loadState(2);
                lblD2.setIcon(imgFall);
                repaint();
                meetSnake((steps - 1),1);
            } else {
                loadState(3);
            }

            
            player=2;
            lblTurn.setText("PLAYER 2 TURN");
            repaint();
        	}else{
	            randomNumber = Math.random() * 6;
	            int roundNumber1 = (int) Math.round(randomNumber);
	            while (roundNumber1 == 0) {
	                randomNumber = Math.random() * 6;
	                roundNumber1 = (int) Math.round(randomNumber);
	            }
	            boolean isConuted = false;
	            loadDies(roundNumber1);
	            roundNumber = 0;
	            for (int j = 0; j < roundNumber1; j++) {
	                ++roundNumber;
	                isConuted = move(2);
	                try {
	                    Thread.sleep(100);

	                } catch (InterruptedException ex) {
	                    ex.printStackTrace();
	                }
	            }

	            boolean isMeetSnake = snakeMap.containsKey(steps2 - 1);
	            boolean isMeetLaddre = LadderMap.containsKey(steps2 - 1);

	            if (isMeetLaddre) {
	                loadState(1);
	                lblD2.setIcon(imgBoy);
	                repaint();
	                meetLadder((steps2 - 1),2);
	            } else if (isMeetSnake) {
	                loadState(2);
	                lblD2.setIcon(imgFall);
	                repaint();
	                meetSnake((steps2 - 1),2);
	            } else {
	                loadState(3);
	            }
	            lblTurn.setText("PLAYER 1 TURN");
	            repaint();
	            player=1;
        	}

        }

    }

    public void meetSnake(int key,int p) {
    	if(p==1){
    		  int destination = (Integer) snakeMap.get(key);
    	        System.out.println("MEET SNAKE " + destination);

    	        Tile tileMoveF = (Tile) tileMap.get(destination);
    	        Tile tileMoveB = (Tile) tileMap.get(key);
    	        tileMoveB.visibleFalse1();
    	        tileMoveF.visibleTrue1();
    	        tileMoveF.repaint();
    	        tileMoveB.repaint();
    	        steps = destination;
    	}else{
    		int destination = (Integer) snakeMap.get(key);

	        Tile tileMoveF = (Tile) tileMap.get(destination);
	        Tile tileMoveB = (Tile) tileMap.get(key);
	        tileMoveB.visibleFalse2();
	        tileMoveF.visibleTrue2();
	        tileMoveF.repaint();
	        tileMoveB.repaint();
	        steps2 = destination;
    	}
      
    }

    public void meetLadder(int key,int p) {
    	if(p==1){
    		   int destination = (Integer) LadderMap.get(key);
        System.out.println("MEET LADDER  " + destination);
        Tile tileMoveF = (Tile) tileMap.get(destination);
        Tile tileMoveB = (Tile) tileMap.get(key);
        tileMoveB.visibleFalse1();
        tileMoveF.visibleTrue1();
        tileMoveF.repaint();
        tileMoveB.repaint();
        steps = destination;
    	}else{
    		int destination = (Integer) LadderMap.get(key);
            System.out.println("MEET LADDER  " + destination);
            Tile tileMoveF = (Tile) tileMap.get(destination);
            Tile tileMoveB = (Tile) tileMap.get(key);
            tileMoveB.visibleFalse2();
            tileMoveF.visibleTrue2();
            tileMoveF.repaint();
            tileMoveB.repaint();
            steps2 = destination;
    	}
    }
}
