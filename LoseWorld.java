import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoseWorld here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class LoseWorld extends World {
    /**
     * Constructor for objects of class LoseWorld.
     * 
     */
    public LoseWorld(int xLapide, int yLapide, int score, int tamanhoX,
            int tamanhoY, String imagem) {
        super(tamanhoX, tamanhoY, 1);
        setBackground(imagem);
        Prepare(xLapide, yLapide, score);
    }

    private void Prepare(int xLapide, int yLapide, int score) {

        // Aparece o Lose no meio da tela
        Lose lose = new Lose();
        addObject(lose, getWidth() / 2, getHeight() / 2);

        // Aparece a pontuação na imagem do Lose
        showText("Seus pontos: " + score, getWidth() / 2, 450);

        // Troca o personagem pela lapide
        Lapide lapide = new Lapide();
        addObject(lapide, xLapide, yLapide);

        showText("Pressione ENTER para reiniciar o jogo", getWidth() / 2, 675);
        showText("Pressione ESPAÇO para ver a lista de pontuação", getWidth() / 2, 700);
        showText("Pressione J para retornar ao tutorial", getWidth() / 2, 725);
    }

    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            // Inicia o jogo da arvore novamente
            Greenfoot.setWorld(new MeuMundo());
        } else if (Greenfoot.isKeyDown("space")) {
            // Visualiza a pontuação
            Greenfoot.setWorld(new Pontuacao());
        } else if (Greenfoot.isKeyDown("j"))

        { // Inicia o tutorial
            Greenfoot.setWorld(new TutorialWorld());
        }
    }
}
