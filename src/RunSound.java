
import java.io.*;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class RunSound {

    RunSound() throws IOException {

        String filename = "RACING_SOUND.wav";
        ContinuousAudioDataStream loop = null;
        InputStream in = null;
        try {
            in = new FileInputStream(filename);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        try {
            AudioStream s = new AudioStream(in);
            AudioData audiodata = s.getData();
            loop = new ContinuousAudioDataStream(audiodata);
            AudioPlayer.player.start(loop);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
