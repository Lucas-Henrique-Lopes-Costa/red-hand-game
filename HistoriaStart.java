import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HistoriaStart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HistoriaStart extends World
{

    /**
     * Constructor for objects of class HistoriaStart.
     * 
     */
    public HistoriaStart()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 750, 1);
        
        PassaHistoria passa = new PassaHistoria();
        addObject(passa, 1000, 430);
    }
}
