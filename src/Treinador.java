import java.util.ArrayList;

public class Treinador {

    //  Criação das variáveis:
    private String nome;
    private ArrayList<Pokemons> listaPoke = new ArrayList<>();
    private ArrayList<Pokemons> listaPokeAdversario = new ArrayList<>();
    Pokemons pokemonLog;

//======================================================================================================================

    //  Criação dos Pokemons:
    Charizard charizard = new Charizard("Charizard", "Fogo", 200, 100);
    Gardevoir gardevoir = new Gardevoir("Gardevoir", "Psiquico", 200, 100);
    Blastoise blastoise = new Blastoise("Blastoise", "Agua", 200, 100);
    Venussaur venussaur = new Venussaur("Venussaur", "Planta", 300, 100);
    Onix onix = new Onix("Onix", "Pedra", 250, 100);
    Bisharp bisharp = new Bisharp("Bisharp", "Sombrio", 250, 100);

//======================================================================================================================

    //  Adiciona os pokemons na lista do Adversario
    public void adicionaListaAdversario() {
        listaPokeAdversario.add(venussaur);
        listaPokeAdversario.add(gardevoir);
        listaPokeAdversario.add(blastoise);
    }

    //  Adiciona os pokemons na lista do Treinador Logado
//  CONSTRUTOR
    public Treinador(String nome) {
        this.nome = nome;
        listaPoke.add(charizard);
        listaPoke.add(bisharp);
        listaPoke.add(onix);

        adicionaListaAdversario();
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Pokemons> getListaPoke() {
        return listaPoke;
    }

    public ArrayList<Pokemons> getListaPokeAdversario() {
        return listaPokeAdversario;
    }

    public void setListaPokeAdversario(ArrayList<Pokemons> listaPokeAdversario) {
        this.listaPokeAdversario = listaPokeAdversario;
    }

//======================================================================================================================


}
