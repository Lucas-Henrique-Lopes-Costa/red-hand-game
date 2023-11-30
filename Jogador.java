/**
 * Write a description of class Jogador here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class Jogador
{
    private String nome;
    private int pontuacao;
    private int tempo;

    /**
     * Constructor for objects of class Jogador
     */
    public Jogador()
    {
        nome = "";
        pontuacao = 0;
        tempo = 0;
    }

    public void setTempo(int tempo)
    {
        this.tempo = tempo;
    }

    public String getNome()
    {
        return nome;
    }

    public int getPontuacao()
    {
        return pontuacao;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setPontuacao(int pontuacao)
    {
        this.pontuacao = pontuacao;
    }

    public int getTempo()
    {
        return tempo;
    }
}
