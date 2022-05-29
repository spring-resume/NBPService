package pl.edu.pjwstk.nbpservice.service;

import org.springframework.stereotype.Service;
import pl.edu.pjwstk.nbpservice.model.Result;
import pl.edu.pjwstk.nbpservice.repository.NbpRepository;
import pl.edu.pjwstk.nbpservice.webclient.NbpClient;

@Service
public class NbpService {
    private final NbpClient nbpClient;
    private final NbpRepository nbpRepository;

    public NbpService(NbpClient nbpClient, NbpRepository nbpRepository) {
        this.nbpClient = nbpClient;
        this.nbpRepository = nbpRepository;
    }
    public Result calculateRateByProvidedData(
            String table,
            String code,
            String startDate,
            String enDate) {
        return nbpRepository.save(nbpClient.getQuestion(table, code, startDate,enDate));
    }


}
