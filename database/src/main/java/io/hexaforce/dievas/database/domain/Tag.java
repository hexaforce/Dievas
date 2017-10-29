package io.hexaforce.dievas.database.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Tag {

	@Id
	@SequenceGenerator(name = "tag_generator", sequenceName = "tag_sequence", initialValue = 4)
	@GeneratedValue(generator = "tag_generator")
	private long id;

	private String name;

	@ManyToMany(mappedBy = "tags")
	private List<Note> notes;
}
