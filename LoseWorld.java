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
            if(score>0)
            {
                score--;
            }
            showText("Seus pontos: " + score, 375, 450);

            // Troca o lenhador pela lapide
            Lapide lapide = new Lapide();
            addObject(lapide, xLapide, yLapide);
            
            //Reinicia o jogo
            showText("Pressione ENTER para reiniciar o jogo", 375, 700);
            
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space") || Greenfoot.mouseClicked(null)) {
            Greenfoot.setWorld(new MeuMundo()); // Inicia o jogo de verdade
        }
    }
}
