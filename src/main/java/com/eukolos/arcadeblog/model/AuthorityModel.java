package com.eukolos.arcadeblog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AuthorityModel implements Serializable {

    @Id
    @Column(length = 16)
    private String name;



    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Authority{" +
                "name='" + name + "'" +
                "}";
    }
}
