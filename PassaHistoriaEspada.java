import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PassaHistoriaEspada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PassaHistoriaEspada extends Actor
{
    private MeuMundo mundo;
    private Jogador jogador;
    
    public PassaHistoriaEspada(MeuMundo mundo, Jogador jogador)
    {
        this.mundo=mundo;
        this.jogador=jogador;
    }
    
    public void act() {
        // Caso o usuário pressione ENTER, ESPAÇO ou clique com o mouse
        checkKeyPress();
    }
    
    public void checkKeyPress() 
    {
        if (Greenfoot.isKeyDown("space")) 
        {
           Greenfoot.setWorld(new HistoriaMundoDragao());// Inicia o mundo do dragão
        }
        else if (Greenfoot.isKeyDown("escape"))
        {
            Greenfoot.setWorld(mundo);
            HistoricoPontuacao.removeJogador(jogador);
        }
    }
}
