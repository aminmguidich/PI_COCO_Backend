package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.RequirementCollocation;

import java.util.List;

public interface IReqCollocationService {
    public RequirementCollocation addRequirementCollocation(RequirementCollocation collocation);
    public RequirementCollocation updateRequirementCollocation(Long id, RequirementCollocation newCollocation);
    List<RequirementCollocation> retrieveAllRequirementCollocations();

    RequirementCollocation retrieveRequirementCollocationById(Long id);
    void deleteRequirementCollocation(Long id);
}
