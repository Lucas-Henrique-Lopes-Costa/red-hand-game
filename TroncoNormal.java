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
    private String gatilho;

    /*
     * Construtor da classe TroncoNormal
     */
    public TroncoNormal(String tipo) {
        if (tipo.equals("normal")) { // Caso o tipo seja normal
            setImage("troncoNormal.png");
            getImage().scale(160, 160);
            lado = tipo;
            gatilho = "";
        } else if (tipo.equals("esquerda")) { // Caso o tipo seja esquerda
            setImage("troncoGalho.png");
            getImage().scale(283, 160);
            lado = tipo;
            gatilho = "";

        } else if (tipo.equals("direita")) { // Caso o tipo seja direita
            setImage("troncoGalho.png");
            getImage().mirrorHorizontally();
            getImage().scale(283, 160);
            lado = tipo;
            gatilho = "";
        }
    }

    /**
     * Act - do whatever the TroncoNormal wants to do. This method is called
     * whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (gatilho.equals("direita")) { // Caso o gatilho seja direita
            setLocation(getX() + 15, getY()); // Move o tronco para a direita voando
            turn(20); // Gira o tronco
        } else if (gatilho.equals("esquerda")) {
            setLocation(getX() - 15, getY()); // Move o tronco para a esquerda voando
            turn(-20); // Gira o tronco
        }

        if (getX() < 100 || getX() > 650) { // Caso o tronco saia da tela
            getWorld().removeObject(this);
        }
    }

    /*
     * Retorna o lado do tronco
     */
    public String getLado() {
        return lado;
    }

    /*
     * Retorna o gatilho do tronco
     */
    public void cair160() {
        setLocation(getX(), getY() + 160); // Move o tronco 160 pixels para baixo
    }

    /*
     * Muda o gatilho do tronco para o lado passado como parâmetro
     */
    public void mudaGatilho(String qualLado) {
        gatilho = qualLado;
    }
}
