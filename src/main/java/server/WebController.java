package server;

import my_random.Interval;
import my_random.return_type.DoubleReturnType;
import my_random.return_type.IntReturnType;
import my_random.return_type.ReturnType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class WebController extends WebMvcConfigurerAdapter {

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/results").setViewName("results");
//    }

    @GetMapping("/results")
    public String showResult(@RequestParam(value = "value", defaultValue = "0") String value, Model model) {
        model.addAttribute("value", value);
        return "results";
    }

    @GetMapping("/")
    public String showForm(IntervalForm intervalForm) {
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid IntervalForm intervalForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        Interval postObject = intervalForm.toInterval();

        RestTemplate restTemplate = new RestTemplate();

        ReturnType rand = intervalForm.getType().equals("int") ?
                restTemplate.postForObject(
                        "http://localhost:80/random/" + intervalForm.getType(),
                        postObject,
                        IntReturnType.class
                ) :
                restTemplate.postForObject(
                        "http://localhost:80/random/" + intervalForm.getType(),
                        postObject,
                        DoubleReturnType.class
                );

        redirectAttributes.addAttribute("value", rand.getValue());

        return "redirect:/results";
    }
}