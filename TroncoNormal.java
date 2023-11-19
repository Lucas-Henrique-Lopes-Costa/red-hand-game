import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Essa classe representa um tronco normal
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class TroncoNormal extends Actor {
    // Atributos da classe
    private String lado;
    private boolean mover;
    private boolean moverDireita;

    /*
     * Construtor da classe TroncoNormal
     */
    public TroncoNormal(String tipo) {
        if (tipo.equals("normal")) { // Caso o tipo seja normal
            setImage("troncoNormal.png");
            lado = tipo;
            mover=false;
        } else if (tipo.equals("esquerda")) { // Caso o tipo seja esquerda
            setImage("troncoGalho.png");
            lado = tipo;
            mover=false;
        } else if (tipo.equals("direita")) { // Caso o tipo seja direita
            setImage("troncoGalho.png");
            getImage().mirrorHorizontally();
            lado = tipo;
            mover=false;
        }
    }

    /**
     * Act - do whatever the TroncoNormal wants to do. This method is called
     * whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(mover)
        {
            if (moverDireita) 
            {   // Move o tronco para a direita voando e girando
                setLocation(getX() + 15, getY()); 
                turn(20); 
            } else  
            {   // Move o tronco para a esquerda voando e girando
                setLocation(getX() - 15, getY()); 
                turn(-20); 
            }
    
            if (getX() < 100 || getX() > 650) 
            { // Caso o tronco saia da tela
                getWorld().removeObject(this);
            }
        }
        
    }

    /**
     * Retorna o lado do galho do tronco
     */
    public String getLado() {
        return lado;
    }

    /**
     * Move o tronco 160 pixeis para baixo
     */
    public void cair160() {
        setLocation(getX(), getY() + 160); // Move o tronco 160 pixels para baixo
    }

    /**
     * Muda o booleano para o  tronco mover para a direita
     */
    public void moverDireita() {
        moverDireita=true;
    }
    
    public void mover()
    {
        mover=true;
    }
}
