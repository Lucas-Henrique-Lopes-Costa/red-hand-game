import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Musicas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Musicas
{
    private String nomeMusica;
    private GreenfootSound musicaDeFundo;
    
    public Musicas(String musica)
    {
        tocar(musica);
    }
    
    private void tocar(String musica)
    {
        musicaDeFundo = new GreenfootSound(musica);
        musicaDeFundo.playLoop();
        musicaDeFundo.setVolume(25);
    }
    
    public void parar()
    {
        musicaDeFundo.stop();
    }
}
