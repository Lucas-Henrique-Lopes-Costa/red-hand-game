import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lenhador extends Actor {

    private boolean ladoDireito;
    private boolean ladoEsquerdo;
    private GreenfootImage[] animationFrames;
    private int currentFrame;
    private int frameDirection;

    public Lenhador() {
        getImage().scale(250, 300);
        ladoDireito = true;
        ladoEsquerdo = true;

        // Initialize animation frames
        animationFrames = new GreenfootImage[3];
        for (int i = 0; i < animationFrames.length; i++) {
            animationFrames[i] = new GreenfootImage("lenhador" + i + ".png");
        }
        currentFrame = 0;
        frameDirection = 1;
    }

    public void act() {
        if (Greenfoot.isKeyDown("left")) {
            for (int i = 0; i < animationFrames.length; i++) {
                animationFrames[i] = new GreenfootImage("lenhador" + i + ".png");
            }
            setLocation(573, 568);
            getImage().scale(200, 200);
            ladoDireito = false;
            ladoEsquerdo = true;

            animate();

        } else if (Greenfoot.isKeyDown("right")) {
            for (int i = 0; i < animationFrames.length; i++) {
                animationFrames[i] = new GreenfootImage("lenhadorInvertido" + i + ".png");
            }
            setLocation(789, 568);
            getImage().mirrorHorizontally();
            getImage().scale(250, 300);
            ladoDireito = true;
            ladoEsquerdo = false;

            animate();

        }
    }

    private void animate() {
        currentFrame = 0;
        for (int i = 0; i <= 4; i++){
            setImage(animationFrames[currentFrame]);
            if (currentFrame == animationFrames.length - 1) {
                frameDirection = -1;
            } else if (currentFrame == 0) {
                frameDirection = 1;
            }
            Greenfoot.delay(10);
            currentFrame += frameDirection;
        }
        currentFrame = 0;
    }
}

