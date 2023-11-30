import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HistoriaMundoDragao here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class HistoriaMundoDragao extends World {
    private int timer = 6;
    private boolean possoClicar = false;

    /**
     * Construtor da classe HistoriaMundoDragao.
     * Inicializa a janela do jogo com as dimensões especificadas.
     */
    public HistoriaMundoDragao() {
        super(750, 750, 1);
    }

    /**
     * Executes the actions for the game character.
     * Checks for key presses and updates the timer.
     * Enables clicking after the timer reaches zero.
     */
    public void act() {
        checkKeyPress();
        if (timer > 0) {
            timer--;
            if (timer == 0) {
                possoClicar = true;
            }
        }
    }

    /**
     * Verifica se a tecla "enter" foi pressionada e inicia o mundo do dragão.
     */
    public void checkKeyPress() {
        if (possoClicar) {
            if (Greenfoot.isKeyDown("enter")) {
                Greenfoot.setWorld(new MundoDragao());// Inicia o mundo do dragão
            }
        }
    }
}
