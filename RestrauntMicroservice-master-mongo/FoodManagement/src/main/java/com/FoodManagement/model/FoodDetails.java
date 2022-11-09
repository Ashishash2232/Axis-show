package com.FoodManagement.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoodDetails {

        @Id
        private int fid;
        private String fname;
        private int fprice;
        private int rid;
}
