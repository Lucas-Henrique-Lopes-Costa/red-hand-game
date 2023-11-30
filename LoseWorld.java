import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoseWorld here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class LoseWorld extends World {
    /**
     * This class represents the LoseWorld in the game.
     * It is responsible for initializing the LoseWorld with the given parameters.
     *
     * @param xLapide  The x-coordinate of the lapide.
     * @param yLapide  The y-coordinate of the lapide.
     * @param score    The score of the game.
     * @param tamanhoX The x-size of the LoseWorld.
     * @param tamanhoY The y-size of the LoseWorld.
     * @param imagem   The background image of the LoseWorld.
     */
    public LoseWorld(int xLapide, int yLapide, int score, int tamanhoX,
            int tamanhoY, String imagem) {
        super(tamanhoX, tamanhoY, 1);
        setBackground(imagem);
        Prepare(xLapide, yLapide, score);
    }

    /**
     * Prepara o mundo do jogo quando o jogador perde.
     * Exibe a tela de "Lose" no centro da tela, mostra a pontuação do jogador,
     * substitui o personagem pelo objeto "Lapide" e exibe instruções para
     * einiciar o jogo,
     * ver a lista de pontuação ou retornar ao tutorial.
     * 
     * @param xLapide a posição x da lapide no mundo do jogo
     * @param yLapide a posição y da lapide no mundo do jogo
     * @param score   a pontuação do jogador
     */
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

    /**
     * Executa ações com base nas teclas pressionadas pelo jogador.
     * Se a tecla "enter" for pressionada, inicia o jogo da árvore novamente.
     * Se a tecla "space" for pressionada, visualiza a pontuação.
     * Se a tecla "j" for pressionada, inicia o tutorial.
     */
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
