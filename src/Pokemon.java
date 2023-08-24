import java.util.ArrayList;

public abstract class Pokemon {

    private String nome;
    private String tipoPoke;
    private int vida;
    private int level;
    private ArrayList<Movimento> movimentoPoke = new ArrayList<>();
    private int paralizado;

    public Pokemon(String nome, String tipoPoke, int vida, int level) {
        this.nome = nome;
        this.tipoPoke = tipoPoke;
        this.vida = vida;
        this.level = level;
        this.paralizado = 0;
    }


    //Getters e Setters de cada Atributo.
    public String getNome() {
        return nome;
    }

    public ArrayList<Movimento> getMovimentosPoke() {
        return movimentoPoke;
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

    public int getParalizado() {
        return paralizado;
    }

    public void setParalizado(int paralizado) {
        this.paralizado = paralizado;
    }
    //=========================================================================================================================================

    //    Adiciona Ataques na lista individual de cada Pokemon
    public void adicionarAtaques(Movimento mov1, Movimento mov2, Movimento mov3, Movimento mov4) {
        this.movimentoPoke.add(mov1);
        this.movimentoPoke.add(mov2);
        this.movimentoPoke.add(mov3);
        this.movimentoPoke.add(mov4);
    }

    public void setMovimentosPoke(ArrayList<Movimento> movimentoPoke) {
        this.movimentoPoke = movimentoPoke;
    }
//=================================================================================================================

    public void setVidaPokemonIgual0(){
        if (this.getVida() <= 0) {
            this.setVida(0);
            System.out.println("A vida do " + this.getNome() + " Diminuiu para: " + this.getVida());
        } else {
            System.out.println("A vida do " + this.getNome() + " Diminuiu para: " + this.getVida());
        }
    }

    abstract void atacar(Pokemon pokemonAdv, int dano,int indice);

//    abstract void curar(Pokemon pokemonAdv, int dano);

    @Override
    public String toString() {
        return "Pokemons{" +
                "nome='" + nome + '\'' +
                ", tipoPokemon='" + tipoPoke + '\'' +
                ", vida=" + vida +
                ", level=" + level +
                ", movimentosPoke=" + movimentoPoke +
                '}';
    }

    public String mostraMovimentos() {
        String listaMovimentos = "";
        listaMovimentos = "Movimentos: \n=========================\nAtaque 0 - " + movimentoPoke.get(0) + "\nAtaque 1 - " +
                movimentoPoke.get(1) + "\nAtaque 2 - " + movimentoPoke.get(2) +
                "\nAtaque 3 - " + movimentoPoke.get(3) +
                "\n=========================" + "\n";

        return listaMovimentos;
    }
}
