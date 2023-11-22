import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esse é o ator que representa o lenhador
 * Ele é responsável por fazer a animação do lenhador e movimentação
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class Lenhador extends Actor {
    // Atributos da classe
    private int contAnimacao;
    private boolean atacando;
    private Arvore arvore;
    private MeuMundo mundo;
    
    /**
     * Construtor da classe Lenhador
     */
    public Lenhador(Arvore arvore,MeuMundo mundo) 
    {
        this.arvore=arvore;
        this.mundo=mundo;
        atacando=false;
        contAnimacao=0;
    }

    /**
     * Act - do whatever the Lenhador wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        if(atacando)
        {
            if(getX() ==215)
            {
                animar("");
            }
            else
            {
                animar("Invertido");
            }
        }
        else
        {
            String tecla = Greenfoot.getKey();
            if(tecla!=null)
            {
                if(tecla.equals("left"))
                {
                    atacando=true;
                    posicionarEsquerda();
                }
                else if(tecla.equals("right"))
                {
                    atacando=true;
                    posicionarDireita();

                }   
            }
        }
    }
    
    private void acontecimentosEsquerda()
    {
        TroncoNormal tronco0 = arvore.getTronco(0);

<<<<<<< Updated upstream
        // Verifica se o tronco que vai cair tem um galho para a direita
        if (arvore.getTronco(1).getLado().equals("esquerda")) 
        {
            MeuMundo.gameOver(true); 
=======

    /*
     * Função da animação do lenhador
     */
    private void animate() {
        // Define o quadro atual como 0
        currentFrame = 0;

        // Loop que executa 5 vezes
        for (int i = 0; i <= 4; i++) {
            // Define a imagem do quadro atual
            setImage(animationFrames[currentFrame]);

            // Se o quadro atual for o último da animação, a direção do quadro é definida
            // como -1
            if (currentFrame == animationFrames.length - 1) {
                frameDirection = -1;
            }
            // Se o quadro atual for o primeiro da animação, a direção do quadro é definida
            // como 1
            else if (currentFrame == 0) {
                frameDirection = 1;
            }

            // Pausa a execução por 1 milissegundo
            // TODO: #11 melhorar forma da animação para não precisar usar delay
            Greenfoot.delay(1);

            // Atualiza o quadro atual com base na direção do quadro
            currentFrame += frameDirection;
>>>>>>> Stashed changes
        }
        
        //Adiciona 1 na pontuação
        mundo.aumentaPontos();
        mundo.aumentaTempo();
        
        tronco0.mover();
        tronco0.moverDireita();
        arvore.removeTronco(0);
        
        //Move todos os troncos da árvore para baixo
        arvore.cair();
        
        // Cria um novo tronco no topo
        arvore.criaTronco(); 
    }
    
    private void acontecimentosDireita()
    {
        TroncoNormal tronco0 = arvore.getTronco(0);

        // Verifica se o tronco que vai cair tem um galho para a direita
        if (arvore.getTronco(1).getLado().equals("direita")) 
        {
            MeuMundo.gameOver(true); 
        }
        
        //Adiciona 1 na pontuação
        mundo.aumentaPontos();
        mundo.aumentaTempo();
        
        tronco0.mover();
        arvore.removeTronco(0);
        
        //Move todos os troncos da árvore para baixo
        arvore.cair();
        
        // Cria um novo tronco no topo
        arvore.criaTronco(); 
    }
    
    private void posicionarEsquerda()
    {
        setLocation(215, getY());
    }
    
    private void posicionarDireita()
    {
        setLocation(530, getY());
    }
    
    private void animar(String complemento)
    {
        if(contAnimacao<3)
        {
            contAnimacao++;
            setImage("lenhador" + complemento + "0.png");
            getImage().scale(160,160);
        }
        else if(contAnimacao<6)
        {
            contAnimacao++;
            setImage("lenhador" + complemento + "1.png");
            getImage().scale(160,160);
        }
        else if(contAnimacao<9)
        {
            contAnimacao++;
            setImage("lenhador" + complemento + "2.png");
            getImage().scale(160,160);
        }
        else if(contAnimacao<12)
        {
            contAnimacao++;
            setImage("lenhador" + complemento + "1.png");
            getImage().scale(160,160);
        }
        else if(contAnimacao<15)
        {
            contAnimacao++;
            setImage("lenhador" + complemento + "0.png");
            getImage().scale(160,160);
        }
        else
        {
            if(complemento=="")
            {
                acontecimentosEsquerda();
            }
            
            else
            {
                acontecimentosDireita();
            }
            atacando=false;
            contAnimacao=0;
        }
    }
}