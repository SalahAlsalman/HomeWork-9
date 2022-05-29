package com.example.moviehw9.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.awt.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor @Data
@Entity
public class Movie {
    @Id
    @Column( unique = true)
    @NotEmpty(message = "id is required")
    @Size(max = 3, message = "id must be more than 3")
    private String id;
    @NotEmpty(message = "name is required")
    @Size(max = 3, message = "name must be more than 3")
    @Column(unique = true)
    private String name;
    @Column(nullable = false)
    @Pattern(regexp = "(Drama|Action|Comedy)" ,message = "must be (Drama|Action|Comedy)")
    private String genre;
    @NotNull(message = "rating is required")
    @Length(min = 1, max = 5, message = "rating must be from 1 to 5")
    private Integer rating;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime duration;
    @NotEmpty(message = "launchDate is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime launchDate;


}
