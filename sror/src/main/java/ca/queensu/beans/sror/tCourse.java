package ca.queensu.beans.sror;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

@JsonPropertyOrder({"units", "responsibilityPercentage", "deliveryFormat", "courseCode", "academicYearTaught"})
public class tCourse implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "courseCode", required = true)
    private String courseCode;

    @JsonProperty(value = "academicYearTaught", required = true)
    private Double academicYearTaught;

    @JsonProperty(value = "units", required = true)
    private Double units;

    @JsonProperty(value = "deliveryFormat", required = true)
    private String deliveryFormat;
    
    @JsonProperty(value = "responsibilityPercentage", required = true)
    private Double responsibilityPercentage;
  
    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public Double getAcademicYearTaught() {
        return academicYearTaught;
    }
    public void setAcademicYearTaught(Double academicYearTaught) {
        this.academicYearTaught = academicYearTaught;
    }
    public Double getUnits() {
        return units;
    }
    public void setUnits(Double units) {
        this.units = units;
    }
    public String getDeliveryFormat() {
        return deliveryFormat;
    }
    public void setDeliveryFormat(String deliveryFormat) {
        this.deliveryFormat = deliveryFormat;
    }
    public Double getResponsibilityPercentage() {
        return responsibilityPercentage;
    }
    public void setResponsibilityPercentage(Double responsibilityPercentage) {
        this.responsibilityPercentage = responsibilityPercentage;
    }
}
