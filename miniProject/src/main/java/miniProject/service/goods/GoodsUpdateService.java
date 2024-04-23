package miniProject.service.goods;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import miniProject.command.GoodsCommand;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.FileDTO;
import miniProject.domain.GoodsDTO;
import miniProject.mapper.EmployeeMapper;
import miniProject.mapper.GoodsMapper;

@Service
public class GoodsUpdateService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(GoodsCommand goodsCommand, HttpSession session
			, BindingResult result, Model model) {
		GoodsDTO dto = new GoodsDTO();
		dto.setGoodsContent(goodsCommand.getGoodsContent());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		dto.setDeliveryCost(goodsCommand.getDeliveryCost());
		// 수정한 직원의 정보를 알기 위해 로그인 정보를 이용해서 직원정보를 가지고왔습니다.
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String empNum = employeeMapper.getEmpNum(auth.getUserId());
		dto.setUpdateEmpNum(empNum);
		System.out.println(dto.getGoodsName());
		
		// 파일의 정보를 디비로 부터 가져오기
		GoodsDTO goodsDTO = goodsMapper.selectOne(goodsCommand.getGoodsNum());
		// session정보를 가져온다.
		List<FileDTO> list = (List<FileDTO>) session.getAttribute("fileList");
		
		//1. 디렉터리 정보
		URL resource = getClass().getClassLoader().getResource("static/upload");
		
		String fileDir = resource.getFile();
		System.out.println(fileDir);
		if(!goodsCommand.getGoodsMainStore().getOriginalFilename().isEmpty()) {
			// 2. 파일객체를 불러오기
			MultipartFile mf = goodsCommand.getGoodsMainStore();
			// 3. 파일이름 가져오기
			String originalFile = mf.getOriginalFilename();
			// 4. 확장자 불리하기
			String extension = originalFile.substring(originalFile.lastIndexOf("."));
			// 5. 새로운 파일면 만들기
			String storeName = UUID.randomUUID().toString().replace("-", "");
			// 6. 새로운 파일명과 확장자 붙이기
			String storeFileName =  storeName + extension;
			// 7. 파일객체 만들기
			File file = new File(fileDir + "/" +storeFileName);
			// 8. 파일 저장
			try {
				mf.transferTo(file);
			} catch (Exception e) {			
				e.printStackTrace();
			}
			// 9. dto에 파일이름 저장
			dto.setGoodsMainStore(storeFileName);
			dto.setGoodsMainStoreImg(originalFile);
		}else {
			if(list != null) {
				for(FileDTO fd : list) {
					if(fd.getStoreFile().equals(goodsDTO.getGoodsMainStore())) {
						//session에 삭제 정보가 있는데  file을 가져오지 않음
						result.rejectValue("goodsMainStore", "error");
						model.addAttribute("error", "대문이미지를 선택해주세요.");
						session.removeAttribute("fileList");
					}
				}
			}
		}
		goodsMapper.goodsUpdate(dto);
		
	}
}

