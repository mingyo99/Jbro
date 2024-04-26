package miniProject.service.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import miniProject.command.CommentCommand;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.CommentDTO;
import miniProject.domain.MemberDTO;
import miniProject.mapper.AutoMapper;
import miniProject.mapper.CommentMapper;
import miniProject.mapper.MemberMapper;

@Service
public class CommentAddService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	CommentMapper commentMapper;
	@Autowired
	AutoMapper autoMapper;
	public List<CommentDTO> execute(CommentCommand commentCommand, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		MemberDTO mDto = memberMapper.memberSelectOne(auth.getUserId());
		
		String contentsNum = autoMapper.autoNumSelect("COMMENTS", "COMMENTS_NUM", "com");
		
		CommentDTO dto = new CommentDTO();
		dto.setCommentsNum(contentsNum);
		dto.setMemberNum(mDto.getMemberNum());
		dto.setCommentsContent(commentCommand.getCommentsContent());
		dto.setPostsNum(commentCommand.getPostsNum());
		commentMapper.commentInsert(dto);
		
		List<CommentDTO> list = commentMapper.commentSelect(dto.getPostsNum());
		return list;
	}
}
