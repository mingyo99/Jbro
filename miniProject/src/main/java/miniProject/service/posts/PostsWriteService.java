package miniProject.service.posts;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import miniProject.command.PostsCommand;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.MemberDTO;
import miniProject.domain.PostsDTO;
import miniProject.mapper.MemberMapper;
import miniProject.mapper.PostsMapper;

@Service
public class PostsWriteService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PostsMapper postsMapper;
	public void execute(PostsCommand postsCommand, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		MemberDTO memDto = memberMapper.memberSelectOne(auth.getUserId());
		PostsDTO dto = new PostsDTO();
		dto.setMemberNum(memDto.getMemberNum());
		dto.setPostsContent(postsCommand.getPostsContent());
		dto.setPostsNum(postsCommand.getPostsNum());
		dto.setPostsStyle(postsCommand.getPostsStyle());
		
		
		
		
		URL resource = getClass().getClassLoader().getResource("static/upload");
		System.out.println(resource);
		String filrDir = resource.getFile();
		String originalTotal = "";
		String storeTotal = "";
		for (MultipartFile mf : postsCommand.getPostsImg()) {
			String originalFile = mf.getOriginalFilename();
			String extension = originalFile.substring(originalFile.lastIndexOf("."));
			String storeName = UUID.randomUUID().toString().replace("-", "");
			String storeFileName = storeName + extension;
			File file = new File(filrDir+"/"+storeFileName);
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			originalTotal += originalFile + "/";
			storeTotal += storeFileName + "/";	
		}
		dto.setPostsImg(storeTotal);
		dto.setPostsImgImg(originalTotal);
		postsMapper.postsInsert(dto);
		
		//상품저장
		dto.setGoodsNums(postsCommand.getGoodsNums());
		for(String goodsNum : dto.getGoodsNums()) {
			postsMapper.postsGoodsInsert(dto.getPostsNum(), goodsNum);
		}
	}
}
