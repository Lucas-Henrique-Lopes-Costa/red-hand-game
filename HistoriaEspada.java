import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HistoriaDragao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HistoriaEspada extends World
{

    /**
     * Constructor for objects of class HistoriaDragao.
     * 
     */
    public HistoriaEspada(MeuMundo mundo)
    {    
        super(750, 750, 1);
        
        PassaHistoriaEspada passa = new PassaHistoriaEspada(mundo);
        addObject(passa, 1000, 430);
    }
}
