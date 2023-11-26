import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Musicas here.
 * 
 * @author (your name) 
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
        musicaDeFundo.playLoop();
        musicaDeFundo.setVolume(volume);
    }
    
    public void parar()
    {
        musicaDeFundo.stop();
    }
}
