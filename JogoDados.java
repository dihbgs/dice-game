public abstract class JogoDados implements Estatistica{
    protected int nDados;
    protected String nomeJogo;
    protected float saldo;
    protected Dado[] dados;

    public JogoDados(int nDados, String nomeJogo) {
        this.nDados = nDados;
        this.nomeJogo = nomeJogo;
        this.saldo = 100.0f; // Saldo inicial é 100.0
        this.dados = new Dado[nDados];

        for (int i = 0; i < nDados; i++) {
            this.dados[i] = new Dado();
        }
    }

    public Dado[] getDados(){
        return this.dados;
    }

    public int[] somarFacesSortedas(Dado[] dados, int retorno){
        int[] soma = new int[6];
        if(retorno == 0){
            for (Dado dado : dados) {
                soma[dado.getFaceSuperior() - 1] = soma[dado.getFaceSuperior() - 1] + 1; 
            }
        }

        return soma;
    }

    public void imprimirEstatisticaDoCampeonato(){
        int[] soma = somarFacesSorteadas(dados, 1);
        int total = 0;

        for(int i = 0; i < 6; i++){
            total += soma[i];
        }

        if(total != 0){
            System.out.println("=== ESTATÍSTICA ===");
            for(int j = 0; j < 6; j++){
                System.out.println("A face " + (j + 1) + " apareceu virada para cima em " + soma[j]/total + "% das jogadas. ");
            }
        }
        else{
            System.out.println("Nenhuma dado foi sorteado. ");
        }
    }

    public void rolarDados() {
        for (Dado dado : dados) {
            dado.roll();
        }
        int[] soma = somarFacesSorteadas(dados, 0);
    }

    public void imprimirResultado() {
        System.out.println("Resultado do " + nomeJogo + ":");

        for (Dado dado : dados) {
            System.out.print(dado.getFaceSuperior() + " ");
        }

        System.out.println();
    }

    public void imprimirDadosUmAUm(){
        int i = 1;

        for(Dado dado : dados){
            System.out.println("Valor do dado " + i + ":" + dado.getFaceSuperior());
            i++;
        }
    }
}
