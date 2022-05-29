package pl.edu.pjwstk.nbpservice.webclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.edu.pjwstk.nbpservice.model.Result;
import pl.edu.pjwstk.nbpservice.webclient.dto.ResultDto;
import pl.edu.pjwstk.nbpservice.webclient.dto.RateDto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class NbpClient {
    private final RestTemplate restTemplate;
    private final String url;

    public NbpClient(RestTemplate restTemplate, @Value("${my.adress}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public Result getResult(String table, String code, String startDate, String endDate) {
        String path = createPath(table,code,startDate,endDate);
        ResultDto root = restTemplate.getForObject(path, ResultDto.class);

        return Result.builder()
                .currency(Objects.requireNonNull(root).getCurrency())
                .startDate(LocalDate.parse(startDate))
                .endDate(LocalDate.parse(endDate))
                .rate(getRate(root))
                .executeQuestion(LocalDateTime.now())
                .build();
    }

    private String createPath(String... var) {
        return url + String.join("/", var) + "?format=json";
    }
    private double getRate(ResultDto question) {
        return question.getRates().stream()
                .mapToDouble(RateDto::getMid)
                .average()
                .orElse(0.0);
    }
}
