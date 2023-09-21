import java.util.ArrayList;

public class Treinador {

    //  Criação das variáveis:
    private String nome;
    private int dificuldadeAdversario;
    private ArrayList<Pokemon> listaPoke = new ArrayList<>();
    private ArrayList<Pokemon> listaPokeAdversario = new ArrayList<>();

    //======================================================================================================================

    //  Criação dos Pokemons do usuário:
    Charizard charizard = new Charizard("Charizard", "Fogo", 300, 50);
    Gardevoir gardevoir = new Gardevoir("Gardevoir", "Psiquico", 300, 50);
    Blastoise blastoise = new Blastoise("Blastoise", "Agua", 300, 50);

    //Criação dos Pokemons da dificuldade 0:
    Venussaur venussaur = new Venussaur("Venussaur", "Planta", 250, 50);
    Lucario lucario = new Lucario("Lucario", "Lutador", 250, 50);
    Onix onix = new Onix("Onix", "Pedra", 250, 50);

    //Criação dos Pokemons da dificuldade 1:
    Gyarados gyarados = new Gyarados("Gyarados", "Agua", 300, 50);
    Bisharp bisharp = new Bisharp("Bisharp", "Sombrio", 300, 50);
    Rhyperior rhyperior = new Rhyperior("Rhyperior", "Pedra", 300, 50);

    //Criação dos Pokemons da dificuldade 2:
    Kyogre kyogre = new Kyogre("Kyogre", "Agua", 450, 50);
    Rayquaza rayquaza = new Rayquaza("Rayquaza", "Pedra", 450, 50);
    Gengar gengar = new Gengar("Gengar", "Fantasma", 350, 50);

//======================================================================================================================


    //  Adiciona os pokemons na lista do Adversario
    public void adicionaListaAdversario(int dificuldade) {
        if (dificuldade == 0) {
            listaPokeAdversario.add(venussaur);
            listaPokeAdversario.add(lucario);
            listaPokeAdversario.add(onix);
        } else if (dificuldade == 1) {
            listaPokeAdversario.add(gyarados);
            listaPokeAdversario.add(bisharp);
            listaPokeAdversario.add(rhyperior);
        } else if (dificuldade == 2) {
            listaPokeAdversario.add(kyogre);
            listaPokeAdversario.add(rayquaza);
            listaPokeAdversario.add(gengar);
        }
    }

    //  Adiciona os pokemons na lista do Treinador Logado
    //  CONSTRUTOR
    public Treinador(String nome, int dificuldadeAdversario) {
        this.nome = nome;
        listaPoke.add(charizard);
        listaPoke.add(gardevoir);
        listaPoke.add(blastoise);

        this.dificuldadeAdversario = dificuldadeAdversario;
        adicionaListaAdversario(dificuldadeAdversario);
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Pokemon> getListaPoke() {
        return listaPoke;
    }

    public ArrayList<Pokemon> getListaPokeAdversario() {
        return listaPokeAdversario;
    }

}
