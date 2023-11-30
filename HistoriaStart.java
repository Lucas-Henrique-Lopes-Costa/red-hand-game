import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HistoriaStart here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class HistoriaStart extends World
{

    /**
     * Constructor for objects of class HistoriaStart.
     * 
     */
    public HistoriaStart()
    {    
        // Create a new world with 750 x 750 cells with a cell size of 1x1 pixels.
        super(750, 750, 1);
    }
    
    public void act() {
        // Caso o usuário pressione ENTER, ESPAÇO ou clique com o mouse
        checkKeyPress();
    }
    
    public void checkKeyPress() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new MeuMundo()); // Inicia o jogo de verdade
        }
    }
}
