package tn.esprit.backendpi.Service.Interfaces;

import java.io.IOException;

public interface IpdfHouse {
    byte[] generatePdf(Long contractId, Long houseId) throws IOException;
}
