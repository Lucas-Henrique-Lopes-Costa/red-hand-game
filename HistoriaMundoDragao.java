import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HistoriaMundoDragao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HistoriaMundoDragao extends World
{
    
    /**
     * Constructor for objects of class HistoriaMundoDragao.
     * 
     */
    public HistoriaMundoDragao()
    {    
        super(750, 750, 1); 
        
        PassaHistoriaEspada2 passa2 = new PassaHistoriaEspada2();
        addObject(passa2, 10000, 430);
    }
}
