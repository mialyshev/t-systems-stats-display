package bean;

import dto.ProductStatisticDto;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import service.ProductService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Slf4j
@Named
@ApplicationScoped
@Getter
public class StatsView implements Serializable {

    @Inject
    private ProductService productService;

    @Inject
    private ReceiverConfigBean receiverConfigBean;

    @Inject
    @Push(channel = "stats")
    private PushContext context;

    private List<ProductStatisticDto> stats;

    @PostConstruct
    public void init() {
        log.info("init connection");
        receiverConfigBean.openConnection();
        stats = productService.getStats();
        log.info(stats.toString());
    }

    public void updateStand() {
        log.info("Update...");
        stats = productService.getStats();
        log.info(stats.toString());
        context.send("update");
        log.info("Update end");
    }
}
