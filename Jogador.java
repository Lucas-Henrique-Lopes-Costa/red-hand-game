/**
 * Write a description of class Jogador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogador  
{
    private String nome;
    private int pontuacao;

    /**
     * Constructor for objects of class Jogador
     */
    public Jogador()
    {
        nome = "";
        pontuacao = 0;
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
}
