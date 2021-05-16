package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.entities.Pedido;
import views.util.MudarTela;

/**
 *
 * @author marcos
 */
public class Programa extends Application {

    private static Scene scene;
    private static Pedido pedido = new Pedido(null);
    public static MudarTela mudarTela = new MudarTela();

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/views/TelaLogin.fxml"));
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Restaurante Bom Prato");
        stage.show();
    }

    public static Scene getScene() {
        return scene;
    }

    public static Pedido getPedido() {
        return pedido;
    }

    public static void setPedido(Pedido p) {
        pedido = p;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
