import greenfoot.*;  //  (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Dragao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragao extends Actor
{
    private int temporizador;
    private static int vida;
    
    public Dragao()
    {
        vida = 1000;
        temporizador=0;
    }
    
    /**
     * Act - do whatever the Dragao wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        temporizador++;
        if(temporizador==180)
        {
            temporizador=0;
            randomizaAtaque();
        }
    }
    
    private void randomizaAtaque()
    {
        
        int random = Greenfoot.getRandomNumber(12);
        
        if(random<4)
        {
            ataqueBolasDeFogo();
        }
        else if(random<80)
        {
            ataquePata();
        }
        else
        {
            ataqueLancaChamas();
        }
    }
    
    private void ataqueBolasDeFogo()
    {
        World mundo = getWorld();
        
        BolaDeFogo bola = new BolaDeFogo();
        BolaDeFogo bola2 = new BolaDeFogo();
        BolaDeFogo bola3 = new BolaDeFogo();
        
        
        int random = Greenfoot.getRandomNumber(4);
        if(random==0)
        {
            mundo.addObject(bola, mundo.getWidth()*2/10, 20);
            mundo.addObject(bola2, mundo.getWidth()*4/10, 20);
            mundo.addObject(bola3, mundo.getWidth()*6/10, 20);
        }
        else if(random==1)
        {
            mundo.addObject(bola, mundo.getWidth()*2/10, 20);
            mundo.addObject(bola2, mundo.getWidth()*4/10, 20);
            mundo.addObject(bola3, mundo.getWidth()*8/10, 20);
        }
        else if(random==2)
        {
            mundo.addObject(bola, mundo.getWidth()*2/10, 20);
            mundo.addObject(bola2, mundo.getWidth()*6/10, 20);
            mundo.addObject(bola3, mundo.getWidth()*8/10, 20);
        }
        else
        {
            mundo.addObject(bola, mundo.getWidth()*4/10, 20);
            mundo.addObject(bola2, mundo.getWidth()*6/10, 20);
            mundo.addObject(bola3, mundo.getWidth()*8/10, 20);
        }
        
    }
    
    private void ataquePata()
    {
        World mundo = getWorld();
        int random = Greenfoot.getRandomNumber(2);
        
        Fogo fogo1 = new Fogo();
        Fogo fogo2 = new Fogo();
        if(random==0)
        {
            mundo.addObject(fogo1, mundo.getWidth()*2/10, mundo.getHeight()*9/10);
            mundo.addObject(fogo2, mundo.getWidth()*4/10, mundo.getHeight()*9/10);
        }
        else
        {
            mundo.addObject(fogo1, mundo.getWidth()*6/10, mundo.getHeight()*9/10);
            mundo.addObject(fogo2, mundo.getWidth()*8/10, mundo.getHeight()*9/10);
        }
    }
    
    private void ataqueLancaChamas()
    {
        
    }
    
    public void perderVida()
    {
        vida-=10;
    }
}
