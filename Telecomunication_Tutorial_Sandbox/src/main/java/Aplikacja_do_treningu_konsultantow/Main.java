package Aplikacja_do_treningu_konsultantow;

import Aplikacja_do_treningu_konsultantow.database.dbutils.DataBaseManager;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.File;

public class Main extends Application {

    public void pdfShow(){

    File file = new File("instrukcja-konsultanta.pdf");
    HostServices hostServices = getHostServices();
    hostServices.showDocument(file.getAbsolutePath());
    }

    public static void main(String[] args) {launch(args);}

    public void start (Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MenuMainBorderPane.fxml"));
        BorderPane borderPane = loader.load();

        borderPane.setStyle(
                "  -fx-base: #242424 ;\n" +
                        "  -fx-control-inner-background: derive(-fx-base,20%);\n" +
                        "  -fx-control-inner-background-alt: derive(-fx-control-inner-background,-10%);\n" +
                        "  -fx-accent: #006689;\n" +
                        "  -fx-focus-color: #036E83;\n" +
                        "  -fx-faint-focus-color: #036E8322;");

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Aplikacja do treningu konsultantow");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setMaximized(true);
        primaryStage.show();

        DataBaseManager.initDatabase();
    }

}
