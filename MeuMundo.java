import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import greenfoot.GreenfootSound;

/**
 * Write a description of class MeuMundo here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */

public class MeuMundo extends World {
    private ArrayList<TroncoNormal> listaTroncos = new ArrayList<>();
    private Lenhador lenhador = new Lenhador();
    private static int score;
    Timer timer = new Timer();
    private GreenfootSound somEsquerda;
    private GreenfootSound somDireita;
    private GreenfootSound musicaDeFundo;
    private boolean musicaDeFundoIniciada = false;

    /**
     * Constructor for objects of class MeuMundo.
     * 
     */
    public MeuMundo() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 750, 1);
        prepare();
        somEsquerda = new GreenfootSound("madeira1.mp3"); // Substitua "som_esquerda.mp3" pelo nome do arquivo de som da
                                                          // esquerda.
        // somDireita = new GreenfootSound("madeira1.mp3"); // Substitua
        // "som_direita.mp3" pelo nome do arquivo de som da direita.
        musicaDeFundo = new GreenfootSound("sounds2/somdofundo.mp3");
        musicaDeFundo.setVolume(25); // Define o volume da música de fundo (50 é metade do volume máximo).

    }

    /**
     * Prepara o mundo para o início do programa.
     * Ou seja: criar os objetos iniciais e adicioná-los ao mundo.
     */
    private void prepare() {
        score = 0;
        addObject(lenhador, 215, 663);

        BaseTronco baseTronco = new BaseTronco();
        addObject(baseTronco, 378, 713);

        TroncoNormal tronco1 = new TroncoNormal("normal");
        addObject(tronco1, 377, 614);

        TroncoNormal tronco2 = new TroncoNormal("normal");
        addObject(tronco2, 377, 454);

        TroncoNormal tronco3 = new TroncoNormal("esquerda");
        addObject(tronco3, 314, 294);

        TroncoNormal tronco4 = new TroncoNormal("direita");
        addObject(tronco4, 439, 134);

        TroncoNormal tronco5 = new TroncoNormal("normal");
        addObject(tronco5, 377, -26);

        listaTroncos.add(tronco1);
        listaTroncos.add(tronco2);
        listaTroncos.add(tronco3);
        listaTroncos.add(tronco4);
        listaTroncos.add(tronco5);

        setPaintOrder(Timer.class, TroncoNormal.class);
        addObject(timer, 375, 50);

    }

    public void act() {
        boolean gameOver = false;

        // inciar a musica de fundo
        if (!musicaDeFundoIniciada) {
            musicaDeFundo.playLoop();
            musicaDeFundoIniciada = true;
        }

        // Lenhador está/vai para a direita e bate
        // E o tronco voa para a esquerda
        String aux = checarLado();
        if (aux.equals("direita") && !listaTroncos.isEmpty()) {
            TroncoNormal tronco0 = listaTroncos.get(0);
            if (listaTroncos.get(1).getLado().equals("direita")) {
                gameOver = true;
            }
            tronco0.mudaGatilho("esquerda");
            listaTroncos.remove(0);
            for (int i = 0; i < listaTroncos.size(); i++) {
                listaTroncos.get(i).cair160();
            }
            criaTronco();
            score++;
            timer.aumentaTempo();
        }

        // Lenhador está/vai para a esquerda e bate
        // E o tronco voa para a direita
        if (aux.equals("esquerda") && !listaTroncos.isEmpty()) {
            TroncoNormal tronco0 = listaTroncos.get(0);
            if (listaTroncos.get(1).getLado().equals("esquerda")) {
                gameOver = true;
            }
            tronco0.mudaGatilho("direita");
            listaTroncos.remove(0);
            for (int i = 0; i < listaTroncos.size(); i++) {
                listaTroncos.get(i).cair160();
            }
            criaTronco();
            score++;
            timer.aumentaTempo();
        }

        if (gameOver) {
            showText("", 375, 200);
            // Aparece o Lose no meio da tela
            Lose lose = new Lose();
            setPaintOrder(Lose.class, TroncoNormal.class);
            addObject(lose, 375, 375);

            // Aparece a pontuação
            showText("Seus pontos: " + (score - 1), 375, 450);

            // Troca o lenhador pela lapide
            lenhador.trocarParaLapide();

            Greenfoot.stop();
        } else {
            showText("Pontos: " + score, 375, 200);
        }
    }

    public String checarLado() {
        String tecla = Greenfoot.getKey();
        if (tecla != null) {
            if (tecla.equals("left")) {
                somEsquerda.play();
                return "esquerda";
            } else if (tecla.equals("right")) {
                somEsquerda.play();
                return "direita";
            } else {
                return "nulo";
            }

        }
        return "0";
    }

    public boolean checarEsquerda() {
        String tecla = Greenfoot.getKey();
        if (tecla != null) {
            if (tecla.equals("left")) {
                somEsquerda.play();
                return true;
            }
        }

        return false;
    }

    public boolean checarDireita() {
        String tecla = Greenfoot.getKey();
        if (tecla != null) {
            if (tecla.equals("right")) {
                somEsquerda.play();
                return true;
            }
        }

        return false;
    }

    public void criaTronco() {
        int random = Greenfoot.getRandomNumber(11);
        {
            if (random < 2) {
                TroncoNormal tronco = new TroncoNormal("esquerda");
                addObject(tronco, 317, -40);
                listaTroncos.add(tronco);
            } else if (random > 8) {
                TroncoNormal tronco = new TroncoNormal("direita");
                addObject(tronco, 442, -40);
                listaTroncos.add(tronco);
            } else {
                TroncoNormal tronco = new TroncoNormal("normal");
                addObject(tronco, 380, -40);
                listaTroncos.add(tronco);
            }
        }
    }

}