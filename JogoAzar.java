public class JogoAzar extends JogoDados{
    private boolean valorAposta;

    public JogoAzar(){
        super(2, "Jogo de Azar");
        this.valorAposta = true;
    }

    public boolean executarRegrasJogo(){
        Dado[] dadosJogoAzar = super.getDados();
    
        dadosJogoAzar[0].roll();
        dadosJogoAzar[1].roll();

        imprimirResultado();
    
        int somaFaces = dadosJogoAzar[0].getFaceSuperior() + dadosJogoAzar[1].getFaceSuperior(); 
        System.out.println("Valor total do lançamento: " + somaFaces);
    
        if(somaFaces == 7 || somaFaces == 11){
            System.out.println("O jogador ganhou a aposta! ");
            return true;
        }
        else if(somaFaces == 2 || somaFaces == 3 || somaFaces == 12){ 
            System.out.println("Que pena... O jogador perdeu a aposta. ");
            return false;
        }
        else{
            System.out.println("Valor a ser encontrado: " + somaFaces);
    
            for(int i = 0; i < 3; i++){
                dadosJogoAzar[0].roll();
                dadosJogoAzar[1].roll(); 
                System.out.println("Valores dos dados do novo lançamento(" + (i + 2) + "): " + dadosJogoAzar[0].getFaceSuperior() + " e " + dadosJogoAzar[1].getFaceSuperior());
    
                int total = dadosJogoAzar[0].getFaceSuperior() + dadosJogoAzar[1].getFaceSuperior();
                System.out.println("Valor total do novo lançamento: " + total);
    
                if(total == somaFaces){
                    System.out.println("Parabéns! O jogador ganhou! ");
                    return true;
                }
            }
    
            System.out.println("Infelizmente, o jogador perdeu. ");
            return false;
        }
    }

    @Override
    public void imprimirResultado(){
        int i = 1;

        for(Dado dado : getDados()){
            System.out.println("Valor do dado " + i + ": " + dado.getFaceSuperior());
            i++;
        }
    }
}