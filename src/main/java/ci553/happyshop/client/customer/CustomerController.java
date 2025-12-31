package ci553.happyshop.client.customer;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.IOException;
import java.sql.SQLException;


public class CustomerController {

    public CustomerModel cusModel;
    public CustomerClient customerClient;

    public void doAction(String action) throws SQLException, IOException {
        switch (action) {
            case "Search":
                cusModel.search();
                playSearchSound();
                break;

            case "Add to Trolley":
                cusModel.addToTrolley();
                playPurchaseSound();
                break;

            case "Cancel":
                cusModel.cancel();
                break;

            case "Check Out":
                cusModel.checkOut();
                break;

            case "Show Available Stock":
                cusModel.showAllAvailableProducts();
                break;

            case "OK & Close":
                ci553.happyshop.utility.SoundFX.playPowerOff();
                break;


        }
    }


    public void playPurchaseSound() {
        try {
            URL soundURL = getClass().getResource("/sounds/purchase.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundURL);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playSearchSound() {
        try {
            URL soundURL = getClass().getResource("/sounds/search.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundURL);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

















