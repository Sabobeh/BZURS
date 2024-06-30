package com.example.bzurs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;


public class SectionViewerController extends DB implements Initializable {

    @FXML
    private AnchorPane CoursesP;
    @FXML
    private TableColumn<Weekdays, String> DayColumn;
    @FXML
    private TableColumn<Weekdays, String> EightColumn;
    @FXML
    private TableColumn<Weekdays, String> ElevenColumn;
    @FXML
    private TableColumn<Weekdays, String> FiveColumn;
    @FXML
    private TableColumn<Weekdays, String> FourColumn;
    @FXML
    private TableColumn<Weekdays, String> NineColumn;
    @FXML
    private TableColumn<Weekdays, String> OneColumn;
    @FXML
    private TableView<Weekdays> ScheduleTable;
    @FXML
    private TableColumn<Weekdays, String> TenColumn;
    @FXML
    private TableColumn<Weekdays, String> ThreeColumn;
    @FXML
    private TreeView<String> TreeProgramViewer;
    @FXML
    private TableColumn<Weekdays, String> TwelveColumn;
    @FXML
    private TableColumn<Weekdays, String> TwoColumn;
    @FXML
    private AnchorPane scheduleP;
    @FXML
    private AnchorPane TreeP;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DB.stage.show();
        Alert welcome = new Alert(Alert.AlertType.INFORMATION);
        welcome.setTitle("Birzeit University Registration System");
        welcome.setContentText("Welcome " + DB.student_name + " :)");
        welcome.showAndWait();
        //setting schedule
        try {
            makeSchedule(student_id, year, semester);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //setting program table
        TableView<ProgramCourses> table = new TableView<>();
        TableColumn<ProgramCourses, Button> course_id = new TableColumn<>("ID");
        course_id.setCellValueFactory(new PropertyValueFactory<>("course_ID"));
        course_id.setPrefWidth(100);

        TableColumn<ProgramCourses, String> course_name = new TableColumn<>("Name");
        course_name.setCellValueFactory(new PropertyValueFactory<>("course_name"));
        course_name.setPrefWidth(385);

        TableColumn<ProgramCourses, TreeView<String>> prerequisites = new TableColumn<>("Prerequisites");
        prerequisites.setCellValueFactory(new PropertyValueFactory<>("prerequisites"));
        prerequisites.setPrefWidth(200);
        prerequisites.setMaxWidth(200);

        table.getColumns().addAll(course_id, course_name, prerequisites);
        table.setPrefSize(700,450);
        CoursesP.getChildren().add(table);

        ArrayList<ProgramCourses> pc = new ArrayList<>();
        //setting Programs and study plans viewer
        try {
            TreeItem<String> root = makeTree(student_id);
            TreeView<String> TreeProgramViewer = new TreeView<>(root);
            TreeProgramViewer.setShowRoot(false);
            TreeProgramViewer.setPrefSize(300, 700);
            TreeProgramViewer.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) ->
                setStudyPlanCourses(newValue, table, pc, CoursesP, student_id, year, semester));
            TreeP.getChildren().add(TreeProgramViewer);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void makeSectionsT(String item, AnchorPane coursesP, TableView<ProgramCourses> ogtable, int student_id, int year , int semester) throws SQLException, ClassNotFoundException {
        ArrayList<SectionData> sectionData = new ArrayList<>();
        TableView<SectionData> table = new TableView<>();
        TableColumn<SectionData, Button> section_id = new TableColumn<>("Section ID");
        section_id.setCellValueFactory(new PropertyValueFactory<>("section_id"));
        section_id.setPrefWidth(100);

        TableColumn<SectionData, String> professor_name = new TableColumn<>("Professor");
        professor_name.setCellValueFactory(new PropertyValueFactory<>("professor_name"));
        professor_name.setPrefWidth(250);

        TableColumn<SectionData, String> time = new TableColumn<>("Time");
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        time.setPrefWidth(250);

        TableColumn<SectionData, String> capacity = new TableColumn<>("Capacity");
        capacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        capacity.setPrefWidth(100);

        table.getColumns().addAll(section_id, professor_name, time, capacity);
        table.setPrefHeight(400);
        table.setTranslateY(50);
        Button back = new Button("Back");
        back.setPrefHeight(40);
        back.setPrefWidth(100);
        back.setTranslateY(5);
        back.setTranslateX(5);
        setButton(back);
        back.setOnMouseReleased(e -> {
            coursesP.getChildren().clear();
            coursesP.getChildren().addAll(ogtable);
        });

        connectDB();
        String SQL1;
        String SQL = "select s.section_id, p.professor_name, t.daycomb, t.timecomb, cl.classroom_capacity, t.timeperiod_id " +
                "from section s, course c, professor p, sectionisin sc, timeperiod t, classroom cl " +
                "where p.professor_id = s.professor_id and s.course_id = c.course_id " +
                "and c.course_id = '" + item + "' and sc.section_id = s.section_id " +
                "and cl.classroom_id = sc.classroom_id and t.timeperiod_id = sc.timeperiod_id and s.Section_academic_year = " +
                year + " and s.section_semester = " + semester + ";";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        while(rs.next()) {
            SQL1 = "select count(s.student_id) from senrollss s where s.section_id = " + rs.getString(1) + ";";
            Statement stmt1 = con.createStatement();
            ResultSet rs1 = stmt1.executeQuery(SQL1);
            while(rs1.next()) {
                Button button = new Button(rs.getString(1));
                button.setPrefWidth(100);
                button.setPrefHeight(45);
                setButton(button);
                button.setOnMouseReleased(e -> {
                    button.setStyle("""
                            -fx-text-fill: #FFFFFF;
                                -fx-background-color: #4a913f;
                                -fx-background-radius: 0px""");
                    try {
                        enrollInSection(Integer.parseInt(button.getText()), student_id, sectionData, item, ogtable, coursesP, year, semester);
                    } catch (SQLException | ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }

                });
                sectionData.add(new SectionData(button, rs.getString(2),
                        rs.getString(3) + " " + rs.getString(4),
                        rs1.getString(1) + "/" + rs.getString(5), Integer.parseInt(rs.getString(6))));
            }
        }
        table.setItems(FXCollections.observableList(sectionData));
        coursesP.getChildren().clear();
        coursesP.getChildren().addAll(back, table);

    }

