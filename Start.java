import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Menu inicial do jogo - Botão Start
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class Start extends Actor 
{
    StartWorld startWorld;
    /*
     * Construtor da classe Start
     */
    public Start() {
        getImage().scale(200, 100); // Redimensiona a imagem
    }
    
    /*
     * Construtor da classe Start com tamanho
     */
    public Start(int x, int y) {
        getImage().scale(x, y); // Redimensiona a imagem
    }

    /**
     * Act - do whatever the Lose wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Caso o usuário pressione ENTER ou clique com o mouse
        checkKeyPress();
    }
    
    public void checkKeyPress() {
            if (Greenfoot.isKeyDown("enter") || Greenfoot.mouseClicked(null)) {
                Greenfoot.setWorld(new HistoriaStart()); // Inicia o jogo de verdade
            }
            else if (Greenfoot.isKeyDown("j")) {
                Greenfoot.setWorld(new TutorialWorld()); // Inicia o tutorial
            }
    }
}
