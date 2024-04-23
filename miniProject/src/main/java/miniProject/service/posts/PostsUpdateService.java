package miniProject.service.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import miniProject.command.PostsCommand;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.MemberDTO;
import miniProject.domain.PostsDTO;
import miniProject.mapper.MemberMapper;
import miniProject.mapper.PostsMapper;

@Service
public class PostsUpdateService {
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
		postsMapper.postsUpdate(dto);
	}
}
