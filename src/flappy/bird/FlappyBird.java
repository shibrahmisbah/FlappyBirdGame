/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappy.bird;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author cute_
 */
public class FlappyBird implements ActionListener{
    
    public final int WIDTH = 800, HEIGHT = 800;
    
    //static variable to be used in a static context; main method
    public static FlappyBird flappyBird;
    
    public Renderer renderer;

    //add a constructor to allow instantiation of class
    public FlappyBird(){
        //create JFrame object using specified height constants
        JFrame jframe = new JFrame();
        Timer timer = new Timer(20, this);
        //add renderer object in memory; not null
        renderer = new Renderer();
        
        jframe.add(renderer);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(WIDTH, HEIGHT);
        jframe.setResizable(false);
        jframe.setVisible(true);
        
        timer.start();
    }
    

    public void repaint(Graphics g) {
        
    }
    
    public static void main(String[] args) {
        flappyBird = new FlappyBird();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderer.repaint();
    }
    
}
