import java.util.ArrayList;

public class Gardevoir extends Pokemons{

    Movimentos recuperarVida = new Movimentos("Recuperar Vida",40,"Psiquico");
    Movimentos raioPsiquico = new Movimentos("Raio Psíquico",30,"Psiquico");
    Movimentos rajadaLunar = new Movimentos("Rajada Lunar",25,"Psiquico");
    Movimentos luzRuinas = new Movimentos("Luz das Ruínas",15,"Psiquico");


    //construtor
    public Gardevoir(String nome, String tipoPoke, int vida, int level ) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(recuperarVida,raioPsiquico,rajadaLunar,luzRuinas);
    }

    //função de atacar;
    @Override
    void atacar() {

    }
}
