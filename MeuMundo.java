import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

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
    private void prepare() 
    {
        arvore = new Arvore(this);
        arvore.limpa();
        
        lenhador = new Lenhador(arvore, this);
        addObject(lenhador, 215, 663);
        
        posicionaTroncos();
        
        espadaApareceu=false;
        
        score = 0;
        tempoDeVida = 0;
        timer = new Timer();

        setPaintOrder(Timer.class, TroncoNormal.class); // Define a ordem de pintura dos objetos
        addObject(timer, 375, 50);

        // pergunta o nome do usuário
        String nome = Greenfoot.ask("Digite seu nome: ");
        if(nome.length() < 1 || nome == null)
        nome = "Anônimo";

        jogador.setNome(nome);
        
        musica = new Musicas("musicaArvore.mp3",30);
    }
    
    private void posicionaTroncos()
    {
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
     * Act - do whatever the TroncoNormal wants to do. This method is called
     * whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (gameOver || timer.getTamanhoAtual() <= 0)
        {
            morreu(); // Verifica se o jogador perdeu
        }
        
        // Mostra a pontuação no topo da tela
        showText("Pontos: " + score, 375, 200);
        
        tempoDeVida++;
    }
    
    public void gameOver(boolean valor)
    {
        gameOver=valor;
    }
    
    /**
     * Verifica se o jogador perdeu
     */
    public void morreu() 
    {
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
    
    public void paraMusica() {
        musica.parar();
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
        espada = new Espada(this, jogador);
        
        if(!espadaApareceu && score>20 && espada.chanceAparecer())
        {
            espadaApareceu=true;
            criaEspada();
        }
    }
    
    public void pararMusica()
    {
        musica.parar();
    }
    
    private void criaEspada()
    {
        if(Greenfoot.getRandomNumber(1)==0)
            addObject(espada, 215, 0);
        else
            addObject(espada, 530, 0);
    }
    
    public void setStatusJogador()
    {
        jogador.setPontuacao(score);
        jogador.setTempo(tempoDeVida);
        HistoricoPontuacao.adicionarJogador(jogador);
    }
}