package com.ippon.hexagonal.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    @Column(columnDefinition = "VARCHAR", nullable = false)
    private String name;
    @Column(columnDefinition = "VARCHAR", nullable = false)
    private String email;
    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDate dob;
    @Column(columnDefinition = "VARCHAR", nullable = false)
    private String city;

    @Transient
    private Integer age;

    public Student(String name, String email, LocalDate dob, String city) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.city = city;
    }

}
