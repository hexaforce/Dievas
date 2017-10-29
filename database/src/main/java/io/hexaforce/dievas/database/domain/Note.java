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
public class Note {
	@Id
	@SequenceGenerator(name="note_generator", sequenceName="note_sequence", initialValue = 5)
	@GeneratedValue(generator = "note_generator")
	private long id;

	private String title;

	private String body;

	@ManyToMany
	private List<Tag> tags;
}
