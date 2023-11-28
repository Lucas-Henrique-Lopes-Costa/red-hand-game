import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fogo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fogo extends Projetil
{
    private int tempoVivo;
    private int indiceImagem;
    
    public Fogo(MundoDragao mundo)
    {
        super(mundo);
        tempoVivo=0;
        indiceImagem=0;
    }
    
    /**
     * Act - do whatever the Fogo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        animar();
        tempoVivo++;
        
        if(tempoVivo==100)
        {
            getWorld().removeObject(this);
        }
        else
        {
            super.conferePerder();
        }
    }
    
    private void animar()
    {
        if(indiceImagem<7)
        {
            setImage("fogo1.png");
            indiceImagem++;
        }
        else if(indiceImagem<14)
        {
            setImage("fogo2.png");
            indiceImagem++;
        }
        else if (indiceImagem<21)
        {
            setImage("fogo3.png");
            indiceImagem++;
        }
        else
        {
            indiceImagem=0;
        }
    }
}
