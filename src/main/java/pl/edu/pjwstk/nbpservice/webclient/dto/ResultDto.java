package pl.edu.pjwstk.nbpservice.webclient.dto;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class ResultDto {
    private String table;
    private String currency;
    private String code;
    private ArrayList<RateDto> rates;
}
