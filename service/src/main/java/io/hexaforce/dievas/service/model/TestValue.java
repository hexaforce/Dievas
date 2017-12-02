package io.hexaforce.dievas.service.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestValue {
	private int point;
	private Integer score;
	private String name;
	private Date now;
}
