package com.example.bzurs;

import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.ArrayList;

public class ProgramCourses {
    private Button course_ID;
    private String course_name;
    private TreeView<String> prerequisites;

    public ProgramCourses(Button course_ID, String course_name, TreeView<String> prerequisites) {
        this.course_ID = course_ID;
        this.course_name = course_name;
        this.prerequisites = prerequisites;
    }

    public Button getCourse_ID() {
        return course_ID;
    }

    public void setCourse_ID(Button course_ID) {
        this.course_ID = course_ID;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public TreeView<String> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(TreeView<String> prerequisites) {
        this.prerequisites = prerequisites;
    }
}
