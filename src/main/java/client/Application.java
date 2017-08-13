package client;

import my_random.Interval;
import my_random.IntervalBound;
import my_random.return_type.IntReturnType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        IntReturnType rand = restTemplate.postForObject(
                "http://localhost:80/int",
                new Interval<>(
                        new IntervalBound<>(true, 0),
                        new IntervalBound<>(true, 10)
                ),
                IntReturnType.class
        );
        log.info(rand.toString());
    }

}


