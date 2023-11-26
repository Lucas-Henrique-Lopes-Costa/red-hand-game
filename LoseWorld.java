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
    
    public LoseWorld()
    {
        super(750, 750, 1);
        Prepare(0);
    }
    
    private void Prepare(int score) 
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

            //Reinicia o jogo
            showText("Pressione ENTER para reiniciar o jogo", 375, 700);

            // Ver pontuação
            showText("Pressione ESPAÇO para ver a lista de pontuação", 375, 725);
            
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
<<<<<<< Updated upstream

            // Ver pontuação
            showText("Pressione ESPAÇO para ver a lista de pontuação", 375, 725);
=======
            showText("Pressione J para retornar ao tutorial", 375, 725);
>>>>>>> Stashed changes
            
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new MeuMundo()); // Inicia o jogo de verdade
        }
<<<<<<< Updated upstream
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new Pontuacao()); // Visualiza a pontuação
=======
        else if (Greenfoot.isKeyDown("j")) {
            Greenfoot.setWorld(new TutorialWorld()); // Inicia o tutorial
>>>>>>> Stashed changes
        }
    }
}
