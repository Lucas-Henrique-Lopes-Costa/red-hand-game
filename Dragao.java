import greenfoot.*; //  (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Dragao here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class Dragao extends Actor {
    private int temporizador;
    private boolean jaNasceu;
    private boolean ataquePata;
    private boolean ataqueChamas;
    private int temporizadorChamas;

    private Barras vida;
    private PataDragao pata1;
    private PataDragao pata2;
    private MundoDragao mundo;
    private PataDragao pataNoAr;

    // Sons do dragão
    private GreenfootSound somPata;
    private GreenfootSound somChamas;
    private GreenfootSound somBolaDeFogo;

    /**
     * Construtor da classe Dragao.
     * 
     * @param mundo O mundo em que o dragão está.
     */
    public Dragao(MundoDragao mundo) {
        ataquePata = false;
        jaNasceu = false;
        ataqueChamas = false;

        this.mundo = mundo;
        temporizador = 0;
        temporizadorChamas = 0;

        pata1 = new PataDragao("PATA DA ESQUERDA.png");
        pata2 = new PataDragao("PATA DA DIREITA.png");
        vida = new Barras(1000);

        Greenfoot.playSound("barulhoDragao.mp3");
        sons();
    }

    /**
     * Executa as ações do dragão.
     * Posiciona as patas do dragão no mundo e realiza ataques de forma periódica.
     * Verifica se o dragão está conjurando um ataque de pata ou de chamas e executa
     * a lógica necessária.
     * Verifica se a vida do dragão chegou a zero e aciona o método de vitória do
     * mundo.
     */
    public void act() {
        // Posiciona as duas patas do dragao no mundo
        if (!jaNasceu) {
            jaNasceu = true;

            mundo.addObject(pata1, mundo.getWidth() * 1 / 10, mundo.getHeight() * 4 / 5);
            mundo.addObject(pata2, mundo.getWidth() * 9 / 10, mundo.getHeight() * 4 / 5);
            mundo.addObject(vida, mundo.getWidth() / 2, mundo.getHeight() * 1 / 10);
        }

        // Lógica padrão do Dragão, ataca uma vez a cada 3 sec
        temporizador++;
        if (temporizador == 180) {
            temporizador = 0;
            randomizaAtaque();
        }

        // Condicional para ver se o dragão está conjurando um ataque de pata
        // Se sim, executa o lógica necessária para o ataque funcionar
        if (ataquePata) {
            if (pataNoAr.estaParada()) {
                somPata.play();
                explosoes();
                ataquePata = false;
            }
        } else if (ataqueChamas) {
            temporizadorChamas++;
            if (temporizadorChamas <= 1) {
                Chamas chamas1 = new Chamas("", mundo);
                Chamas chamas2 = new Chamas("esquerda", mundo);
                Chamas chamas3 = new Chamas("direita", mundo);
                mundo.addObject(chamas1, mundo.getWidth() / 2, mundo.getHeight() / 3);
                mundo.addObject(chamas2, mundo.getWidth() / 2, mundo.getHeight() / 3);
                mundo.addObject(chamas3, mundo.getWidth() / 2, mundo.getHeight() / 3);
            } else {
                temporizadorChamas = 0;
                ataqueChamas = false;
            }
        }

        // Verifica se a vida do dragão chegou a zero
        if (vida.getTamanhoAtual() <= 0) {
            mundo.ganhar();
        }
    }

    
    /**
     * Método responsável por inicializar os sons do dragão.
     */
    private void sons() {
        somPata = new GreenfootSound("pata.mp3");
        somPata.setVolume(40);
        somChamas = new GreenfootSound("chamas.mp3");
        somChamas.setVolume(80);
        somBolaDeFogo = new GreenfootSound("bolaDeFogo.mp3");
        somBolaDeFogo.setVolume(80);
    }

    /**
     * Método responsável por randomizar o ataque do dragão.
     * O dragão pode realizar um dos três ataques: ataque de bolas de fogo, subir a
     * pata ou ataque de chamas.
     * A escolha do ataque é feita de forma aleatória.
     */
    private void randomizaAtaque() {
        int random = Greenfoot.getRandomNumber(12);

        if (random < 4) {
            ataqueBolasDeFogo();
        } else if (random < 8) {
            subirPata();
        } else {
            somChamas.play();
            ataqueChamas = true;
        }
    }

    /**
     * Realiza o ataque de bolas de fogo.
     * Gera bolas de fogo em posições específicas no mundo do jogo, exceto em uma
     * posição aleatória.
     * Reproduz o som das bolas de fogo.
     */
    private void ataqueBolasDeFogo() {
        int random = 2 * (1 + Greenfoot.getRandomNumber(4));

        for (int i = 2; i <= 8; i += 2) {
            if (i != random) {
                mundo.addObject(new BolaDeFogo(mundo), mundo.getWidth() * i / 10, 20);
            }
        }
        somBolaDeFogo.play();
    }

    /**
     * Faz o dragão levantar uma das patas aleatoriamente.
     * A pata levantada será armazenada na variável pataNoAr.
     * O ataquePata será ativado.
     */
    private void subirPata() {
        int numero = Greenfoot.getRandomNumber(2);

        if (numero == 0) {
            pata1.subir();
            pataNoAr = pata1;
        } else {
            pata2.subir();
            pataNoAr = pata2;
        }

        ataquePata = true;
    }

    /**
     * Método responsável por criar e adicionar explosões no mundo do jogo.
     * As explosões são adicionadas em posições específicas, dependendo da pata do
     * dragão que está no ar.
     */
    private void explosoes() {
        Explosao Explosao1 = new Explosao(mundo);
        Explosao Explosao2 = new Explosao(mundo);
        if (pataNoAr == pata1) {
            mundo.addObject(Explosao1, mundo.getWidth() * 2 / 10, mundo.getHeight() * 7 / 10);
            mundo.addObject(Explosao2, mundo.getWidth() * 4 / 10, mundo.getHeight() * 7 / 10);
        } else if (pataNoAr == pata2) {
            mundo.addObject(Explosao1, mundo.getWidth() * 6 / 10, mundo.getHeight() * 7 / 10);
            mundo.addObject(Explosao2, mundo.getWidth() * 8 / 10, mundo.getHeight() * 7 / 10);
        }
    }

    /**
     * Realiza o ataque de lança-chamas.
     */
    private void ataqueLancaChamas() {
        World mundo = getWorld();
    }

    /**
     * Reduz a vida do dragão em 10 pontos.
     */
    public void perderVida() {
        vida.redimensiona(-10);
    }
}
