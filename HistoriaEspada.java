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
     * Constructor for objects of class HistoriaDragao.
     * 
     */
    public HistoriaEspada(MeuMundo mundo, Jogador jogador) {
        super(750, 750, 1);

        this.jogador = jogador;
        this.mundo = mundo;

    }

    public void act() {
        // Caso o usuário pressione ENTER, ESPAÇO ou clique com o mouse
        checkKeyPress();
    }

    public void checkKeyPress() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new HistoriaMundoDragao());// Inicia o mundo do dragão
        } else if (Greenfoot.isKeyDown("escape")) {
            Greenfoot.setWorld(mundo);
            HistoricoPontuacao.removeJogador(jogador);
        }
    }
}
