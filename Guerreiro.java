import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Guerreiro here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class Guerreiro extends Actor {
    private boolean atacando;
    private int contAtaque;
    private Dragao dragao;
    private MundoDragao mundo;

    public Guerreiro(Dragao dragao, MundoDragao mundo) {
        atacando = false;
        contAtaque = 0;

        this.dragao = dragao;
        this.mundo = mundo;
    }

    /**
     * Act - do whatever the Guerreiro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (atacando) {
            World mundo = getWorld();
            if (getX() == mundo.getWidth() * 4 / 10
                    || getX() == mundo.getWidth() * 8 / 10) {
                animar("");
            } else {
                animar("Invertido");
            }
        } else {
            // Posiciona o guerreiro corretamente
            arrumarDirecao();

            String tecla = Greenfoot.getKey();
            if (tecla != null) {
                if (tecla.equals("space")) {
                    atacar();
                } else if (tecla.equals("right")) {
                    moverDireita();
                } else if (tecla.equals("left")) {
                    moverEsquerda();
                }
            }
        }
    }

    private void atacar() {
        dragao.perderVida();
        atacando = true;
    }

    private void moverDireita() {
        if (getX() != getWorld().getWidth() * 8 / 10) {
            setLocation(getX() + getWorld().getWidth() * 2 / 10, getY());
        }
    }

    private void moverEsquerda() {
        if (getX() != getWorld().getWidth() * 2 / 10) {
            setLocation(getX() - getWorld().getWidth() * 2 / 10, getY());
        }
    }

    private void arrumarDirecao() {
        if (getX() == mundo.getWidth() * 4 / 10
                || getX() == mundo.getWidth() * 8 / 10) {
            setImage("guerreiro0.png");
        } else {
            setImage("guerreiroInvertido0.png");
        }
    }

    private void animar(String complemento) {
        if (contAtaque < 5) {
            contAtaque++;
            setImage("guerreiro" + complemento + "0.png");
        } else if (contAtaque < 10) {
            contAtaque++;
            setImage("guerreiro" + complemento + "1.png");
        } else if (contAtaque < 15) {
            contAtaque++;
            setImage("guerreiro" + complemento + "2.png");
        } else if (contAtaque < 20) {
            contAtaque++;
            setImage("guerreiro" + complemento + "1.png");

        } else if (contAtaque < 25) {
            contAtaque++;
            setImage("guerreiro" + complemento + "0.png");
        } else {
            contAtaque = 0;
            atacando = false;
            mundo.aumentaScore(10);
        }
    }
}
