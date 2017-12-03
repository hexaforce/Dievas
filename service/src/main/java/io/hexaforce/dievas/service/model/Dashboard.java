package io.hexaforce.dievas.service.model;

import java.util.Collection;

import io.hexaforce.dievas.database.freude.entity.AdminUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dashboard {
	private String message;
	private Collection<AdminUser> adminUsers;
}
