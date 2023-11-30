/**
 * Write a description of class Jogador here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class Jogador {
    private String nome;
    private int pontuacao;
    private int tempo;

    /**
     * Construtor padrão da classe Jogador.
     * Inicializa o nome, pontuação e tempo do jogador.
     */
    public Jogador() {
        nome = "";
        pontuacao = 0;
        tempo = 0;
    }

    /**
     * Define o tempo do jogador.
     * 
     * @param tempo o tempo a ser definido para o jogador
     */
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    /**
     * Define o nome do jogador.
     * 
     * @param nome o nome a ser definido para o jogador
     */
    public String getNome() {
        return nome;
    }

    
    /**
     * Retorna a pontuação do jogador.
     *
     * @return a pontuação do jogador
     */
    public int getPontuacao() {
        return pontuacao;
    }

    /**
     * Define o nome do jogador.
     * 
     * @param nome o nome do jogador
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define a pontuação do jogador.
     * 
     * @param pontuacao a pontuação a ser definida
     */
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    /**
     * Retorna o tempo atual do jogador.
     *
     * @return o tempo atual do jogador.
     */
    public int getTempo() {
        return tempo;
    }
}
