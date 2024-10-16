/**
 * 
 */
// onload 시점
$(() => {
    // [정보보기] 버튼 클릭 시 데이터 요청
    $("#btn1").click(()=>{

        getTsunamiShelter(1);

    });

});

// 지진해일 긴급대피소 데이터 요청
const getTsunamiShelter = (pageNo) => {
    $.ajax({
        url: 'shelter.do',
        data: {
            rows: $("#rows").val(),
            pageNo: pageNo
        },
        success: (result)=> {
            console.log(result);
            let value;
			for(let r of result.TsunamiShelter[1].row){
				value += '<tr><td>'+ r.shel_nm +'</td>'
	                    +'<td>'+ r.address +'</td>'
	                    +'<td>'+ r.shel_av +'</td>'
	                    +'<td>'+ r.shel_div_type +'</td>'
	                    +'<td>'+ r.tel +'</td>'
	                    +'<td>'+ r.manage_gov_nm + '</td></tr>'
			}
				
			$("#shelter-list tbody").html(value);

            showPagination(pageNo, Math.ceil(result.TsunamiShelter[0].head[0].totalCount / $("#rows").val()) )
        },
        error: (err)=> {
            console.log(err);
        }
    });
}

const showPagination = (currPage, maxPage) => {
    const pageLimit = 10;       // 페이징바 표시 개수
    let startPage;     // (표시) 현재 페이지 번호
    let endPage;      // (표시) 마지막 페이지 번호

    startPage = Math.floor((currPage -1) / pageLimit) * pageLimit + 1;

    endPage = startPage + pageLimit -1;
    if(endPage> maxPage) {
        endPage = maxPage;
    }
    
    /*
        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item"><a class="page-link" href="#">Next</a></li>
    */
   let pgData = '';

    // 이전 버튼
     pgData += "<li class ='page-item "
     + (currPage == 1 ? "disabled" : "")     // 현재 페이지가 1이라면 비활성화
     + " '> <a class='page-link' href='#' onclick='getTsunamiShelter("
     + (currPage - 1)
     +")'>Previous</a></li>";

    // 페이징 번호 버튼
    for (let i = startPage; i <= endPage; i++) {
        pgData += '<li class="page-item ' 
                + (currPage == i ? 'active' : '') 
                + '"><a class="page-link" href="#" onclick="getTsunamiShelter('
                + i + ')">' + i + '</a></li>';
    }



    // 다음 버튼
    pgData += "<li class='page-item "
        + (currPage == maxPage ? 'disabled' : '')      // 현재 페이지가 마지막 페이지라면 비활성화
        +"'><a class='page-link' href='#' onclick='getTsunamiShelter("
        + (currPage + 1)
        + ")'>Next</a></li>";

    $("#page-area").html(pgData);

    $("#currPage").text(currPage);
    $("#maxPage").text(maxPage);
}