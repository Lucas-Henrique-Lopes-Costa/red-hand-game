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
    private String gatilho;
    /**
     * Act - do whatever the TroncoNormal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TroncoNormal (String tipo)
    {
        if(tipo.equals("normal"))
        {
            setImage("troncoNormal.png");
            getImage().scale(160, 160);
            lado=tipo;
            gatilho="";
        }
        else if(tipo.equals("esquerda"))
        {
            setImage("troncoGalho.png");
            getImage().scale(283, 160);
            lado=tipo;
            gatilho="";

        }
        else if (tipo.equals("direita"))
        {
            setImage("troncoGalho.png");
            getImage().mirrorHorizontally();
            getImage().scale(283, 160);
            lado=tipo;
            gatilho="";
        }
    }
    
    public String getLado()
    {
        return lado;        
    }
    
    public void act()
    {
        if(gatilho.equals("direita"))
        {
            setLocation(getX()+15, getY());
            turn(20);
        }
        else if(gatilho.equals("esquerda"))
        {
            setLocation(getX()-15, getY());
            turn(-20);
        }
        
        if(getX()<100 || getX()>650)
        {
            getWorld().removeObject(this);
        }
    }
    
    public void cair160()
    {
        setLocation(getX(), getY()+160);
    }
    
    public void mudaGatilho(String qualLado)
    {
        gatilho=qualLado;
    }
}
