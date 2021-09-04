/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappy.bird;

import javax.swing.JFrame;

/**
 *
 * @author cute_
 */
public class FlappyBird {
    
    public final int WIDTH = 800, HEIGHT = 800;
    
    public static FlappyBird flappyBird;

    //add a constructor to allow instantiation of class
    public FlappyBird(){
        //create JFrame object using specified height constants
        JFrame jframe = new JFrame();
        
        jframe.setSize(WIDTH, HEIGHT);
        jframe.setVisible(true);
    }
  
    public static void main(String[] args) {
        flappyBird = new FlappyBird();
        
    }
    
}
