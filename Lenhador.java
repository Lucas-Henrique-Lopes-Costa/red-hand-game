import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lenhador here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lenhador extends Actor {
    /**
     * Act - do whatever the Lenhador wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Lenhador() {
        getImage().scale(200, 200);
    }

    public void act() {
        if (Greenfoot.isKeyDown("left")) {
            setImage("lenhador.jpeg");
            setLocation(789, 568);
            getImage().scale(200, 200);
            // Greenfoot.playSound("corte.wav");
        } else if (Greenfoot.isKeyDown("right")) {
            setImage("lenhador.jpeg");
            setLocation(789, 568);
            getImage().mirrorHorizontally();
            getImage().scale(200, 200);
            // Greenfoot.playSound("corte.wav");
        }
    }
}
