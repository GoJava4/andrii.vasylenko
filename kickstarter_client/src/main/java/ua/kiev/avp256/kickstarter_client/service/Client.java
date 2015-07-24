package ua.kiev.avp256.kickstarter_client.service;

import java.util.List;

public interface Client {
	<ENTITY> ENTITY getEntity(String path, Class<ENTITY> clazz);

	<ENTITY> List<ENTITY> getEntitiesList(String path, Class<ENTITY> clazz);
}
