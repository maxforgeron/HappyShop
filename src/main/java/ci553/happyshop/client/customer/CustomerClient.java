package ci553.happyshop.client.customer;
import java.net.URL;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import ci553.happyshop.storageAccess.DatabaseRW;
import ci553.happyshop.storageAccess.DatabaseRWFactory;
import javafx.application.Application;
import javafx.stage.Stage;



/**
 * A standalone Customer Client that can be run independently without launching the full system.
 * Designed for early-stage testing, though full functionality may require other clients to be active.
 */

public class CustomerClient extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Creates the Model, View, and Controller objects and links them together for communication.
     * It also creates the DatabaseRW instance via the DatabaseRWFactory and injects it into the CustomerModel.
     * Once the components are linked, the customer interface (view) is started.
     * <p>
     * Also creates the RemoveProductNotifier, which tracks the position of the Customer View
     * and is triggered by the Customer Model when needed.
     */
    @Override
    public void start (Stage stage) {

        CustomerController cusController = new CustomerController();
        CustomerView cusView = new CustomerView();
        CustomerModel cusModel = new CustomerModel();
        DatabaseRW databaseRW = DatabaseRWFactory.createDatabaseRW();

        cusView.cusController = cusController;
        cusController.cusModel = cusModel;
        cusController.customerClient = this;
        cusModel.cusView = cusView;
        cusModel.databaseRW = databaseRW;
        cusView.start(stage);


    }

    public void playPurchaseSound() {
        try {
            URL soundURL = getClass().getResource("/sounds/purchase.wav");

            if (soundURL == null) {
                System.err.println("search.wav NOT FOUND");
                return;
            }

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

            if (soundURL == null) {
                System.err.println("search.wav NOT FOUND");
                return;
            }

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundURL);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



















