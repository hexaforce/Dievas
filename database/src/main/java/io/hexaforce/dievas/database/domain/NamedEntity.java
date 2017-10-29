package io.hexaforce.dievas.database.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
@SuppressWarnings("serial")
public class NamedEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

}
