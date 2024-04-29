/**
 * 
 */

$(function(){
	$('#userId').on("change keyup",function(){
		$.ajax({
			type:'post',
			url:"/item/userIdCheck",
			data:{"userId":$("#userId").val()},
			dataType : "text",
			success : function(result){
				if(result == "1"){
					$("#idCheck").text("사용중인 아이디 입니다.");
					$("#idCheck").css("color","red");
				}else{
					$("#idCheck").text("사용가능한 아이디 입니다.");
					
				}
			},
			error:function(){
				alert("서버 오류");
			}
		});
	});

	/*$("#userEmail").on("change keyup", function(){
		$.ajax({
			type:'post',
			url:"/checkRest/userEmailCheck",
			data:{"userEmail":$("#userEmail").val()},
			dataType:"html",
			success:function(result){
				if(result == "1"){
					$("#emailCheck").text("사용중인 이메일입니다.");
					$("#emailCheck").css("color","red");
				}else{
					$("#emailCheck").text("사용가능한 이메일입니다.");
					$("#emailCheck").css("color","aqua");
				}
			},
			error:function(){
				
			}
		});
	});*/
	$("#frm").submit(function(){
		if($("#idCheck").text()=="" || $("#idCheck").text()=="사용중인 아이디입니다."){
			$("#idCheck").text("아이디 중복 확인을 해주세요.")
			return false;
		}
		/*if($("#emailCheck").text()=="" || $("#emailCheck").text()=="사용중인 이메일입니다."){
			$("#emailCheck").text("이메일 중복 확인을 해주세요.")
			return false;
		}*/
	});
});