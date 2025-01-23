package ca.queensu.beans.sror;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"full_Name","employee_ID","sror_Status","courses_Taught"})
public class tAdjunct {

    @JsonProperty(required = true)
    private String full_Name;

    @JsonProperty(required = true)
    private String employee_ID;

    @JsonProperty(required = true)
    private String sror_Status;

    @JsonProperty(required = true)
    private List<tCourse> courses_Taught;
 
    public String getFull_Name() {
        return full_Name;
    }
    public void setFull_Name(String fullName) {
        this.full_Name = fullName;
    }
    public String getEmployee_ID() {
        return employee_ID;
    }
    public void setEmployee_ID(String employeeID) {
        this.employee_ID = employeeID;
    }
    public String getSror_Status() {
        return sror_Status;
    }
    public void setSror_Status(String srorStatus) {
        this.sror_Status = srorStatus;
    }
    public List<tCourse> getCourses_Taught() {
        return courses_Taught;
    }
    public void setCourses_Taught(List<tCourse> courses) {
        this.courses_Taught = courses;
    }
    
    

}
