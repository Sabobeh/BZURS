package com.example.bzurs;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import java.util.ResourceBundle;

import com.mysql.jdbc.ResultSetMetaData;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class DB extends Application implements Initializable {

    @FXML
    private ImageView BZULogo;
    @FXML
    private Button LoginB;
    @FXML
    private AnchorPane LoginscreenP;
    @FXML
    private Label LoginInfoL;
    @FXML
    private Label PasswordL;
    @FXML
    private TextField PasswordTF;
    @FXML
    private Label UsernameL;
    @FXML
    private TextField UsernameTF;


    public static void main(String[] args) {
        Application.launch(args);
    }
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Classroom> classrooms = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();
    ArrayList<Pre_Course> pre_courses = new ArrayList<>();
    ArrayList<Department> departments = new ArrayList<>();
    ArrayList<Faculty> faculties = new ArrayList<>();
    ArrayList<Professor> professors = new ArrayList<>();
    ArrayList<Program> programs = new ArrayList<>();
    ArrayList<SdoMinor> s_do_minor = new ArrayList<>();
    ArrayList<Section> sections = new ArrayList<>();
    ArrayList<SectionIsIn> section_is_in = new ArrayList<>();
    ArrayList<SenrollsS> s_enrolls_s = new ArrayList<>();
    ArrayList<StudyPlan> study_plans = new ArrayList<>();
    ArrayList<TimePeriod> time_Periods = new ArrayList<>();

    Connection con;
    static Stage stage;
    static String student_name;
    static int student_id;
    //        final int year = Calendar.getInstance().get(Calendar.YEAR);
//        int month = Calendar.getInstance().get(Calendar.MONTH) - 1;
//        int temp;
//        if(month < 1){
//            temp = 1;
//        } else if(month < 6){
//            temp = 2;
//        } else {
//            temp = 3;
//        }
//        final int semester = temp;
    final int year = 2021;
    final int semester = 2;

    @Override
    public void start(Stage stage) {
        this.stage = new Stage();
        try {
            Parent loginScreen = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
            Scene loginScreenScene = new Scene(loginScreen);
            this.stage.setScene(loginScreenScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.stage.setResizable(false);
        this.stage.show();

    }


    void insertData(Student rc) {

        try {
            System.out.println(
                    "Insert into student (Student_ID, Student_Name, National_ID, BirthDate, gender, Phone_Number, address, Graduation_Status, balance, email, Community_Hours) values('"
                            + rc.getStudent_ID() + "','" + rc.getStudent_Name() + "','" + rc.getNational_ID() + "','" + rc.getBirthDate() + "','"
                            + rc.getGender() + "', '" + rc.getPhone_Number() + "', '" + rc.getAddress() + "', '"
                            + rc.getGraduation_Status() + "', '" + rc.getBalance() + "', '" + rc.getEmail() + "', '"
                            + rc.getCommunity_Hours() + "', '" + rc.getMajor_id() + "', '" + rc.getGPA() + "')");

            connectDB();
            ExecuteStatement(
                    "Insert into student (Student_ID, Student_Name, National_ID, BirthDate, gender, Phone_Number, address, Graduation_Status, balance, email, Community_Hours) values('"
                            + rc.getStudent_ID() + "','" + rc.getStudent_Name() + "','" + rc.getNational_ID() + "','" + rc.getBirthDate() + "','"
                            + rc.getGender() + "', '" + rc.getPhone_Number() + "', '" + rc.getAddress() + "', '"
                            + rc.getGraduation_Status() + "', '" + rc.getBalance() + "', '" + rc.getEmail() + "', '"
                            + rc.getCommunity_Hours() + "', '" + rc.getMajor_id() + "', '" + rc.getGPA() + "');");
            con.close();
            System.out.println("Connection closed" + students.size());

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

     void getData() throws SQLException, ClassNotFoundException {

        String SQL;
        connectDB();
        System.out.println("Connection established");


        SQL = "select * from student";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
        int i = 0;
        while (rs.next()) {

            String[] token = new String[rsmd.getColumnCount()];
            for(int j = 0; j<token.length ; j++){
                if(rs.getString(j+1) == null)
                    token[j] = "0";
                else
                    token[j] = rs.getString(j+1);
            }

            students.add(new Student(Integer.parseInt(token[0]), token[1],
                    Integer.parseInt(token[2]), token[3], token[4].charAt(0),
                    token[5], token[6], token[7], Double.parseDouble(token[8]),
                    token[9], Integer.parseInt(token[10]), Integer.parseInt(token[11]),
                    Double.parseDouble(token[12])));
            System.out.println(students.get(i++));
        }

        SQL = "select * from Department";
        rs = stmt.executeQuery(SQL);
        rsmd = (ResultSetMetaData) rs.getMetaData();
        i = 0;
        while(rs.next()){

            String[] token = new String[rsmd.getColumnCount()];
            for(int j = 0; j<token.length ; j++){
                if(rs.getString(j+1) == null)
                    token[j] = "0";
                else
                    token[j] = rs.getString(j+1);
            }

            departments.add(new Department(Integer.parseInt(token[0]),
                    token[1], token[2], token[3], token[4], Integer.parseInt(token[5]),
                            Integer.parseInt(token[6])));
            System.out.println(departments.get(i++));

        }

        SQL = "select * from Faculty";
        rs = stmt.executeQuery(SQL);
        rsmd = (ResultSetMetaData) rs.getMetaData();
        i = 0;
        while(rs.next()){

            String[] token = new String[rsmd.getColumnCount()];
            for(int j = 0; j<token.length ; j++){
                if(rs.getString(j+1) == null)
                    token[j] = "0";
                else
                    token[j] = rs.getString(j+1);
            }

            faculties.add(new Faculty(Integer.parseInt(token[0]),
                    token[1], token[2], token[3],
                    token[4], Integer.parseInt(token[5])
                    ));
            System.out.println(faculties.get(i++));
        }

        SQL = "select * from Professor";
        rs = stmt.executeQuery(SQL);
        rsmd = (ResultSetMetaData) rs.getMetaData();
        i = 0;
        while(rs.next()){

            String[] token = new String[rsmd.getColumnCount()];
            for(int j = 0; j<token.length ; j++){
                if(rs.getString(j+1) == null)
                    token[j] = "0";
                else
                    token[j] = rs.getString(j+1);
            }

            professors.add(new Professor(Integer.parseInt(token[0]),
                    token[1], Integer.parseInt(token[2]), token[3], token[4].charAt(0),
                    token[5], token[6], token[7], token[8], Integer.parseInt(token[10])));
            System.out.println(professors.get(i++));
        }

        SQL = "select * from Classroom";
        rs = stmt.executeQuery(SQL);
        rsmd = (ResultSetMetaData) rs.getMetaData();
        i = 0;
        while(rs.next()){

            String[] token = new String[rsmd.getColumnCount()];
            for(int j = 0; j<token.length ; j++){
                if(rs.getString(j+1) == null)
                    token[j] = "0";
                else
                    token[j] = rs.getString(j+1);
            }

            classrooms.add(new Classroom(Integer.parseInt(token[0]),
                    Integer.parseInt(token[2]), token[1]));
            System.out.println(classrooms.get(i++));
        }

        SQL = "select * from Course";
        rs = stmt.executeQuery(SQL);
        rsmd = (ResultSetMetaData) rs.getMetaData();
        i = 0;
        while(rs.next()){

            String[] token = new String[rsmd.getColumnCount()];
            for(int j = 0; j<token.length ; j++){
                if(rs.getString(j+1) == null)
                    token[j] = "0";
                else
                    token[j] = rs.getString(j+1);
            }

            courses.add(new Course(token[0],
                    token[1], Integer.parseInt(token[2]), Integer.parseInt(token[3])));
            System.out.println(courses.get(i++));
        }

        SQL = "select * from Pre_Course";
        rs = stmt.executeQuery(SQL);
        rsmd = (ResultSetMetaData) rs.getMetaData();
        i = 0;
        while(rs.next()){

            String[] token = new String[rsmd.getColumnCount()];
            for(int j = 0; j<token.length ; j++){
                if(rs.getString(j+1) == null)
                    token[j] = "0";
                else
                    token[j] = rs.getString(j+1);
            }

            pre_courses.add(new Pre_Course(token[0],
                    token[1]));
            System.out.println(pre_courses.get(i++));
        }


        SQL = "select * from Program";
        rs = stmt.executeQuery(SQL);
        rsmd = (ResultSetMetaData) rs.getMetaData();
        i = 0;
        while(rs.next()){

            String[] token = new String[rsmd.getColumnCount()];
            for(int j = 0; j<token.length ; j++){
                if(rs.getString(j+1) == null)
                    token[j] = "0";
                else
                    token[j] = rs.getString(j+1);
            }

            programs.add(new Program(Integer.parseInt(token[0]), token[1],
                    Integer.parseInt(token[3]), token[2], Integer.parseInt(token[4]), token[5],
                    Integer.parseInt(token[6])));
            System.out.println(programs.get(i++));
        }

        SQL = "select * from SdoMinor";
        rs = stmt.executeQuery(SQL);
        rsmd = (ResultSetMetaData) rs.getMetaData();
        i = 0;
        while(rs.next()){

            String[] token = new String[rsmd.getColumnCount()];
            for(int j = 0; j<token.length ; j++){
                if(rs.getString(j+1) == null)
                    token[j] = "0";
                else
                    token[j] = rs.getString(j+1);
            }

            s_do_minor.add(new SdoMinor(Integer.parseInt(token[0]), Integer.parseInt(token[1])));
            System.out.println(s_do_minor.get(i++));
        }

        SQL = "select * from Section";
        rs = stmt.executeQuery(SQL);
        rsmd = (ResultSetMetaData) rs.getMetaData();
        i = 0;
        while(rs.next()){

            String[] token = new String[rsmd.getColumnCount()];
            for(int j = 0; j<token.length ; j++){
                if(rs.getString(j+1) == null)
                    token[j] = "0";
                else
                    token[j] = rs.getString(j+1);
            }

            sections.add(new Section(Integer.parseInt(token[0]), Integer.parseInt(token[1]),
                    Integer.parseInt(token[2]), Integer.parseInt(token[3]), token[4]));
            System.out.println(sections.get(i++));
        }

        SQL = "select * from SectionIsIn";
        rs = stmt.executeQuery(SQL);
        rsmd = (ResultSetMetaData) rs.getMetaData();
        i = 0;
        while(rs.next()){

            String[] token = new String[rsmd.getColumnCount()];
            for(int j = 0; j<token.length ; j++){
                if(rs.getString(j+1) == null)
                    token[j] = "0";
                else
                    token[j] = rs.getString(j+1);
            }

            section_is_in.add(new SectionIsIn(Integer.parseInt(token[0]),
                    Integer.parseInt(token[1]), Integer.parseInt(token[2])));
            System.out.println(section_is_in.get(i++));
        }

        SQL = "select * from SenrollsS";
        rs = stmt.executeQuery(SQL);
        rsmd = (ResultSetMetaData) rs.getMetaData();
        i = 0;
        while(rs.next()){

            String[] token = new String[rsmd.getColumnCount()];
            for(int j = 0; j<token.length ; j++){
                if(rs.getString(j+1) == null)
                    token[j] = "0";
                else
                    token[j] = rs.getString(j+1);
            }

            s_enrolls_s.add(new SenrollsS(Integer.parseInt(token[0]),
                    Integer.parseInt(token[1]), Integer.parseInt(token[2]),
                    Double.parseDouble(token[3])));
            System.out.println(s_enrolls_s.get(i++));
        }

        SQL = "select * from Study_Plan";
        rs = stmt.executeQuery(SQL);
        rsmd = (ResultSetMetaData) rs.getMetaData();
        i = 0;
        while(rs.next()){

            String[] token = new String[rsmd.getColumnCount()];
            for(int j = 0; j<token.length ; j++){
                if(rs.getString(j+1) == null)
                    token[j] = "0";
                else
                    token[j] = rs.getString(j+1);
            }

            study_plans.add(new StudyPlan(token[0],
                    Integer.parseInt(token[1])));
            System.out.println(study_plans.get(i++));
        }

        SQL = "select * from TimePeriod";
        rs = stmt.executeQuery(SQL);
        rsmd = (ResultSetMetaData) rs.getMetaData();
        i = 0;
        while(rs.next()){

            String[] token = new String[rsmd.getColumnCount()];
            for(int j = 0; j<token.length ; j++){
                if(rs.getString(j+1) == null)
                    token[j] = "0";
                else
                    token[j] = rs.getString(j+1);
            }

            time_Periods.add(new TimePeriod(Integer.parseInt(token[0]), token[1],
                    token[2], Integer.parseInt(token[3])));
            System.out.println(time_Periods.get(i++));
        }

        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed");

    }

    void connectDB() throws ClassNotFoundException, SQLException {

        String dbName = "BZURS";
        String port = "3306";
        String URL = "127.0.0.1";
        String dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
        Properties p = new Properties();
        String dbUsername = "root";
        p.setProperty("user", dbUsername);
        String dbPassword = "ahmad2004";
        p.setProperty("password", dbPassword);
        p.setProperty("useSSL", "false");
        p.setProperty("autoReconnect", "true");
        Class.forName("com.mysql.jdbc.Driver");

        con = DriverManager.getConnection(dbURL, p);

    }

    public boolean ExecuteStatement(String SQL) throws SQLException {

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(SQL);
            stmt.close();
            return true;

        } catch (SQLException s) {
            s.printStackTrace();
            System.out.println("SQL statement is not executed!");
            return false;

        }

    }

    @FXML
    void MouseHover(MouseEvent event) {
        LoginB.getStyleClass().add("button-hover");
    }

    @FXML
    void MouseUnHover(MouseEvent event) {
        LoginB.getStyleClass().removeAll("button-hover");

    }

    @FXML
    void MouseClicked(MouseEvent event) {
        LoginB.getStyleClass().add("button-clicked");
    }

    @FXML
    void MouseReleased(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
        LoginB.getStyleClass().removeAll("button-clicked");
        LoginInfoL.setText("Stop pressing the button!");
        try{
            if (UsernameTF.getText().equals("DBA")) {
                Parent loginScreen = FXMLLoader.load(getClass().getResource("DBAInterface.fxml"));
                Scene loginScreenScene = new Scene(loginScreen);
                this.stage.setScene(loginScreenScene);
                this.stage.show();
                return;
            } else {
                connectDB();
                String SQL = "select student_name from student where student_id = " + Integer.parseInt(UsernameTF.getText()) + ";";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);
                if (rs.next()) {
                    student_id = Integer.parseInt(UsernameTF.getText());
                    student_name = rs.getString(1);
                    Parent loginScreen = FXMLLoader.load(getClass().getResource("SectionsViewer.fxml"));
                    Scene loginScreenScene = new Scene(loginScreen);
                    this.stage.setScene(loginScreenScene);
                    this.stage.show();
                }
            }
        } catch(Exception e){

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UsernameTF.setText("");
    }
}

   



