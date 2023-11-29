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
    private Barras vida;
    private MundoDragao mundo;
    
    //Sons do dragão
    private GreenfootSound somPata;
    private GreenfootSound somChamas;
    private GreenfootSound somBolaDeFogo;
    public Dragao(MundoDragao mundo)
    {
        ataquePata=false;
        jaNasceu=false;
        ataqueChamas=false;
        
        this.mundo=mundo;
        temporizador=0;
        temporizadorChamas=0;
        
        pata1 = new PataDragao("PATA DA ESQUERDA.png");
        pata2 = new PataDragao("PATA DA DIREITA.png");
        vida = new Barras(1000);
        
        Greenfoot.playSound("barulhoDragao.mp3");
        sons();
    }
    
    private void sons()
    {
        somPata = new GreenfootSound("pata.mp3");
        somPata.setVolume(40);
        somChamas = new GreenfootSound("chamas.mp3");
        somChamas.setVolume(80);
        somBolaDeFogo = new GreenfootSound("bolaDeFogo.mp3");
        somBolaDeFogo.setVolume(80);
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
                somPata.play();
                explosoes();
                ataquePata=false;
            }
        }
        else if(ataqueChamas)
        {
            temporizadorChamas++;
            if(temporizadorChamas<=1)
            {
                Chamas chamas1 = new Chamas("",mundo);
                Chamas chamas2 = new Chamas("esquerda",mundo);
                Chamas chamas3 = new Chamas("direita",mundo);
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

        if (vida.getTamanhoAtual()<=0)
        {
            mundo.ganhar();
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
            somChamas.play();
            ataqueChamas=true;
        }
        
    }
    
    //toda a lógica do ataque das bolas de Fogo está nessa função
    private void ataqueBolasDeFogo()
    {
        int random = 2*(1+Greenfoot.getRandomNumber(4));
        
        for(int i=2; i<=8; i+=2)
        {
            if(i!=random)
            {
                mundo.addObject(new BolaDeFogo(mundo), mundo.getWidth()*i/10, 20);
            }
        }
        somBolaDeFogo.play();
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
        Explosao Explosao1 = new Explosao(mundo);
        Explosao Explosao2 = new Explosao(mundo);
        if(pataNoAr == pata1)
        {
            mundo.addObject(Explosao1, mundo.getWidth()*2/10, mundo.getHeight()*7/10);
            mundo.addObject(Explosao2, mundo.getWidth()*4/10, mundo.getHeight()*7/10);
        }
        else if (pataNoAr == pata2)
        {
            mundo.addObject(Explosao1, mundo.getWidth()*6/10, mundo.getHeight()*7/10);
            mundo.addObject(Explosao2, mundo.getWidth()*8/10, mundo.getHeight()*7/10);
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
