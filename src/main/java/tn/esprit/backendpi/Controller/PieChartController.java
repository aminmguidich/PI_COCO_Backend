package tn.esprit.backendpi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.backendpi.Service.Classes.PieChartService;

import java.util.Map;

@RestController
@RequestMapping("/api/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class PieChartController {

    private final PieChartService pieChartService;

    @Autowired
    public PieChartController(PieChartService pieChartService) {
        this.pieChartService = pieChartService;
    }

    @GetMapping("/budget-pie-chart")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Map<String, Integer>> getBudgetPieChartData() {
        Map<String, Integer> data = pieChartService.getBudgetPieChartData();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }}