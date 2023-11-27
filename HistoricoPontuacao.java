import java.util.ArrayList;
import java.util.List;

public class HistoricoPontuacao {
    private static List<Jogador> jogadores;

    public HistoricoPontuacao() 
    {
        jogadores = new ArrayList<>();
    }

    public static int obterTamanho() 
    {
        ordenarJogadores();
        return jogadores.size();
    }

    public static void adicionarJogador(Jogador jogador) 
    {
        // verifica se já exite o jogador, e se a potuação é maior que a anterior, atualiza
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i).getNome().equals(jogador.getNome())) {
                if (jogadores.get(i).getPontuacao() < jogador.getPontuacao()) {
                    jogadores.set(i, jogador);
                }
                return;
            }
        }
        
        jogadores.add(jogador);
    }

    public static String consultarNomeJogadorPorId(int id) 
    {
        return jogadores.get(id).getNome();
    }

    public static int consultarPontuacaoJogadorPorId(int id) 
    {
        return jogadores.get(id).getPontuacao();
    }

    public static int consultarTempoJogadorPorId(int id) 
    {
        return jogadores.get(id).getTempo();
    }

    public static void aumentaTempoJogadorPorId(int id) 
    {
        jogadores.get(id).aumentaTempo();
    }

    // função de ordernar unsado bubble sort
    private static void ordenarJogadores() 
    {
        int tamanho = jogadores.size();
        for (int i = 0; i < tamanho - 1; i++) 
        {
            for (int j = 0; j < tamanho - i - 1; j++) 
            {
                if (jogadores.get(j).getPontuacao() < jogadores.get(j + 1).getPontuacao()) 
                {
                    Jogador aux = jogadores.get(j);
                    jogadores.set(j, jogadores.get(j + 1));
                    jogadores.set(j + 1, aux);
                }
            }
        }
    }
    
    public static Jogador getUltimoJogador()
    {
        return jogadores.get(jogadores.size()-1);
    }
}
