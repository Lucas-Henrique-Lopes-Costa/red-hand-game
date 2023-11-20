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
        addObject(dragao, getWidth()/2, 375);
        
        Guerreiro guerreiro = new Guerreiro();
        addObject(guerreiro, getWidth()*4/10, getHeight()*8/10);
        
        PataDragao pata1 = new PataDragao();
        addObject(pata1, getWidth()*1/10, getHeight()*8/10);
        PataDragao pata2 = new PataDragao();
        addObject(pata2, getWidth()*9/10, getHeight()*8/10);
    }
}
