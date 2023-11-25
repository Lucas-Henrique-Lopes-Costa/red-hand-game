import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialWorld extends World
{

    /**
     * Constructor for objects of class TutorialWorld.
     * 
     */
    public TutorialWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 750, 1); 
        showText("Pressione ENTER para voltar", 375, 725);
        if (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space") || Greenfoot.mouseClicked(null)) {
            Greenfoot.setWorld(new StartWorld()); // Inicia o jogo de verdade
        }
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
        {
            StartWorld menu = new StartWorld();
            Greenfoot.setWorld(menu);
        }
    }
}
