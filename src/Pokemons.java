import java.util.ArrayList;

public abstract class Pokemons {

    private String nome;
    private String tipoPoke;
    private int vida;
    private int level;
    private static ArrayList<Movimentos> movimentosPoke = new ArrayList<>();

    public Pokemons (String nome, String tipoPoke,int vida,int level, ArrayList<Movimentos> movimentosPoke) {
        this.nome = nome;
        this.tipoPoke = tipoPoke;
        this.vida = vida;
        this.level = level;
        this.movimentosPoke = movimentosPoke;
    }

    //Getters e Setters de cada Atributo.
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoPoke() {
        return tipoPoke;
    }

    public void setTipoPoke(String tipoPoke) {
        this.tipoPoke = tipoPoke;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static ArrayList<Movimentos> getMovimentosPoke() {
        return movimentosPoke;
    }

    public void setMovimentosPoke(ArrayList<Movimentos> movimentosPoke) {
        this.movimentosPoke = movimentosPoke;
    }

//=================================================================================================================

    abstract void atacar();



    @Override
    public String toString() {
        return "Pokemons{" +
                "nome='" + nome + '\'' +
                ", tipoPokemon='" + tipoPoke + '\'' +
                ", vida=" + vida +
                ", level=" + level +
                ", movimentosPoke=" + movimentosPoke +
                '}';
    }

    public String mostraMovimentos(){
        String listaMovimentos="";
        listaMovimentos = "Movimentos: \n"+movimentosPoke;

        return listaMovimentos;
    }
}
