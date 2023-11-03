import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Menu inicial do jogo
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class StartWorld extends World {
    /*
     * Construtor da classe StartWorld
     */
    public StartWorld() {
        super(750, 750, 1);

        Start start = new Start();
        addObject(start, 375, 375);

        Greenfoot.start(); // Inicia o jogo
    }

    /**
     * Act - do whatever the Lose wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        showText("Pressione ENTER para iniciar", 375, 675);

        // Caso o usuário pressione ENTER, ESPAÇO ou clique com o mouse
        if (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space") || Greenfoot.mouseClicked(null)) {
            Greenfoot.setWorld(new MeuMundo()); // Inicia o jogo de verdade
        }
    }
}
