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

    /**
     * Construtor da classe Guerreiro.
     * 
     * @param dragao o Dragão que o Guerreiro irá atacar
     * @param mundo  o Mundo em que o Guerreiro está
     */
    public Guerreiro(Dragao dragao, MundoDragao mundo) {
        atacando = false;
        contAtaque = 0;

        this.dragao = dragao;
        this.mundo = mundo;
    }

    /**
     * Executa as ações do Guerreiro.
     * Verifica se o Guerreiro está atacando ou se está se movendo.
     * Caso esteja atacando, anima o ataque.
     * Caso esteja se movendo, verifica se o jogador pressionou alguma tecla e
     * realiza a ação correspondente.
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

    /**
     * Verifica se o Guerreiro está atacando.
     * 
     * @return true se o Guerreiro está atacando, false caso contrário definindo na
     *         variável atacando.
     */
    private void atacar() {
        dragao.perderVida();
        atacando = true;
    }

    /**
     * Move o personagem para a direita.
     * Verifica se o personagem já está na borda direita do mundo antes de mover.
     * Caso contrário, move o personagem para a direita em uma distância
     * proporcional à largura do mundo.
     */
    private void moverDireita() {
        if (getX() != getWorld().getWidth() * 8 / 10) {
            setLocation(getX() + getWorld().getWidth() * 2 / 10, getY());
        }
    }

    /**
     * Move o personagem para a esquerda.
     * Verifica se o personagem já está na borda esquerda do mundo antes de mover.
     * Caso contrário, move o personagem para a esquerda em uma distância
     * proporcional à largura do mundo.
     */
    private void moverEsquerda() {
        if (getX() != getWorld().getWidth() * 2 / 10) {
            setLocation(getX() - getWorld().getWidth() * 2 / 10, getY());
        }
    }

    /**
     * Arruma a direção do personagem.
     * Verifica se o personagem está na borda direita ou esquerda do mundo e
     * posiciona o personagem de acordo com a posição.
     */
    private void arrumarDirecao() {
        if (getX() == mundo.getWidth() * 4 / 10
                || getX() == mundo.getWidth() * 8 / 10) {
            setImage("guerreiro0.png");
        } else {
            setImage("guerreiroInvertido0.png");
        }
    }

    /**
     * Anima o ataque do Guerreiro.
     * Alterna entre as imagens do ataque para dar a impressão de movimento.
     * 
     * @param complemento o complemento do nome da imagem do Guerreiro
     */
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
