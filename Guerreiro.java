import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Guerreiro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Guerreiro extends Actor
{
    public Guerreiro ()
    {
        getImage().scale(130, 130);
    }
    
    /**
     * Act - do whatever the Guerreiro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        String tecla = Greenfoot.getKey();
        if(tecla!=null)
        {
            if(tecla.equals("space"))
            {
                atacar();
            }
            else if(tecla.equals("right"))
            {
                moverDireita();
            }
            else if(tecla.equals("left"))
            {
                moverEsquerda();
            }
        }
    }
    
    private void atacar()
    {
        
    }
    
    private void moverDireita()
    {
        if(getX() != getWorld().getWidth()*8/10)
        {
            setLocation(getX()+ getWorld().getWidth()*2/10, getY());
        }
    }
    
    private void moverEsquerda()
    {
        if(getX() != getWorld().getWidth()*2/10)
        {
            setLocation(getX() - getWorld().getWidth()*2/10, getY());
        }
    }
}
