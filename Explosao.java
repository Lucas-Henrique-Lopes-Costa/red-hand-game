import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fogo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosao extends Projetil
{
    private int tempoVivo;
    private int indiceImagem;
    
    public Explosao(MundoDragao mundo)
    {
        super(mundo);
        tempoVivo=0;
        indiceImagem=0;
    }
    
    /**
     * Act - do whatever the Explosão wants to do. This method is called whenever
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
        if(indiceImagem<11)
        {
            setImage("nuvem1.png");
            indiceImagem++;
        }
        else if(indiceImagem<22)
        {
            setImage("nuvem2.png");
            indiceImagem++;
        }
        else if (indiceImagem<33)
        {
            setImage("nuvem3.png");
            indiceImagem++;
        }
        else if (indiceImagem<44)
        {
            setImage("nuvem4.png");
            indiceImagem++;
        }
        else if (indiceImagem<55)
        {
            setImage("nuvem5.png");
            indiceImagem++;
        }
        else if (indiceImagem<66)
        {
            setImage("nuvem6.png");
            indiceImagem++;
        }
        else if (indiceImagem<77)
        {
            setImage("nuvem7.png");
            indiceImagem++;
        }
        else if (indiceImagem<88)
        {
            setImage("nuvem8.png");
            indiceImagem++;
        }
        else if (indiceImagem<100)
        {
            setImage("nuvem9.png");
            indiceImagem++;
        }
        else
        {
            indiceImagem=0;
        }
    }
}
