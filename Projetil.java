import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projetil here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class Projetil extends Actor {
    private MundoDragao mundo;

    /**
     * Construtor da classe Projetil.
     * 
     * @param mundo O mundo do dragão onde o projetil será lançado.
     */
    public Projetil(MundoDragao mundo) {
        this.mundo = mundo;
    }

    /**
     * Verifica se o projetil colidiu com o Guerreiro e realiza as ações correspondentes.
     */
    public void conferePerder() {
        if (getIntersectingObjects(Guerreiro.class).size() == 1) {
            getWorld().removeObject(this);
            mundo.perder();
        }
    }
}
