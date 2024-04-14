package tn.esprit.backendpi.Service.Classes;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.AnnouncementCarpooling;
import tn.esprit.backendpi.Entities.RatingCarpooling;
import tn.esprit.backendpi.Entities.RequirementCarpooling;
import tn.esprit.backendpi.Entities.User;
import tn.esprit.backendpi.Repository.ReqCarpoolingRepository;
import tn.esprit.backendpi.Repository.UserRepository;
import tn.esprit.backendpi.Service.Interfaces.IAnnCarpoolingService;
import tn.esprit.backendpi.Service.Interfaces.IEmailService;
import tn.esprit.backendpi.Service.Interfaces.IReqCarpoolingService;

import java.util.List;
import java.util.Optional;

import static tn.esprit.backendpi.Service.Classes.EmailServiceImpl.htmlTemplate;

@Service
@RequiredArgsConstructor
public class ReqCarpoolingServiceImpl implements IReqCarpoolingService {

    private final IAnnCarpoolingService iAnnCarpoolingService;


    private final ReqCarpoolingRepository reqCarpoolingRepository;
    private final IEmailService emailService;
    private final UserRepository userRepository;
    @Override
    public RequirementCarpooling addReqCarpooling(RequirementCarpooling requirementCarpooling) {
        System.out.println(requirementCarpooling);
        User loggedInUser=userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
        AnnouncementCarpooling a= iAnnCarpoolingService.getByIdAnnouncementCarpooling(requirementCarpooling.getAnnouncementCarpoolingReq().getIdCarpoolingAnnouncement());
        User requiredUser=a.getUserAnnCarpooling();

        try {
            assert loggedInUser != null;
            emailService.sendSimpleMessage(requiredUser.getEmail(),"Requirement", htmlTemplate("Coco",requiredUser.getFullname(),loggedInUser.getFullname()));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        a.setPlaces(a.getPlaces()-1);
        iAnnCarpoolingService.updateAnnCarpooling(a);
        requirementCarpooling.setUsersRequirementCarpooling(loggedInUser);
        return reqCarpoolingRepository.save(requirementCarpooling);
    }

    @Override
    public RequirementCarpooling updateReqCarpooling(RequirementCarpooling requirementCarpooling) {
        return reqCarpoolingRepository.save(requirementCarpooling);
    }

    @Override
    public void deleteReqCarpooling(Long id) {

        reqCarpoolingRepository.deleteById(id);
    }

    @Override
    public List<RequirementCarpooling> getAllReqCarpooling() {
        return (List<RequirementCarpooling>) reqCarpoolingRepository.findAll();
    }

    @Override
    public RequirementCarpooling getByIdReqCarpooling(Long id) {

        return reqCarpoolingRepository.findById(id).orElse(null);
    }
}
