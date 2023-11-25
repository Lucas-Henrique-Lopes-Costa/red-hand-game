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
        
        if (tamanho > 5)
        {
            tamanho = 5;
        }
        
        for (int i = 0; i < tamanho; i++)
        {
            // verifica o tamanho do nome, se passar de 20 caracteres, corta e coloca "..."
            if (HistoricoPontuacao.consultarNomeJogadorPorId(i).length() > 20)
            {
                showText(HistoricoPontuacao.consultarNomeJogadorPorId(i).substring(0, 19) + "...", 310, 300 + (i * 55));
            }
            else
            {
                showText(HistoricoPontuacao.consultarNomeJogadorPorId(i), 310, 300 + (i * 55));
            }
            
            // mostra cada pontuação em uma linha
            showText(Integer.toString(HistoricoPontuacao.consultarPontuacaoJogadorPorId(i)), 539, 300 + (i * 55));
        }

        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new MeuMundo());
        }

    }
}
