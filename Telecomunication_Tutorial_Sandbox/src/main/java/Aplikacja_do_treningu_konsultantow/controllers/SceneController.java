package Aplikacja_do_treningu_konsultantow.controllers;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {

    public void ChangeScene(Stage window, Parent mainParentScene) {

        mainParentScene.setStyle(
                "  -fx-base: #242424 ;\n" +
                        "  -fx-control-inner-background: derive(-fx-base,20%);\n" +
                        "  -fx-control-inner-background-alt: derive(-fx-control-inner-background,-10%);\n" +
                        "  -fx-accent: #006689;\n" +
                        "  -fx-focus-color: #036E83;\n" +
                        "  -fx-faint-focus-color: #036E8322;");
        Scene mainScene = new Scene (mainParentScene);
        window.setScene(mainScene);
        window.show();
    }
}
