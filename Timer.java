import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Programa de contador de tempo
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class Timer extends Barras {
    
    /*
     * Construtor da classe Timer
     */
    public Timer() 
    {
        super(710);
    }

    /**
     * Act - do whatever the Lose wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        redimensiona(-1);
        atualizarImagem();
    }
}
