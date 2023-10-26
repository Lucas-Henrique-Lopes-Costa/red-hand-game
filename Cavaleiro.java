import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cavaleiro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cavaleiro extends Actor
{
    private GreenfootImage[] imagens;
    private int indiceImagemAtual;

    private int passosParaAtualizarAImagem;
    private int passosDesdeUltimaAtualizacaoImagem;

    private boolean esquerda;
    
    public Cavaleiro() {
        passosParaAtualizarAImagem = 5;
        passosDesdeUltimaAtualizacaoImagem = 0;
        
        esquerda = false;

        // criamos o vetor com 10 posições, pois temos 10 imagens
        imagens = new GreenfootImage[10];

        for (int i = 0; i < imagens.length; i++) {
            imagens[i] = new GreenfootImage("Idle (" + (i+1) + ").png");
            imagens[i].scale(120,140);
        }

        // definimos a primeira imagem como a imagem inicial do cavaleiro
        indiceImagemAtual = 0;
        setImage(imagens[indiceImagemAtual]);
    }

    public void act()
    {
        // se a tecla seta para a ESQUERDA estiver pressionada
        if (Greenfoot.isKeyDown("left")) {
            // posição do cavaleiro DIMINUI 4 no eixo X e se mantém no eixo Y
            setLocation(getX()-4, getY());

            for (int i = 0; i < imagens.length; i++) {
                imagens[i] = new GreenfootImage("Walk (" + (i+1) + ").png");
                imagens[i].scale(120,140);
                imagens[i].mirrorHorizontally();
            }

            esquerda = true;
        }
        // se a tecla seta para a DIREITA estiver pressionada
        else if (Greenfoot.isKeyDown("right")) {
            // posição do cavaleiro AUMENTA 4 no eixo X e se mantém no eixo Y
            setLocation(getX()+4, getY()); 

            for (int i = 0; i < imagens.length; i++) {
                imagens[i] = new GreenfootImage("Walk (" + (i+1) + ").png");
                imagens[i].scale(120,140);
            }

            esquerda = false;
        }
        else {
            for (int i = 0; i < imagens.length; i++) {
                imagens[i] = new GreenfootImage("Idle (" + (i+1) + ").png");
                imagens[i].scale(120,140);
            }

            if (esquerda)
            {
                for (int i = 0; i < imagens.length; i++) {
                    imagens[i].mirrorHorizontally();
                }
            }
        }

        passosDesdeUltimaAtualizacaoImagem++;

        if (passosDesdeUltimaAtualizacaoImagem == passosParaAtualizarAImagem)
        {
            indiceImagemAtual++;
            if (indiceImagemAtual >= imagens.length)
            {
                indiceImagemAtual = 0;
            }
            setImage(imagens[indiceImagemAtual]);
            passosDesdeUltimaAtualizacaoImagem = 0;
        }
    }
}
