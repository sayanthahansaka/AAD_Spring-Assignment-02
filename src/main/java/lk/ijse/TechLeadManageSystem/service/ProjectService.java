package lk.ijse.TechLeadManageSystem.service;

import lk.ijse.TechLeadManageSystem.dto.ProjectDTO;
import lk.ijse.TechLeadManageSystem.dto.TechLeadDTO;

import java.util.List;

public interface ProjectService {

    public void saveProject(ProjectDTO dto);

    public void deleteProject(String id);

    public void updateProject(ProjectDTO dto);

    public ProjectDTO searchProject(String id);

    public List<ProjectDTO> getAllProject();

}
