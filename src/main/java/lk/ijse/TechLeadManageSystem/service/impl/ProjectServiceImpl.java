package lk.ijse.TechLeadManageSystem.service.impl;

import lk.ijse.TechLeadManageSystem.dto.ProjectDTO;
import lk.ijse.TechLeadManageSystem.entity.Project;
import lk.ijse.TechLeadManageSystem.entity.TechLead;
import lk.ijse.TechLeadManageSystem.repo.ProjectRepo;
import lk.ijse.TechLeadManageSystem.repo.TechLeadRepo;
import lk.ijse.TechLeadManageSystem.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TechLeadRepo tlRepo;
    @Override
    public void saveProject(ProjectDTO dto) {
        if (!repo.existsById(dto.getProjectId())){
            TechLead techLead = mapper.map(tlRepo.getTechLeadsById(dto.getTechLeadID()), TechLead.class);
            if (techLead!=null){
                repo.save( mapper.map(dto, Project.class));
            }else {
                throw new RuntimeException("Customer Does Not Exist...!");
            }
        }else {
            throw new RuntimeException("Order Already Exist...!");
        }
    }

    @Override
    public void deleteProject(String id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
        }else {
            throw new RuntimeException("Customer Already Exist...!");
        }
    }

    @Override
    public void updateProject(ProjectDTO dto) {
        if (repo.existsById(dto.getProjectId())) {
            repo.save(mapper.map(dto,Project.class));
        }else {
            throw new RuntimeException("Customer NOT Exist...!");
        }
    }

    @Override
    public ProjectDTO searchProject(String id) {
        if (repo.existsById(id)){
            Project project = repo.findById(id).get();
            return mapper.map(project,ProjectDTO.class);
        }else {
            throw new RuntimeException("Customer NOT Exist...!");
        }
    }

    @Override
    public List<ProjectDTO> getAllProject() {
        List<Project> all = repo.findAll();
        return mapper.map(all,new TypeToken<List<ProjectDTO>>(){}.getType());
    }
}
