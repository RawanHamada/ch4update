/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jit
 */
public class RegFxmlController implements Initializable {

    @FXML
    private TextField txtFieldStudentID;
    @FXML
    private TextField txtFieldCourseid;
    @FXML
    private TextField txtFieldSemester;
    @FXML
    private Button buttonregister;
    @FXML
    private Button buttonReset;

        private Statement statement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            // TODO
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
               DriverManager.
                getConnection("jdbc:mysql://127.0.0.1:3306/user-friendly?serverTimezone=UTC",
                        "root", "");
            this.statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
 

    }    

    @FXML
    private void buttonRegHandle(ActionEvent event) throws Exception {
        
            Integer stdId = Integer.parseInt(txtFieldStudentID.getText());
            Integer courseId = Integer.parseInt(txtFieldCourseid.getText());
            String semester = txtFieldSemester.getText();
            String sql = "Insert Into Registration values(" + stdId + "," + courseId + ",'"
                    + semester + "')";
            this.statement.executeUpdate(sql);
           
        reset();
    }

    @FXML
    private void buttonResetHandle(ActionEvent event) {
    reset();
    }
    
    private void reset() {
        txtFieldCourseid.setText("");
        txtFieldStudentID.setText("");
        txtFieldSemester.setText("");
    }
    
}
