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
  private TextArea textArea;
  private TextField inputField;
  private ArrayList<String> scripList;

  /**
  * method writeFile
  * A generic method to write to a file.
  */
  public void writeFile(String text, String filename, boolean fAppend) {
    //try with resources closes my Writers/Files for me
    try(PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter(filename, fAppend)))) {
      fout.println(text);
    } catch (IOException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }

  /**
  * Method start
  * Initializes the GUI
  */
  @Override
  public void start(Stage stage) {
    Button saveFileBtn = new Button("Save file");
    Button sortBtn = new Button("Sort the list");
    Button saveBtn = new Button("Add to list");
    Label label = new Label("Scripture");
    Label label2 = new Label("Scriptures");
    scripList = new ArrayList<String>();

    textArea = new TextArea();
    inputField = new TextField();

    saveBtn.setMinWidth(100);
    textArea.setMinWidth(50);
    textArea.setMaxWidth(150);
    textArea.setMinHeight(200);
    inputField.setMinWidth(150);
    //Set the title of the window

    saveBtn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        String totalText = "";
        scripList.add(inputField.getText());


        for (String text : scripList) {
          totalText += text + "\n";
        }
        textArea.setText(totalText);
        inputField.setText("");
      }
    });

    sortBtn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        String totalText = "";
        Collections.sort(scripList);
        for (String text : scripList) {
          totalText += text + "\n";
        }
        textArea.setText(totalText);
      }
    });

    //this method handles what happens when the button is clicked
    saveFileBtn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        //FileChooser is the save prompt object
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Scripture List");

        //this brings up the actual save prompt object and returns where you pick
        File file = fileChooser.showSaveDialog(stage);
        writeFile( textArea.getText(), file.getAbsolutePath(), false);

      }
    });
    stage.setTitle("Journal App v0.04");
    VBox vb3 = new VBox();
    HBox root = new HBox();
    root.setPadding(new Insets(20, 50, 20, 50));
    root.setSpacing(50);
    VBox vb1 = new VBox();
    vb1.setSpacing(10);
    vb1.getChildren().add(label);
    vb1.getChildren().add(inputField);

    root.getChildren().add(vb1);

    vb3.getChildren().add(saveBtn);
    vb3.getChildren().add(sortBtn);
    vb3.getChildren().add(saveFileBtn);
    vb3.setSpacing(10);
    vb3.setPadding(new Insets(25, 0, 0, 0));
    root.getChildren().add(vb3);

    VBox vb2 = new VBox();
    vb2.setSpacing(10);
    vb2.getChildren().add(label2);
    vb2.getChildren().add(textArea);

    root.getChildren().add(vb2);
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

  /**
    * Method main
    * Our driver program.  Gadzooks! Robin, why don't you drive for once?
    */
  public static void main(String args[]) {
    launch(args);
  }
}
