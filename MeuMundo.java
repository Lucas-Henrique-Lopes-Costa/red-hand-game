import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import greenfoot.GreenfootSound;

/**
 * Programa principal do jogo
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class MeuMundo extends World {
    // Atributos
    private Arvore arvore;
    private Lenhador lenhador;
    private Timer timer = new Timer();
    private Espada espada;

    private static int score;
    private static boolean gameOver;

    // Sons
    private GreenfootSound somMadeira;
    private GreenfootSound musicaDeFundo;
    private boolean musicaDeFundoIniciada = false;

    Jogador jogador = new Jogador();

    /**
     * Construtor para objetos da classe MeuMundo.
     */
    public MeuMundo() {
        // Cria um novo mundo com 750x750 células com um tamanho de célula de 1x1px.
        super(750, 750, 1);
        prepare(); // Monta o mundo
        
        // Define os sons
        somMadeira = new GreenfootSound("madeira1.mp3");
        musicaDeFundo = new GreenfootSound("somdofundo.mp3");
        musicaDeFundo.setVolume(25); // Define o volume da música de fundo
        
        iniciaMusica(musicaDeFundoIniciada); //inicia a musica
        
        gameOver = false; // Define o jogo como não finalizado
    }

    /**
     * Prepara o mundo para o início do programa.
     * Ou seja: criar os objetos iniciais e adicioná-los ao mundo.
     */
    private void prepare() 
    {
        arvore = new Arvore(this);
        arvore.limpa();
        
        lenhador = new Lenhador(arvore, this);
        
        espada = new Espada(this);
        
        score = 0;
        timer = new Timer();
        addObject(lenhador, 215, 663);

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

        setPaintOrder(Timer.class, TroncoNormal.class); // Define a ordem de pintura dos objetos
        addObject(timer, 375, 50);

        // pergunta o nome do usuário
        String nome = Greenfoot.ask("Digite seu nome: ");
        if(nome.length() <= 1 || nome == null)
        nome = "Anônimo";

        jogador.setNome(nome);
    }
    
    /**
     * inciar a musica de fundo
     */
    public void iniciaMusica (boolean musicaDeFundoIniciada) 
    {
        if(!musicaDeFundoIniciada){
            musicaDeFundo.playLoop();
            musicaDeFundoIniciada = true;
        }
    }

    /**
     * Act - do whatever the TroncoNormal wants to do. This method is called
     * whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // inciar a musica de fundo
        if (!musicaDeFundoIniciada) 
        {
            musicaDeFundo.playLoop();
            musicaDeFundoIniciada = true;
        }

        if (gameOver || timer.getTamanhoAtual() <= 0)
        {
            morreu(); // Verifica se o jogador perdeu
        }
        
        // Mostra a pontuação no topo da tela
        showText("Pontos: " + score, 375, 200);

    }
    
    public static void gameOver(boolean valor)
    {
        gameOver=valor;
    }
    
    /**
     * Verifica se o jogador perdeu
     */
    public void morreu() 
    {
        jogador.setPontuacao(score);
        musicaDeFundo.stop();
        Greenfoot.setWorld(new LoseWorld(lenhador.getX(), lenhador.getY(), score));

        HistoricoPontuacao.adicionarJogador(jogador);

    }
    
    /**
     * Retorna se o jogo acabou
     */
    public boolean getGameOver() {
        return gameOver;
    }
    
    public void paraMusica() {
        musicaDeFundo.stop();
    }
    
    public void aumentaPontos()
    {
        score++;
    }
    
    public int obterPontos()
    {
        return score;
    }
    
    //Incrementa a barra do tempo
    public void aumentaTempo()
    {
        timer.redimensiona(25);
    }
    
    public void chanceEspada()
    {
        if(score == 2)
        {
            espada.chanceAparecer();
        }
    }
}