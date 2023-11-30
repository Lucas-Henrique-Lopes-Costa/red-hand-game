import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fogo here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class Explosao extends Projetil {
    private int tempoVivo;
    private int indiceImagem;

    /**
     * Construtor da classe Explosao.
     * Inicializa o tempo de vida e o índice da imagem da explosão.
     * 
     * @param mundo O mundo do dragão onde a explosão ocorre.
     */
    public Explosao(MundoDragao mundo) {
        super(mundo);
        tempoVivo = 0;
        indiceImagem = 0;
    }

    /**
     * Executa as ações da explosão.
     * Verifica se o tempo de vida da explosão chegou a 100 e remove a explosão do
     * mundo.
     * Caso contrário, verifica se o jogador perdeu o jogo.
     */
    public void act() {
        animar();
        tempoVivo++;

        if (tempoVivo == 100) {
            getWorld().removeObject(this);
        } else {
            super.conferePerder();
        }
    }

    /**
     * Anima a explosão.
     * Alterna entre as imagens da explosão para dar a impressão de movimento.
     */
    private void animar() {
        if (indiceImagem < 11) {
            setImage("nuvem1.png");
            indiceImagem++;
        } else if (indiceImagem < 22) {
            setImage("nuvem2.png");
            indiceImagem++;
        } else if (indiceImagem < 33) {
            setImage("nuvem3.png");
            indiceImagem++;
        } else if (indiceImagem < 44) {
            setImage("nuvem4.png");
            indiceImagem++;
        } else if (indiceImagem < 55) {
            setImage("nuvem5.png");
            indiceImagem++;
        } else if (indiceImagem < 66) {
            setImage("nuvem6.png");
            indiceImagem++;
        } else if (indiceImagem < 77) {
            setImage("nuvem7.png");
            indiceImagem++;
        } else if (indiceImagem < 88) {
            setImage("nuvem8.png");
            indiceImagem++;
        } else if (indiceImagem < 100) {
            setImage("nuvem9.png");
            indiceImagem++;
        } else {
            indiceImagem = 0;
        }
    }
}
