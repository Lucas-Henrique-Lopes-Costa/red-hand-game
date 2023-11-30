import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PataDragao here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class PataDragao extends Actor
{
    
    public PataDragao(String imagem)
    {
        setImage(imagem);    
    }
    
    /**
     * Act - do whatever the PataDragao wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(getY()!=getWorld().getHeight()*4/5)
        {
            setLocation(getX(), getY() +5);
        }
    }
    
    public void subir()
    {
        setLocation(getX(), getWorld().getHeight()*3/10);
    }
    
    public boolean estaParada()
    {
        if(getY() == getWorld().getHeight()*8/10)
        return true;
        
        return false;
    }
}
