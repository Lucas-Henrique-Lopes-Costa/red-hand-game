import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projetil here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class Projetil extends Actor {
    private MundoDragao mundo;

    public Projetil(MundoDragao mundo) {
        this.mundo = mundo;
    }

    public void conferePerder() {
        if (getIntersectingObjects(Guerreiro.class).size() == 1) {
            getWorld().removeObject(this);
            mundo.perder();
        }
    }
}
