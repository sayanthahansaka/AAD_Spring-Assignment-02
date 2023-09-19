package lk.ijse.TechLeadManageSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Project {
    @Id
    private String projectId;
    private String projectName;
    @ManyToOne
    private TechLead techLead;
    private String projectDeadLine;
}
