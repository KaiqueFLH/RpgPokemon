import java.util.ArrayList;
import java.util.List;

public class Pokemons {

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

    public Pokemons(Pokemons other) {
        this.nome = other.nome;
        this.tipoPoke = other.tipoPoke;
        this.vida = other.vida;
        this.level = other.level;
        this.movimentosPoke = new ArrayList<>(other.movimentosPoke); // Faz uma cópia da lista de movimentos
    }

    //Getters e Setters de cada Atributo.
    public String getNome() {
        return nome;
    }

    public ArrayList<Movimentos> getMovimentosPoke() {
        return movimentosPoke;
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
        if(this.getTipoPoke().equals("Fogo") && pokemonAdv.getTipoPoke().equals("Planta")){
            System.out.println("O seu Ataque é Super Efetivo!");
            pokemonAdv.setVida(pokemonAdv.getVida() - dano*2);
        }
        else if(this.getTipoPoke().equals("Sombrio") && pokemonAdv.getTipoPoke().equals("Psiquico")){
            System.out.println("O seu Ataque é Super Efetivo!");
            pokemonAdv.setVida(pokemonAdv.getVida() - dano*2);
        }
        else if(this.getTipoPoke().equals("Agua") && pokemonAdv.getTipoPoke().equals("Fogo")){
            System.out.println("O seu Ataque é Super Efetivo!");
            pokemonAdv.setVida(pokemonAdv.getVida() - dano*2);
        }
        else if(this.getTipoPoke().equals("Agua") && pokemonAdv.getTipoPoke().equals("Pedra")){
            System.out.println("O seu Ataque é Super Efetivo!");
            pokemonAdv.setVida(pokemonAdv.getVida() - dano*2);
        }

        else {
            pokemonAdv.setVida(pokemonAdv.getVida() - dano);
        }
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