    private void enrollInSection(int section_id, int student_id, ArrayList<SectionData> sectionData, String item
    , TableView<ProgramCourses> ogtable, AnchorPane coursesP, int year, int semester) throws SQLException, ClassNotFoundException {
        connectDB();

        String SQL2 = "select * from senrollss where student_id = " + student_id + " and section_id = " + section_id + ";";
        Statement stmt2 = con.createStatement();
        ResultSet rs2 = stmt2.executeQuery(SQL2);
        if(rs2.next()){
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Birzeit University Registration System");
            alert1.setContentText("You are already enrolled in this class");
            alert1.showAndWait();
        }
        else {
            String SQL5 = "select s.section_id\n" +
                    "from senrollss s, section sc\n" +
                    "where s.section_id = sc.Section_ID and sc.Section_Academic_year = " + year + " and sc.Section_semester = " +
                    semester + " and s.Student_id = " + student_id +
                    " and sc.course_id = (select course_id from section s where s.section_id = " + section_id + ");";
            Statement stmt5 = con.createStatement();
            ResultSet rs5 = stmt5.executeQuery(SQL5);
            if (rs5.next()) {
                Alert alert5 = new Alert(Alert.AlertType.CONFIRMATION);
                alert5.setTitle("Birzeit University Registration System");
                alert5.setContentText("Are you sure you want to switch to this section?");
                Optional<ButtonType> result = alert5.showAndWait();
                if(result.get() == ButtonType.OK){
                    ExecuteStatement("delete from senrollss where section_id = " + Integer.parseInt(rs5.getString(1))
                            + " and Student_id = " + student_id + ";");
                    enroll(section_id, student_id, sectionData, item, coursesP, ogtable, year, semester);
                }
            }
            else {
                enroll(section_id, student_id, sectionData, item, coursesP, ogtable, year, semester);
            }
        }
    }

