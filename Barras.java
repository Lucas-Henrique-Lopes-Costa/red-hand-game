import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barras extends Actor
{
    private int tamanhoOriginal;
    private int tamanhoAtual;
    private GreenfootImage imagem;
    
    public Barras(int larguraOriginal)
    {
        tamanhoOriginal=larguraOriginal;
        tamanhoAtual=tamanhoOriginal;
        
        imagem = new GreenfootImage(larguraOriginal, 10);
        
        atualizarImagem();
    }
    
    /**
     * Act - do whatever the Barras wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        /* */
    }
    
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
        
        setImage(imagem); // Define a imagem do contador
    }
    
    public void redimensiona(int tamanho)
    {
        tamanhoAtual+=tamanho;
        atualizarImagem();
    }
    
    public int getTamanhoAtual()
    {
        return tamanhoAtual;
    }
}
