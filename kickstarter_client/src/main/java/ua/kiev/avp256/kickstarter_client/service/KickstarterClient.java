package ua.kiev.avp256.kickstarter_client.service;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

@ManagedBean(name = "client")
@ApplicationScoped
public class KickstarterClient implements ua.kiev.avp256.kickstarter_client.service.Client {
	private String URL = "http://localhost:8080/kickstarter_server/v1";

	@Override
	public <ENTITY> ENTITY getEntity(String path, Class<ENTITY> clazz) {
		return getResponse(path).getEntity(clazz);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <ENTITY> List<ENTITY> getEntitiesList(String path, Class<ENTITY> clazz) {
		return getResponse(path).getEntity(List.class);
	}

	private ClientResponse getResponse(String path) {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);

		WebResource webResource = client.resource(URL).path(path);

		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new WebApplicationException(response.getStatus());
		}

		return response;
	}
}
