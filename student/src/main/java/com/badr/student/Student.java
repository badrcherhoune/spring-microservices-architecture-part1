package com.badr.student;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    private Integer schoolId;
}
