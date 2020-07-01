//package sample;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//public class Main extends Application {
//
//    public void start(Stage primaryStage) {
//        Label l1 = new Label("Hallo");
//        Label l2 = new Label("Welt");
//        VBox root = new VBox();
//
//        root.getChildren().add(l1);
//        root.getChildren().add(l2);
//
//        Scene scene = new Scene(root, 240, 40);
//        primaryStage.setScene(scene); primaryStage.setTitle("Hello World");
//        primaryStage.show();
//    }
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//    }
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
