package org.aukcje.user;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="app_user")
public class User extends PanacheEntity {

    private String name;

    private String surname;

    private String email;

    private String password;

}
