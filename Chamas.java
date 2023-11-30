import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chamas here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class Chamas extends Projetil {
    private String direcao;

    /**
     * Constructor for objects of class Chamas
     * 
     * @param direcao direcao que a chama vai seguir
     * @param mundo   mundo que a chama vai ser criada
     */
    public Chamas(String direcao, MundoDragao mundo) {
        super(mundo);
        this.direcao = direcao;
    }

    /**
     * Executa a ação do objeto Chamas.
     * Move o objeto em uma direção específica e verifica se atingiu o limite
     * inferior do mundo.
     * Caso tenha atingido, remove o objeto do mundo. Caso contrário, verifica se o
     * jogador perdeu o jogo.
     */
    public void act() {
        World mundo = getWorld();
        if (direcao.equals("direita")) {
            turnTowards(mundo.getWidth() * 6 / 10, mundo.getHeight());
        } else if (direcao.equals("esquerda")) {
            turnTowards(mundo.getWidth() * 4 / 10, mundo.getHeight());
        } else {
            turnTowards(mundo.getWidth() / 2, mundo.getHeight());
        }
        move(3);

        if (getY() > mundo.getHeight() * 4 / 5) {
            mundo.removeObject(this);
        } else {
            super.conferePerder();
        }
    }
}
