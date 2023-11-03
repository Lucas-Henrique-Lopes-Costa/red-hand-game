import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BaseTronco here.
 * 
 * @Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class StartWorld extends World {
    public StartWorld() {
        super(750, 750, 1);

        Start start = new Start();
        addObject(start, 375, 375);

        Greenfoot.start();
    }

    public void act() {
        showText("Pressione ENTER para iniciar", 375, 675);

        if (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space") || Greenfoot.mouseClicked(null)) {
            Greenfoot.setWorld(new MeuMundo());
        }
    }
}
