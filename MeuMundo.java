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
    
    private Lenhador lenhador = new Lenhador();
    private Timer timer = new Timer();

    private static int score;
    private boolean gameOver;

    // Sons
    private GreenfootSound somMadeira;
    private GreenfootSound musicaDeFundo;
    private boolean musicaDeFundoIniciada = false;

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

        gameOver = false; // Define o jogo como não finalizado
    }

    /**
     * Prepara o mundo para o início do programa.
     * Ou seja: criar os objetos iniciais e adicioná-los ao mundo.
     */
    private void prepare() {
        score = 0;
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

        Arvore.addTronco(tronco1);
        Arvore.addTronco(tronco2);
        Arvore.addTronco(tronco3);
        Arvore.addTronco(tronco4);
        Arvore.addTronco(tronco5);

        setPaintOrder(Timer.class, TroncoNormal.class); // Define a ordem de pintura dos objetos
        addObject(timer, 375, 50);
    }

    /**
     * Act - do whatever the TroncoNormal wants to do. This method is called
     * whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Teste do mundo do dragao
        
        if(score==1)
        {
            Greenfoot.setWorld(new MundoDragao());
        }
        
        
        boolean gameOver = false;

        // inciar a musica de fundo
        if (!musicaDeFundoIniciada) {
            musicaDeFundo.playLoop();
            musicaDeFundoIniciada = true;
        }

        // Lenhador está/vai para a direita e bate
        // E o tronco voa para a esquerda
        String aux = checarLado(); // Verifica se o jogador apertou alguma tecla
        if(aux!=null)
        {
            if (aux.equals("direita")) 
            {
                TroncoNormal tronco0 = Arvore.getTronco(0);
    
                // Verifica se o tronco que vai cair tem um galho para a direita
                if (Arvore.getTronco(1).getLado().equals("direita")) {
                    gameOver = true; 
                }
                
                tronco0.mover();
                Arvore.removeTronco(0);
                
                //Move todos os troncos da árvore para baixo
                Arvore.cair();
    
                criaTronco(); // Cria um novo tronco no topo
                timer.aumentaTempo(); // Aumenta o tempo do jogo
                score++; // Aumenta a pontuação
            }

            // Lenhador está/vai para a esquerda e bate
            // E o tronco voa para a direita
            if (aux.equals("esquerda")) 
            {
                TroncoNormal tronco0 = Arvore.getTronco(0);

                // Verifica se o tronco que vai cair tem um galho para a esquerda
                if (Arvore.getTronco(1).getLado().equals("esquerda")) 
                {
                    gameOver = true;
                }
            
                tronco0.moverDireita();
                tronco0.mover(); 
                Arvore.removeTronco(0);
    
                //Move todos os troncos da árvore para baixo
                Arvore.cair();
    
                criaTronco(); // Cria um novo tronco no topo
                timer.aumentaTempo(); // Aumenta o tempo do jogo
                score++; // Aumenta a pontuação
            }
        }
        

        morreu(gameOver); // Verifica se o jogador perdeu
    }

    /*
     * Verifica se o jogador perdeu
     */
    public void morreu(boolean gameOver) {
        if (gameOver || timer.getTempo() <= 0) 
        {
            // Cria um texto vazio na frente dos pontos
            // Isso porque o Greenfoot não tem um método para apagar o texto
            showText("", 375, 200);

            // Aparece o Lose no meio da tela
            Lose lose = new Lose();
            setPaintOrder(Lose.class, TroncoNormal.class);
            addObject(lose, 375, 375);

            // Aparece a pontuação na imagem do Lose
            showText("Seus pontos: " + (score - 1), 375, 450);

            // Troca o lenhador pela lapide
            Lapide lapide = new Lapide();
            addObject(lapide, lenhador.getX(), lenhador.getY());
            removeObject(lenhador);

            // Para o Jogo
            Greenfoot.stop();

            // Remove todos os troncos
            Arvore.limpa();
            removeObjects(getObjects(TroncoNormal.class));
            removeObjects(getObjects(BaseTronco.class));

            // TODO: #14 aparecer botão para reiniciar o jogo
            // Start start = new Start(200, 100);
            // addObject(start, 375, 650);
        } 
        else 
        {
            // Mostra a pontuação no topo da tela
            showText("Pontos: " + score, 375, 200);
        }
    }
    
    /*
     * Cria um novo tronco no topo
     */
    public void criaTronco() {
        int random = Greenfoot.getRandomNumber(11); // Gera um número aleatório entre 0 e 10

        if (random < 2) { // 20% de chance de cair um tronco com galho para a esquerda
            TroncoNormal tronco = new TroncoNormal("esquerda");
            addObject(tronco, 317, -40);
            Arvore.addTronco(tronco);
        } else if (random > 8) { // 20% de chance de cair um tronco com galho para a direita
            TroncoNormal tronco = new TroncoNormal("direita");
            addObject(tronco, 442, -40);
            Arvore.addTronco(tronco);
        } else { // 60% de chance de cair um tronco normal
            TroncoNormal tronco = new TroncoNormal("normal");
            addObject(tronco, 380, -40);
            Arvore.addTronco(tronco);
        }
    }


    /*
     * Verifica se o jogador apertou alguma tecla
     */
    public String checarLado() {
        String tecla = Greenfoot.getKey(); // Verifica se o jogador apertou alguma tecla
        if (tecla != null) {
            // TODO: #12 Melhorar os sons, está com muito delay quando descomenta e ativa
            // eles quando batemos na madeira
            if (tecla.equals("left")) {
                // somMadeira.play();
                return "esquerda";
            } else if (tecla.equals("right")) {
                // somMadeira.play();
                return "direita";
            } else {
                return null;
            }

        }
        return null;
    }

    
    /*
     * Retorna se o jogo acabou
     */
    public boolean getGameOver() {
        return gameOver;
    }
}