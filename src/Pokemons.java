import java.util.ArrayList;
import java.util.List;

public abstract class Pokemons {

    private String nome;
    private String tipoPoke;
    private int vida;
    private int level;
    private ArrayList<Movimentos> movimentosPoke = new ArrayList<>();

    public Pokemons(String nome, String tipoPoke, int vida, int level) {
        this.nome = nome;
        this.tipoPoke = tipoPoke;
        this.vida = vida;
        this.level = level;
    }

    //Getters e Setters de cada Atributo.
    public String getNome() {
        return nome;
    }

    public ArrayList<Movimentos> getMovimentosPoke() {
        return movimentosPoke;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    //=========================================================================================================================================

    //    Adiciona Ataques na lista individual de cada Pokemon
    public void adicionarAtaques(Movimentos mov1, Movimentos mov2, Movimentos mov3, Movimentos mov4) {
        this.movimentosPoke.add(mov1);
        this.movimentosPoke.add(mov2);
        this.movimentosPoke.add(mov3);
        this.movimentosPoke.add(mov4);
    }

    public void setMovimentosPoke(ArrayList<Movimentos> movimentosPoke) {
        this.movimentosPoke = movimentosPoke;
    }
//=================================================================================================================

    void atacar(Pokemons pokemonAdv, int dano) {
        pokemonAdv.setVida(pokemonAdv.getVida() - dano);
    }


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

    public String mostraMovimentos() {
        String listaMovimentos = "";
        listaMovimentos = "Movimentos: \n" + movimentosPoke;

        return listaMovimentos;
    }
}
