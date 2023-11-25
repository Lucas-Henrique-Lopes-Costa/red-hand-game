import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Programa principal do jogo
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class Pontuacao extends World
{
    // Chama os métodos estatico de tamanho
    private int tamanho = HistoricoPontuacao.obterTamanho();

    /**
     * Construtor para objetos da classe Pontuacao.
     */
    public Pontuacao()
    {    
        // Cria um novo mundo com 750x750 células com um tamanho de célula de 1x1px.
        super(750, 750, 1);
        showText("Aperte ENTER para voltar ao Jogo", 375, 700);
    }

    public void act()
    {        
        
        if (tamanho > 6)
        {
            tamanho = 6;
        }
        
        for (int i = 0; i < tamanho; i++)
        {
            // mostra cada pontuação em uma linha
            showText((i + 1) + "º " + HistoricoPontuacao.consultarNomeJogadorPorId(i) + " - " + HistoricoPontuacao.consultarPontuacaoJogadorPorId(i), 375, 100 + (i * 100));
        }

        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new MeuMundo());
        }

    }
}
