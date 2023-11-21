import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Programa de contador de tempo
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class Timer extends Actor {
    // Atributos do contador
    private int tempo;
    private int larguraOriginal;

    private TroncoNormal tronco; // Atributo para acessar o método aumentaTempo() da classe TroncoNormal
    private GreenfootImage timer; // Imagem do contador

    /*
     * Construtor da classe Timer
     */
    public Timer() {
        // Inicializa os atributos
        tempo = 710;
        larguraOriginal = 710;
        timer = new GreenfootImage(larguraOriginal, 10);

        atualizaImagem(); // Gera a imagem do contador
    }

    /**
     * Act - do whatever the Lose wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Diminui o tempo do contador
        tempo -=1;
        atualizaImagem(); // Vai atualizando a imagem do contador
    }

    /*
     * Atualiza a imagem do contador
     */
    private void atualizaImagem() {
        timer.clear(); // Limpa a imagem do contador
        if (tempo > 0) { // Caso o tempo seja maior que 0
            if (tempo > 710) {
                tempo = 710;
            }
            int novaLargura = tempo; // Define a nova largura do contador
            timer.setColor(Color.RED);
            timer.fillRect(0, 0, novaLargura, 10);
        }
        setImage(timer); // Define a imagem do contador
    }

    /*
     * Aumenta o tempo do contador
     */
    public void aumentaTempo() {
        // Aumenta o tempo do contador em 15
        // É acionado quando o jogador pega um tronco
        tempo += 15;
        atualizaImagem();
    }

    /*
     * Retorna o tempo do contador
     */
    public int getTempo() {
        return tempo;
    }
}
