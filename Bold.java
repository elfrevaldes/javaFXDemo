//javaFX stuff
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Priority;
import javafx.scene.input.KeyEvent;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.layout.Region;
import java.util.ArrayList;
import java.util.Collections;
import javafx.geometry.Insets;

//file stuff
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;


public class Bold extends Application {
  private Scene scene;
  private TextField inputField;
  private ArrayList<String> threadList;
  private Button addBtn;
  private VBox root;
  private Label label;
  /**
  * Method start
  * Initializes the GUI
  */
  @Override
  public void start(Stage stage) {
    label = new Label("Please enter a Runnable class name:");
    threadList = new ArrayList<String>();
    inputField = new TextField();
    addBtn = new Button("Add Class");
    root = new VBox();

    //handle the button press.
    addBtn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        addClass();
        inputField.setText("");
      }
    });

    //setup our layout
    setupLayout(stage);

    //Create a new scene of type Browser (which we create below)
    //and with the background color specified
    scene = new Scene(root, 600, 300);

    //Set this scene as the current scene on stage
    stage.setScene(scene);

    //load our CSS file for this stage
    scene.getStylesheets().add("mycss.css");

    //Show the stage to the world!  (make it visible)
    stage.show();
  }

  public void setupLayout(Stage stage) {
    stage.setTitle("Boldness Exploration");
    root.getChildren().add(label);
    root.getChildren().add(inputField);
    root.getChildren().add(addBtn);
  }

  public void addClass() {

  }
  /**
    * Method main
    * Our driver program.  Gadzooks! Robin, why don't you drive for once?
    */
  public static void main(String args[]) {
    launch(args);
  }
}
