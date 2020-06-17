/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author jit
 */
public class TableUserController implements Initializable {

    @FXML
    private TextField txtFieldID;
    @FXML
    private TextField txtFieldName;
    @FXML
    private TextField txtFieldMajor;
    @FXML
    private TextField txtFieldGrade;
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, Integer> tcID;
    @FXML
    private TableColumn<Student, String> tcName;
    @FXML
    private TableColumn<Student, String> tcMajor;
    @FXML
    private TableColumn<Student, Double> tcGrade;
    @FXML
    private Button buttonView;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonEdit;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonReset;

        Statement statement;
    @FXML
    private Button buttonReg;
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
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcMajor.setCellValueFactory(new PropertyValueFactory("Major"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("grade"));
        tableView.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedStudent());
 

        // TODO
    }    

    @FXML
    private void buttonViewHandle(ActionEvent event) throws Exception {
                ResultSet rs = this.statement.executeQuery("Select * From Student");
        tableView.getItems().clear();
        while(rs.next()){
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setMajor(rs.getString("major"));
            student.setGrade(rs.getDouble("grade"));
            tableView.getItems().add(student);
        }

    }

    @FXML
    private void buttonAddHandle(ActionEvent event) throws Exception {
        Integer id = Integer.parseInt(txtFieldID.getText());
        String name = txtFieldName.getText();
       String major = txtFieldMajor.getText();
     Double grade = Double.parseDouble(txtFieldGrade.getText());
        String sql = "Insert Into Student values(" + id + ",'" +name + "','" 
                + major + "'," + grade + ")";
        this.statement.executeUpdate(sql);

    }

    @FXML
    private void buttonEditHandle(ActionEvent event) throws Exception {
        Integer id = Integer.parseInt(txtFieldID.getText());
        String name = txtFieldName.getText();
        String major = txtFieldMajor.getText();
        Double grade = Double.parseDouble(txtFieldGrade.getText());
        String sql = "Update student Set name='" + name + "', major='" + 
                major + "', grade=" + grade + " Where id=" +id;
        this.statement.executeUpdate(sql);

    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) throws Exception {
        Integer id = Integer.parseInt(txtFieldID.getText());
        String sql = "delete from student where id = " + id + "";
        this.statement.executeUpdate(sql);
        buttonResetHandle(event);
        buttonViewHandle(event);

    }

    @FXML
    private void buttonResetHandle(ActionEvent event) {
            resetControls();
    }
    private void resetControls(){
        txtFieldID.setText("");
        txtFieldName.setText("");
        txtFieldMajor.setText("");
        txtFieldGrade.setText("");
        tableView.getItems().clear();
    }

        private void showSelectedStudent(){
        Student student = tableView.getSelectionModel().getSelectedItem();
        if(student != null){
        txtFieldID.setText(String.valueOf(student.getId()));
        txtFieldName.setText(student.getName());
        txtFieldMajor.setText(student.getMajor());
        txtFieldGrade.setText(String.valueOf(student.getGrade()));
        }

    }
 
    @FXML
    private void buttonRegHandle(ActionEvent event) {
      try {
            new RegRun().start(new Stage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
}
