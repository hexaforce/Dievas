package io.hexaforce.dievas.database.domain;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * @author tanta
 *
 */

@Data
@Entity
@Table(name = "pets")
@SuppressWarnings("serial")
public class Pet extends NamedEntity {
	
    /**
     * 
     */
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date birthDate;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType type;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    /**
     * 
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "petId", fetch = FetchType.EAGER)
    private Set<Visit> visits = new LinkedHashSet<>();
    
    
    
    
    
    
    
    
    
    
}
