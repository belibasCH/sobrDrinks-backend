package com.example.sobrdrinks.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@Table(
        name="\"user\"",
        uniqueConstraints={
                @UniqueConstraint(columnNames={"rfId"})
        }
)
public class User {
    @Id
    private String rfId;
    private String name;
    private String email;
}
