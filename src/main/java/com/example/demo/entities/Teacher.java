package com.example.demo.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Teacher {

    int id;

    String name;

    String subject;

    int rating;

    int salary;

    int totalsub;
}
