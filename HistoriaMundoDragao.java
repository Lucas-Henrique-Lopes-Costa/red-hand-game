import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HistoriaMundoDragao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HistoriaMundoDragao extends World
{
    private int timer = 6;
    private boolean possoClicar = false;

    public HistoriaMundoDragao()
    { 
        super(750,750,1);
    }

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
            if (Greenfoot.isKeyDown("enter")) 
            {
                Greenfoot.setWorld(new MundoDragao());// Inicia o mundo do dragão
            }
        }
    }
}
