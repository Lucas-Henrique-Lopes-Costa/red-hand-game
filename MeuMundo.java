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
        TroncoNormal troncoNormal = new TroncoNormal();
        addObject(troncoNormal,652,628);
        TroncoNormal troncoNormal2 = new TroncoNormal();
        addObject(troncoNormal2,651,504);
        TroncoNormal troncoNormal3 = new TroncoNormal();
        addObject(troncoNormal3,650,383);
        TroncoGalho troncoGalho = new TroncoGalho();
        addObject(troncoGalho,720,374);
        troncoGalho.setLocation(790,270);
        troncoGalho.setLocation(780,265);
        troncoGalho.setLocation(656,268);
        TroncoNormal troncoNormal4 = new TroncoNormal();
        addObject(troncoNormal4,660,174);
        TroncoGalho troncoGalho2 = new TroncoGalho();
        addObject(troncoGalho2,652,68);
        lenhador.setLocation(744,609);
        lenhador.setLocation(820,632);
        lenhador.setLocation(737,609);
        lenhador.setLocation(844,588);
        lenhador.setLocation(787,591);
        troncoNormal.setLocation(700,561);
        troncoNormal2.setLocation(710,469);
        troncoNormal3.setLocation(726,375);
        troncoGalho.setLocation(690,246);
        troncoNormal4.setLocation(686,164);
        troncoGalho2.setLocation(692,52);
        lenhador.setLocation(663,588);
        lenhador.setLocation(653,496);
        troncoNormal3.setLocation(652,348);
        troncoNormal4.setLocation(680,162);
        troncoGalho.setLocation(675,232);
        troncoNormal4.setLocation(679,130);
        troncoGalho2.setLocation(696,32);
        troncoNormal4.setLocation(713,124);
        troncoGalho.setLocation(682,217);
        troncoNormal3.setLocation(688,329);
        troncoNormal2.setLocation(700,443);
        troncoNormal.setLocation(689,566);
        lenhador.setLocation(921,542);
        lenhador.setLocation(789,568);
    }
}
