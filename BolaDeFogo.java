import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BolaDeFogo here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class BolaDeFogo extends Projetil {
    private int indiceImagem = 0;

    /**
     * Construtor da classe BolaDeFogo.
     * Cria uma nova instância de BolaDeFogo associada a um mundo específico.
     * 
     * @param mundo O mundo do dragão ao qual a bola de fogo pertence.
     */
    public BolaDeFogo(MundoDragao mundo) {
        super(mundo);
    }

    /**
     * Act - do whatever the BolaDeFogo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        animar();
        setLocation(getX(), getY() + 5);
        if (isAtEdge()) {
            getWorld().removeObject(this);
        } else {
            super.conferePerder();
        }
    }

    /**
     * Método responsável por animar a bola de fogo.
     * A cada chamada do método, a imagem da bola de fogo é alterada de acordo com o
     * índice atual.
     * Caso o índice atinja o valor máximo, a imagem é reiniciada.
     */
    private void animar() {
        if (indiceImagem < 7) {
            setImage("BolaDeFogo1.png");
            indiceImagem++;
        } else if (indiceImagem < 14) {
            setImage("BolaDeFogo2.png");
            indiceImagem++;
        } else if (indiceImagem < 21) {
            setImage("BolaDeFogo3.png");
            indiceImagem++;
        } else if (indiceImagem < 28) {
            setImage("BolaDeFogo2.png");
            indiceImagem++;
        } else {
            indiceImagem = 0;
        }
    }
}
