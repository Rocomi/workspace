  $(document).ready(function() {
      // 1) 텍스트 에디터 표시
      $('#summernote').summernote({
        placeholder: 'My Editor!',
        tabsize: 2,
        height: 400,
        toolbar: [
          ['style', ['style']],
          ['font', ['bold', 'clear']],
          ['color', ['color']],
          ['para', ['ul', 'ol', 'paragraph']],
          ['table', ['table']],
          ['insert', ['picture']],
          ['view', ['fullscreen', 'codeview', 'help']]
        ],
        callbacks: {
          onImageUpload: imageUpload
        }
      });
      
       $("#btn-write").click(() => {
    	$.ajax({
    		url: "/board",
    		type: "POST",
    		data: {
    			title:$("#title").val() ,
    			content: $("#summernote").summernote("code")
    		},
    		
    		success: (result) => {
    			if (result === 'ok!') {
    				alert("게시글 작성 성공!");
    				
    			console.log(result);
    		} else {
    				alert("게시글 작성 실패!");
    				}
    		},
    		
    		error: (err) => {
    			console.log(err);
    				alert("문제가 발생하였습니다. 다시 시도해주세요!");
    				}
    		});
    	});

 

	$("#btn-reset").click(() => {
    	//	제목 초기화 => input 요소의 value 속성을 초기화 (빈 값으로 설정)
        $("#title").val("");
        
    	// 	내용 초기화 => summernote 초기화. empty, code, reset ... 
    	// $("#summernote").summernote('code', ''); 
        $("#summernote").summernote("empty");
        // $("#summernote").summernote("reset");
  });



    $("#btn-check").click(() => {
      // 2) 입력된 데이터, 스타일 등의 정보를 조회
      const content = $("#summernote").summernote("code");
      $("#result").text(content);
      // $("#result").html(content);
    })
  });

  // imgList : file 객체 리스트(배열)
  const imageUpload = (imgList) => {
  // console.log(imgList);

  // 텍스트 에디터에 이미지가 추가되었을 때
  // summernote 에서는 이미지 파일을 전달해준다. --> callbacks.onImageUpload

  // 이미지가 추가되면 우리 서버에 따로 업로드 후 해당 이미지 경로를 세팅해줘야 함.

  // form 태그에서는 enctype 을 multipart/form-data로 설정하여 전송했으며
  // 스크립트 상으로는 FormData 객체를 사용하여 ajax 요청을 할 것임.

  const formData = new FormData();
  for (let file of imgList) {
      formData.append("imgList", file);
  }
  

  $.ajax ({
    url: 'upload',
    type: 'post',
    data: formData,
    processData: false,
    contentType: false,   // application/x-www-form-... (default) -> multipart/form-data
    success: (result)=> {
      console.log(result);  // ["xxx.xx", "xx.xx"]
      for (let imgSrc of result) {
          $("#summernote").summernote("editor.insertImage", imgSrc);
      }
    },
    error: (err)=> {
      console.log(err);
      alert('문제가 발생하였습니다.');
    }
  });
}    
    
    
    
