import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barras here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class Barras extends Actor
{
    private int tamanhoOriginal;
    private int tamanhoAtual;
    private GreenfootImage imagem;
    
    /**
     * Construtor da classe Barras.
     * 
     * @param larguraOriginal a largura original da barra
     */
    public Barras(int larguraOriginal)
    {
        tamanhoOriginal=larguraOriginal;
        tamanhoAtual=tamanhoOriginal;
        
        imagem = new GreenfootImage(larguraOriginal, 10);
        
        atualizarImagem();
    }
    
    /**
     * Atualiza a imagem da barra com base no tamanho atual.
     * A cor da barra é definida com base no tamanho atual em relação ao tamanho original.
     */
    public void atualizarImagem()
    {
        imagem.clear();
        if (tamanhoAtual>tamanhoOriginal)
        {
            tamanhoAtual=tamanhoOriginal;
        }
        
        if(tamanhoAtual>=tamanhoOriginal*2/3)
        {
            imagem.setColor(Color.GREEN);
        }
        else if (tamanhoAtual>=tamanhoOriginal*1/3)
        {
            imagem.setColor(Color.YELLOW);
        }
        else
        {
            imagem.setColor(Color.RED);
        }
        
        imagem.fillRect(0, 0, tamanhoAtual, 10);
        
        setImage(imagem);
    }
    
    /**
     * Redimensiona a barra de acordo com o tamanho fornecido.
     * 
     * @param tamanho o tamanho a ser adicionado à barra
     */
    public void redimensiona(int tamanho)
    {
        tamanhoAtual+=tamanho;
        atualizarImagem();
    }
    
    /**
     * Retorna o tamanho atual da barra.
     *
     * @return o tamanho atual da barra.
     */
    public int getTamanhoAtual()
    {
        return tamanhoAtual;
    }
}
