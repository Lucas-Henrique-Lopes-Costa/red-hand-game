import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HistoriaDragao here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class HistoriaEspada extends World {
    private MeuMundo mundo;
    private Jogador jogador;

    /**
     * Classe que representa a história do jogo relacionada à espada.
     * 
     * @param mundo   O mundo do jogo.
     * @param jogador O jogador do jogo.
     */
    public HistoriaEspada(MeuMundo mundo, Jogador jogador) {
        super(750, 750, 1);

        this.jogador = jogador;
        this.mundo = mundo;
    }

    /**
     * Executa a ação principal do ator.
     * Verifica se o usuário pressionou ENTER, ESPAÇO ou clicou com o mouse.
     */
    public void act() {
        checkKeyPress();
    }

    /**
     * Verifica se alguma tecla foi pressionada e executa a ação correspondente.
     * Se a tecla "enter" for pressionada, inicia o mundo do dragão.
     * Se a tecla "escape" for pressionada, retorna ao mundo anterior e remove o
     * jogador do histórico de pontuação.
     */
    public void checkKeyPress() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new HistoriaMundoDragao());// Inicia o mundo do dragão
        } else if (Greenfoot.isKeyDown("escape")) {
            Greenfoot.setWorld(mundo);
            HistoricoPontuacao.removeJogador(jogador);
        }
    }
}
