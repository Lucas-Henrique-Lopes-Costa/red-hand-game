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
        GreenfootImage imagemFundoPreto = new GreenfootImage(800, 600);
        // Desenha um retângulo preto em toda a imagem
        imagemFundoPreto.setColor(Color.BLACK);
        imagemFundoPreto.fillRect(0, 0, 800, 600);
        // Define a imagem com o plano de fundo do mundo
        setBackground(imagemFundoPreto);
        prepare();
    }
    
    /**
     * Prepara o mundo para o início do programa.
     * Ou seja: criar os objetos iniciais e adicioná-los ao mundo.
     */
    private void prepare()
    {
        Lenhador lenhador = new Lenhador();
        addObject(lenhador,352,487);
        lenhador.setLocation(351,511);
        Lenhador lenhador2 = new Lenhador();
        addObject(lenhador2,351,511);
        lenhador.setLocation(431,433);
        Lenhador lenhador3 = new Lenhador();
        addObject(lenhador3,431,433);
        lenhador.setLocation(431,433);
        lenhador.setLocation(445,411);
        removeObject(lenhador3);
        lenhador.setLocation(383,544);
        removeObject(lenhador2);
        lenhador.setLocation(532,576);
        lenhador.setLocation(412,623);
        lenhador.setLocation(408,606);
        lenhador.setLocation(752,536);
        lenhador.setLocation(822,586);
    }
}
