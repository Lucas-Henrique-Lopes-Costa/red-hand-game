import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PataDragao here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class PataDragao extends Actor {
    /**
     * Construtor da classe PataDragao.
     * 
     * @param imagem o caminho da imagem da pata de dragão
     */
    public PataDragao(String imagem) {
        setImage(imagem);
    }

    /**
     * Atualiza a posição da pata de dragão.
     */
    public void act() {
        if (getY() != getWorld().getHeight() * 4 / 5) {
            setLocation(getX(), getY() + 5);
        }
    }

    /**
     * Move o objeto para cima, definindo sua nova posição vertical.
     */
    public void subir() {
        setLocation(getX(), getWorld().getHeight() * 3 / 10);
    }

    /**
     * Verifica se a pata do dragão está parada.
     * 
     * @return true se a pata estiver parada, caso contrário, retorna false.
     */
    public boolean estaParada() {
        if (getY() == getWorld().getHeight() * 8 / 10)
            return true;

        return false;
    }
}
