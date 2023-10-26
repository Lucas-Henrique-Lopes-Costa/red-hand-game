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
        super(800, 600, 1); 
        // Cria uma imagem do tamanho do mundo
        GreenfootImage imagemFundoPreto = new GreenfootImage(800, 600);
        // Desenha um retângulo preto em toda a imagem
        imagemFundoPreto.setColor(Color.BLACK);
        imagemFundoPreto.fillRect(0, 0, 800, 600);
        // Define a imagem com o plano de fundo do mundo
        setBackground(imagemFundoPreto);
    }
}
