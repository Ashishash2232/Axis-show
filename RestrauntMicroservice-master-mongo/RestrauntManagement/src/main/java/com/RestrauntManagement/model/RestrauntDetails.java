package com.RestrauntManagement.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestrauntDetails {
    @Id
    private int rid;
    private String rname;
    private String rnumber;
    private String rcity;
    private List foodDetails;
}
