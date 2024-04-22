package miniProject.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.command.MemberCommand;
import miniProject.mapper.AutoMapper;

@Service
public class MemberAutoNumService {
	@Autowired
	AutoMapper autoMapper;
	public void execute(Model model) {
		String memberNum = autoMapper.autoNumSelect("MEMBERS", "MEMBER_NUM", "mem");
		MemberCommand memberCommand = new MemberCommand();
		memberCommand.setMemberNum(memberNum);
		model.addAttribute("memberCommand", memberCommand);
	}
}
