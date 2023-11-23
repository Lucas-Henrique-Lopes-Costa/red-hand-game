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
        // Verifica se o tronco que vai cair tem um galho para a direita
        if (arvore.getTronco(1).getLado().equals("esquerda")) 
        {
            mundo.gameOver(true); 
        }
        
        arvore.bater(true);
        
        //Adiciona 1 na pontuação
        mundo.aumentaPontos();
        mundo.aumentaTempo();
    }
    
    private void acontecimentosDireita()
    {
        // Verifica se o tronco que vai cair tem um galho para a direita
        if (arvore.getTronco(1).getLado().equals("direita")) 
        {
            mundo.gameOver(true); 
        }
        
        arvore.bater(false);
        
        //Adiciona 1 na pontuação
        mundo.aumentaPontos();
        mundo.aumentaTempo();
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