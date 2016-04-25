package metier.configs;

import metier.GrpColis;

public abstract class ConfigurationColis extends GrpColis {
	String nomConfig;
	public ConfigurationColis(String nom) {
		super();
		nomConfig = nom;
	}
	
}