    private void enroll(int section_id, int student_id, ArrayList<SectionData> sectionData, String item, AnchorPane coursesP, TableView<ProgramCourses> ogtable , int year, int semester) throws SQLException, ClassNotFoundException {
        connectDB();
        String SQL = "select course_name from course c " +
                "where c.course_id in(select pre_course_id " +
                "from course c, pre_course p, section sc " +
                "where c.course_id = p.course_id and sc.course_id = c.course_id " +
                "and sc.section_id = " + section_id + ") and c.course_name not in(select course_name " +
                "from section sc, student s, course c, senrollss e " +
                "where e.student_id = s.student_id and c.course_id = sc.course_id " +
                "and sc.section_id = e.section_id and e.grade >= 60 and s.student_id = " + student_id + ");";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        String pre = "";
        while (rs.next()) {
            pre += rs.getString(1) + "\n";
        }
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Birzeit University Registration System");
        if (!pre.isEmpty()) {
            System.out.println(pre);
            alert.setContentText("You are not eligible for enrolling in this class until you take the following courses:-\n" + pre);
            alert.setHeight(300);
            alert.setResizable(true);
            alert.showAndWait();
        } else {
            for (int i = 0; i < sectionData.size(); i++) {
                if (Integer.parseInt(sectionData.get(i).getSection_id().getText()) == section_id) {
                    String[] token = sectionData.get(i).getCapacity().split("/");
                    int min = Integer.parseInt(token[0]);
                    int max = Integer.parseInt(token[1]);
                    if (min >= max) {
                        alert.setContentText("Section is full");
                        alert.showAndWait();
                    } else {
                        String SQL1 = "select timeperiod_id, sc.section_id from senrollss s, section sc, sectionisin sci where s.section_id = sc.section_id" +
                                " and sci.section_id = sc.section_id and s.student_id = " + student_id + " and sc.section_academic_year = " + year + "" +
                                " and sc.section_semester = " + semester + ";";
                        Statement stmt1 = con.createStatement();
                        ResultSet rs1 = stmt1.executeQuery(SQL1);
                        int alrdy;
                        boolean ok = true;
                        while (rs1.next()) {
                            alrdy = Integer.parseInt(rs1.getString(1));
                            if (contradicts(alrdy, sectionData.get(i).getTimeperiod_id())) {
                                ok = false;
                                String SQL3 = "select course_name from section sc, course c" +
                                        " where sc.course_id = c.course_id and sc.section_id = " + rs1.getString(2) + ";";
                                Statement stmt3 = con.createStatement();
                                ResultSet rs3 = stmt3.executeQuery(SQL3);
                                if (rs3.next()) {
                                    Alert alert3 = new Alert(Alert.AlertType.ERROR);
                                    alert3.setTitle("Birzeit University Registration System");
                                    alert3.setContentText("This section contradicts with " + rs3.getString(1));
                                    alert3.showAndWait();
                                    break;
                                }

                            }
                        }
                        if (ok) {
                            ExecuteStatement("insert into senrollss values (" + student_id + ", "
                                    + Integer.parseInt(sectionData.get(i).getSection_id().getText()) + ", 0, 0);");
                            Alert alert4 = new Alert(Alert.AlertType.INFORMATION);
                            alert4.setTitle("Birzeit University Registration System");
                            alert4.setContentText("Successfully enrolled in section");
                            alert4.showAndWait();
                            makeSectionsT(item, coursesP, ogtable, student_id, year, semester);
                            makeSchedule(student_id, year, semester);

                        }
                    }
                }

            }

        }
    }

