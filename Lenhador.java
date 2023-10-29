import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lenhador extends Actor {

    private boolean ladoDireito;
    private boolean ladoEsquerdo;
    private GreenfootImage[] animationFrames;
    private int currentFrame;
    private int frameDirection;
    private boolean keyWasDown;
    
    public Lenhador() {
    // Inicializa as variáveis de direção
    ladoDireito = true;
    ladoEsquerdo = true;
    keyWasDown = false;
    
    // Inicializa os quadros da animação do lenhador
    animationFrames = new GreenfootImage[3];
    for (int i = 0; i < animationFrames.length; i++) {
        // Carrega as imagens dos quadros da animação
        animationFrames[i] = new GreenfootImage("lenhador" + i + ".png");
    }

    // Define a localização inicial do lenhador
    setLocation(215,663);

    // Ajusta o tamanho da imagem do lenhador
    getImage().scale(160, 160);

    // Inicializa o quadro atual e a direção do quadro para a animação
    currentFrame = 0;
    frameDirection = 1;
}


    public void act() {
    // Verifica se a tecla "left" está pressionada
    if (Greenfoot.isKeyDown("left")) {
        // Carrega as imagens de animação para o lenhador virado para a esquerda
        for (int i = 0; i < animationFrames.length; i++) {
            animationFrames[i] = new GreenfootImage("lenhador" + i + ".png");
            setLocation(215,663);
            animationFrames[i].scale(160, 160);
        }
        // Verifica se a tecla foi pressionada pela primeira vez
        if (!keyWasDown) {
            keyWasDown = true;
            ladoDireito = false;
            ladoEsquerdo = true;
            // Inicia a animação
            animate();
        }
    } 
    // Verifica se a tecla "right" está pressionada
    else if (Greenfoot.isKeyDown("right")) {
        // Carrega as imagens de animação para o lenhador virado para a direita
        for (int i = 0; i < animationFrames.length; i++) {
            animationFrames[i] = new GreenfootImage("lenhadorInvertido" + i + ".png");
            setLocation(530,663);
            animationFrames[i].scale(160, 160);
        }
        // Verifica se a tecla foi pressionada pela primeira vez
        if (!keyWasDown) {
            keyWasDown = true;
            ladoDireito = true;
            ladoEsquerdo = false;
            // Inicia a animação
            animate();
        }
    } 
    // Se nenhuma das teclas está pressionada, reseta a variável keyWasDown
    else {
        keyWasDown = false; 
    }
}



    private void animate() {
    // Define o quadro atual como 0
    currentFrame = 0;

    // Loop que executa 5 vezes
    for (int i = 0; i <= 4; i++) {
        // Define a imagem do quadro atual
        setImage(animationFrames[currentFrame]);

        // Se o quadro atual for o último da animação, a direção do quadro é definida como -1
        if (currentFrame == animationFrames.length - 1) {
            frameDirection = -1;
        } 
        // Se o quadro atual for o primeiro da animação, a direção do quadro é definida como 1
        else if (currentFrame == 0) {
            frameDirection = 1;
        }

        // Pausa a execução por 4 milissegundos
        Greenfoot.delay(4);

        // Atualiza o quadro atual com base na direção do quadro
        currentFrame += frameDirection;
    }

    // Redefine o quadro atual para 0 após a conclusão da animação
    currentFrame = 0;
}

    
    
}
