import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PataDragao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PataDragao extends Actor
{
    /**
     * Act - do whatever the PataDragao wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(getY()!=getWorld().getHeight()*8/10)
        {
            setLocation(getX(), getY() +10);
        }
    }
}
