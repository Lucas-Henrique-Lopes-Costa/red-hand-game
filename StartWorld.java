import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartWorld extends World
{
    public StartWorld()
    {    
        super(750, 750, 1); 
        Greenfoot.start();
    }

    public void act()
    {
        showText("Pressione ENTER para iniciar", 375, 675);
        
        if(Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new MeuMundo());
        }
    }
}

