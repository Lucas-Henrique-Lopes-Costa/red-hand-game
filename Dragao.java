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
    private boolean jaNasceu;
    private boolean ataquePata;
    private boolean ataqueChamas;
    private int temporizadorChamas;
    private PataDragao pata1;
    private PataDragao pata2;
    private PataDragao pataNoAr;
    private VidaDragao vida;
    
    public Dragao()
    {
        ataquePata=false;
        jaNasceu=false;
        ataqueChamas=false;
        
        temporizador=0;
        temporizadorChamas=0;
        
        pata1 = new PataDragao("PATA DA ESQUERDA.png");
        pata2 = new PataDragao("PATA DA DIREITA.png");
        vida = new VidaDragao();
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
            mundo.addObject(pata1, mundo.getWidth()*1/10, mundo.getHeight()*4/5);
            mundo.addObject(pata2, mundo.getWidth()*9/10, mundo.getHeight()*4/5);
            mundo.addObject(vida, mundo.getWidth()/2, mundo.getHeight()*1/10);
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
            if(pataNoAr.estaParada())
            {
                explosoes();
                ataquePata=false;
            }
        }
        else if(ataqueChamas)
        {
            temporizadorChamas++;
            if(temporizadorChamas<=1)
            {
                World mundo = getWorld();
                
                Chamas chamas1 = new Chamas("");
                Chamas chamas2 = new Chamas("esquerda");
                Chamas chamas3 = new Chamas("direita");
                mundo.addObject(chamas1, mundo.getWidth()/2, mundo.getHeight()/3);
                mundo.addObject(chamas2, mundo.getWidth()/2, mundo.getHeight()/3);
                mundo.addObject(chamas3, mundo.getWidth()/2, mundo.getHeight()/3);
            }
            else
            {
                temporizadorChamas=0;
                ataqueChamas=false;
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
        else if(random<8)
        {
            subirPata();
        }
        else
        {
            ataqueChamas=true;
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
            mundo.addObject(fogo1, mundo.getWidth()*2/10, mundo.getHeight()*7/10-15);
            mundo.addObject(fogo2, mundo.getWidth()*4/10, mundo.getHeight()*7/10-15);
        }
        else if (pataNoAr == pata2)
        {
            mundo.addObject(fogo1, mundo.getWidth()*6/10, mundo.getHeight()*7/10-15);
            mundo.addObject(fogo2, mundo.getWidth()*8/10, mundo.getHeight()*7/10-15);
        }
    }
    
    private void ataqueLancaChamas()
    {
        World mundo = getWorld();
    }
    
    public void perderVida()
    {
        vida.redimensiona(-10);
    }
}
