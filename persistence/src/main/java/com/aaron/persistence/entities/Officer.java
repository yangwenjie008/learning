package com.aaron.persistence.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="officers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Officer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Rank rank;
    @NonNull
    @Column(name = "first_name")
    private String first;
    @NonNull
    @Column(name = "last_name")
    private String last;
}
