package server;

import my_random.Interval;
import my_random.MyRandom;
import my_random.return_type.ReturnType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("random")
public class RandomRangeController {

    @RequestMapping(value = "/int", method = RequestMethod.POST)
    public ReturnType<Integer> fromIntRange(
            @RequestBody Interval<Integer> interval
    ) {
        return new ReturnType<>(MyRandom.randomInt(interval));
    }

    @RequestMapping(value = "/double", method = RequestMethod.POST)
    public ReturnType<Double> fromDoubleRange(
            @RequestBody Interval<Double> interval
    ) {
        return  new ReturnType<>(MyRandom.randomDouble(interval));
    }
}
