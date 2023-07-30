import java.util.ArrayList;

public class Treinador {

    //  Criação das variáveis:
    private String nome;
    private int dificuldadeAdversario;
    private ArrayList<Pokemons> listaPoke = new ArrayList<>();
    private ArrayList<Pokemons> listaPokeAdversario = new ArrayList<>();
    Pokemons pokemonLog;

//======================================================================================================================

    //  Criação dos Pokemons do usuário:
    Charizard charizard = new Charizard("Charizard", "Fogo", 300, 100);
    Bisharp bisharp = new Bisharp("Bisharp", "Sombrio", 300, 100);
    Blastoise blastoise = new Blastoise("Blastoise", "Agua", 300, 100);

    //Criação dos Pokemons da dificuldade 0:
    Venussaur venussaur = new Venussaur("Venussaur", "Planta", 300, 100);
    Gardevoir gardevoir = new Gardevoir("Gardevoir", "Psiquico", 250, 100);
    Onix onix = new Onix("Onix", "Pedra", 250, 100);

    //Criação dos Pokemons da dificuldade 1:
    Gyarados gyarados = new Gyarados("Gyarados", "Agua", 250, 100);
    Lucario lucario = new Lucario("Lucario", "Lutador", 225, 100);
    Rhyperior rhyperior = new Rhyperior("Rhyperior", "Pedra", 250, 100);

    //Criação dos Pokemons da dificuldade 2:
    Kyogre kyogre = new Kyogre("Kyogre", "Agua", 450, 100);
    Rayquaza rayquaza = new Rayquaza("Rayquaza", "Pedra", 450, 100);
    Gengar gengar = new Gengar("Gengar", "Fantasma", 250, 100);

//======================================================================================================================

    //  Adiciona os pokemons na lista do Adversario
    public void adicionaListaAdversario(int dificuldade) {
        if (dificuldade==0){
            listaPokeAdversario.add(venussaur);
            listaPokeAdversario.add(gardevoir);
            listaPokeAdversario.add(onix);
        }else if (dificuldade == 1){
            listaPokeAdversario.add(gyarados);
            listaPokeAdversario.add(lucario);
            listaPokeAdversario.add(rhyperior);
        }else if(dificuldade == 2){
            listaPokeAdversario.add(kyogre);
            listaPokeAdversario.add(rayquaza);
            listaPokeAdversario.add(gengar);
        }
    }

    //  Adiciona os pokemons na lista do Treinador Logado
//  CONSTRUTOR
    public Treinador(String nome,int dificuldadeAdversario) {
        this.nome = nome;
        listaPoke.add(charizard);
        listaPoke.add(bisharp);
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

    public ArrayList<Pokemons> getListaPoke() {
        return listaPoke;
    }

    public ArrayList<Pokemons> getListaPokeAdversario() {
        return listaPokeAdversario;
    }
}
