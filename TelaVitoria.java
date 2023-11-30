import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TelaVitoria here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class TelaVitoria extends World
{
    private Musicas musicaDeFundo;
    
    /**
     * Constructor for objects of class TelaVitoria.
     * 
     */
    public TelaVitoria()
    {    
        // Create a new world with 1200x750 cells with a cell size of 1x1 pixels.
        super(1200, 750, 1);

        // para a musica de fundo
        musicaDeFundo = new Musicas("vitoria.wav", 40);
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("escape"))
        {
            musicaDeFundo.parar();
            Greenfoot.setWorld(new MeuMundo());
        }
        else if (Greenfoot.isKeyDown("enter")) 
        {
            musicaDeFundo.parar();
            Greenfoot.setWorld(new Pontuacao()); 
        }
    }
}
