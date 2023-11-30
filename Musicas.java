import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Musicas here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class Musicas
{
    private GreenfootSound musicaDeFundo;
    
    public Musicas(String musica, int volume)
    {
        tocar(musica,volume);
    }
    
    private void tocar(String musica, int volume)
    {
        musicaDeFundo = new GreenfootSound(musica);
        try 
        {
            musicaDeFundo.playLoop();
            musicaDeFundo.setVolume(volume);
        }
        catch (Exception e) 
        {
            System.out.println("Ops.. não foi possível tocar os sons do jogo");
        }
    }
    
    public void parar()
    {
        musicaDeFundo.stop();
    }
}
