package miniProject.service.member;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import miniProject.command.MemberCommand;
import miniProject.domain.MemberDTO;
import miniProject.mapper.MemberMapper;

@Service
public class MemberWriteService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberMapper memberMapper;
	public void execute(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		String memberPw = memberCommand.getMemberPw();
		//BeanUtils.copyProperties(memberCommand, dto);
		dto.setGender(memberCommand.getGender());
		dto.setHeight(memberCommand.getHeight());
		dto.setMemberAddr(memberCommand.getMemberAddr());
		dto.setMemberAddrDetail(memberCommand.getMemberAddrDetail());
		dto.setMemberBirth(memberCommand.getMemberBirth());
		dto.setMemberEmail(memberCommand.getMemberEmail());
		dto.setMemberId(memberCommand.getMemberId());
		dto.setMemberName(memberCommand.getMemberName());
		dto.setMemberNum(memberCommand.getMemberNum());
		dto.setMemberPhone1(memberCommand.getMemberPhone1());
		dto.setMemberPhone2(memberCommand.getMemberPhone2());
		dto.setMemberPost(memberCommand.getMemberPost());
		dto.setWeight(memberCommand.getWeight());
		dto.setMemberPw(passwordEncoder.encode(memberPw));
		memberMapper.memberInsert(dto);
	}
}