    private boolean contradicts(int alrdy, int desired) {
        int i = desired%10;
        int j = alrdy%10;
        System.out.println(i + " " + j);
        desired /= 10;
        alrdy /= 10;
        int itype = desired%10;
        int jtype = alrdy%10;
        System.out.println(itype + " " + jtype);
        desired /= 10;
        alrdy /= 10;
        int iday = desired;
        int jday = alrdy;
        System.out.println(iday + " " + jday);
        if(iday != jday){
            return false;
        } else if(itype == 2){
            if(i < j && j < i+3)
                return true;
        } else
            if(i == j || (i/3)*3 == j){
                return true;
            }
        return false;
    }


    private void setStudyPlanCourses(TreeItem<String> newValue, TableView<ProgramCourses> table
            , ArrayList<ProgramCourses> pc, AnchorPane coursesP, int student_id, int year, int semester) {
        if(newValue != null){
            String[] token = newValue.getValue().split(" ");
            if(token[token.length-1].equalsIgnoreCase("program") || token[token.length-1].equalsIgnoreCase("minor")){
                try {
                    connectDB();
                    String SQL1;
                    String SQL = "select s.course_id, c.course_name from program p, study_plan s" +
                            ", course c " +
                            " where p.program_name = '"
                            + newValue.getValue() + "' and p.program_id = s.program_id"
                            + " and s.course_id = c.course_id";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(SQL);
                    pc.clear();
                    while(rs.next()) {
                        SQL1 = "select course_name from course c where c.course_id in(select pre_course_id" +
                        " from course c, pre_course p where c.course_id = p.course_id and c.course_id = '" + rs.getString(1) + "')";
                        Statement stmt1 = con.createStatement();
                        ResultSet rs1 = stmt1.executeQuery(SQL1);
                        ArrayList<String> pre = new ArrayList<>();
                        while(rs1.next()){
                            pre.add(rs1.getString(1));
                        }
                        TreeItem<String> root = new TreeItem<>();
                        for(int i = 0; i < pre.size(); i++){
                            makebranch(root, pre.get(i));
                        }
                        TreeView<String> tree = new TreeView<>(root);
                        tree.setShowRoot(false);
                        tree.setPrefSize(100, 50);
                        Button button = new Button(rs.getString(1));
                        button.setPrefWidth(100);
                        button.setPrefHeight(45);
                        setButton(button);
                        button.setOnMouseReleased(e ->{
                            button.setStyle("""
                                    -fx-text-fill: #FFFFFF;
                                        -fx-background-color: #4a913f;
                                        -fx-background-radius: 0px""");
                            try {
                                makeSectionsT(button.getText(), coursesP, table, student_id, year, semester);
                            } catch (SQLException | ClassNotFoundException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        tree.setOnMouseClicked(mouseEvent -> {
                            if (mouseEvent.getClickCount() == 2){
                                String course = tree.getSelectionModel().getSelectedItem().getValue();
                                try {
                                    connectDB();
                                    String SQL2 = "select course_id from course c " +
                                            " where course_name = '" + course + "'";
                                    Statement stmt2 = con.createStatement();
                                    ResultSet rs2 = stmt2.executeQuery(SQL2);
                                    while(rs2.next()) {
                                        System.out.println(table.getItems());
                                        makeSectionsT(rs2.getString(1), coursesP, table, student_id, year, semester);
                                    }
                                } catch (ClassNotFoundException | SQLException e) {
                                    throw new RuntimeException(e);
                                }

                            }
                        });
                        pc.add(new ProgramCourses(button, rs.getString(2)
                        , tree));
                    }
                    table.setItems(FXCollections.observableList(pc));
                    CoursesP.getChildren().clear();
                    CoursesP.getChildren().add(table);
                } catch (ClassNotFoundException | SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    TreeItem<String> makeTree(int student_id) throws SQLException, ClassNotFoundException {
        TreeItem<String> root = new TreeItem<>();
        String SQL1, SQL2, SQL3;

        connectDB();
        String SQL = "select program_name from student s, program p where p.program_id = s.major_id and student_id = " + student_id + ";";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        while(rs.next()){
            makebranch(root, rs.getString(1));
        }

        String SQL4 = "select program_name from student s, program p, sdominor sd where p.program_id = sd.minor_id and sd.student_id = s.student_id and s.student_id = " + student_id + ";";
        Statement stmt4 = con.createStatement();
        ResultSet rs4 = stmt4.executeQuery(SQL4);
        while(rs4.next()){
            makebranch(root, rs4.getString(1));
        }

        SQL1 = "select faculty_name from Faculty";
        Statement stmt1 = con.createStatement();
        ResultSet rs1 = stmt1.executeQuery(SQL1);
        ArrayList<TreeItem<String>> faculties = new ArrayList<>();
//        rs1.last();
//        TreeItem<String>[] faculties= new TreeItem[rs1.getRow()];
//        rs1.first();
//        rs1.previous();
        int i = 0;
        while (rs1.next()) {
            faculties.add(makebranch(root, rs1.getString(1)));
            System.out.println(rs1.getString(1));
            SQL2 = "select department_name from faculty f, department d" +
                    " where f.Faculty_id = d.faculty_id and f.Faculty_name =\"" + rs1.getString(1) + "\"";
            Statement stmt2 = con.createStatement();
            ResultSet rs2 = stmt2.executeQuery(SQL2);
            ArrayList<TreeItem<String>> departments = new ArrayList<>();
//            rs2.last();
//            TreeItem<String>[] departments= new TreeItem[rs2.getRow()];
//            rs2.first();
//            rs2.previous();
            int j = 0;
            while(rs2.next()){
                departments.add(makebranch(faculties.get(i), rs2.getString(1)));
                System.out.println(rs2.getString(1));
                SQL3 = "select Program_name from faculty f, department d, program p" +
                " where f.Faculty_id = d.faculty_id and f.Faculty_name =\"" + rs1.getString(1)  + "\" and d.department_id = p.program_department_id and d.department_name =\"" + rs2.getString(1) + "\"";
                Statement stmt3 = con.createStatement();
                ResultSet rs3 = stmt3.executeQuery(SQL3);
//                rs3.last();
//                TreeItem<String>[] programs= new TreeItem[rs3.getRow()];
//                rs3.first();
//                rs3.previous();
                while(rs3.next()) {
                    makebranch(departments.get(j), rs3.getString(1));
                    System.out.println(rs3.getString(1));
                }
                j++;
            }
            i++;
        }
        con.close();
        return root;
    }

    private TreeItem<String> makebranch(TreeItem<String> root, String string) {
        TreeItem<String> temp = new TreeItem<>(string);
        root.getChildren().add(temp);
        return temp;
    }

    void makeSchedule(int student_id, int year, int semester) throws SQLException, ClassNotFoundException {
        ArrayList<Weekdays> weekdays = new ArrayList<>();
        weekdays.add(new Weekdays("Saturday"));
        weekdays.add(new Weekdays("Sunday"));
        weekdays.add(new Weekdays("Monday"));
        weekdays.add(new Weekdays("Tuesday"));
        weekdays.add(new Weekdays("Wednesday"));
        weekdays.add(new Weekdays("Thursday"));
        weekdays.add(new Weekdays("Friday"));
        ObservableList<Weekdays> weekdays1 = FXCollections.observableArrayList(weekdays);
        ScheduleTable = new TableView<>();
        DayColumn = new TableColumn<>("Day");
        DayColumn.setCellValueFactory(new PropertyValueFactory<>("day"));
        ScheduleTable.getColumns().clear();
        ScheduleTable.getColumns().addAll(DayColumn,EightColumn,NineColumn,TenColumn,ElevenColumn,TwelveColumn,OneColumn,TwoColumn,ThreeColumn,FourColumn,FiveColumn);
        ScheduleTable.setItems(weekdays1);
        scheduleP.getChildren().add(ScheduleTable);
        ScheduleTable.setPrefSize(900, 250);
        ScheduleTable.setFixedCellSize(32);
        DayColumn.setPrefWidth(98);
        ScheduleTable.setEditable(false);

        connectDB();
        System.out.println("Connection established");

        String SQL = "select timeperiod_id, course_id from senrollss s, section sc, sectionisin sci where s.section_id = sc.section_id" +
                " and sci.section_id = sc.section_id and s.student_id = " + student_id + " and sc.section_academic_year = " + year + "" +
                " and sc.section_semester = " + semester + ";";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        ArrayList<Button> buttons = new ArrayList<>();
        while (rs.next()) {
            Button button = new Button(rs.getString(2));
            button.setPrefHeight(32);
            setButton(button);
            button.setFont(new Font(12));
            button.setOnMouseReleased(e -> {
                try {
                    Alert alert5 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert5.setTitle("Birzeit University Registration System");
                    alert5.setContentText("Are you sure you want to withdraw from that section?");
                    Optional<ButtonType> result = alert5.showAndWait();
                    if(result.get() == ButtonType.OK){
                        connectDB();
                        ExecuteStatement("delete from senrollss where Student_id = " + student_id + " and section_id in (select section_id " +
                                " from section " +
                                " where course_id = '" + button.getText() +
                                "' and Section_Academic_year = " + year +
                                " and Section_semester = " + semester + ");");
                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                        alert1.setTitle("Birzeit University Registration System");
                        alert1.setContentText("Successfully withdrawn from that section");
                        alert1.showAndWait();
                        makeSchedule(student_id, year, semester);
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException(ex);
                }
            });
            int timeperiod = Integer.parseInt(rs.getString(1));
            int set = timeperiod%10;
            timeperiod /= 10;
            int type = timeperiod%10;
            timeperiod /= 10;
            int day = timeperiod%10;
            switch (day) {
                case 1 -> button.setTranslateY(89);
                case 2 -> button.setTranslateY(121);
                case 3 -> button.setTranslateY(153);
                case 4 -> button.setTranslateY(185);
                case 5 -> button.setTranslateY(25);
            }
            switch (type) {
                case 1 -> {
                    button.setPrefWidth(50);
                    button.setFont(new Font(8));
                }
                case 2 -> button.setPrefWidth(135);
                case 3 -> button.setPrefWidth(75);
            }
            switch (set) {
                case 0 -> button.setTranslateX(100);
                case 1 -> button.setTranslateX(130);
                case 2 -> button.setTranslateX(220);
                case 3, 4 -> button.setTranslateX(305);
                case 5 -> button.setTranslateX(390);
                case 6, 7 -> button.setTranslateX(475);
                case 8 -> button.setTranslateX(550);
            }
            buttons.add(button);
        }
        for(int i = 0; i < buttons.size(); i++) {
            scheduleP.getChildren().add(buttons.get(i));
        }
        con.close();

    }

    void setButton(Button button){
        button.setStyle("""
                -fx-text-fill: #FFFFFF;
                    -fx-background-color: #4a913f;
                    -fx-background-radius: 0px""");
        button.setOnMouseEntered(e -> button.setStyle("""
                -fx-text-fill: #FFFFFF;
                    -fx-background-color: #71b367;
                    -fx-background-radius: 0px"""));
        button.setOnMouseExited(e -> button.setStyle("""
                -fx-text-fill: #FFFFFF;
                    -fx-background-color: #4a913f;
                    -fx-background-radius: 0px"""));
        button.setOnMouseClicked(e -> button.setStyle("""
                -fx-text-fill: #FFFFFF;
                    -fx-background-color: #7abd6f;
                    -fx-background-radius: 0px"""));
    }
}
