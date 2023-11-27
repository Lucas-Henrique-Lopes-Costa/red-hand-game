import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PassaHistoriaEspada2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PassaHistoriaEspada2 extends Actor
{
    private int timer = 6;
    private boolean possoClicar = false;
    
    public void act() {
        checkKeyPress();
        if (timer > 0) 
        {
            timer--;
            if (timer == 0) {
                possoClicar = true;
            }
        }
    }
    
    public void checkKeyPress() {
        if(possoClicar)
        {
            if (Greenfoot.isKeyDown("space")) 
            {
                Greenfoot.setWorld(new MundoDragao());// Inicia o mundo do dragão
            }
        }
    }
}
