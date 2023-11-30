import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Programa principal do jogo
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class MeuMundo extends World {
    private Arvore arvore;
    private Lenhador lenhador;
    private Timer timer = new Timer();
    private Espada espada;

    private boolean espadaApareceu;

    private static boolean gameOver;

    private Jogador jogador = new Jogador();
    private int score;
    private int tempoDeVida;

    private Musicas musica;

    /**
     * Construtor para objetos da classe MeuMundo.
     */
    public MeuMundo() {
        // Cria um novo mundo com 750x750 células com um tamanho de célula de 1x1px.
        super(750, 750, 1);
        prepare(); // Monta o mundo

        gameOver = false; // Define o jogo como não finalizado
    }

    /**
     * Prepara o mundo para o início do programa.
     * Ou seja: criar os objetos iniciais e adicioná-los ao mundo.
     */
    private void prepare() {
        arvore = new Arvore(this);
        arvore.limpa();

        lenhador = new Lenhador(arvore, this);
        addObject(lenhador, 215, 663);

        posicionaTroncos();

        espadaApareceu = false;

        score = 0;
        tempoDeVida = 0;
        timer = new Timer();

        setPaintOrder(Timer.class, TroncoNormal.class); // Define a ordem de pintura dos objetos
        addObject(timer, 375, 50);

        // pergunta o nome do usuário
        String nome = Greenfoot.ask("Digite seu nome: ");
        if (nome.length() < 1 || nome == null)
            nome = "Anônimo";

        jogador.setNome(nome);

        musica = new Musicas("musicaArvore.wav", 30);
    }

    /**
     * Posiciona os troncos no mundo do jogo.
     */
    private void posicionaTroncos() {
        BaseTronco baseTronco = new BaseTronco();
        addObject(baseTronco, 378, 713);

        TroncoNormal tronco1 = new TroncoNormal("normal");
        addObject(tronco1, 377, 614);
        TroncoNormal tronco2 = new TroncoNormal("normal");
        addObject(tronco2, 377, 454);
        TroncoNormal tronco3 = new TroncoNormal("esquerda");
        addObject(tronco3, 314, 294);
        TroncoNormal tronco4 = new TroncoNormal("direita");
        addObject(tronco4, 439, 134);
        TroncoNormal tronco5 = new TroncoNormal("normal");
        addObject(tronco5, 377, -26);

        arvore.addTronco(tronco1);
        arvore.addTronco(tronco2);
        arvore.addTronco(tronco3);
        arvore.addTronco(tronco4);
        arvore.addTronco(tronco5);
    }

    /**
     * Executa as ações do jogo.
     * Verifica se o jogo acabou ou se o tempo do timer chegou a zero.
     * Chama o método "morreu()" caso o jogo tenha acabado.
     * Mostra a pontuação no topo da tela.
     * Atualiza o tempo de vida do jogador.
     * Diminui a quantidade de tempo do lenhador a cada 300 unidades de tempo de
     * vida.
     */
    public void act() {
        if (gameOver || timer.getTamanhoAtual() <= 0) {
            morreu(); // Verifica se o jogador perde
        }

        // Mostra a pontuação no topo da tela
        showText("Pontos: " + score, 375, 200);

        tempoDeVida++;

        if (tempoDeVida % 300 == 0) {
            lenhador.diminiuQuantidadeTempo();
        }
    }

    /**
     * Define o estado do jogo como "game over" ou não.
     * 
     * @param valor o valor booleano que indica se o jogo está "game over" ou não
     */
    public void gameOver(boolean valor) {
        gameOver = valor;
    }

    /**
     * Executa as ações necessárias quando o jogador perde.
     * Para a música, mostra a tela de "Lose" e adiciona o jogador na lista de
     * pontuação.
     */
    public void morreu() {
        musica.parar();

        Greenfoot.setWorld(new LoseWorld(lenhador.getX(),
                lenhador.getY(), score, 750, 750, "fundoPadrao.png"));

        jogador.setPontuacao(score);
        jogador.setTempo(tempoDeVida);
        HistoricoPontuacao.adicionarJogador(jogador);
    }

    /**
     * Retorna se o jogo acabou
     */
    public boolean getGameOver() {
        return gameOver;
    }

    /**
     * Para a reprodução da música.
     */
    public void paraMusica() {
        musica.parar();
    }

    /**
     * Aumenta a pontuação do jogo em 1.
     */
    public void aumentaPontos() {
        score++;
    }

    /**
     * Retorna a pontuação do jogo.
     * 
     * @return a pontuação do jogo
     */
    public int obterPontos() {
        return score;
    }

    /**
     * Aumenta o tempo do timer em uma quantidade específica.
     * 
     * @param quantidade a quantidade de tempo a ser adicionada ao timer
     */
    public void aumentaTempo(int quantidade) {
        timer.redimensiona(quantidade);
    }

    /**
     * Verifica a chance de aparecer uma espada no jogo.
     * Se a pontuação for maior que 20 e a espada tiver chance de aparecer,
     * uma nova espada é criada.
     */
    public void chanceEspada() {
        espada = new Espada(this, jogador);

        if (!espadaApareceu && score > 20 && espada.chanceAparecer()) {
            espadaApareceu = true;
            criaEspada();
        }
    }

    /**
     * Cria uma espada em uma posição aleatória no mundo.
     */
    private void criaEspada() {
        if (Greenfoot.getRandomNumber(1) == 0)
            addObject(espada, 215, 0);
        else
            addObject(espada, 530, 0);
    }

    /**
     * Define o status do jogador, atualizando sua pontuação e tempo de vida.
     * Adiciona o jogador ao histórico de pontuações.
     */
    public void setStatusJogador() {
        jogador.setPontuacao(score);
        jogador.setTempo(tempoDeVida);
        HistoricoPontuacao.adicionarJogador(jogador);
    }
}