import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Espada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Espada extends Actor
{
    MeuMundo mundo;
    public Espada(MeuMundo mundo)
    {
        this.mundo=mundo;
    }
    
    /**
     * Act - do whatever the Espada wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(getY()<700)
        {
            setLocation(getX(), getY()+1);
        }
        
        if(getIntersectingObjects(Lenhador.class).size()==1)
        {
            Greenfoot.setWorld(new MundoDragao());
        }
    }
    
    public void chanceAparecer()
    {
        if(Greenfoot.getRandomNumber(50) == 0)
        {
            if(Greenfoot.getRandomNumber(1)==0)
            {
                mundo.addObject(this,215,0);
            }
            else
            {
                mundo.addObject(this,530,0);
            }
        }
    }
    
}
