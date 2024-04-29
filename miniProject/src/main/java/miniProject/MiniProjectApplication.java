package miniProject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import miniProject.service.AllPostsListService;
@Controller
@SpringBootApplication
@MapperScan(value = {"miniProject"})
public class MiniProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniProjectApplication.class, args);
	}
	@Autowired
	AllPostsListService allPostsListService;
	@GetMapping("/")
	public String index(@RequestParam(value = "gender", required = false)String gender
					  , @RequestParam(value = "height", required = false)String height
					  , @RequestParam(value = "weight", required = false)String weight
					  , @RequestParam(value = "style", required = false)String style
					  , @RequestParam(value = "orderBy", required = false)String orderBy
					  ,Model model) {
		allPostsListService.execute(gender, height, weight, style, orderBy, model );
		return "thymeleaf/index";
	}

}
