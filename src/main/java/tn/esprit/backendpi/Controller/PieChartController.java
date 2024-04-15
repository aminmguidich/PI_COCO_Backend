package tn.esprit.backendpi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.backendpi.Service.Classes.PieChartService;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PieChartController {

    private final PieChartService pieChartService;

    @Autowired
    public PieChartController(PieChartService pieChartService) {
        this.pieChartService = pieChartService;
    }

    @GetMapping("/budget-pie-chart")
    public ResponseEntity<Map<String, Integer>> getBudgetPieChartData() {
        Map<String, Integer> data = pieChartService.getBudgetPieChartData();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }}