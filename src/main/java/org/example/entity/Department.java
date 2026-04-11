package org.example.entity;
import java.util.*;

public class Department {
    private String departmentID;
    private String departmentName;
    private List<Instructor> instructorList;
    private List<Section> sectionList;

    public Department(String departmentID, String departmentName,  List<Instructor> instructorList,
                      List<Section> sectionList){
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.instructorList = instructorList;
        this.sectionList = sectionList;

    }

    //lagyan ng toString

}
