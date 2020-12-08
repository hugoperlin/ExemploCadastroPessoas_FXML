import controle.Janela;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Cadastro;

public class Main extends Application {

    private Cadastro cadastro;


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        cadastro = new Cadastro();


        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(Main.class.getResource("fxml/Janela.fxml"));
        loader.setControllerFactory((aClass) -> new Janela(cadastro));

        Parent root = loader.load();

        Scene scene = new Scene(root,400,600);

        stage.setScene(scene);
        stage.setTitle("Cadastro Pessoa");
        stage.show();


    }
}
