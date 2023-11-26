import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MundoDragao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MundoDragao extends World
{
    /**
     * Constructor for objects of class MundoDragao.
     * 
     */
    public MundoDragao()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 750, 1);
        
        Dragao dragao = new Dragao();
        addObject(dragao, getWidth()/2, 350);
        
        Guerreiro guerreiro = new Guerreiro(dragao);
        addObject(guerreiro, getWidth()*4/10, getHeight()*7/10-15);
        
        Muro muro = new Muro();
        addObject(muro,getWidth()/2, getHeight()*8/10);
        
        Musicas musica = new Musicas("musicaDragao.mp3");
    }
}
