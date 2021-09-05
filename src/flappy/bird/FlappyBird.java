/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappy.bird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author cute_
 */
public class FlappyBird implements ActionListener{
    
    public final int WIDTH = 800, HEIGHT = 800;
    
    //randomizer for height
    Random rand;
    
    //static variable to be used in a static context; main method
    public static FlappyBird flappyBird;
    
    //to render graphics; extends JPanel 
    public Renderer renderer; 
    
    public Rectangle bird;
    
    //ArrayList of rectangles 
    ArrayList<Rectangle> columns;
    
    //motion of the bird
    public int ticks, yMotion;
    

    //add a constructor to allow instantiation of class
    public FlappyBird(){
        //create JFrame object using specified height constants
        JFrame jframe = new JFrame();
        Timer timer = new Timer(20, this);
        
        //add renderer object in memory; not null
        renderer = new Renderer();
        
        rand = new Random();
        
        jframe.add(renderer);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(WIDTH, HEIGHT);
        jframe.setResizable(false);
        jframe.setVisible(true);
        
        columns = new ArrayList<Rectangle>();
        
        bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
        
        timer.start();
        
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);

    }
    

    public void repaint(Graphics g) {
        
        //generates red square inside of cyan background
        g.setColor(Color.cyan);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        g.setColor(Color.green);
        g.fillRect(0, HEIGHT - 150, WIDTH, 120);
        
        g.setColor(Color.orange);
        g.fillRect(0, HEIGHT - 120, WIDTH, 20);
        
   
        g.setColor(Color.red);
        g.fillRect(bird.x, bird.y, bird.width, bird.height);
    }
    
    public static void main(String[] args) {
        flappyBird = new FlappyBird();
    }
    
    public void addColumn(boolean start){
        int space = 300;
        int width = 100;
        int height = 50 + rand.nextInt(300);
        
        if(start){
            /**
             * WIDTH + width + columns.size() * 300 
             * to move column 100 units away from top left 
             */
            columns.add(new Rectangle(WIDTH + width + columns.size() * 300, HEIGHT - height - 120, width, height));
            columns.add(new Rectangle(WIDTH + width + (columns.size()-1) * 300, 0, width, HEIGHT - height - space));
        }
        else{
            columns.add(new Rectangle(columns.get(columns.size() - 1).x * 600, HEIGHT - height - 120, width, height));
            columns.add(new Rectangle(WIDTH + width + columns.get(columns.size()-1).x, 0, width, HEIGHT - height - space));    
        }
       
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ticks++;
        
        if(ticks % 2 == 0 && yMotion < 15){
            yMotion += 2;
        }
        
        bird.y += yMotion;
        
        renderer.repaint();
    }
    
    public void paintColumn(Graphics g, Rectangle column){
        g.setColor(Color.green.darker());
        g.fillRect(column.x, column.y, column.width, column.height);
    }
    
}
