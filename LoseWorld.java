import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoseWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoseWorld extends World
{
    
    
    /**
     * Constructor for objects of class LoseWorld.
     * 
     */
    public LoseWorld(int xLapide, int yLapide, int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 750, 1);
        Prepare(xLapide, yLapide, score);
    }
    
    private void Prepare(int xLapide, int yLapide, int score) 
    {

            // Aparece o Lose no meio da tela
            Lose lose = new Lose();
            addObject(lose, 375, 375);

            // Aparece a pontuação na imagem do Lose
            showText("Seus pontos: " + (score - 1), 375, 450);

            // Troca o lenhador pela lapide
            Lapide lapide = new Lapide();
            addObject(lapide, xLapide, yLapide);

            // Remove todos os troncos
            Arvore.limpa();            
            //Reinicia o jogo
            showText("Pressione ENTER para reiniciar o jogo", 375, 700);
            
            
            // TODO: #14 aparecer botão para reiniciar o jogo
            // Start start = new Start(200, 100);
            // addObject(start, 375, 650);
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space") || Greenfoot.mouseClicked(null)) {
            Greenfoot.setWorld(new MeuMundo()); // Inicia o jogo de verdade
        }
    }
}
