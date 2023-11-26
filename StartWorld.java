import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Menu inicial do jogo
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class StartWorld extends World {
    private HistoricoPontuacao historicoPontuacao;

    /*
     * Construtor da classe StartWorld
     */
    public StartWorld() {
        super(750, 750, 1);

        Start start = new Start();
        addObject(start, 375, 430);

        Greenfoot.start(); // Inicia o jogo
<<<<<<< Updated upstream
        prepare();

        historicoPontuacao = new HistoricoPontuacao();
=======
>>>>>>> Stashed changes
    }

    /**
     * Act - do whatever the Lose wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        showText("Pressione ENTER para iniciar", 375, 675);
        showText("Pressione J para abrir o tutorial", 375, 700);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void abreHistoria() 
    {
        
    }
}
