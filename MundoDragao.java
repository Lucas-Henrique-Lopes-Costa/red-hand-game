import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MundoDragao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MundoDragao extends World
{
    private GreenfootSound musicaDeFundo;
    
    /**
     * Constructor for objects of class MundoDragao.
     * 
     */
    public MundoDragao()
    {    
        super(1200, 750, 1);
        
        Dragao dragao = new Dragao();
        addObject(dragao, getWidth()/2, 350);
        
        Guerreiro guerreiro = new Guerreiro(dragao);
<<<<<<< Updated upstream
        addObject(guerreiro, getWidth()*4/10, getHeight()*7/10-15);
        
        Muro muro = new Muro();
        addObject(muro,getWidth()/2, getHeight()*8/10);
=======
        addObject(guerreiro, getWidth()*4/10, getHeight()*8/10);
        
        musicaDeFundo = new GreenfootSound("megalovania.mp3");
        musicaDeFundo.setVolume(35); // Define o volume da música de fundo
        iniciaMusica();
    }
    
    public void iniciaMusica () 
    {
            musicaDeFundo.playLoop();
>>>>>>> Stashed changes
    }
}
