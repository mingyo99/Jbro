package miniProject.service.posts;

import java.io.File;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniProject.domain.PostsDTO;
import miniProject.mapper.PostsMapper;

@Service
public class PostsDeleteService {
	@Autowired
	PostsMapper postsMapper;
	public void execute(String postsNum) {
		PostsDTO dto = postsMapper.postsSelectOne(postsNum);
		int i = postsMapper.postsDelete(postsNum);
		if(i > 0) {
			URL resource = getClass().getClassLoader().getResource("static/upload");
			String fileDir = resource.getFile();
			
			for(String fileName : dto.getPostsImg().split("/")) {
				File file = new File(fileDir + "/" + fileName);
				if(file.exists())file.delete();
			}
		}
	}
}
