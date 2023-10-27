import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lenhador extends Actor {
    
    private boolean ladoDireito;
    private boolean ladoEsquerdo;
    
    public Lenhador() {
        getImage().scale(200, 200);
        ladoDireito = true;
        ladoEsquerdo = true;
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("left")) {
            setImage("lenhador.png");
            setLocation(573, 568);
            getImage().scale(200, 200);
            ladoDireito = false;
            ladoEsquerdo = true;
            // Greenfoot.playSound("corte.wav");
        } else if (Greenfoot.isKeyDown("right")) {
            setImage("lenhador.png");
            setLocation(789, 568);
            getImage().mirrorHorizontally();
            getImage().scale(200, 200);
            ladoDireito = true;
            ladoEsquerdo = false;
            // Greenfoot.playSound("corte.wav");
        }
    }
    
    public void bater(boolean ladoDireito) {
        if (ladoDireito) {
            // bate do lado direito
        } else if (ladoEsquerdo) {
            // bate do lado esquerdo
        }
    }
}
