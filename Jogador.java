import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Jogador implements Serializable {
    private String nome = new String();
    private char tipo;
    private JogoDados[] jogos = new JogoDados[10];
    private double DinheiroDisponivel;

    public Jogador(String nome, char tipo) { // Inicializa jogador.
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() { // Retorna o nome.
        return nome;
    }

    public void setNome(String nome) { // Altera o nome.
        this.nome = nome;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void setDinheiroDisponivel(double dinheiro){
        this.DinheiroDisponivel = dinheiro;
    }

    public String cartela(int i){ // Retorna a pontuação de uma jogada específica para a tabela final.
        String s = new String();
        s = jogo.montarTabela(i);
        return s;
    }

    public String cartela2(int i){ // Retorna pontuação de uma jogada específica para as tabelas intermediárias.
        String s = new String();
        s = jogo.montarTabela2(i);
        return s;
    }

    public String mostraJogadasExecutadas(){
        String s = new String();

        s = "1\t2\t3\t4\t5\t6\t7(T)\t8(Q)\t9(F)\t10(S+)\t11(S-)\t12(G)\t13(X)\n";

        for(int i = 1; i <= 13; i++){
            s = s + this.cartela2(i);
        }
        return s;
    }

    public void inicializarPartida(){
        jogo.inicializarJogadas();
    }

    public void jogada(){ // Efetua uma jogada, rolando os dados e imprimindo.
       jogo.rolarDados();
       String s = jogo.toString(); 

       System.out.printf(s);
    }

    public boolean validar(int escolha){ // Valida a jogada.
        return jogo.validarJogada(escolha);
    }

    public int total(){ // Calcula pontuacao total.
        return jogo.calculaTotal();
    }

    

        // Verifica se o jogador eh maquina:
        if(this.tipo == 'M' || this.tipo == 'm'){
            int melhorJogada = -1;
            int melhorPontuacao = 0;
            
            // Percorre jogadas para determinar qual a melhor(que rende maior pontuacao):
            for (int choice = 1; choice <= 13; choice++) {
                if (validar(choice)) {
                    int pontuacao = jogo.pontuarJogada(choice);
                    if (pontuacao > melhorPontuacao) {
                        melhorPontuacao = pontuacao;
                        melhorJogada = choice;
                    }
                }
            }

            // Caso todas as pontuacoes forem 0, escolhe uma aleatoria para zerar:
            if(melhorJogada == -1){
                melhorJogada = random.nextInt(13) + 1;
                while(!validar(melhorJogada)){
                    melhorJogada = random.nextInt(13) + 1;
                }
                melhorPontuacao = 0;
            }
                        
            System.out.println("Essa jogada gera o seguinte numero de pontos: " + melhorPontuacao);
            jogo.setJogada(melhorJogada, melhorPontuacao);
        }
    }            
}