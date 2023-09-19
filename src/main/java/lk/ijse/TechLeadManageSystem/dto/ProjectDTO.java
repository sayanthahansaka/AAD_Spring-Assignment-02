package lk.ijse.TechLeadManageSystem.dto;

import lk.ijse.TechLeadManageSystem.entity.TechLead;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ProjectDTO {
    private String projectId;
    private String projectName;
    private String techLeadID;
    private String projectDeadLine;
}
