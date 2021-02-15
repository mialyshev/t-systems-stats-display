package service;

import dto.ProductStatisticDto;
import util.StatsJsonParser;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
public class ProductServiceImpl implements ProductService {

    @Inject
    private StatsJsonParser statsJsonParser;

    private final String GET_STATS_URI = "http://localhost:8080/api/stats";

    public List<ProductStatisticDto> getStats() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(GET_STATS_URI);
        String response = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        return statsJsonParser.parse(response);
    }
}
