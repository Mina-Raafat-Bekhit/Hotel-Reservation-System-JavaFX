/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfx;

import com.sun.javaws.JnlpxArgs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Enter Computer
 */
public class Testfx extends Application {
    ObservableList  <User> date ; 
    TableView t;
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rest=null;
    @Override
    public void start(Stage primaryStage) {
        
         Label b1=new Label("Sign in");
        Label b2=new Label("Email");
        Label b3=new Label("Password");
        CheckBox cb=new CheckBox("I Agree");
        TextField t1=new TextField();
         
        PasswordField t2=new PasswordField();
        Button p1=new Button("LOGIN");
        Button p2=new Button("Forgot password");
        Label b4=new Label("Don't have an account?");
        Button p3=new Button("Sign up");
       
        GridPane g=new GridPane();
        g.add(b1,1,0,2,1);
        g.add(b2,0,1);
        g.add(b3,0,2);
        g.add(t1, 1, 1);
        g.add(t2,1,2);
        g.add(cb, 0, 3);
        g.add(p2,1,3);
        g.add(p1,1,4);
        g.add(b4,1,5);
        g.add(p3,2,5);
        g.setAlignment(Pos.CENTER);
        g.setVgap(20);
        g.setHgap(20);
        Scene s1=new Scene(g,750,750);
        primaryStage.setScene(s1);
        b1.getStyleClass().add("title");
        s1.getStylesheets().add(this.getClass().getResource("CSS.css").toExternalForm());
        p1.getStyleClass().add("p");
        p3.getStyleClass().add("me");
        primaryStage.show();
        
        
        Label signup=new Label("Sign up");
         Label labelname =new Label("name");
        Label labelpass=new Label("password");
        Label labelemail=new Label("email");
        Label labeldate=new Label("Date of Birth");
       
        PasswordField textpass = new PasswordField();
        TextField textemail = new TextField();
        Button button= new Button("sign up");
        CheckBox check=new CheckBox("I agree");
        RadioButton radio1=new RadioButton("male");
        RadioButton radio2=new RadioButton("female");
        DatePicker date=new DatePicker();
        ToggleGroup group=new ToggleGroup();
        radio1.setToggleGroup(group);
        radio2.setToggleGroup(group);
        
        GridPane root=new GridPane();
        root.add(signup,1,0,2,1);
        root.add(labelname, 0,1);
        root.add(labelemail, 0, 2);
        root.add(labelpass, 0, 3);
        root.add(textemail, 1, 2);
        root.add(textpass, 1, 3);
        root.add(button, 0, 7);
        root.add(check, 1,6);
        root.add(radio2, 1, 4);
        root.add(radio1, 0, 4);
        root.add(date, 1, 5);
        root.add(labeldate, 0, 5);
        
        
        root.setAlignment(Pos.CENTER);
        root.setHgap(20);
        root.setVgap(20);
        Scene s2=new Scene(root,750,750);
        
        button.setOnAction(e->{
            conn=DBConn.DBConnection();
            String insert="insert into employee (email,password) values (?,?)";
             try {
                 pst=conn.prepareStatement(insert);
                 pst.setString(1, textemail.getText());
                 pst.setString(2, textpass.getText());
                 if(pst.executeUpdate()==1){
                     System.out.println("done");
                     Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("sign up");
                    alert.setContentText("creation account is done");
                    alert.showAndWait();
                    primaryStage.setScene(s1);
                 }
                 pst.close();
                 conn.close();
             } catch (SQLException ex) {
                 Logger.getLogger(Testfx.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        });
        
        
        
        
        
        Button l=new Button("Submit");
        p3.setOnAction((value)->{
        primaryStage.setScene(s2);
        });
         signup.getStyleClass().add("sign");
         s2.getStylesheets().add(this.getClass().getResource("CSS.css").toExternalForm());
         button.getStyleClass().add("but");
                
                Label q=new Label("Forgot Password");
                Label q1=new Label("email:");
                Button q2=new Button("Forgot password");
                TextField q3=new TextField();
                Button bb=new Button("Back");
                
                GridPane g2=new GridPane();
                g2.add(q,0,0);
                g2.add(q1,0,1);
                g2.add(q2,0,3);
                g2.add(q3,0,2);
                g2.add(bb,1,3);
                
                g2.setAlignment(Pos.CENTER);
                g2.setVgap(20);
                g2.setHgap(20);
                Scene s3=new Scene(g2,750,750);
                
                bb.setOnAction((value)->{;
                primaryStage.setScene(s1);
                });
                
                p2.setOnAction((value)->{;
                primaryStage.setScene(s3);
                });
                q.getStyleClass().add("buto");
                s3.getStylesheets().add(this.getClass().getResource("CSS.css").toExternalForm());
                
                Label l1=new Label("Reset Password");
                Label l2=new Label("Password:");
                Label l3=new Label("Confirm Password:");
                TextField txt=new TextField();
                TextField txt1=new TextField();
                Button button1=new Button("Reset Password");
               Button button2=new Button("Back");
                
                GridPane g3=new GridPane();
                g3.add(l1,0,0);
                g3.add(l2,0,1);
                g3.add(txt,0,2);
                g3.add(l3,0,3);
                g3.add(txt1,0,4);
                g3.add(button1,0,5);
                g3.add(button2, 1, 5);
                
                g3.setAlignment(Pos.CENTER);
                g3.setVgap(20);
                g3.setHgap(20);
                
                Scene s4=new Scene(g3,750,750);
                q2.setOnAction((value)->{
                    
                    conn=DBConn.DBConnection();
                    String select="select * from employee where email=?";
            
             try {
                 pst=conn.prepareStatement(select);
                 pst.setString(1,q3.getText());
                 rest=pst.executeQuery();
                  if(rest.next()){
                 if(rest.getString(1).equals(q3.getText())){
                    primaryStage.setScene(s4);
                    
                 }
                 }
                 else{
                    Alert alert =new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("invalid");
                    alert.setContentText("you email not found");
                    alert.show();
                 }
                 pst.close();
                 conn.close();
             } catch (SQLException ex) {
                 Logger.getLogger(Testfx.class.getName()).log(Level.SEVERE, null, ex);
             }
        
                 });
                
                button1.setOnAction((e)->{
                conn=DBConn.DBConnection();
                String update="update employee set password=? where email=?";
                try {
                    if(txt.getText().equals(txt1.getText())){
                        
                    pst=conn.prepareStatement(update);
                    pst.setString(1,txt.getText());
                    pst.setString(2,q3.getText());
                    pst.executeUpdate();
                    Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("done");
                    alert.setContentText("rest password is done ");
                    alert.showAndWait();
                    primaryStage.setScene(s1);
                    }
                    else{
                        Alert alert =new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("invalid");
                    alert.setContentText("your password are not the same ");
                    alert.show();
                    }
                    pst.close();
                    conn.close();
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Testfx.class.getName()).log(Level.SEVERE, null, ex);
                }
    
               
                
                });
                
                button2.setOnAction((value)->{
                primaryStage.setScene(s3);
                
                });
                
                
                
                 l1.getStyleClass().add("buton");
                 s4.getStylesheets().add(this.getClass().getResource("CSS.css").toExternalForm());
                
                
          Button x1 = new Button ("ADD");
          Button x2 = new Button ("Delete");  
          Button x3 = new Button ("select");
          Button x4 = new Button ("Update");
          GridPane g4=new GridPane();
                g4.add(x1,0,0);
                g4.add(x2,0,1);
                g4.add(x3,0,2);  
                g4.add(x4,0,3);   
    
     g4.setAlignment(Pos.CENTER);
                g4.setVgap(20);
                g4.setHgap(20);
                Scene s5=new Scene(g4,750,750);
    
    p1.setOnAction((value)->{
        String email=t1.getText();
        String pass=t2.getText();
        
        if (email.isEmpty() || pass.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Missing Data");
        alert.setContentText("Please enter both email and password!");
        alert.show();
        return;   }

          conn = DBConn.DBConnection();
          String select = "select * from employee where email = ?";
    
        try {
            pst = conn.prepareStatement(select);
            pst.setString(1, email);
            rest = pst.executeQuery();

        if (rest.next()) {
            if (rest.getString("password").equals(pass)) {
                primaryStage.setScene(s5);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Login");
                alert.setContentText("Incorrect password!");
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Login");
            alert.setContentText("Email not found!");
            alert.show();
        }

        pst.close();
        conn.close();
        
        } catch (SQLException ex) {
        Logger.getLogger(Testfx.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    });
    
    s5.getStylesheets().add(this.getClass().getResource("CSS.css").toExternalForm());

    x1.getStyleClass().add("button1");
    x2.getStyleClass().add("button2");
    x3.getStyleClass().add("button3");
    x4.getStyleClass().add("button4");

    Label labelnum=new Label("Add your name");
    TextField txtname=new TextField();
    
    Label labelid=new Label("Enter your id");
    TextField txtid=new TextField();
    
    Label labelroom=new Label("Enter your numroom");
    TextField txtroom=new TextField();
    
    Label labelnight=new Label("Enter your numnight");
    TextField txtnight=new TextField();
    
    
    Button back=new Button("Back"); 
    
    Button submit=new Button("Submit");
    GridPane g5=new GridPane();
    g5.add(labelname,0,0);
    g5.add(txtname,1,0);
    g5.add(labelid,0,1);
    g5.add(txtid,1,1);
    g5.add(labelroom,0,2);
    g5.add(txtroom,1,2);
    g5.add(labelnight,0,3);
    g5.add(txtnight,1,3);
    g5.add(submit,1,4,2,1);
    g5.add(back,1,5);
    
    g5.setAlignment(Pos.CENTER);
    g5.setVgap(20);
    g5.setHgap(20);
    Scene s6=new Scene(g5,750,750);
    s6.getStylesheets().add(this.getClass().getResource("CSS.css").toExternalForm());

    x1.setOnAction((value)->{
      primaryStage.setScene(s6);
    });
    submit.setOnAction(e->{
        int id =Integer.parseInt(txtid.getText());
        String name =txtname.getText();
        int numroom=Integer.parseInt(txtroom.getText());
        int numnight=Integer.parseInt(txtnight.getText());
        
        conn=DBConn.DBConnection();
        String insert="insert into users (id ,name, numroom,numnights) values (?,?,?,?)";
             try {
                 pst=conn.prepareStatement(insert);
                 pst.setInt(1,id);
                 pst.setString(2,name);
                 pst.setInt(3,numroom);
                 pst.setInt(4,numnight);
                 
                 if(pst.executeUpdate()==1){
                     System.out.println("done");
                 }
                 
                 pst.close();
                 conn.close();
                 
             } catch (SQLException ex) {
                 Logger.getLogger(Testfx.class.getName()).log(Level.SEVERE, null, ex);
             }
    });
    
    back.setOnAction((value)->{;
    primaryStage.setScene(s5);
    });
      
    Label lab=new Label("Enter your id");
    TextField txtt=new TextField();
    
    Button back2=new Button("Back");
    Button submit1=new Button("Submit");
    GridPane g6=new GridPane();
    g6.add(lab,0,0);
    g6.add(txtt,1,0);
    g6.add(submit1,1,1,2,1);
    g6.add(back2,1,2); 
    
    g6.setAlignment(Pos.CENTER);
    g6.setVgap(20);
    g6.setHgap(20);
    Scene s7=new Scene(g6,750,750);
    s7.getStylesheets().add(this.getClass().getResource("CSS.css").toExternalForm());
    submit1.setOnAction(e->{
        int id=Integer.parseInt(txtt.getText());
        conn=DBConn.DBConnection();
        String delete="delete from users where id=?";
             try {
                 pst=conn.prepareStatement(delete);
                 pst.setInt(1,id);
                 pst.executeUpdate();
                 pst.close();
                 conn.close();
             } catch (SQLException ex) {
                 Logger.getLogger(Testfx.class.getName()).log(Level.SEVERE, null, ex);
             }
        
    });
    
    x2.setOnAction((value)->{;
      primaryStage.setScene(s7);
    });
    back2.setOnAction((value)->{;
    primaryStage.setScene(s5);
    });
     
    Label labelids=new Label("Enter your id");
    TextField txtids=new TextField();
    
    Button back3=new Button("Back");
    Button submit19=new Button("Submit");
    
         t= new TableView();
        t.setPlaceholder(new Label("No rows to display"));
      
        
        TableColumn<User, Integer> c1 = new TableColumn<>("ID");
        c1.setCellValueFactory(new PropertyValueFactory<>("id"));
        

        TableColumn<User, String> c2 = new TableColumn<>("Name");
        c2.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<User, Integer> c3 = new TableColumn<>("numroom");
        c3.setCellValueFactory(new PropertyValueFactory<>("numroom")); 
        
        TableColumn<User, Integer> c4 = new TableColumn<>("numnights");
        c4.setCellValueFactory(new PropertyValueFactory<>("numnights"));

        t.getColumns().addAll(c1, c2, c3,c4);
        
        VBox v=new VBox(t);
    

    GridPane g7=new GridPane();
    g7.add(labelids,0,1);
    g7.add(txtids,1,1);
    g7.add(submit19,1,4,2,1);
    g7.add(back3, 1, 5);
    g7.setAlignment(Pos.CENTER);
    g7.setVgap(20);
    g7.setHgap(20);
    
    FlowPane root2=new FlowPane(g7,v);
    Scene s8=new Scene(root2,750,750);
    s8.getStylesheets().add(this.getClass().getResource("CSS.css").toExternalForm());
    x3.setOnAction((value)->{
        
      primaryStage.setScene(s8);
    });
    back3.setOnAction((value)->{;
    primaryStage.setScene(s5);
    });
    
    submit19.setOnAction(e->{
        if (txtids.getText() == null || txtids.getText().trim().isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setContentText("Please enter an ID first!");
        alert.show();
        return;
        }
        int id=Integer.parseInt(txtids.getText());
        t.getItems().clear();
        conn=DBConn.DBConnection();
        String select="select * from users where id=? ";
             try {
                 pst=conn.prepareStatement(select);
                 pst.setInt(1, id);
                 rest=pst.executeQuery();
                 if(rest.next()){
                     t.getItems().add(new User(rest.getString(2),rest.getInt(1),rest.getInt(3),rest.getInt(4)));
                 }
             } catch (SQLException ex) {
                 Logger.getLogger(Testfx.class.getName()).log(Level.SEVERE, null, ex);
             }
        
    });
    
    Label kl=new Label("Add your id");
    TextField kl1=new TextField();
    
    Label kl2=new Label("Enter your numroom");
    TextField kl3=new TextField();
    
    Label kl4=new Label("Enter your numnight");
    TextField kl5=new TextField();
    Button back4=new Button("Back");
    Button kl6=new Button("Submit");
    GridPane g8=new GridPane();
    g8.add(kl,0,0);
    g8.add(kl1,1,0);
    g8.add(kl2,0,1);
    g8.add(kl3,1,1);
    g8.add(kl4,0,2);
    g8.add(kl5,1,2);
    g8.add(kl6,1,3,2,1);
    g8.add(back4,1,4);
    g8.setAlignment(Pos.CENTER);
    g8.setVgap(20);
    g8.setHgap(20);
    Scene s9=new Scene(g8,750,750);
    s9.getStylesheets().add(this.getClass().getResource("CSS.css").toExternalForm());
    x4.setOnAction((value)->{;
      primaryStage.setScene(s9);
    });
    kl6.setOnAction(event->{
        int room=Integer.parseInt(kl3.getText());
        int night=Integer.parseInt(kl5.getText());
        int id =Integer.parseInt(kl1.getText());
        conn=DBConn.DBConnection();
        String Update="Update users set numroom=? , numnights=?  where id=?";
             try {
                 pst=conn.prepareStatement(Update);
                 pst.setInt(1, room);
                 pst.setInt(2, night);
                 pst.setInt(3, id);
                 pst.executeUpdate();
                 pst.close();
                 conn.close();
                 
                 
                 
                 
             } catch (SQLException ex) {
                 Logger.getLogger(Testfx.class.getName()).log(Level.SEVERE, null, ex);
             }
        
   
    
    
    });
    primaryStage.show();
    
    
    
    
    
    
    
    
    back4.setOnAction((value)->{;
    primaryStage.setScene(s5);
    });
    primaryStage.show();
    }
    
    
    
    
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
