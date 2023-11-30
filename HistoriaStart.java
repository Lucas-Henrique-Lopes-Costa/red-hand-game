import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HistoriaStart here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class HistoriaStart extends World {

    /**
     * Constructor for objects of class HistoriaStart.
     */
    public HistoriaStart() {
        // Create a new world with 750 x 750 cells with a cell size of 1x1 pixels.
        super(750, 750, 1);
    }

    /**
     * Executa a ação do objeto.
     * Verifica se o usuário pressionou ENTER, ESPAÇO ou clicou com o mouse.
     */
    public void act() {
        checkKeyPress();
    }

    /**
     * Verifica se a tecla "enter" foi pressionada.
     * Se a tecla for pressionada, inicia o jogo.
     */
    public void checkKeyPress() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new MeuMundo()); // Inicia o jogo
        }
    }
}
