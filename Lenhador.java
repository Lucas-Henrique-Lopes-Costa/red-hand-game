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
        //Verifica a morte do lenhador
        arvore.direcaoGalho("esquerda");
        
        //Aciona as ações necessárias para o funcionamento da arvore
        arvore.bater(true);
        
        //Adiciona tempo e um ponto
        mundo.aumentaPontos();
        mundo.aumentaTempo();
    }
    
    private void acontecimentosDireita()
    {
        //Verifica a morte do lenhador
        arvore.direcaoGalho("direita");
        
        //Aciona as ações necessárias para o funcionamento da arvore
        arvore.bater(false);
        
        //Adiciona tempo e um ponto
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