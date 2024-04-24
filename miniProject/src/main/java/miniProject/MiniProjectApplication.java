package miniProject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	public String index(Model model) {
		allPostsListService.execute(model);
		return "thymeleaf/index";
	}

}
