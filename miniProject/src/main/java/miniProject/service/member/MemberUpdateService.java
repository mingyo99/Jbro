package miniProject.service.member;

import java.io.File;
import java.net.URL;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import miniProject.command.MemberCommand;
import miniProject.domain.MemberDTO;
import miniProject.mapper.MemberMapper;

@Service
public class MemberUpdateService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setGender(memberCommand.getGender());
		dto.setHeight(memberCommand.getHeight());
		dto.setMemberAddr(memberCommand.getMemberAddr());
		dto.setMemberAddrDetail(memberCommand.getMemberAddrDetail());
		dto.setMemberBirth(memberCommand.getMemberBirth());
		dto.setMemberName(memberCommand.getMemberName());
		dto.setMemberNum(memberCommand.getMemberNum());
		dto.setMemberPhone1(memberCommand.getMemberPhone1());
		dto.setMemberPhone2(memberCommand.getMemberPhone2());
		dto.setMemberPost(memberCommand.getMemberPost());
		dto.setWeight(memberCommand.getWeight());
		
		URL resource = getClass().getClassLoader().getResource("static/upload");
		System.out.println(resource);
		String filrDir = "C:\\dev\\src5\\miniProject\\target\\classes\\static\\upload";
		MultipartFile mf = memberCommand.getProfileImg();
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
		
		dto.setProfileImg(storeFileName);
		dto.setProfileImgImg(originalFile);
		
		memberMapper.memberUpdate(dto);
	}
}
