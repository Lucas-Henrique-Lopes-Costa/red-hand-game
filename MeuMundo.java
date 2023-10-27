import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MeuMundo extends World
{
    public MeuMundo()
    {    
        // Cria um novo mundo com 800x600 células,
        // com células de tamanho 1x1 pixels.
        super(1200, 700, 1); 
        // Cria uma imagem do tamanho do mundo
        GreenfootImage imagemFundo = new GreenfootImage(1152, 1152);
        // Seta a imagem fundo
        setBackground("fundo.jpeg");
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Lenhador lenhador = new Lenhador();
        addObject(lenhador,532,510);
    }
}
