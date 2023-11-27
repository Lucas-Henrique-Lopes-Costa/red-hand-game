import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Espada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Espada extends Actor
{
    private MeuMundo mundo;
    private Jogador jogador;
    
    public Espada(MeuMundo mundo, Jogador jogador)
    {
        this.mundo=mundo;
        this.jogador=jogador;
    }
    
    /**
     * Act - do whatever the Espada wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(getY()<700)
        {
            setLocation(getX(), getY()+1);
        }
        
        if(getIntersectingObjects(Lenhador.class).size()==1)
        {
            mundo.setStatusJogador();
            mundo.removeObject(this);
            mundo.paraMusica();
            Greenfoot.setWorld(new HistoriaEspada(mundo, jogador));
        }
    }
    
    public boolean chanceAparecer()
    {
        if(Greenfoot.getRandomNumber(20) == 0 || mundo.obterPontos() == 50)
        {
                return true;
        }
        return false;
    }
    
}
