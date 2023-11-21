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
    private boolean jaNasceu;
    private boolean ataquePata;
    private PataDragao pata1;
    private PataDragao pata2;
    private PataDragao pataNoAr;
    
    public Dragao()
    {
        ataquePata=false;
        jaNasceu=false;
        
        
        vida = 1000;
        temporizador=0;
        
        pata1 = new PataDragao();
        pata2 = new PataDragao();
    }
    
    /**
     * Act - do whatever the Dragao wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //Posiciona as duas patas do dragao no mundo
        if(!jaNasceu)
        {
            jaNasceu=true;
            
            World mundo = getWorld();
            mundo.addObject(pata1, mundo.getWidth()*1/10, mundo.getHeight()*8/10);
            mundo.addObject(pata2, mundo.getWidth()*9/10, mundo.getHeight()*8/10);
        }
        
        //Lógica padrão do Dragão, ataca uma vez a cada 3 sec
        temporizador++;
        if(temporizador==180)
        {
            temporizador=0;
            randomizaAtaque();
        }
        
        //Condicional para ver se o dragão está conjurando um ataque de pata
        //Se sim, executa o lógica necessária para o ataque funcionar
        if(ataquePata)
        {
            World mundo = getWorld();
            if(pataNoAr.estaParada())
            {
                explosoes();
                ataquePata=false;
            }
        }
    }
    
    //Função chave para o funcionamento do dragão.
    //É nela que os ataques são aleatorizados.
    private void randomizaAtaque()
    {
        
        int random = Greenfoot.getRandomNumber(12);
        
        if(random<4)
        {
            ataqueBolasDeFogo();
        }
        else if(random<80)
        {
            subirPata();
        }
        else
        {
            ataqueLancaChamas();
        }
        
    }
    
    //toda a lógica do ataque das bolas de fogo está nessa função
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
    
    private void subirPata()
    {
        int numero = Greenfoot.getRandomNumber(2);
        
        if(numero==0)
        {
            pata1.subir();
            pataNoAr=pata1;
        }
        else
        {
            pata2.subir();
            pataNoAr=pata2;
        }
        
        ataquePata=true;
    }
    
    private void explosoes()
    {
        World mundo = getWorld();
        Fogo fogo1 = new Fogo();
        Fogo fogo2 = new Fogo();
        if(pataNoAr == pata1)
        {
            mundo.addObject(fogo1, mundo.getWidth()*2/10, mundo.getHeight()*9/10);
            mundo.addObject(fogo2, mundo.getWidth()*4/10, mundo.getHeight()*9/10);
        }
        else if (pataNoAr == pata2)
        {
            mundo.addObject(fogo1, mundo.getWidth()*6/10, mundo.getHeight()*9/10);
            mundo.addObject(fogo2, mundo.getWidth()*8/10, mundo.getHeight()*9/10);
        }
    }
    
    private void ataqueLancaChamas()
    {
        
    }
    
    public static void perderVida()
    {
        vida-=10;
    }
}
