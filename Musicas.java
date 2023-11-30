import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Musicas here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class Musicas {
    private GreenfootSound musicaDeFundo;

    /**
     * Construtor da classe Musicas.
     * 
     * @param musica o nome da música a ser reproduzida
     * @param volume o volume da música a ser reproduzida
     */
    public Musicas(String musica, int volume) {
        tocar(musica, volume);
    }

    /**
     * Toca a música especificada em loop com o volume fornecido.
     * 
     * @param musica a música a ser tocada
     * @param volume o volume da música (0-100)
     */
    private void tocar(String musica, int volume) {
        musicaDeFundo = new GreenfootSound(musica);
        try {
            musicaDeFundo.playLoop();
            musicaDeFundo.setVolume(volume);
        } catch (Exception e) {
            System.out.println("Ops.. não foi possível tocar os sons do jogo");
        }
    }

    /**
     * Para a reprodução da música de fundo.
     */
    public void parar() {
        musicaDeFundo.stop();
    }
}
