import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MundoDragao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MundoDragao extends World
{
    private Musicas musica;
    private Guerreiro guerreiro;
    private Dragao dragao;

    private int score;
    private Jogador jogador;
    /**
     * Constructor for objects of class MundoDragao.
     * 
     */
    public MundoDragao()
    {    
        super(1200, 750, 1);
        
        dragao = new Dragao(this);
        addObject(dragao, getWidth()/2, 350);
        
        guerreiro = new Guerreiro(dragao,this);
        addObject(guerreiro, getWidth()*4/10, getHeight()*7/10-15);
        
        Muro muro = new Muro();
        addObject(muro,getWidth()/2, getHeight()*8/10);
        
        musica = new Musicas("musicaDragao.mp3",40);
        
        this.jogador=HistoricoPontuacao.getUltimoJogador();
        this.score = jogador.getPontuacao();
    }
    
    public void act()
    {
        showText("Pontos: " + score, getWidth()/2, 200);
    }
    
    public void perder()
    {
        musica.parar();
        Greenfoot.setWorld(new LoseWorld(guerreiro.getX(), 
            guerreiro.getY()+10, score, 1200, 750, "fundoDragao.jpeg"));
            
        jogador.setPontuacao(score);
        HistoricoPontuacao.adicionarJogador(jogador);
    }
    
    public void aumentaScore(int quantidade)
    {
        score+=quantidade;
    }
}
