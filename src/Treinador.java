import java.util.ArrayList;

public class Treinador {

    private String nome;
    private ArrayList<Pokemons> listaPoke  = new ArrayList<>();
    static Charizard charizard =  new Charizard("Charizard","Fogo",200,100,Pokemons.getMovimentosPoke());
    static Blastoise blastoise =  new Blastoise("Blastoise","Água",200,100,Pokemons.getMovimentosPoke());
    static Venussaur venussaur =  new Venussaur("Venussaur","Planta",300,100,Pokemons.getMovimentosPoke());
    static Onix onix =  new Onix("Onix","Pedra",250,100,Pokemons.getMovimentosPoke());

    public Treinador(String nome){
        this.nome = nome;
        listaPoke.add(charizard);
        listaPoke.add(blastoise);
        listaPoke.add(onix);
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
//===================================================================

    public void escolherMov(){

    }

    public void trocarPoke(){

    }
    public void desistir(){

    }



}
