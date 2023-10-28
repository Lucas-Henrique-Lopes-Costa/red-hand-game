import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class TroncoNormal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TroncoNormal extends Actor
{
    
    private String lado;
    /**
     * Act - do whatever the TroncoNormal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TroncoNormal (String tipo)
    {
        if(tipo.equals("normal"))
        {
            setImage("troncoNormal.png");
            lado=tipo;
        }
        else if(tipo.equals("esquerda"))
        {
            setImage("tree.png");
            lado=tipo;
        }
        else if (tipo.equals("direita"))
        {
            setImage("baby2.png");
            lado=tipo;
        }
    }
    
    public String getLado()
    {
        return lado;        
    }
    
    public void act()
    {
    }
}
