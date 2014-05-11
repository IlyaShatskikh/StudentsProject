package org.home.ilya.tz.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "student_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentGroup.findAll", query = "SELECT s FROM StudentGroup s"),
    @NamedQuery(name = "StudentGroup.findByGroupId", query = "SELECT s FROM StudentGroup s WHERE s.groupId = :groupId"),
    @NamedQuery(name = "StudentGroup.findByDepartment", query = "SELECT s FROM StudentGroup s WHERE s.department = :department")})
public class StudentGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "group_id")
    private Integer groupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "department")
    private String department;
    @OneToMany(mappedBy = "groupId")
    private List<Student> studentList;

    public StudentGroup() {
    }

    public StudentGroup(Integer groupId) {
        this.groupId = groupId;
    }

    public StudentGroup(Integer groupId, String department) {
        this.groupId = groupId;
        this.department = department;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @XmlTransient
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentGroup)) {
            return false;
        }
        StudentGroup other = (StudentGroup) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "session.StudentGroup[ groupId=" + groupId + " ]";
    }
    
}