package org.home.ilya.tz.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentId", query = "SELECT s FROM Student s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "Student.findByStudentFio", query = "SELECT s FROM Student s WHERE s.studentFio = :studentFio"),
    @NamedQuery(name = "Student.findByScholarship", query = "SELECT s FROM Student s WHERE s.scholarship = :scholarship"),
    @NamedQuery(name = "Student.findByEnrollmentDate", query = "SELECT s FROM Student s WHERE s.enrollmentDate = :enrollmentDate")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "student_id")
    private Integer studentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "student_fio")
    private String studentFio;
    @Column(name = "scholarship")
    private Integer scholarship;
    @Column(name = "enrollment_date")
    @Temporal(TemporalType.DATE)
    private Date enrollmentDate;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = StudentGroup.class)
    private StudentGroup groupId;

    public Student() {
    }

    public Student(Integer studentId) {
        this.studentId = studentId;
    }

    public Student(Integer studentId, String studentFio) {
        this.studentId = studentId;
        this.studentFio = studentFio;
    }
    
    public Student(Integer studentId, String studentFio, Integer scholarship, 
            Date enrollmentDate) {
        this.studentId = studentId;
        this.studentFio = studentFio;
        this.scholarship = scholarship;
        this.enrollmentDate = enrollmentDate;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentFio() {
        return studentFio;
    }

    public void setStudentFio(String studentFio) {
        this.studentFio = studentFio;
    }

    public Integer getScholarship() {
        return scholarship;
    }

    public void setScholarship(Integer scholarship) {
        this.scholarship = scholarship;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public StudentGroup getGroupId() {
        return groupId;
    }

    public void setGroupId(StudentGroup groupId) {
        this.groupId = groupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "session.Student[ studentId=" + studentId + " ]";
    }
    
}
