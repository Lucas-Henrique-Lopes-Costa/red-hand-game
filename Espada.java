import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Espada here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class Espada extends Actor {
    private MeuMundo mundo;
    private Jogador jogador;

    /**
     * Construtor da classe Espada.
     * 
     * @param mundo   O mundo do jogo.
     * @param jogador O jogador que está utilizando a espada.
     */
    public Espada(MeuMundo mundo, Jogador jogador) {
        this.mundo = mundo;
        this.jogador = jogador;
    }

    /**
     * Executa as ações da espada.
     * Move a espada para baixo e verifica se ela atingiu o lenhador.
     * Caso tenha atingido, remove a espada do mundo e inicia a história da espada.
     */
    public void act() {
        if (getY() < 700) {
            setLocation(getX(), getY() + 1);
        }

        if (getIntersectingObjects(Lenhador.class).size() == 1) {
            mundo.setStatusJogador();
            mundo.removeObject(this);
            mundo.paraMusica();
            Greenfoot.setWorld(new HistoriaEspada(mundo, jogador));
        }
    }

    /**
     * Verifica se a espada deve aparecer.
     * 
     * @return true se a espada deve aparecer, false caso contrário.
     */
    public boolean chanceAparecer() {
        if (Greenfoot.getRandomNumber(20) == 0 || mundo.obterPontos() == 50) {
            return true;
        }
        return false;
    }
}
