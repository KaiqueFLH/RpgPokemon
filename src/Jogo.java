import javax.sound.sampled.*;
import java.util.Random;

public class Jogo {

    private static Clip musicaBatalha;
    private static Clip musicaVitoria;

    public int geraAleatorio() {
        int ataqueAleatorio;

        Random indice = new Random();

        ataqueAleatorio = indice.nextInt(3);

        return ataqueAleatorio;
    }

    public void verificaParalizia(Pokemon meuPokemon,Pokemon pokemonAdversario){
        if (meuPokemon.getParalizado()!=0){
            meuPokemon.setParalizado(meuPokemon.getParalizado()-1);
        }
        if (pokemonAdversario.getParalizado()!=0){
            pokemonAdversario.setParalizado(pokemonAdversario.getParalizado()-1);
        }
    }

    public void startMusicaBatalha() {
        try {
            // Carrega o arquivo de áudio
            AudioInputStream batalha = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("battle_music.wav"));

            // Cria o objeto Clip
            musicaBatalha = AudioSystem.getClip();
            musicaBatalha.open(batalha);

            // Reproduz a música em loop
            musicaBatalha.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startMusicaVitoria() {
        try {
            // Carrega o arquivo de áudio
            AudioInputStream vitoria = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("victory_music.wav"));

            // Cria o objeto Clip
            musicaVitoria = AudioSystem.getClip();
            musicaVitoria.open(vitoria);

            // Reproduz a música uma vez
            musicaVitoria.start();

            // Aguarda até que a música termine de tocar, não entendi muito bem, mas funciona.
            musicaVitoria.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        musicaVitoria.close();
                    }
                }
            });

            // setTimeOut do java
            Thread.sleep(10000);

            // Encerra a música depois do setTimeOut do java
            musicaVitoria.stop();
            musicaVitoria.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopmusicaBatalha() {
        // Encerra a musica.
        if (musicaBatalha != null && musicaBatalha.isRunning()) {
            musicaBatalha.stop();
        }
    }
    
}
