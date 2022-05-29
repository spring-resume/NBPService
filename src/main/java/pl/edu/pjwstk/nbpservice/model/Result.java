package pl.edu.pjwstk.nbpservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@ApiModel("Data about your inquiry")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(position = 1, value = "unique id of your inquiry")
    private Long id;
    @ApiModelProperty(position = 2, value = "provided currency")
    private String currency;
    @ApiModelProperty(position = 3, value = "start of the time period")
    private LocalDate startDate;
    @ApiModelProperty(position = 4, value = "end of the time period")
    private LocalDate endDate;
    @ApiModelProperty(position = 5, value = "calculated rate")
    private double rate;
    @ApiModelProperty(position = 6, value = "date of the query")
    private LocalDateTime executeQuestion;

    public Result() {
    }

    public Result(Long id,
                  String currency,
                  LocalDate startDate,
                  LocalDate endDate,
                  double rate,
                  LocalDateTime executeQuestion) {
        this.id = id;
        this.currency = currency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rate = rate;
        this.executeQuestion = executeQuestion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public LocalDateTime getExecuteQuestion() {
        return executeQuestion;
    }

    public void setExecuteQuestion(LocalDateTime executeQuestion) {
        this.executeQuestion = executeQuestion;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", rate=" + rate +
                ", executeQuestion=" + executeQuestion +
                '}';
    }
}
