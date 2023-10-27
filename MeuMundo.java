import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MeuMundo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MeuMundo extends World
{

    /**
     * Constructor for objects of class MeuMundo.
     * 
     */
    public MeuMundo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 750, 1); 
        prepare();
    }
    
    /**
     * Prepara o mundo para o início do programa.
     * Ou seja: criar os objetos iniciais e adicioná-los ao mundo.
     */
    private void prepare()
    {
        Lenhador lenhador = new Lenhador();
        addObject(lenhador,128,465);
        TroncoNormal troncoNormal = new TroncoNormal();
        addObject(troncoNormal,389,407);
        TroncoNormal troncoNormal2 = new TroncoNormal();
        addObject(troncoNormal2,388,190);
    }
}
