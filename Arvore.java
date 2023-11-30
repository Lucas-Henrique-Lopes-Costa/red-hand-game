import java.util.*;
import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arvore here.
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class Arvore
{
    private  ArrayList<TroncoNormal> listaTroncos = new ArrayList<>();
    private MeuMundo mundo;

    /**
     * Construtor da classe Arvore.
     * @param mundo O mundo em que a árvore está inserida.
     */
    public Arvore(MeuMundo mundo) {
        this.mundo = mundo;
    }
    
    /**
     * Faz o movimendo quando bate, removendo o tronco atual, movendo os troncos restantes para baixo
     * e criando um novo tronco no topo.
     * 
     * @param moverDireita indica se o tronco deve ser movido para a direita antes de ser removido
     */
    public void bater(boolean moverDireita)
    {
        TroncoNormal tronco0 = getTronco(0);
        
        tronco0.som();
        tronco0.mover();
        if(moverDireita)
        {
            tronco0.moverDireita();
        }
        removeTronco(0);
         
        //Move todos os troncos da árvore para baixo
        cair();
        
        // Cria um novo tronco no topo
        criaTronco(); 
    }
    
    /**
     * Adiciona um tronco à árvore.
     * 
     * @param tronco O tronco a ser adicionado.
     */
    public void addTronco(TroncoNormal tronco)
    {
        listaTroncos.add(tronco);
    }
    
    /**
     * Retorna o objeto TroncoNormal correspondente ao ID fornecido.
     *
     * @param id O ID do tronco desejado.
     * @return O objeto TroncoNormal correspondente ao ID fornecido.
     */
    private TroncoNormal getTronco(int id)
    {
        return listaTroncos.get(id);
    }
    
    /**
     * Remove um tronco da lista de troncos.
     * 
     * @param id o identificador do tronco a ser removido
     */
    private void removeTronco(int id)
    {
        listaTroncos.remove(id);
    }
    
    /**
     * Limpa a lista de troncos da árvore.
     */
    public void limpa()
    {
        listaTroncos.clear();
    }
    
    /**
     * Faz com que a árvore caia, fazendo com que todos os troncos da listaTroncos caiam 160 unidades.
     */
    private void cair()
    {
        for(TroncoNormal tronco : listaTroncos)
        {
            tronco.cair160();
        }
    }
    
    /**
     * Cria um tronco aleatório e o adiciona ao mundo do jogo.
     * A probabilidade de cada tipo de tronco é a seguinte:
     * - 20% de chance de cair um tronco com galho para a esquerda
     * - 20% de chance de cair um tronco com galho para a direita
     * - 60% de chance de cair um tronco normal
     */
    private void criaTronco()
    {
        int random = Greenfoot.getRandomNumber(11); // Gera um número aleatório entre 0 e 10
        
        if (random < 2) 
        { // 20% de chance de cair um tronco com galho para a esquerda
            TroncoNormal tronco = new TroncoNormal("esquerda");
            listaTroncos.add(tronco);
            mundo.addObject(tronco,314,-40);
        } 
        else if (random > 8) 
        { // 20% de chance de cair um tronco com galho para a direita
            TroncoNormal tronco = new TroncoNormal("direita");
            listaTroncos.add(tronco);
            mundo.addObject(tronco,439,-40);
        } 
        else 
        { // 60% de chance de cair um tronco normal
            TroncoNormal tronco = new TroncoNormal("normal");
            listaTroncos.add(tronco);
            mundo.addObject(tronco,377,-40);
        }
    }
    
    /**
     * Verifica a direção do galho e aciona o método gameOver se for igual ao lado especificado.
     * 
     * @param lado a direção do galho a ser verificada
     */
    public void direcaoGalho(String lado)
    {
        if (getTronco(1).getLado().equals(lado)) 
        {
            mundo.gameOver(true); 
        }
    }
}
