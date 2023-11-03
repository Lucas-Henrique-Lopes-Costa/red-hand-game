import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe que cuida da barra que domonstra quanto de experiencia o player acumulou apara aumentar de nivel
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    private int tempo;
    private int larguraOriginal;
    
    private TroncoNormal tronco;
    private GreenfootImage timer;
    
    
    public Timer() {
        tempo = 710;
        larguraOriginal = 710;
        timer = new GreenfootImage(larguraOriginal, 10);
        atualizaImagem();
    }
    
    public void act() {    
        tempo -=2;
        atualizaImagem();
    }
    
    private void atualizaImagem() {
        timer.clear();
        if (tempo > 0) {
            if(tempo>710)
            {
                tempo=710;
            }
            int novaLargura = tempo;
            timer.setColor(Color.RED);
            timer.fillRect(0, 0, novaLargura, 10);
        }
        setImage(timer);
    }
    
    public void aumentaTempo()
    {
        tempo+=15;
        atualizaImagem();
    }
    
    public int getTempo()
    {
        return tempo;
    }
}
