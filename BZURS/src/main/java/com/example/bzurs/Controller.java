package com.example.bzurs;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;

public class Controller {

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

    @FXML
    private Button ActivitiesB;

    @FXML
    private Button ClassroomsB;

    @FXML
    private Button CoursesB;

    @FXML
    private Button DepartmentsB;

    @FXML
    private AnchorPane EditP;

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
    private Button SectionsIsAtB;

    @FXML
    private Button SectionsandStudentsB;

    @FXML
    private Button StudentsAndMinorB;

    @FXML
    private Button StudentsB;

    @FXML
    private Button StudentsandActivitiesB;

    @FXML
    private Button StudyPlansB;

    @FXML
    private AnchorPane TableP;

    @FXML
    private Button TimePeriodsB;

    @FXML
    private AnchorPane CoursesP;

    @FXML
    private TableColumn<Weekdays, String> DayColumn;

    @FXML
    private TableColumn<?, ?> EightColumn;

    @FXML
    private TableColumn<?, ?> ElevenColumn;

    @FXML
    private TableColumn<?, ?> FiveColumn;

    @FXML
    private TableColumn<?, ?> FourColumn;

    @FXML
    private TableColumn<?, ?> NineColumn;

    @FXML
    private TableColumn<?, ?> OneColumn;

    @FXML
    private TableView<?> ScheduleTable;

    @FXML
    private TableColumn<?, ?> TenColumn;

    @FXML
    private TableColumn<?, ?> ThreeColumn;

    @FXML
    private TreeView<?> TreeProgramViewer;

    @FXML
    private TableColumn<?, ?> TwelveColumn;

    @FXML
    private TableColumn<?, ?> TwoColumn;

    @FXML
    private AnchorPane scheduleP;


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
    void MouseReleased(MouseEvent event) {
        LoginB.getStyleClass().removeAll("button-clicked");
        LoginInfoL.setText("Stop pressing the button!");
    }

    @FXML
    void ActivitiesClicked(MouseEvent event) {
        removeReleased();
        ActivitiesB.getStyleClass().add("button-clicked");
    }

    @FXML
    void ActivitiesHover(MouseEvent event) {
        ActivitiesB.getStyleClass().add("button-hover");
    }

    @FXML
    void ActivitiesReleased(MouseEvent event) {
        ActivitiesB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        ActivitiesB.getStyleClass().add("button-released");
    }

    @FXML
    void ActivitiesUnHover(MouseEvent event) {
        ActivitiesB.getStyleClass().removeAll("button-hover");
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
        ClassroomsB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        ClassroomsB.getStyleClass().add("button-released");
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
        CoursesB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        CoursesB.getStyleClass().add("button-released");

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
        DepartmentsB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        DepartmentsB.getStyleClass().add("button-released");
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
        FaciltiesB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        FaciltiesB.getStyleClass().add("button-released");
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
        PrerequisitesB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        PrerequisitesB.getStyleClass().add("button-released");
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
        ProfessorsB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        ProfessorsB.getStyleClass().add("button-released");

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
        ProgramsB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        ProgramsB.getStyleClass().add("button-released");
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
    void SectionsReleased(MouseEvent event) {
        SectionsB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        SectionsB.getStyleClass().add("button-released");
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
        SectionIsInB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        SectionIsInB.getStyleClass().add("button-released");
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
        SectionsandStudentsB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        SectionsandStudentsB.getStyleClass().add("button-released");
    }

    @FXML
    void SectionsandStudentsUnHover(MouseEvent event) {
        SectionsandStudentsB.getStyleClass().removeAll("button-hover");
    }

    @FXML
    void SectionsandTimePeriodsClicked(MouseEvent event) {
        removeReleased();
        SectionsIsAtB.getStyleClass().add("button-clicked");
    }

    @FXML
    void SectionsandTimePeriodsHover(MouseEvent event) {
        SectionsIsAtB.getStyleClass().add("button-hover");
    }

    @FXML
    void SectionsandTimePeriodsReleased(MouseEvent event) {
        SectionsIsAtB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        SectionsIsAtB.getStyleClass().add("button-released");    }

    @FXML
    void SectionsandTimePeriodsUnHover(MouseEvent event) {
        SectionsIsAtB.getStyleClass().removeAll("button-hover");
    }

    @FXML
    void SectionsunHover(MouseEvent event) {
        SectionsB.getStyleClass().removeAll("button-hover");
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
        StudentsB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        StudentsB.getStyleClass().add("button-released");    }

    @FXML
    void StudentsandactivitesClicked(MouseEvent event) {
        removeReleased();
        StudentsandActivitiesB.getStyleClass().add("button-clicked");
    }

    @FXML
    void StudentsandactivitesHover(MouseEvent event) {
        StudentsandActivitiesB.getStyleClass().add("button-hover");
    }

    @FXML
    void StudentsandactivitesReleased(MouseEvent event) {
        StudentsandActivitiesB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        StudentsandActivitiesB.getStyleClass().add("button-released");    }

    @FXML
    void StudentsandactivitesUnHover(MouseEvent event) {
        StudentsandActivitiesB.getStyleClass().removeAll("button-hover");
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
        StudentsAndMinorB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        StudentsAndMinorB.getStyleClass().add("button-released");    }

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
        StudyPlansB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        StudyPlansB.getStyleClass().add("button-released");    }

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
        TimePeriodsB.getStyleClass().removeAll("button-clicked");
        removeReleased();
        TimePeriodsB.getStyleClass().add("button-released");    }

    @FXML
    void TimePeriodsUnHover(MouseEvent event) {
        TimePeriodsB.getStyleClass().removeAll("button-hover");
    }

    private void removeReleased(){
        ActivitiesB.getStyleClass().removeAll("button-released");
        ClassroomsB.getStyleClass().removeAll("button-released");
        CoursesB.getStyleClass().removeAll("button-released");
        DepartmentsB.getStyleClass().removeAll("button-released");
        FaciltiesB.getStyleClass().removeAll("button-released");
        PrerequisitesB.getStyleClass().removeAll("button-released");
        ProfessorsB.getStyleClass().removeAll("button-released");
        ProgramsB.getStyleClass().removeAll("button-released");
        StudentsandActivitiesB.getStyleClass().removeAll("button-released");
        StudentsAndMinorB.getStyleClass().removeAll("button-released");
        SectionsB.getStyleClass().removeAll("button-released");
        SectionIsInB.getStyleClass().removeAll("button-released");
        SectionsIsAtB.getStyleClass().removeAll("button-released");
        SectionsandStudentsB.getStyleClass().removeAll("button-released");
        StudentsB.getStyleClass().removeAll("button-released");
        StudyPlansB.getStyleClass().removeAll("button-released");
        TimePeriodsB.getStyleClass().removeAll("button-released");
    }

}
