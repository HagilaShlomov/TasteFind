package org.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
@Id
    private int id;
    private String username;
    private String email;
    private String passwordHash;
    private java.sql.Timestamp createdAt;

}
