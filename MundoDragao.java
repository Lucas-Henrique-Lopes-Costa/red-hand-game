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
     * Construtor da classe MundoDragao.
     * Inicializa o mundo com as dimensões especificadas.
     * Cria e adiciona os objetos dragão, guerreiro e muro ao mundo.
     * Inicializa a música de fundo.
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

    /**
     * Atualiza o mundo do jogo.
     * Exibe a pontuação atual na tela.
     * Incrementa o tempo de vida do mundo.
     */
    public void act() {
        showText("Pontos: " + score, getWidth() / 2, 200);
        tempoDeVida++;
    }

    /**
     * Método responsável por encerrar o jogo quando o jogador perde.
     * Para a reprodução da música de fundo e cria um novo mundo de derrota.
     * Atualiza a pontuação e o tempo de vida do jogador.
     */
    public void perder() {
        musica.parar();
        Greenfoot.setWorld(new LoseWorld(guerreiro.getX(),
                guerreiro.getY() + 10, score, 1200, 750, "fundoDragao.jpeg"));

        jogador.setPontuacao(score);
        jogador.setTempo(tempoDeVida);
    }

    /**
     * Método responsável por executar as ações necessárias quando o jogador ganha o
     * jogo.
     * Para isso, o método para a música de fundo, cria uma nova tela de vitória,
     * atualiza a pontuação do jogador e define o tempo de vida do jogador.
     */
    public void ganhar() {
        musica.parar();
        Greenfoot.setWorld(new TelaVitoria());

        jogador.setPontuacao(score + 10);
        jogador.setTempo(tempoDeVida);
    }

    /**
     * Aumenta o score do jogo.
     * 
     * @param quantidade a quantidade a ser adicionada ao score
     */
    public void aumentaScore(int quantidade) {
        score += quantidade;
    }
}
