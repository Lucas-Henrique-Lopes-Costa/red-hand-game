import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialWorld here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class TutorialWorld extends World {
    /**
     * Constructor for objects of class TutorialWorld.
     * 
     */
    public TutorialWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 750, 1);
    }

    /**
     * Verifica se alguma tecla foi pressionada ou se o mouse foi clicado.
     * Se a tecla "enter" ou "space" for pressionada, ou se o mouse for clicado,
     * o mundo é alterado para a tela de início.
     */
    public void checkKeyPress() {
        if (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space") || Greenfoot.mouseClicked(null)) {
            Greenfoot.setWorld(new MeuMundo()); // volta para a tela de start
        }
    }

    /**
     * Executa a ação do mundo Tutorial.
     * Se a tecla "enter" for pressionada, cria uma instância de MeuMundo e define-o
     * como o mundo atual.
     * Em seguida, verifica se alguma outra tecla foi pressionada.
     */
    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            MeuMundo menu = new MeuMundo();
            Greenfoot.setWorld(menu);
            checkKeyPress();
        }
    }

}
