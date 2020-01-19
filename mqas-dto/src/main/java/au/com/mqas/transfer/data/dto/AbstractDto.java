package au.com.mqas.transfer.data.dto;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;

@Data
public abstract class AbstractDto {

    private Long id;

    @Getter(onMethod_ = @JsonProperty(value = "creation_time"))
    private ZonedDateTime creationTime;

    @Getter(onMethod_ = @JsonProperty(value = "modified_time"))
    private ZonedDateTime modifiedTime;

}
