import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MundoDragao here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class MundoDragao extends World {
    private Musicas musica;
    private Guerreiro guerreiro;
    private Dragao dragao;

    private Jogador jogador = HistoricoPontuacao.pegaUltimoJogador();
    private int score;
    private int tempoDeVida;

    /**
     * Constructor for objects of class MundoDragao.
     * 
     */
    public MundoDragao() {
        super(1200, 750, 1);

        dragao = new Dragao(this);
        addObject(dragao, getWidth() / 2, 350);

        guerreiro = new Guerreiro(dragao, this);
        addObject(guerreiro, getWidth() * 4 / 10, getHeight() * 7 / 10 - 15);

        Muro muro = new Muro();
        addObject(muro, getWidth() / 2, getHeight() * 8 / 10);

        musica = new Musicas("musicaDragao.wav", 40);

        this.score = jogador.getPontuacao();
        this.tempoDeVida = jogador.getTempo();
    }

    public void act() {
        showText("Pontos: " + score, getWidth() / 2, 200);
        tempoDeVida++;
    }

    public void perder() {
        musica.parar();
        Greenfoot.setWorld(new LoseWorld(guerreiro.getX(),
                guerreiro.getY() + 10, score, 1200, 750, "fundoDragao.jpeg"));

        jogador.setPontuacao(score);
        jogador.setTempo(tempoDeVida);
    }

    public void ganhar() {
        musica.parar();
        Greenfoot.setWorld(new TelaVitoria());

        jogador.setPontuacao(score + 10);
        jogador.setTempo(tempoDeVida);
    }

    public void aumentaScore(int quantidade) {
        score += quantidade;
    }
}
