package com.example.bzurs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DBAIntrefaceController extends DB implements Initializable {

    @FXML
    private Button Bars;
    @FXML
    private Button Charts;
    @FXML
    private Button ClassroomsB;
    @FXML
    private Button CoursesB;
    @FXML
    private Button DepartmentsB;
    @FXML
    private AnchorPane EditP;
    @FXML
    private AnchorPane TableP;
    @FXML
    private Button FaciltiesB;
    @FXML
    private Button PrerequisitesB;
    @FXML
    private Button ProfessorsB;
    @FXML
    private Button ProgramsB;
    @FXML
    private Button SectionIsInB;
    @FXML
    private Button SectionsB;
    @FXML
    private Button StudyPlansB;
    @FXML
    private Button TimePeriodsB;
    @FXML
    private Button SectionsandStudentsB;
    @FXML
    private Button StudentsAndMinorB;
    @FXML
    private Button StudentsB;

    private Boolean update(String table, String column, String newValue, String IDComlumn, String id, int flag) {
        boolean flag1 = true;
        try {

            connectDB();
            if (flag == 0)
                flag1 = ExecuteStatement("update " + table + " set " + column + " = " + Integer.parseInt(newValue) + " where "+ IDComlumn + " = " + Integer.parseInt(id) +";");
            else if (flag == 2)
                flag1 =ExecuteStatement("update " + table + " set " + column + " = " + Integer.parseInt(newValue) + " where "+ IDComlumn + " = '" + id +"';");
            else if (flag == 1)
                flag1 =ExecuteStatement("update " + table + " set " + column + " = '" + newValue + "' where "+ IDComlumn + " = " + Integer.parseInt(id) +";");
            else if (flag == 3)
                flag1 =ExecuteStatement("update " + table + " set " + column + " = '" + newValue + "' where "+ IDComlumn + " = '" + id +"';");
            else if (flag == 4)
                flag1 = ExecuteStatement("update " + table + " set " + column + " = " + (newValue) + " where "+ IDComlumn + " = " + Integer.parseInt(id) +";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        return  flag1;
    }

    private boolean update(String table, String column, String newValue, String IDComlumn1, String id1, String IDComlumn2, String id2, int flag) {
        boolean flag1 = true;
        try {
            connectDB();
            if (flag == 0)
                flag1 = ExecuteStatement("update " + table + " set " + column + " = " + (newValue) + " where "+ IDComlumn1 + " = " + Integer.parseInt(id1)+ " AND " + IDComlumn2 + " = " + Integer.parseInt(id2)+ ";");
            else if (flag == 2) {
                flag1= ExecuteStatement("update " + table + " set " + column + " = '" + (newValue) + "' where " + IDComlumn1 + " = '" + id1 + "' AND " + IDComlumn2 + " = '" + id2 + "';");
            }
            else if (flag == 3) {
                flag1= ExecuteStatement("update " + table + " set " + column + " = '" + (newValue) + "' where " + IDComlumn1 + " = '" + id1 + "' AND " + IDComlumn2 + " = " + Integer.parseInt(id2) + ";");
            }
            else if (flag == 4) {
                flag1= ExecuteStatement("update " + table + " set " + column + " = '" + (newValue) + "' where " + IDComlumn1 + " = '" + id1 + "' AND " + IDComlumn2 + " = " + Integer.parseInt(id2) + ";");
            }
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return flag1;
    }

    private boolean update(String table, String column, String newValue, String IDComlumn1, String id1, String IDComlumn2, String id2, String IDComlumn3, String id3) {
        boolean flag1 = true;
        try {
            connectDB();
            flag1 =ExecuteStatement("update " + table + " set " + column + " = " + (newValue) + " where "+ IDComlumn1 + " = " + Integer.parseInt(id1)+ " AND " + IDComlumn2 + " = " + Integer.parseInt(id2) + " AND " + IDComlumn3 + " = " + Integer.parseInt(id3)+ ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

            return false;
        }
        return flag1;
    }

    @FXML
    void ClassroomsClicked(MouseEvent event) {
        removeReleased();
        ClassroomsB.getStyleClass().add("button-clicked");
    }

    @FXML
    void ClassroomsHover(MouseEvent event) {
        ClassroomsB.getStyleClass().add("button-hover");
    }

    @FXML
    void ClassroomsReleased(MouseEvent event) {
        Bars.setMinWidth(0);
        Charts.setMinWidth(0);
        ClassroomsB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        ClassroomsB.getStyleClass().add("button-released");

        TableView<Classroom> classroomTableView = new TableView<>();
        classroomTableView.setEditable(true);
        classroomTableView.prefWidth(830);
        classroomTableView.prefHeight(500);

        TableColumn<Classroom, Integer> classroomIDColumn = new TableColumn<>("Classroom ID");
        classroomIDColumn.setCellValueFactory(new PropertyValueFactory<>("classroom_ID"));
        classroomIDColumn.setPrefWidth(200);
        classroomIDColumn.setResizable(false);
        classroomIDColumn.setStyle( "-fx-alignment: CENTER;");


        TableColumn<Classroom, String> classroomNameColumn = new TableColumn<>("Name");
        classroomNameColumn.setCellValueFactory(new PropertyValueFactory<>("classroom_name"));
        classroomNameColumn.setPrefWidth(500);
        classroomNameColumn.setResizable(false);
        classroomNameColumn.setStyle( "-fx-alignment: CENTER;");
        classroomNameColumn.setCellFactory(TextFieldTableCell.<Classroom>forTableColumn());
        classroomNameColumn.setOnEditCommit((CellEditEvent<Classroom, String> t) -> {
            ((Classroom) t.getTableView().getItems().get(t.getTablePosition().getRow())).setClassroom_name(t.getNewValue());
            update("classroom", "classroom_Name",t.getNewValue(), "classroom_id", t.getRowValue().getClassroom_ID() + "",1);});


        TableColumn<Classroom, Integer> classroomCapacityColumn = new TableColumn<>("Classroom Capacity");
        classroomCapacityColumn.setCellValueFactory(new PropertyValueFactory<>("classroom_Capacity"));
        classroomCapacityColumn.setPrefWidth(130);
        classroomCapacityColumn.setResizable(false);
        classroomCapacityColumn.setStyle( "-fx-alignment: CENTER;");
        classroomCapacityColumn.setCellFactory(TextFieldTableCell.<Classroom, Integer>forTableColumn(new IntegerStringConverter()));
        classroomCapacityColumn.setOnEditCommit((CellEditEvent<Classroom, Integer> t) -> {
            ((Classroom) t.getTableView().getItems().get(t.getTablePosition().getRow())).setClassroom_Capacity(t.getNewValue());
            update("classroom", "classroom_Capacity",t.getNewValue()+"", "classroom_id", t.getRowValue().getClassroom_ID() + "",0);});


        classroomTableView.getColumns().addAll(classroomIDColumn, classroomNameColumn, classroomCapacityColumn);
        classroomTableView.setItems(FXCollections.observableList(classrooms));
        TableP.getChildren().clear();
        TableP.getChildren().add(classroomTableView);


    }



    @FXML
    void ClassroomsUnHover(MouseEvent event) {
        ClassroomsB.getStyleClass().removeAll("button-hover");
    }

    @FXML
    void CorursesHover(MouseEvent event) {
        CoursesB.getStyleClass().add("button-hover");
    }

    @FXML
    void CoursesClicked(MouseEvent event) {
        removeReleased();
        CoursesB.getStyleClass().add("button-clicked");
    }

    @FXML
    void CoursesReleased(MouseEvent event) {
        Bars.setMinWidth(0);
        Charts.setMinWidth(0);
        CoursesB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        CoursesB.getStyleClass().add("button-released");

        TableView<Course> courseTableView = new TableView<>();
        courseTableView.setEditable(true);
        courseTableView.prefWidth(830);
        courseTableView.prefHeight(500);


        TableColumn<Course, String> Course_ID_Column = new TableColumn<>("Course ID");
        Course_ID_Column.setCellValueFactory(new PropertyValueFactory<>("course_ID"));
        Course_ID_Column.setPrefWidth(200);
        Course_ID_Column.setResizable(false);
        Course_ID_Column.setStyle( "-fx-alignment: CENTER;");

        TableColumn<Course, String> courseNameColumn = new TableColumn<>("Name");
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courses_Name"));
        courseNameColumn.setPrefWidth(370);
        courseNameColumn.setResizable(false);
        courseNameColumn.setStyle( "-fx-alignment: CENTER;");
        courseNameColumn.setCellFactory(TextFieldTableCell.<Course>forTableColumn());
        courseNameColumn.setOnEditCommit((CellEditEvent<Course, String> t) -> {
            ((Course) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCourses_Name(t.getNewValue());
            update("course", "Course_name",t.getNewValue(), "course_id", t.getRowValue().getCourse_ID() + "",3);});

        TableColumn<Course, Integer> courseHoursColumn = new TableColumn<>("Course Hours");
        courseHoursColumn.setCellValueFactory(new PropertyValueFactory<>("credit_Hours"));
        courseHoursColumn.setPrefWidth(130);
        courseHoursColumn.setStyle( "-fx-alignment: CENTER;");
        courseHoursColumn.setResizable(false);

        TableColumn<Course, Integer> courseDeptIDColumn = new TableColumn<>("Department ID");
        courseDeptIDColumn.setCellValueFactory(new PropertyValueFactory<>("department_ID"));
        courseDeptIDColumn.setPrefWidth(130);
        courseDeptIDColumn.setResizable(false);
        courseDeptIDColumn.setStyle( "-fx-alignment: CENTER;");
        courseDeptIDColumn.setCellFactory(TextFieldTableCell.<Course, Integer>forTableColumn(new IntegerStringConverter()));
        courseDeptIDColumn.setOnEditCommit((CellEditEvent<Course, Integer> t) -> {
            if (!update("Course", "Course_department_ID",t.getNewValue()+"", "course_id", t.getRowValue().getCourse_ID() + "",2)){;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Department doesn't exist!!");
                alert.showAndWait();
                CoursesReleased(event);
            }
            else ((Course) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDepartment_ID(t.getNewValue());});




        courseTableView.getColumns().addAll(Course_ID_Column, courseNameColumn, courseHoursColumn, courseDeptIDColumn);
        courseTableView.setItems(FXCollections.observableList(courses));
        TableP.getChildren().clear();
        TableP.getChildren().add(courseTableView);
    }

    @FXML
    void CoursesunHover(MouseEvent event) {
        CoursesB.getStyleClass().removeAll("button-hover");

    }

    @FXML
    void DepartmentsHover(MouseEvent event) {
        DepartmentsB.getStyleClass().add("button-hover");

    }

    @FXML
    void DepartmentsReleased(MouseEvent event) {
        Bars.setMinWidth(0);
        Charts.setMinWidth(0);
        DepartmentsB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        DepartmentsB.getStyleClass().add("button-released");

        TableView<Department> DepartmentTableView = new TableView<>();
        DepartmentTableView.setEditable(true);
        DepartmentTableView.prefWidth(830);
        DepartmentTableView.prefHeight(500);


        TableColumn<Department, Integer> departmentIDColumn = new TableColumn<>("Department ID");
        departmentIDColumn.setCellValueFactory(new PropertyValueFactory<>("department_ID"));
        departmentIDColumn.setPrefWidth(100);
        departmentIDColumn.setResizable(false);
        departmentIDColumn.setStyle( "-fx-alignment: CENTER;");


        TableColumn<Department, String> departmentNameColumn = new TableColumn<>("Name");
        departmentNameColumn.setCellValueFactory(new PropertyValueFactory<>("department_Name"));
        departmentNameColumn.setPrefWidth(230);
        departmentNameColumn.setStyle( "-fx-alignment: CENTER;");
        departmentNameColumn.setResizable(false);
        departmentNameColumn.setCellFactory(TextFieldTableCell.<Department>forTableColumn());
        departmentNameColumn.setOnEditCommit((CellEditEvent<Department, String> t) -> {
            ((Department) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDepartment_Name(t.getNewValue());
            update("Department", "department_Name",t.getNewValue(), "department_ID", t.getRowValue().getDepartment_ID() + "",1);});


        TableColumn<Department, String> departmentPhoneColumn = new TableColumn<>("Phone");
        departmentPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone_Number"));
        departmentPhoneColumn.setPrefWidth(71);
        departmentPhoneColumn.setResizable(false);
        departmentPhoneColumn.setStyle( "-fx-alignment: CENTER;");
        departmentPhoneColumn.setCellFactory(TextFieldTableCell.<Department>forTableColumn());
        departmentPhoneColumn.setOnEditCommit((CellEditEvent<Department, String> t) -> {
            ((Department) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPhone_Number(t.getNewValue());
            update("Department", "department_phone_number",t.getNewValue(), "department_ID", t.getRowValue().getDepartment_ID() + "",1);});


        TableColumn<Department, String> departmentEmailColumn = new TableColumn<>("Email");
        departmentEmailColumn.setCellValueFactory(new PropertyValueFactory<>("department_Email"));
        departmentEmailColumn.setPrefWidth(120);
        departmentEmailColumn.setResizable(false);
        departmentEmailColumn.setStyle( "-fx-alignment: CENTER;");
        departmentEmailColumn.setCellFactory(TextFieldTableCell.<Department>forTableColumn());
        departmentEmailColumn.setOnEditCommit((CellEditEvent<Department, String> t) -> {
            ((Department) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDepartment_Email(t.getNewValue());
            update("Department", "department_Email",t.getNewValue(), "department_ID", t.getRowValue().getDepartment_ID() + "",1);});


        TableColumn<Department, String> departmentFaxColumn = new TableColumn<>("Fax");
        departmentFaxColumn.setCellValueFactory(new PropertyValueFactory<>("department_Fax"));
        departmentFaxColumn.setPrefWidth(75);
        departmentFaxColumn.setResizable(false);
        departmentFaxColumn.setStyle( "-fx-alignment: CENTER;");
        departmentFaxColumn.setCellFactory(TextFieldTableCell.<Department>forTableColumn());
        departmentFaxColumn.setOnEditCommit((CellEditEvent<Department, String> t) -> {
            ((Department) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDepartment_Fax(t.getNewValue());
            update("Department", "department_fax",t.getNewValue(), "department_ID", t.getRowValue().getDepartment_ID() + "",1);});


        TableColumn<Department, Integer> departmentFacultyID = new TableColumn<>("Faculty ID");
        departmentFacultyID.setCellValueFactory(new PropertyValueFactory<>("faculty_ID"));
        departmentFacultyID.setPrefWidth(100);
        departmentFacultyID.setResizable(false);
        departmentFacultyID.setStyle( "-fx-alignment: CENTER;");
        departmentFacultyID.setCellFactory(TextFieldTableCell.<Department, Integer>forTableColumn(new IntegerStringConverter()));
        departmentFacultyID.setOnEditCommit((CellEditEvent<Department, Integer> t) -> {
            if (!update("Department", "Faculty_ID",t.getNewValue()+"", "department_ID", t.getRowValue().getDepartment_ID() + "",0)){;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Faculty doesn't exist!!");
                alert.showAndWait();
                DepartmentsReleased(event);
            }
            else ((Department) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFaculty_ID(t.getNewValue());});

        TableColumn<Department, Integer> departmentManagerID = new TableColumn<>("Department Manager");
        departmentManagerID.setCellValueFactory(new PropertyValueFactory<>("department_Manager_ID"));
        departmentManagerID.setPrefWidth(140);
        departmentManagerID.setResizable(false);
        departmentManagerID.setStyle( "-fx-alignment: CENTER;");
        departmentManagerID.setCellFactory(TextFieldTableCell.<Department, Integer>forTableColumn(new IntegerStringConverter()));
        departmentManagerID.setOnEditCommit((CellEditEvent<Department, Integer> t) -> {
            if (!update("Department", "department_Manager_ID",t.getNewValue()+"", "department_ID", t.getRowValue().getDepartment_ID() + "",0)){;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Manager doesn't exist!!");
                alert.showAndWait();
                DepartmentsReleased(event);
            }
            else ((Department) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDepartment_Manager_ID(t.getNewValue());});



        DepartmentTableView.getColumns().addAll(departmentIDColumn, departmentNameColumn, departmentPhoneColumn, departmentEmailColumn,departmentFaxColumn,departmentFacultyID,departmentManagerID);
        DepartmentTableView.setItems(FXCollections.observableList(departments));
        TableP.getChildren().clear();
        TableP.getChildren().add(DepartmentTableView);
    }

    @FXML
    void DepartmentsUnHover(MouseEvent event) {
        DepartmentsB.getStyleClass().removeAll("button-hover");
    }

    @FXML
    void DepartmentsClicked(MouseEvent event) {
        removeReleased();
        DepartmentsB.getStyleClass().add("button-clicked");
    }

    @FXML
    void FacultiesClicked(MouseEvent event) {
        removeReleased();
        FaciltiesB.getStyleClass().add("button-clicked");
    }

    @FXML
    void FacultiesHover(MouseEvent event) {
        FaciltiesB.getStyleClass().add("button-hover");
    }

    @FXML
    void FacultiesReleased(MouseEvent event) {
        Bars.setMinWidth(0);
        Charts.setMinWidth(0);
        FaciltiesB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        FaciltiesB.getStyleClass().add("button-released");

        TableView<Faculty> facultyTableView = new TableView<>();
        facultyTableView.setEditable(true);
        facultyTableView.prefWidth(830);
        facultyTableView.prefHeight(500);


        TableColumn<Faculty, Integer> FacultyIDColumn = new TableColumn<>("Faculty ID");
        FacultyIDColumn.setCellValueFactory(new PropertyValueFactory<>("faculty_ID"));
        FacultyIDColumn.setPrefWidth(100);
        FacultyIDColumn.setResizable(false);
        FacultyIDColumn.setStyle( "-fx-alignment: CENTER;");


        TableColumn<Faculty, String> facultyNameColumn = new TableColumn<>("Name");
        facultyNameColumn.setCellValueFactory(new PropertyValueFactory<>("faculty_Name"));
        facultyNameColumn.setPrefWidth(230);
        facultyNameColumn.setResizable(false);
        facultyNameColumn.setStyle( "-fx-alignment: CENTER;");
        facultyNameColumn.setCellFactory(TextFieldTableCell.<Faculty>forTableColumn());
        facultyNameColumn.setOnEditCommit((CellEditEvent<Faculty, String> t) -> {
            ((Faculty) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFaculty_Name(t.getNewValue());
            update("Faculty", "faculty_Name",t.getNewValue(), "faculty_id", t.getRowValue().getFaculty_ID() + "",1);});

        TableColumn<Faculty, String> facultyPhoneColumn = new TableColumn<>("Phone");
        facultyPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("faculty_Phone_Number"));
        facultyPhoneColumn.setPrefWidth(100);
        facultyPhoneColumn.setResizable(false);
        facultyPhoneColumn.setStyle( "-fx-alignment: CENTER;");
        facultyPhoneColumn.setCellFactory(TextFieldTableCell.<Faculty>forTableColumn());
        facultyPhoneColumn.setOnEditCommit((CellEditEvent<Faculty, String> t) -> {
            ((Faculty) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFaculty_Phone_Number(t.getNewValue());
            update("Faculty", "faculty_Phone_number",t.getNewValue(), "faculty_id", t.getRowValue().getFaculty_ID() + "",1);});

        TableColumn<Faculty, String> facultyFaxColumn = new TableColumn<>("Fax");
        facultyFaxColumn.setCellValueFactory(new PropertyValueFactory<>("faculty_Fax"));
        facultyFaxColumn.setPrefWidth(120);
        facultyFaxColumn.setResizable(false);
        facultyFaxColumn.setStyle( "-fx-alignment: CENTER;");
        facultyFaxColumn.setCellFactory(TextFieldTableCell.<Faculty>forTableColumn());
        facultyFaxColumn.setOnEditCommit((CellEditEvent<Faculty, String> t) -> {
            ((Faculty) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFaculty_Fax(t.getNewValue());
            update("Faculty", "faculty_fax",t.getNewValue(), "faculty_id", t.getRowValue().getFaculty_ID() + "",1);});

        TableColumn<Faculty, String> facultyEmailColumn = new TableColumn<>("Email");
        facultyEmailColumn.setCellValueFactory(new PropertyValueFactory<>("faculty_Email"));
        facultyEmailColumn.setPrefWidth(150);
        facultyEmailColumn.setResizable(false);
        facultyEmailColumn.setStyle( "-fx-alignment: CENTER;");
        facultyEmailColumn.setCellFactory(TextFieldTableCell.<Faculty>forTableColumn());
        facultyEmailColumn.setOnEditCommit((CellEditEvent<Faculty, String> t) -> {
            ((Faculty) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFaculty_Email(t.getNewValue());
            update("Faculty", "faculty_Email",t.getNewValue(), "faculty_id", t.getRowValue().getFaculty_ID() + "",1);});


        TableColumn<Faculty, Integer> FacultyManagerColumn = new TableColumn<>("Faculty Manager");
        FacultyManagerColumn.setCellValueFactory(new PropertyValueFactory<>("faculty_Manager_ID"));
        FacultyManagerColumn.setPrefWidth(130);
        FacultyManagerColumn.setResizable(false);
        FacultyManagerColumn.setStyle( "-fx-alignment: CENTER;");
        FacultyManagerColumn.setCellFactory(TextFieldTableCell.<Faculty, Integer>forTableColumn(new IntegerStringConverter()));
        FacultyManagerColumn.setOnEditCommit((CellEditEvent<Faculty, Integer> t) -> {
            if (!update("Faculty", "faculty_manager_id",t.getNewValue()+"", "faculty_id", t.getRowValue().getFaculty_ID() + "",0)){;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Manager doesn't exist!!");
                alert.showAndWait();
                FacultiesReleased(event);
            }
            else ((Faculty) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFaculty_Manager_ID(t.getNewValue());});



        facultyTableView.getColumns().addAll(FacultyIDColumn, facultyNameColumn, facultyPhoneColumn, facultyFaxColumn, facultyEmailColumn, FacultyManagerColumn);
        facultyTableView.setItems(FXCollections.observableList(faculties));
        TableP.getChildren().clear();
        TableP.getChildren().add(facultyTableView);
    }

    @FXML
    void FacultiesUnHover(MouseEvent event) {
        FaciltiesB.getStyleClass().removeAll("button-hover");
    }

    @FXML
    void PrerequisitesClicked(MouseEvent event) {
        removeReleased();
        PrerequisitesB.getStyleClass().add("button-clicked");

    }

    @FXML
    void PrerequisitesHover(MouseEvent event) {
        PrerequisitesB.getStyleClass().add("button-hover");
    }

    @FXML
    void PrerequisitesReleased(MouseEvent event) {
        Bars.setMinWidth(0);
        Charts.setMinWidth(0);
        PrerequisitesB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        PrerequisitesB.getStyleClass().add("button-released");

        TableView<Pre_Course> preCourseTableView = new TableView<>();
        preCourseTableView.setEditable(true);
        preCourseTableView.prefWidth(830);
        preCourseTableView.prefHeight(500);



        TableColumn<Pre_Course, String> courseColumn = new TableColumn<>("Course");
        courseColumn.setCellValueFactory(new PropertyValueFactory<>("course_ID"));
        courseColumn.setPrefWidth(400);
        courseColumn.setResizable(false);
        courseColumn.setStyle( "-fx-alignment: CENTER;");
        courseColumn.setCellFactory(TextFieldTableCell.<Pre_Course>forTableColumn());
        courseColumn.setOnEditCommit((CellEditEvent<Pre_Course, String> t) -> {
            if (!update("Pre_Course", "Course_id",t.getNewValue(), "course_id", t.getOldValue(),"pre_course_id", t.getRowValue().getPre_course_ID() ,2)){;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Course doesn't exist!!");
                alert.showAndWait();
                ProgramsReleased(event);
            }
            else ((Pre_Course) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCourse_ID(t.getNewValue());});


        TableColumn<Pre_Course, String> preCourseColumn = new TableColumn<>("Prerequisite");
        preCourseColumn.setCellValueFactory(new PropertyValueFactory<>("pre_course_ID"));
        preCourseColumn.setPrefWidth(430);
        preCourseColumn.setResizable(false);
        preCourseColumn.setStyle( "-fx-alignment: CENTER;");
        preCourseColumn.setCellFactory(TextFieldTableCell.<Pre_Course>forTableColumn());
        preCourseColumn.setOnEditCommit((CellEditEvent<Pre_Course, String> t) -> {
            if (!update("Pre_Course", "Pre_Course_id",t.getNewValue(), "course_id", t.getRowValue().getCourse_ID(),"pre_course_id", t.getOldValue() ,2)){;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Course doesn't exist!!");
                alert.showAndWait();
                PrerequisitesReleased(event);
            }
            else ((Pre_Course) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPre_course_ID(t.getNewValue());});





        preCourseTableView.getColumns().addAll(courseColumn, preCourseColumn);
        preCourseTableView.setItems(FXCollections.observableList(pre_courses));
        TableP.getChildren().clear();
        TableP.getChildren().add(preCourseTableView);
    }

    @FXML
    void PrerequisitesunHover(MouseEvent event) {
        PrerequisitesB.getStyleClass().removeAll("button-hover");
    }

    @FXML
    void ProfessorsClicked(MouseEvent event) {
        removeReleased();
        ProfessorsB.getStyleClass().add("button-clicked");
    }

    @FXML
    void ProfessorsHover(MouseEvent event) {
        ProfessorsB.getStyleClass().add("button-hover");
    }

    @FXML
    void ProfessorsReleased(MouseEvent event) {
        Bars.setMinWidth(0);
        Charts.setMinWidth(0);
        ProfessorsB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        ProfessorsB.getStyleClass().add("button-released");


        TableView<Professor> professorTableView = new TableView<>();
        professorTableView.setEditable(true);
        professorTableView.prefWidth(830);
        professorTableView.prefHeight(500);


        TableColumn<Professor, Integer> professorIDColumn = new TableColumn<>("PID");
        professorIDColumn.setCellValueFactory(new PropertyValueFactory<>("professor_ID"));
        professorIDColumn.setPrefWidth(40);
        professorIDColumn.setResizable(false);
        professorIDColumn.setStyle( "-fx-alignment: CENTER;");


        TableColumn<Professor, String> professormNameColumn = new TableColumn<>("Name");
        professormNameColumn.setCellValueFactory(new PropertyValueFactory<>("professor_Name"));
        professormNameColumn.setPrefWidth(110);
        professormNameColumn.setResizable(false);
        professormNameColumn.setStyle( "-fx-alignment: CENTER;");
        professormNameColumn.setCellFactory(TextFieldTableCell.<Professor>forTableColumn());
        professormNameColumn.setOnEditCommit((CellEditEvent<Professor, String> t) -> {
            ((Professor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setProfessor_Name(t.getNewValue());
            update("Professor", "professor_Name",t.getNewValue(), "professor_ID", t.getRowValue().getProfessor_ID() + "",1);});


        TableColumn<Professor, Integer> professorNIDColumn = new TableColumn<>("National ID");
        professorNIDColumn.setCellValueFactory(new PropertyValueFactory<>("national_ID"));
        professorNIDColumn.setPrefWidth(75);
        professorNIDColumn.setResizable(false);
        professorNIDColumn.setStyle( "-fx-alignment: CENTER;");
        professorNIDColumn.setCellFactory(TextFieldTableCell.<Professor, Integer>forTableColumn(new IntegerStringConverter()));
        professorNIDColumn.setOnEditCommit((CellEditEvent<Professor, Integer> t) -> {
            ((Professor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNational_ID(t.getNewValue());
            update("Professor", "professor_NID",t.getNewValue()+"", "professor_ID", t.getRowValue().getProfessor_ID() + "",0);});

        TableColumn<Professor, String> professormDateColumn = new TableColumn<>("Birthdate");
        professormDateColumn.setCellValueFactory(new PropertyValueFactory<>("professor_BirthDate"));
        professormDateColumn.setPrefWidth(90);
        professormDateColumn.setResizable(false);
        professormDateColumn.setStyle( "-fx-alignment: CENTER;");
        professormDateColumn.setCellFactory(TextFieldTableCell.<Professor>forTableColumn());
        professormDateColumn.setOnEditCommit((CellEditEvent<Professor, String> t) -> {
            ((Professor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setProfessor_BirthDate(t.getNewValue());
            update("Professor", "professor_BDate",t.getNewValue(), "professor_ID", t.getRowValue().getProfessor_ID() + "",1);});

        TableColumn<Professor, String> professormGenderColumn = new TableColumn<>("Gender");
        professormGenderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        professormGenderColumn.setPrefWidth(50);
        professormGenderColumn.setResizable(false);
        professormGenderColumn.setStyle( "-fx-alignment: CENTER;");
        professormGenderColumn.setCellFactory(TextFieldTableCell.<Professor>forTableColumn());
        professormGenderColumn.setOnEditCommit((CellEditEvent<Professor, String> t) -> {
            ((Professor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setGender(t.getNewValue());
            update("Professor", "professor_gender",t.getNewValue(), "professor_ID", t.getRowValue().getProfessor_ID() + "",1);});

        TableColumn<Professor, String> professormPhoneColumn = new TableColumn<>("Phone");
        professormPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("professor_Phone_Number"));
        professormPhoneColumn.setPrefWidth(80);
        professormPhoneColumn.setResizable(false);
        professormPhoneColumn.setStyle( "-fx-alignment: CENTER;");
        professormPhoneColumn.setCellFactory(TextFieldTableCell.<Professor>forTableColumn());
        professormPhoneColumn.setOnEditCommit((CellEditEvent<Professor, String> t) -> {
            ((Professor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setProfessor_Phone_Number(t.getNewValue());
            update("Professor", "professor_phoneNo",t.getNewValue(), "professor_ID", t.getRowValue().getProfessor_ID() + "",1);});

        TableColumn<Professor, String> professormaddressColumn = new TableColumn<>("Address");
        professormaddressColumn.setCellValueFactory(new PropertyValueFactory<>("professor_Address"));
        professormaddressColumn.setPrefWidth(70);
        professormaddressColumn.setResizable(false);
        professormaddressColumn.setStyle( "-fx-alignment: CENTER;");
        professormaddressColumn.setCellFactory(TextFieldTableCell.<Professor>forTableColumn());
        professormaddressColumn.setOnEditCommit((CellEditEvent<Professor, String> t) -> {
            ((Professor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setProfessor_Address(t.getNewValue());
            update("Professor", "professor_address",t.getNewValue(), "professor_ID", t.getRowValue().getProfessor_ID() + "",1);});

        TableColumn<Professor, String> professorDegreeColumn = new TableColumn<>("Degree");
        professorDegreeColumn.setCellValueFactory(new PropertyValueFactory<>("professor_Degree"));
        professorDegreeColumn.setPrefWidth(70);
        professorDegreeColumn.setResizable(false);
        professorDegreeColumn.setStyle( "-fx-alignment: CENTER;");
        professorDegreeColumn.setCellFactory(TextFieldTableCell.<Professor>forTableColumn());
        professorDegreeColumn.setOnEditCommit((CellEditEvent<Professor, String> t) -> {
            ((Professor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setProfessor_Degree(t.getNewValue());
            update("Professor", "professor_degree",t.getNewValue(), "professor_ID", t.getRowValue().getProfessor_ID() + "",1);});


        TableColumn<Professor, String> professorEmailColumn = new TableColumn<>("Email");
        professorEmailColumn.setCellValueFactory(new PropertyValueFactory<>("professor_Email"));
        professorEmailColumn.setPrefWidth(130);
        professorEmailColumn.setResizable(false);
        professorEmailColumn.setStyle( "-fx-alignment: CENTER;");
        professorEmailColumn.setCellFactory(TextFieldTableCell.<Professor>forTableColumn());
        professorEmailColumn.setOnEditCommit((CellEditEvent<Professor, String> t) -> {
            ((Professor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setProfessor_Email(t.getNewValue());
            update("Professor", "professor_Email",t.getNewValue(), "professor_ID", t.getRowValue().getProfessor_ID() + "",1);});

        TableColumn<Professor, Integer> professorAgeColumn = new TableColumn<>("Age");
        professorAgeColumn.setCellValueFactory(new PropertyValueFactory<>("professor_Age"));
        professorAgeColumn.setPrefWidth(60);
        professorAgeColumn.setResizable(false);
        professorAgeColumn.setStyle( "-fx-alignment: CENTER;");

        TableColumn<Professor, Integer> professorDepartmentColumn = new TableColumn<>("Department");
        professorDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department_ID"));
        professorDepartmentColumn.setPrefWidth(60);
        professorDepartmentColumn.setResizable(false);
        professorDepartmentColumn.setStyle( "-fx-alignment: CENTER;");
        professorDepartmentColumn.setCellFactory(TextFieldTableCell.<Professor, Integer>forTableColumn(new IntegerStringConverter()));
        professorDepartmentColumn.setOnEditCommit((CellEditEvent<Professor, Integer> t) -> {
            if (!update("Professor", "department_id",t.getNewValue()+"", "professor_id", t.getRowValue().getProfessor_ID() + "",0)){;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Department doesn't exist!!");
                alert.showAndWait();
                ProfessorsReleased(event);
            }
            else ((Professor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDepartment_ID(t.getNewValue());});

        professorTableView.getColumns().addAll(professorIDColumn, professormNameColumn, professorNIDColumn, professormDateColumn, professormGenderColumn, professormPhoneColumn, professormaddressColumn, professorEmailColumn, professorDegreeColumn,professorAgeColumn,professorDepartmentColumn);
        professorTableView.setItems(FXCollections.observableList(professors));
        TableP.getChildren().clear();
        TableP.getChildren().add(professorTableView);
    }

    @FXML
    void ProfessorsunHover(MouseEvent event) {
        ProfessorsB.getStyleClass().removeAll("button-hover");

    }

    @FXML
    void ProgramsClicked(MouseEvent event) {
        removeReleased();
        ProgramsB.getStyleClass().add("button-clicked");

    }

    @FXML
    void ProgramsHover(MouseEvent event) {
        ProgramsB.getStyleClass().add("button-hover");
    }

    @FXML
    void ProgramsReleased(MouseEvent event) {
        Charts.setMinWidth(0);
        ProgramsB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        ProgramsB.getStyleClass().add("button-released");

        TableView<Program> ProgramTableView = new TableView<>();
        ProgramTableView.setEditable(true);
        ProgramTableView.prefWidth(830);
        ProgramTableView.prefHeight(500);
        ProgramTableView.setStyle( "-fx-alignment: CENTER;");


        TableColumn<Program, Integer> ProgramIDColumn = new TableColumn<>("PID");
        ProgramIDColumn.setCellValueFactory(new PropertyValueFactory<>("program_ID"));
        ProgramIDColumn.setPrefWidth(100);
        ProgramIDColumn.setResizable(false);
        ProgramIDColumn.setStyle( "-fx-alignment: CENTER;");


        TableColumn<Program, String> programNameColumn = new TableColumn<>("Name");
        programNameColumn.setCellValueFactory(new PropertyValueFactory<>("program_Name"));
        programNameColumn.setPrefWidth(300);
        programNameColumn.setResizable(false);
        programNameColumn.setStyle( "-fx-alignment: CENTER;");
        programNameColumn.setCellFactory(TextFieldTableCell.<Program>forTableColumn());
        programNameColumn.setOnEditCommit((CellEditEvent<Program, String> t) -> {

            update("Program", "program_name",t.getNewValue(), "program_ID", t.getRowValue().getProgram_ID() + "",1);
            ((Program) t.getTableView().getItems().get(t.getTablePosition().getRow())).setProgram_Name(t.getNewValue());});

        TableColumn<Program, String> programAbbrevColumn = new TableColumn<>("Abbreviation");
        programAbbrevColumn.setCellValueFactory(new PropertyValueFactory<>("abbreviation"));
        programAbbrevColumn.setPrefWidth(90);
        programAbbrevColumn.setResizable(false);
        programAbbrevColumn.setStyle( "-fx-alignment: CENTER;");
        programAbbrevColumn.setCellFactory(TextFieldTableCell.<Program>forTableColumn());
        programAbbrevColumn.setOnEditCommit((CellEditEvent<Program, String> t) -> {
            ((Program) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAbbreviation(t.getNewValue());
            update("Program", "abbreviation",t.getNewValue(), "program_ID", t.getRowValue().getProgram_ID() + "",1);});


        TableColumn<Program, Integer> programHoursColumn = new TableColumn<>("Hours");
        programHoursColumn.setCellValueFactory(new PropertyValueFactory<>("credit_Hours"));
        programHoursColumn.setPrefWidth(100);
        programHoursColumn.setResizable(false);
        programHoursColumn.setStyle( "-fx-alignment: CENTER;");
        programHoursColumn.setCellFactory(TextFieldTableCell.<Program, Integer>forTableColumn(new IntegerStringConverter()));
        programHoursColumn.setOnEditCommit((CellEditEvent<Program, Integer> t) -> {
            ((Program) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCredit_Hours(t.getNewValue());
            update("Program", "credit_hours",t.getNewValue()+"", "program_ID", t.getRowValue().getProgram_ID() + "",0);});

        TableColumn<Program, Integer> programHoursPriceColumn = new TableColumn<>("Hour Price");
        programHoursPriceColumn.setCellValueFactory(new PropertyValueFactory<>("credit_Hour_Price"));
        programHoursPriceColumn.setPrefWidth(150);
        programHoursPriceColumn.setResizable(false);
        programHoursPriceColumn.setStyle( "-fx-alignment: CENTER;");
        programHoursPriceColumn.setCellFactory(TextFieldTableCell.<Program, Integer>forTableColumn(new IntegerStringConverter()));
        programHoursPriceColumn.setOnEditCommit((CellEditEvent<Program, Integer> t) -> {
            ((Program) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCredit_Hour_Price(t.getNewValue());
            update("Program", "credit_hour_price",t.getNewValue()+"", "program_ID", t.getRowValue().getProgram_ID() + "",0);});


        TableColumn<Program, String> programMMColumn = new TableColumn<>("Type");
        programMMColumn.setCellValueFactory(new PropertyValueFactory<>("major_Minor"));
        programMMColumn.setPrefWidth(90);
        programMMColumn.setResizable(false);
        programMMColumn.setStyle( "-fx-alignment: CENTER;");
        programMMColumn.setCellFactory(TextFieldTableCell.<Program>forTableColumn());
        programMMColumn.setOnEditCommit((CellEditEvent<Program, String> t) -> {
            ((Program) t.getTableView().getItems().get(t.getTablePosition().getRow())).setMajor_Minor(t.getNewValue());
            update("Program", "major_minor",t.getNewValue(), "program_ID", t.getRowValue().getProgram_ID() + "",1);});

        TableColumn<Program, Integer> programDepartmentColumn = new TableColumn<>("Dept ID");
        programDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("program_Department_ID"));
        programDepartmentColumn.setPrefWidth(130);
        programDepartmentColumn.setResizable(false);
        programDepartmentColumn.setStyle( "-fx-alignment: CENTER;");
        programDepartmentColumn.setCellFactory(TextFieldTableCell.<Program, Integer>forTableColumn(new IntegerStringConverter()));
        programDepartmentColumn.setOnEditCommit((CellEditEvent<Program, Integer> t) -> {
            if (!update("Program", "program_department_id",t.getNewValue()+"", "program_ID", t.getRowValue().getProgram_ID() + "",0)){;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Department doesn't exist!!");
                alert.showAndWait();
                ProgramsReleased(event);
            }
            else ((Program) t.getTableView().getItems().get(t.getTablePosition().getRow())).setProgram_Department_ID(t.getNewValue());});


        ProgramTableView.getColumns().addAll(ProgramIDColumn, programNameColumn, programAbbrevColumn, programHoursPriceColumn, programMMColumn, programDepartmentColumn);
        ProgramTableView.setItems(FXCollections.observableList(programs));
        TableP.getChildren().clear();
        TableP.getChildren().add(ProgramTableView);
        Bars.setMinWidth(200);
        Bars.setPrefWidth(0);
    }

    @FXML
    void ProgramsunHover(MouseEvent event) {
        ProgramsB.getStyleClass().removeAll("button-hover");
    }

    @FXML
    void SectionsClicked(MouseEvent event) {
        removeReleased();
        SectionsB.getStyleClass().add("button-clicked");
    }

    @FXML
    void SectionsHover(MouseEvent event) {
        SectionsB.getStyleClass().add("button-hover");
    }
    @FXML
    void SectionsunHover(MouseEvent event) {
        SectionsB.getStyleClass().removeAll("button-hover");
    }

    @FXML
    void SectionsReleased(MouseEvent event) {
        Bars.setMinWidth(0);
        Charts.setMinWidth(0);
        SectionsB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        SectionsB.getStyleClass().add("button-released");

        TableView<Section> sectionTableView = new TableView<>();
        sectionTableView.setEditable(true);
        sectionTableView.prefWidth(830);
        sectionTableView.setStyle( "-fx-alignment: CENTER;");
        sectionTableView.prefHeight(500);


        TableColumn<Section, Integer> sectionIDColumn = new TableColumn<>("Section ID");
        sectionIDColumn.setCellValueFactory(new PropertyValueFactory<>("section_ID"));
        sectionIDColumn.setPrefWidth(200);
        sectionIDColumn.setStyle( "-fx-alignment: CENTER;");
        sectionIDColumn.setResizable(false);

        TableColumn<Section, Integer> yearColumn = new TableColumn<>("Academic Year");
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("section_Year"));
        yearColumn.setPrefWidth(130);
        yearColumn.setResizable(false);
        yearColumn.setStyle( "-fx-alignment: CENTER;");
        yearColumn.setCellFactory(TextFieldTableCell.<Section, Integer>forTableColumn(new IntegerStringConverter()));
        yearColumn.setOnEditCommit((CellEditEvent<Section, Integer> t) -> {
            ((Section) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSection_Year(t.getNewValue());
            update("Section", "section_academic_year",t.getNewValue()+"", "section_ID", t.getRowValue().getSection_ID() + "",0);});

        TableColumn<Section, Integer> semesterColumn = new TableColumn<>("Semester");
        semesterColumn.setCellValueFactory(new PropertyValueFactory<>("section_Semester"));
        semesterColumn.setPrefWidth(130);
        semesterColumn.setResizable(false);
        semesterColumn.setStyle( "-fx-alignment: CENTER;");
        semesterColumn.setCellFactory(TextFieldTableCell.<Section, Integer>forTableColumn(new IntegerStringConverter()));
        semesterColumn.setOnEditCommit((CellEditEvent<Section, Integer> t) -> {
            ((Section) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSection_Semester(t.getNewValue());
            update("Section", "section_semester",t.getNewValue()+"", "section_ID", t.getRowValue().getSection_ID() + "",0);});


        TableColumn<Section, Integer> ProfessorIDColumn = new TableColumn<>("Professor ID");
        ProfessorIDColumn.setCellValueFactory(new PropertyValueFactory<>("professor_ID"));
        ProfessorIDColumn.setPrefWidth(130);
        ProfessorIDColumn.setResizable(false);
        ProfessorIDColumn.setStyle( "-fx-alignment: CENTER;");
        ProfessorIDColumn.setCellFactory(TextFieldTableCell.<Section, Integer>forTableColumn(new IntegerStringConverter()));
        ProfessorIDColumn.setOnEditCommit((CellEditEvent<Section, Integer> t) -> {
            if (!update("Section", "professor_id",t.getNewValue()+"", "section_ID", t.getRowValue().getSection_ID() + "",0)){;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Professor doesn't exist!!");
                alert.showAndWait();
                SectionsReleased(event);
            }
            else ((Section) t.getTableView().getItems().get(t.getTablePosition().getRow())).setProfessor_ID(t.getNewValue());});


        TableColumn<Section, String> courseIDColumn = new TableColumn<>("Course");
        courseIDColumn.setCellValueFactory(new PropertyValueFactory<>("course_ID"));
        courseIDColumn.setPrefWidth(240);
        courseIDColumn.setResizable(false);
        courseIDColumn.setStyle( "-fx-alignment: CENTER;");
        courseIDColumn.setCellFactory(TextFieldTableCell.<Section>forTableColumn());
        courseIDColumn.setOnEditCommit((CellEditEvent<Section, String> t) -> {
            if (!update("Section", "course_id",t.getNewValue(), "section_ID", t.getRowValue().getSection_ID() + "",1)){;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Course doesn't exist!!");
                alert.showAndWait();
                SectionsReleased(event);
            }
            else ((Section) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCourse_ID(t.getNewValue());});




        sectionTableView.getColumns().addAll(sectionIDColumn, yearColumn, semesterColumn, ProfessorIDColumn, courseIDColumn);
        sectionTableView.setItems(FXCollections.observableList(sections));
        TableP.getChildren().clear();
        TableP.getChildren().add(sectionTableView);
    }

    @FXML
    void SectionsandClassroomsClicked(MouseEvent event) {
        removeReleased();
        SectionIsInB.getStyleClass().add("button-clicked");



    }

    @FXML
    void SectionsandClassroomsHover(MouseEvent event) {
        SectionIsInB.getStyleClass().add("button-hover");
    }

    @FXML
    void SectionsandClassroomsReleased(MouseEvent event) {
        Bars.setMinWidth(0);
        Charts.setMinWidth(0);
        SectionIsInB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        SectionIsInB.getStyleClass().add("button-released");

        TableView<SectionIsIn> classroomTableView = new TableView<>();
        classroomTableView.setEditable(true);
        classroomTableView.prefWidth(830);
        classroomTableView.prefHeight(500);
        classroomTableView.setStyle( "-fx-alignment: CENTER;");


        TableColumn<SectionIsIn, Integer> classroomIDColumn = new TableColumn<>("Classroom ID");
        classroomIDColumn.setCellValueFactory(new PropertyValueFactory<>("classroom_ID"));
        classroomIDColumn.setPrefWidth(300);
        classroomIDColumn.setResizable(false);
        classroomIDColumn.setStyle( "-fx-alignment: CENTER;");
        classroomIDColumn.setCellFactory(TextFieldTableCell.<SectionIsIn, Integer>forTableColumn(new IntegerStringConverter()));
        classroomIDColumn.setOnEditCommit((CellEditEvent<SectionIsIn, Integer> t) -> {
            if (!update("SectionIsIn", "classroom_id",t.getNewValue()+"", "classroom_id", t.getOldValue()+"","section_ID", t.getRowValue().getSection_ID()+"", "TimePeriod_ID", t.getRowValue().getTimePeriod_ID()+"")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Classroom doesn't exist!!");
                alert.showAndWait();
                SectionsandClassroomsReleased(event);
            }
            else ((SectionIsIn) t.getTableView().getItems().get(t.getTablePosition().getRow())).setClassroom_ID(t.getNewValue());});

        TableColumn<SectionIsIn, Integer> sectionIDColumn = new TableColumn<>("Section ID");
        sectionIDColumn.setCellValueFactory(new PropertyValueFactory<>("section_ID"));
        sectionIDColumn.setPrefWidth(300);
        sectionIDColumn.setResizable(false);
        sectionIDColumn.setStyle( "-fx-alignment: CENTER;");
        sectionIDColumn.setCellFactory(TextFieldTableCell.<SectionIsIn, Integer>forTableColumn(new IntegerStringConverter()));
        sectionIDColumn.setOnEditCommit((CellEditEvent<SectionIsIn, Integer> t) -> {
            if (!update("SectionIsIn", "section_ID",t.getNewValue()+"", "classroom_id", t.getRowValue().getClassroom_ID()+"","section_ID", t.getOldValue() +"", "TimePeriod_ID", t.getRowValue().getTimePeriod_ID()+"")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Section doesn't exist!!");
                alert.showAndWait();
                SectionsandClassroomsReleased(event);
            }
            else ((SectionIsIn) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSection_ID(t.getNewValue());});


        TableColumn<SectionIsIn, Integer> timePeriodIDColumn = new TableColumn<>("Time Period ID");
        timePeriodIDColumn.setCellValueFactory(new PropertyValueFactory<>("timePeriod_ID"));
        timePeriodIDColumn.setPrefWidth(230);
        timePeriodIDColumn.setResizable(false);
        timePeriodIDColumn.setStyle( "-fx-alignment: CENTER;");
        timePeriodIDColumn.setCellFactory(TextFieldTableCell.<SectionIsIn, Integer>forTableColumn(new IntegerStringConverter()));
        timePeriodIDColumn.setOnEditCommit((CellEditEvent<SectionIsIn, Integer> t) -> {
            if (!update("SectionIsIn", "Timeperiod_ID",t.getNewValue()+"", "classroom_id", t.getRowValue().getClassroom_ID()+"","section_ID", t.getRowValue().getSection_ID() +"", "TimePeriod_ID", t.getOldValue()+"")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("TimePeriod doesn't exist!!");
                alert.showAndWait();
                SectionsandClassroomsReleased(event);
            }
            else ((SectionIsIn) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTimePeriod_ID(t.getNewValue());});


        classroomTableView.getColumns().addAll(classroomIDColumn, sectionIDColumn, timePeriodIDColumn);
        classroomTableView.setItems(FXCollections.observableList(section_is_in));
        TableP.getChildren().clear();
        TableP.getChildren().add(classroomTableView);
    }

    @FXML
    void SectionsandClassroomsUnHover(MouseEvent event) {
        SectionIsInB.getStyleClass().removeAll("button-hover");
    }

    @FXML
    void SectionsandStudentsClicked(MouseEvent event) {
        removeReleased();
        SectionsandStudentsB.getStyleClass().add("button-clicked");
    }

    @FXML
    void SectionsandStudentsHover(MouseEvent event) {
        SectionsandStudentsB.getStyleClass().add("button-hover");
    }

    @FXML
    void SectionsandStudentsReleased(MouseEvent event) {
        Bars.setMinWidth(0);
        Charts.setMinWidth(0);
        SectionsandStudentsB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        SectionsandStudentsB.getStyleClass().add("button-released");

        TableView<SenrollsS> ssTableView = new TableView<>();
        ssTableView.setEditable(true);
        ssTableView.prefWidth(830);
        ssTableView.prefHeight(500);
        ssTableView.setStyle( "-fx-alignment: CENTER;");

        TableColumn<SenrollsS, Integer> studentIDColumn = new TableColumn<>("Student ID");
        studentIDColumn.setCellValueFactory(new PropertyValueFactory<>("student_ID"));
        studentIDColumn.setPrefWidth(200);
        studentIDColumn.setResizable(false);
        studentIDColumn.setStyle( "-fx-alignment: CENTER;");
        studentIDColumn.setCellFactory(TextFieldTableCell.<SenrollsS, Integer>forTableColumn(new IntegerStringConverter()));
        studentIDColumn.setOnEditCommit((CellEditEvent<SenrollsS, Integer> t) -> {
            if (!update("SenrollsS", "Student_id",t.getNewValue()+"", "student_ID", t.getOldValue()+"","section_ID", t.getRowValue().getSection_ID()+"" ,0)){;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Student doesn't exist!!");
                alert.showAndWait();
                SectionsandStudentsReleased(event);
            }
            else ((SenrollsS) t.getTableView().getItems().get(t.getTablePosition().getRow())).setStudent_ID(t.getNewValue());});

        TableColumn<SenrollsS, Integer> sectionIDColumn = new TableColumn<>("Section ID");
        sectionIDColumn.setCellValueFactory(new PropertyValueFactory<>("section_ID"));
        sectionIDColumn.setPrefWidth(200);
        sectionIDColumn.setResizable(false);
        sectionIDColumn.setStyle( "-fx-alignment: CENTER;");
        sectionIDColumn.setCellFactory(TextFieldTableCell.<SenrollsS, Integer>forTableColumn(new IntegerStringConverter()));
        sectionIDColumn.setOnEditCommit((CellEditEvent<SenrollsS, Integer> t) -> {
            if (!update("SenrollsS", "Section_id",t.getNewValue()+"", "student_ID", t.getRowValue().getStudent_ID()+"","section_ID", t.getOldValue()+"" ,0)){;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Section doesn't exist!!");
                alert.showAndWait();
                SectionsandStudentsReleased(event);
            }
            else ((SenrollsS) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSection_ID(t.getNewValue());});


        TableColumn<SenrollsS, Integer> AbsenceColumn = new TableColumn<>("Number of Absence");
        AbsenceColumn.setCellValueFactory(new PropertyValueFactory<>("absences"));
        AbsenceColumn.setPrefWidth(130);
        AbsenceColumn.setResizable(false);
        AbsenceColumn.setStyle( "-fx-alignment: CENTER;");
        AbsenceColumn.setCellFactory(TextFieldTableCell.<SenrollsS, Integer>forTableColumn(new IntegerStringConverter()));
        AbsenceColumn.setOnEditCommit((CellEditEvent<SenrollsS, Integer> t) -> {
            ((SenrollsS) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAbsences(t.getNewValue());
            update("SenrollsS", "Number_of_Absences",t.getNewValue()+"", "student_ID", t.getRowValue().getStudent_ID()+"","section_id", t.getRowValue().getSection_ID()+"" ,0);});


        TableColumn<SenrollsS, Double> GradeColumn = new TableColumn<>("Grade");
        GradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
        GradeColumn.setPrefWidth(300);
        GradeColumn.setResizable(false);
        GradeColumn.setStyle( "-fx-alignment: CENTER;");
        GradeColumn.setCellFactory(TextFieldTableCell.<SenrollsS, Double>forTableColumn(new DoubleStringConverter()));
        GradeColumn.setOnEditCommit((CellEditEvent<SenrollsS, Double> t) -> {
            ((SenrollsS) t.getTableView().getItems().get(t.getTablePosition().getRow())).setGrade(t.getNewValue());
            update("SenrollsS", "Grade",t.getNewValue()+"",  "student_ID", t.getRowValue().getStudent_ID()+"","section_id", t.getRowValue().getSection_ID()+"" ,0);});




        ssTableView.getColumns().addAll(studentIDColumn, sectionIDColumn, AbsenceColumn, GradeColumn);
        ssTableView.setItems(FXCollections.observableList(s_enrolls_s));
        TableP.getChildren().clear();
        TableP.getChildren().add(ssTableView);

    }

    @FXML
    void SectionsandStudentsUnHover(MouseEvent event) {
        SectionsandStudentsB.getStyleClass().removeAll("button-hover");
    }



    @FXML
    void StudentsClicked(MouseEvent event) {
        removeReleased();
        StudentsB.getStyleClass().add("button-clicked");
    }

    @FXML
    void StudentsHover(MouseEvent event) {
        StudentsB.getStyleClass().add("button-hover");
    }

    @FXML
    void StudentsReleased(MouseEvent event) {
        Bars.setMinWidth(0);
        Charts.setMinWidth(0);
        StudentsB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        StudentsB.getStyleClass().add("button-released");



        TableView<Student> studentTableView = new TableView<>();
        studentTableView.setEditable(true);
        studentTableView.prefWidth(830);
        studentTableView.prefHeight(500);
        studentTableView.setStyle( "-fx-alignment: CENTER;");



        // SID
        TableColumn<Student, Integer> SIDCol = new TableColumn<Student, Integer>("SID");
        SIDCol.setCellValueFactory(new PropertyValueFactory<Student, Integer>("Student_ID"));
        SIDCol.setPrefWidth(50);
        SIDCol.setResizable(false);
        SIDCol.setStyle( "-fx-alignment: CENTER;");

        // sname
        TableColumn<Student, String> nameCol = new TableColumn<Student, String>("Name");
        nameCol.setPrefWidth(70);
        nameCol.setResizable(false);
        nameCol.setStyle( "-fx-alignment: CENTER;");
        nameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("student_Name"));
        nameCol.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
        nameCol.setOnEditCommit((CellEditEvent<Student, String> t) -> {
            ((Student) t.getTableView().getItems().get(t.getTablePosition().getRow())).setStudent_Name(t.getNewValue()); // display
            // only
            update("Student", "student_Name",t.getNewValue(), "student_id", t.getRowValue().getStudent_ID() + "",1);
        });

        // NID
        TableColumn<Student, Integer> NIDCol = new TableColumn<Student, Integer>("NID");
        NIDCol.setPrefWidth(50);
        NIDCol.setResizable(false);
        NIDCol.setStyle( "-fx-alignment: CENTER;");
        NIDCol.setCellValueFactory(new PropertyValueFactory<Student, Integer>("National_ID"));

        // BDate
        TableColumn<Student, String> BDateCol = new TableColumn<Student, String>("Birth Date");
        BDateCol.setPrefWidth(30);
        BDateCol.setResizable(false);
        BDateCol.setStyle( "-fx-alignment: CENTER;");
        BDateCol.setCellValueFactory(new PropertyValueFactory<Student, String>("BirthDate"));
        BDateCol.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
        BDateCol.setOnEditCommit((CellEditEvent<Student, String> t) -> {
            ((Student) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBirthDate(t.getNewValue()); // display
            // only
            update("Student", "BirthDate",t.getNewValue(), "student_id", t.getRowValue().getStudent_ID() + "",1);
        });

        // gender
        TableColumn<Student, Character> GenderCol = new TableColumn<Student, Character>("Gender");
        GenderCol.setPrefWidth(40);
        GenderCol.setResizable(false);
        GenderCol.setStyle( "-fx-alignment: CENTER;");
        GenderCol.setCellValueFactory(new PropertyValueFactory<Student, Character>("gender"));

        // phoneNo
        TableColumn<Student, String> PhoneNoCol = new TableColumn<Student, String>("Phone Number");
        PhoneNoCol.setPrefWidth(70);
        PhoneNoCol.setResizable(false);
        PhoneNoCol.setStyle( "-fx-alignment: CENTER;");
        PhoneNoCol.setCellValueFactory(new PropertyValueFactory<Student, String>("phone_Number"));
        PhoneNoCol.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
        PhoneNoCol.setOnEditCommit((CellEditEvent<Student, String> t) -> {
            ((Student) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPhone_Number(t.getNewValue());
            update("Student", "phone_number",t.getNewValue(), "student_id", t.getRowValue().getStudent_ID() + "",1);
        });

        // Address
        TableColumn<Student, String> AddressCol = new TableColumn<Student, String>("Address");
        AddressCol.setPrefWidth(80);
        AddressCol.setResizable(false);
        AddressCol.setStyle( "-fx-alignment: CENTER;");
        AddressCol.setCellValueFactory(new PropertyValueFactory<Student, String>("address"));
        AddressCol.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
        AddressCol.setOnEditCommit((CellEditEvent<Student, String> t) -> {
            ((Student) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAddress(t.getNewValue());
            update("Student", "address",t.getNewValue(), "student_id", t.getRowValue().getStudent_ID() + "",1);
        });

        // GradStat
        TableColumn<Student, String> GradStatCol = new TableColumn<Student, String>("Graduation Status");
        GradStatCol.setPrefWidth(90);
        GradStatCol.setResizable(false);
        GradStatCol.setStyle( "-fx-alignment: CENTER;");
        GradStatCol.setCellValueFactory(new PropertyValueFactory<Student, String>("graduation_Status"));
        GradStatCol.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
        GradStatCol.setOnEditCommit((CellEditEvent<Student, String> t) -> {
            ((Student) t.getTableView().getItems().get(t.getTablePosition().getRow())).setGraduation_Status(t.getNewValue());
            update("Student", "graduation_status",t.getNewValue(), "student_id", t.getRowValue().getStudent_ID() + "",1);
        });

        // Balance
        TableColumn<Student, Double> BalanceCol = new TableColumn<>("Balance");
        BalanceCol.setCellValueFactory(new PropertyValueFactory<>("balance"));
        BalanceCol.setPrefWidth(90);
        BalanceCol.setResizable(false);
        BalanceCol.setStyle( "-fx-alignment: CENTER;");
        BalanceCol.setCellFactory(TextFieldTableCell.<Student, Double>forTableColumn(new DoubleStringConverter()));
        BalanceCol.setOnEditCommit((CellEditEvent<Student, Double> t) -> {
            ((Student) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBalance(t.getNewValue());
            update("Student", "balance",t.getNewValue()+"", "student_id", t.getRowValue().getStudent_ID() + "",4);
        });

        // Email
        TableColumn<Student, String> EmailCol = new TableColumn<Student, String>("Email");
        EmailCol.setPrefWidth(30);
        EmailCol.setResizable(false);
        EmailCol.setStyle( "-fx-alignment: CENTER;");
        EmailCol.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        EmailCol.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
        EmailCol.setOnEditCommit((CellEditEvent<Student, String> t) -> {
            ((Student) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEmail(t.getNewValue());
            update("Student", "email",t.getNewValue(), "student_id", t.getRowValue().getStudent_ID() + "",1);
        });

        // CommunityHrs
        TableColumn<Student, Integer> CommunityHrsCol = new TableColumn<Student, Integer>("Community Hours");
        CommunityHrsCol.setPrefWidth(60);
        CommunityHrsCol.setResizable(false);
        CommunityHrsCol.setStyle( "-fx-alignment: CENTER;");
        CommunityHrsCol.setCellValueFactory(new PropertyValueFactory<Student, Integer>("community_Hours"));
        CommunityHrsCol.setCellFactory(TextFieldTableCell.<Student, Integer>forTableColumn(new IntegerStringConverter()));
        CommunityHrsCol.setOnEditCommit((CellEditEvent<Student, Integer> t) -> {
            ((Student) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCommunity_Hours(t.getNewValue());
            update("student", "community_hours",t.getNewValue()+"", "student_id", t.getRowValue().getStudent_ID() + "",0);
        });


        TableColumn<Student, Integer> MajorColumn = new TableColumn<>("Major");
        MajorColumn.setCellValueFactory(new PropertyValueFactory<>("major_id"));
        MajorColumn.setPrefWidth(70);
        MajorColumn.setResizable(false);
        MajorColumn.setStyle( "-fx-alignment: CENTER;");
        MajorColumn.setCellFactory(TextFieldTableCell.<Student, Integer>forTableColumn(new IntegerStringConverter()));
        MajorColumn.setOnEditCommit((CellEditEvent<Student, Integer> t) -> {
            if (!update("Student", "major_id",t.getNewValue()+"", "student_id", t.getRowValue().getStudent_ID() + "",0)){;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Major doesn't exist!!");
                alert.showAndWait();
                StudentsReleased(event);
            }
            else ((Student) t.getTableView().getItems().get(t.getTablePosition().getRow())).setMajor_id(t.getNewValue());});


        TableColumn<Student, Double> GPAcol = new TableColumn<>("GPA");
        GPAcol.setCellValueFactory(new PropertyValueFactory<>("GPA"));
        GPAcol.setPrefWidth(90);
        GPAcol.setResizable(false);
        GPAcol.setStyle( "-fx-alignment: CENTER;");
        GPAcol.setCellFactory(TextFieldTableCell.<Student, Double>forTableColumn(new DoubleStringConverter()));
        GPAcol.setOnEditCommit((CellEditEvent<Student, Double> t) -> {
            ((Student) t.getTableView().getItems().get(t.getTablePosition().getRow())).setGPA(t.getNewValue());
            update("Student", "GPA",t.getNewValue()+"", "student_id", t.getRowValue().getStudent_ID() + "",4);
        });

        studentTableView.getColumns().addAll(SIDCol, nameCol, NIDCol, BDateCol, GenderCol, PhoneNoCol, AddressCol, GradStatCol, BalanceCol, EmailCol, CommunityHrsCol, GPAcol, MajorColumn);
        studentTableView.setItems(FXCollections.observableList(students));
        TableP.getChildren().clear();
        TableP.getChildren().add(studentTableView);

        Charts.setMinWidth(100);
        Charts.setPrefWidth(0);
        System.out.println("G");
    }

    @FXML
    void StudentsandminorsClicked(MouseEvent event) {
        removeReleased();
        StudentsAndMinorB.getStyleClass().add("button-clicked");
    }

    @FXML
    void StudentsandminorsHover(MouseEvent event) {
        StudentsAndMinorB.getStyleClass().add("button-hover");
    }

    @FXML
    void StudentsandminorsReleased(MouseEvent event) {
        Bars.setMinWidth(0);
        Charts.setMinWidth(0);
        StudentsAndMinorB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        StudentsAndMinorB.getStyleClass().add("button-released");

        TableView<SdoMinor> SdoMinorTableView = new TableView<>();
        SdoMinorTableView.setEditable(true);
        SdoMinorTableView.prefWidth(830);
        SdoMinorTableView.prefHeight(500);
        SdoMinorTableView.setStyle( "-fx-alignment: CENTER;");


        TableColumn<SdoMinor, Integer> studentIDColumn = new TableColumn<>("Student ID");
        studentIDColumn.setStyle( "-fx-alignment: CENTER;");
        studentIDColumn.setCellValueFactory(new PropertyValueFactory<>("student_ID"));
        studentIDColumn.setPrefWidth(400);
        studentIDColumn.setResizable(false);
        studentIDColumn.setCellFactory(TextFieldTableCell.<SdoMinor, Integer>forTableColumn(new IntegerStringConverter()));
        studentIDColumn.setOnEditCommit((CellEditEvent<SdoMinor, Integer> t) -> {
            if (!update("SdoMinor", "Student_id",t.getNewValue()+"", "student_ID", t.getOldValue()+"","minor_ID", t.getRowValue().getMinor_ID()+"" ,0)){;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Student doesn't exist!!");
                alert.showAndWait();
                StudentsandminorsReleased(event);
            }
            else ((SdoMinor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setStudent_ID(t.getNewValue());});



        TableColumn<SdoMinor, Integer> minorIDColumn = new TableColumn<>("Minor ID");
        minorIDColumn.setStyle( "-fx-alignment: CENTER;");
        minorIDColumn.setCellValueFactory(new PropertyValueFactory<>("minor_ID"));
        minorIDColumn.setPrefWidth(430);
        minorIDColumn.setResizable(false);
        minorIDColumn.setCellFactory(TextFieldTableCell.<SdoMinor, Integer>forTableColumn(new IntegerStringConverter()));
        minorIDColumn.setOnEditCommit((CellEditEvent<SdoMinor, Integer> t) -> {
            if (!update("SdoMinor", "minor_ID",t.getNewValue()+"", "student_ID", t.getRowValue().getStudent_ID()+"","minor_ID", t.getOldValue()+"" ,0)){;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Minor Course doesn't exist!!");
                alert.showAndWait();
                StudentsandminorsReleased(event);
            }
            else ((SdoMinor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setStudent_ID(t.getNewValue());});


        SdoMinorTableView.getColumns().addAll(studentIDColumn, minorIDColumn);
        SdoMinorTableView.setItems(FXCollections.observableList(s_do_minor));
        TableP.getChildren().clear();
        TableP.getChildren().add(SdoMinorTableView);
    }

    @FXML
    void StudentsandminorsUnHover(MouseEvent event) {
        StudentsAndMinorB.getStyleClass().removeAll("button-hover");
    }

    @FXML
    void StudentsunHover(MouseEvent event) {
        StudentsB.getStyleClass().removeAll("button-hover");
    }

    @FXML
    void StudyPlansClicked(MouseEvent event) {
        removeReleased();
        StudyPlansB.getStyleClass().add("button-clicked");
    }

    @FXML
    void StudyPlansHover(MouseEvent event) {
        StudyPlansB.getStyleClass().add("button-hover");
    }

    @FXML
    void StudyPlansReleased(MouseEvent event) {
        Bars.setMinWidth(0);
        Charts.setMinWidth(0);
        StudyPlansB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        StudyPlansB.getStyleClass().add("button-released");

        TableView<StudyPlan> studyPlanTableView = new TableView<>();
        studyPlanTableView.setEditable(true);
        studyPlanTableView.prefWidth(830);
        studyPlanTableView.prefHeight(500);


        TableColumn<StudyPlan, String> CourseIDColumn = new TableColumn<>("Course ID");
        CourseIDColumn.setCellValueFactory(new PropertyValueFactory<>("course_ID"));
        CourseIDColumn.setPrefWidth(400);
        CourseIDColumn.setResizable(false);
        CourseIDColumn.setStyle( "-fx-alignment: CENTER;");
        CourseIDColumn.setCellFactory(TextFieldTableCell.<StudyPlan>forTableColumn());
        CourseIDColumn.setOnEditCommit((CellEditEvent<StudyPlan, String> t) -> {
            if (!update("Study_Plan", "course_id",t.getNewValue(), "course_id", t.getOldValue() + "", "program_id", t.getRowValue().getProgram_ID()+"", 3)){;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Course doesn't exist!!");
                alert.showAndWait();
                StudyPlansReleased(event);
            }
            else ((StudyPlan) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCourse_ID(t.getNewValue());});


        TableColumn<StudyPlan, Integer> programIDColumn = new TableColumn<>("Program ID");
        programIDColumn.setCellValueFactory(new PropertyValueFactory<>("program_ID"));
        programIDColumn.setPrefWidth(430);
        programIDColumn.setResizable(false);
        programIDColumn.setStyle( "-fx-alignment: CENTER;");
        programIDColumn.setCellFactory(TextFieldTableCell.<StudyPlan, Integer>forTableColumn(new IntegerStringConverter()));
        programIDColumn.setOnEditCommit((CellEditEvent<StudyPlan, Integer> t) -> {
            if (!update("Study_Plan", "program_id",t.getNewValue()+"", "course_id", t.getRowValue().getCourse_ID()+"","program_id", t.getOldValue()+"" ,3)){;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Program Course doesn't exist!!");
                alert.showAndWait();
                StudyPlansReleased(event);
            }
            else ((StudyPlan) t.getTableView().getItems().get(t.getTablePosition().getRow())).setProgram_ID(t.getNewValue());});


        studyPlanTableView.getColumns().addAll(CourseIDColumn, programIDColumn);
        studyPlanTableView.setItems(FXCollections.observableList(study_plans));
        TableP.getChildren().clear();
        TableP.getChildren().add(studyPlanTableView);
    }

    @FXML
    void StudyPlansUnHover(MouseEvent event) {
        StudyPlansB.getStyleClass().removeAll("button-hover");
    }

    @FXML
    void TimePeriodsClicked(MouseEvent event) {
        removeReleased();
        removeReleased();
        TimePeriodsB.getStyleClass().add("button-clicked");
    }

    @FXML
    void TimePeriodsHover(MouseEvent event) {
        TimePeriodsB.getStyleClass().add("button-hover");
    }

    @FXML
    void TimePeriodsReleased(MouseEvent event) {
        Bars.setMinWidth(0);
        Charts.setMinWidth(0);
        TimePeriodsB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        TimePeriodsB.getStyleClass().add("button-released");

        TableView<TimePeriod> timePeriodsTableView = new TableView<>();
        timePeriodsTableView.setEditable(true);
        timePeriodsTableView.prefWidth(830);
        timePeriodsTableView.setStyle( "-fx-alignment: CENTER;");
        timePeriodsTableView.prefHeight(500);


        TableColumn<TimePeriod, Integer> TimePeriodIDColumn = new TableColumn<>("Time Period ID");
        TimePeriodIDColumn.setCellValueFactory(new PropertyValueFactory<>("timePeriod_ID"));
        TimePeriodIDColumn.setPrefWidth(200);
        TimePeriodIDColumn.setResizable(false);
        TimePeriodIDColumn.setStyle( "-fx-alignment: CENTER;");


        TableColumn<TimePeriod, String> dayCombColumn = new TableColumn<>("Day Combination");
        dayCombColumn.setCellValueFactory(new PropertyValueFactory<>("dayComb"));
        dayCombColumn.setPrefWidth(200);
        dayCombColumn.setResizable(false);
        dayCombColumn.setStyle( "-fx-alignment: CENTER;");
        dayCombColumn.setCellFactory(TextFieldTableCell.<TimePeriod>forTableColumn());
        dayCombColumn.setOnEditCommit((CellEditEvent<TimePeriod, String> t) -> {
            ((TimePeriod) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDayComb(t.getNewValue());
            update("TimePeriod", "daycomb",t.getNewValue(), "timeperiod_id", t.getRowValue().getTimePeriod_ID() + "",1);});

        TableColumn<TimePeriod, String> timeCombColumn = new TableColumn<>("Time Combination");
        timeCombColumn.setCellValueFactory(new PropertyValueFactory<>("timeComb"));
        timeCombColumn.setPrefWidth(230);
        timeCombColumn.setResizable(false);
        timeCombColumn.setStyle( "-fx-alignment: CENTER;");
        timeCombColumn.setCellFactory(TextFieldTableCell.<TimePeriod>forTableColumn());
        timeCombColumn.setOnEditCommit((CellEditEvent<TimePeriod, String> t) -> {
            ((TimePeriod) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTimeComb(t.getNewValue());
            update("TimePeriod", "timecomb",t.getNewValue(), "timeperiod_id", t.getRowValue().getTimePeriod_ID() + "",1);});

        TableColumn<TimePeriod, Integer> courseTypeColumn = new TableColumn<>("Course Type");
        courseTypeColumn.setCellValueFactory(new PropertyValueFactory<>("courseType"));
        courseTypeColumn.setPrefWidth(200);
        courseTypeColumn.setResizable(false);
        courseTypeColumn.setStyle( "-fx-alignment: CENTER;");
        courseTypeColumn.setCellFactory(TextFieldTableCell.<TimePeriod, Integer>forTableColumn(new IntegerStringConverter()));
        courseTypeColumn.setOnEditCommit((CellEditEvent<TimePeriod, Integer> t) -> {
            ((TimePeriod) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCourseType(t.getNewValue());
            update("TimePeriod", "course_type",t.getNewValue()+"", "timeperiod_id", t.getRowValue().getTimePeriod_ID() + "",0);});


        timePeriodsTableView.getColumns().addAll(TimePeriodIDColumn, dayCombColumn, timeCombColumn, courseTypeColumn);
        timePeriodsTableView.setItems(FXCollections.observableList(time_Periods));
        TableP.getChildren().clear();
        TableP.getChildren().add(timePeriodsTableView);
    }


    @FXML
    void TimePeriodsUnHover(MouseEvent event) {
        TimePeriodsB.getStyleClass().removeAll("button-hover");
    }

    private void removeReleased(){
        ClassroomsB.getStyleClass().removeAll("button-released");
        CoursesB.getStyleClass().removeAll("button-released");
        DepartmentsB.getStyleClass().removeAll("button-released");
        FaciltiesB.getStyleClass().removeAll("button-released");
        PrerequisitesB.getStyleClass().removeAll("button-released");
        ProfessorsB.getStyleClass().removeAll("button-released");
        ProgramsB.getStyleClass().removeAll("button-released");
        StudentsAndMinorB.getStyleClass().removeAll("button-released");
        SectionsB.getStyleClass().removeAll("button-released");
        SectionIsInB.getStyleClass().removeAll("button-released");
        SectionsandStudentsB.getStyleClass().removeAll("button-released");
        StudentsB.getStyleClass().removeAll("button-released");
        StudyPlansB.getStyleClass().removeAll("button-released");
        TimePeriodsB.getStyleClass().removeAll("button-released");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Alert welcome = new Alert(Alert.AlertType.INFORMATION);
            welcome.setTitle("Birzeit University Registration System");
            welcome.setContentText("Welcome Professor Basem :)");
            welcome.showAndWait();
            DB.stage.show();
            getData();
            TableP.getChildren().clear();
            Label t = new Label("Choose the table you want to edit from the left.");
            t.setPrefWidth(830);
            t.setPrefHeight(500);
            t.setStyle( "-fx-alignment: CENTER;");
            TableP.getChildren().add(t);

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Birzeit University Registration System");
            alert.setContentText("Any Changes you make on the editable fields cannot be revertible, WATCH OUT!");
            alert.showAndWait();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void ChartsClicked(ActionEvent event) throws SQLException, ClassNotFoundException {
//        System.out.println("reached");
        connectDB();
        String SQL = "select count(gender) from student group by gender order by gender asc;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        int[] count = new int[2];
        int i = 0;
        while (rs.next()){
            count[i] = Integer.parseInt(rs.getString(1));
            i++;
        }

        double total = (count[0] + count[1])/10000.0;
        ObservableList<PieChart.Data> valueList = FXCollections.observableArrayList(
                new PieChart.Data("Females", (count[0]/total)),
                new PieChart.Data("Males", (count[1]/total)));
        PieChart pieChart = new PieChart(valueList);
        pieChart.setTitle("Gender Percentages");
        pieChart.getData().forEach(data -> {
            String percentage = String.format("%.2f%%", (data.getPieValue() / 100));
            Tooltip toolTip = new Tooltip(percentage);
            Tooltip.install(data.getNode(), toolTip);
        });
        Pane P = new Pane();
        P.getChildren().addAll(pieChart);
        Scene scene = new Scene(P, 450, 450);
        Stage soso = new Stage();
        soso.setScene(scene);
        soso.show();
    }

    @FXML
    private void BarsClicked(ActionEvent event) throws SQLException, ClassNotFoundException {

        connectDB();
        String SQL = "select p.Program_Name, avg(s.gpa)  from student s, program p where s.major_id = p.Program_ID group by p.Program_Name;";
        Statement stmt = con.createStatement();
        ResultSet rst = stmt.executeQuery(SQL);

        ArrayList<String> names = new ArrayList<String>();
        ArrayList <Double> grades = new ArrayList<Double>();

        while (rst.next()){
            names.add(rst.getString(1));
            grades.add(rst.getDouble(2));
        }
        rst.close();

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Names");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Grades");

        BarChart barChart = new BarChart(xAxis, yAxis);
        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Average Grades");

        for (int i = 0; i <  names.size(); i++){
            dataSeries1.getData().add(new XYChart.Data(names.get(i), grades.get(i)));
        }
        barChart.getData().add(dataSeries1);


        Pane P = new Pane();
        P.getChildren().addAll(barChart);
        Scene scene = new Scene(P, 600, 600);
        Stage soso = new Stage();
        soso.setScene(scene);
        soso.show();
    }



}
