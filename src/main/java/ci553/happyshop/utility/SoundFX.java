package ci553.happyshop.utility;

import javafx.scene.media.AudioClip;
import java.net.URL;

public final class SoundFX {
    private SoundFX() {}

    private static AudioClip load(String path) {
        URL url = SoundFX.class.getResource(path);
        if (url == null) {
            System.err.println("Sound not found: " + path);
            return null;
        }
        return new AudioClip(url.toExternalForm());
    }

    private static final AudioClip POWER_OFF = load("/sounds/poweroff.wav");

    public static void playPowerOff() {
        if (POWER_OFF != null) POWER_OFF.play();
    }
}
