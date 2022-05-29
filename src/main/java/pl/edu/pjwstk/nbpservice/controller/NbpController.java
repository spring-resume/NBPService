package pl.edu.pjwstk.nbpservice.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pjwstk.nbpservice.model.Result;
import pl.edu.pjwstk.nbpservice.service.NbpService;

@RestController
public class NbpController {
    private final NbpService nbpService;

    public NbpController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @ApiOperation(value = "Get rate", notes = "calculate rate by provided data")
    @GetMapping("/{table}/{code}/{startDate}/{endDate}")
    public ResponseEntity<Result> getRate(
            @ApiParam(value = "table A,B or C") @PathVariable String table,
            @ApiParam(value = "code of currency") @PathVariable String code,
            @ApiParam(value = "beginning of time period") @PathVariable String startDate,
            @ApiParam(value = "end of time period") @PathVariable String endDate) {
        return ResponseEntity.ok(nbpService.calculateRateByProvidedData(table,code,startDate,endDate));
    }


}
