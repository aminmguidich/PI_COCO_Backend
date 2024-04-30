package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.Contract;

import java.io.IOException;

public interface IpdfHouse {
    byte[] generatePdf(Contract contract) throws IOException;
}
