package pl.sda.final_project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "WORKER")
@Data
@NoArgsConstructor
public class Worker extends User {

    @Column(name = "department_id")
    private String departmentId;
    @Column(name = "job_title")
    private String jobTitle;
}
