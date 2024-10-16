
// 비동기 통신 (ajax)

// onload 시점
$(function() {
	// btn1 아이디 속성을 가진 요소의 클릭 이벤트
	$("#btn1").click(function() {
		
		// // ajax 통신 : 요청 주소 - air.do, 요청 데이터 - {location: 선택된 지역정보}
		// // json 방식으로 데이터를 응답받는 방법
		// $.ajax({
		// 	url: "air.do",
		// 	data: {location : $("#location").val() },
		// 	success: function (result) {
		// 		console.log(result);
				
		// 		let value;
		// 		for(let r of result.response.body.items){
					
		// 			value += '<tr><td>'+ r.stationName +'</td>'
	    //                     +'<td>'+ r.dataTime +'</td>'
	    //                     +'<td>'+ r.khaiValue +'</td>'
	    //                     +'<td>'+ r.pm10Value +'</td>'
	    //                     +'<td>'+ r.coValue +'</td>'
	    //                     +'<td>'+ r.no2Value +'</td>'
	    //                     +'<td>'+ r.so2Value +'</td>'
	    //                     +'<td>'+ r.o3Value +'</td></tr>'
		// 		}
				
		// 		$(".table tbody").html(value);
		// 	},
		// 	error: function(err) {
		// 		console.log(err);
		// 	}
		// });

		getAirPollution("air.do", 1, function(result) {
			console.log(result);
				
			// 응답데이터를 화면에 표시하는 부분을 함수로 분리!
			appendJsonData(result);
		})
	});

	// btn2 아이디 속성을 가진 요소의 클릭 이벤트
	$("#btn2").click(function() {
		
		// xml 방식으로 데이터를 응답받는 방법
		// $.ajax({
		// 	url: "air2.do",
		// 	data: {location : $("#location").val() },
		// 	success: (result) => {
		// 		console.log(result);

		// 		const itemArr = $(result).find("item"); //[<item/>,<item/>,...]

		// 		let tbodyData = "";
		// 		itemArr.each((index, item) => {
		// 			// console.log($(item));

		// 			tbodyData += "<tr>"
		// 						+ "<td>" + $(item).find("stationName").text() + "</td>"
		// 						+'<td>'+ $(item).find("dataTime").text() +'</td>'
		// 						+'<td>'+ $(item).find("khaiValue").text() +'</td>'
		// 						+'<td>'+ $(item).find("pm10Value").text() +'</td>'
		// 						+'<td>'+ $(item).find("coValue").text() +'</td>'
		// 						+'<td>'+ $(item).find("no2Value").text() +'</td>'
		// 						+'<td>'+ $(item).find("so2Value").text() +'</td>'
		// 						+'<td>'+ $(item).find("o3Value").text() +'</td></tr>';
					
		// 			$(".table tbody").html(tbodyData);
		// 		})
		// 	},
		// 	error: (err) => {
		// 		console.log(err);
		// 	}
		// });

		getAirPollution("air2.do", 1, function(result) {
			console.log(result);

			appendXmlData(result);
		});
	});
})

const getAirPollution = (url, pageNo, callback) => {
	$.ajax({
		url: url,
		data: {location : $("#location").val(), pageNo : pageNo },
		success: (result) => {
			// 매개변수 전달된 콜백함수를 응답데이터를 담아 호출
			callback(result)
		},
		error: (err) => {
			console.log(err);
		}
	})
};

const getMoreData = (nextNo) => {
	// [더보기] 버튼이 클릭되었을 때 데이터를 추가로 요청
	getAirPollution("air.do", nextNo, function(result) {
		appendJsonData(result);
	})
}

const getMoreXmlData = (nextNo) => {
	// [더보기] 버튼이 클릭되었을 때 데이터를 추가로 요청
	getAirPollution("air2.do", nextNo, function(result) {
		appendXmlData(result);
	})
}

const appendJsonData = (result) => {
	let value = "";
	if(result.response.body.pageNo != 1){
		value = $(".table tbody").html(); 	// pageNo가 1이 아닐때만 tbody 데이터 기존데이터에 추가
	}
	for(let r of result.response.body.items){
		
		value += '<tr><td>'+ r.stationName +'</td>'
	            +'<td>'+ r.dataTime +'</td>'
	            +'<td>'+ r.khaiValue +'</td>'
	            +'<td>'+ r.pm10Value +'</td>'
	            +'<td>'+ r.coValue +'</td>'
	            +'<td>'+ r.no2Value +'</td>'
	            +'<td>'+ r.so2Value +'</td>'
	            +'<td>'+ r.o3Value +'</td></tr>'
	}
	
	$(".table tbody").html(value);

	$("#ap-table + button").remove();

	if($(".table tbody tr").length < result.response.body.totalCount){
		$("#ap-table").after("<button class='btn btn-dark w-100' onclick='getMoreData("+(result.response.body.pageNo+1)+")'>더보기</button>");
	}
}

const appendXmlData = (result) => {
	const itemArr = $(result).find("item"); 
	let tbodyData = "";
	if($(result).find("pageNo").text() != 1){
		tbodyData = $(".table tbody").html(); 	// pageNo가 1이 아닐때만 tbody 데이터 기존데이터에 추가
	}

	itemArr.each((index, item) => {

		tbodyData += "<tr>"
					+ "<td>" + $(item).find("stationName").text() + "</td>"
					+'<td>'+ $(item).find("dataTime").text() +'</td>'
					+'<td>'+ $(item).find("khaiValue").text() +'</td>'
					+'<td>'+ $(item).find("pm10Value").text() +'</td>'
					+'<td>'+ $(item).find("coValue").text() +'</td>'
					+'<td>'+ $(item).find("no2Value").text() +'</td>'
					+'<td>'+ $(item).find("so2Value").text() +'</td>'
					+'<td>'+ $(item).find("o3Value").text() +'</td></tr>';
		
		$(".table tbody").html(tbodyData);

	});

	$(".table tbody").html(tbodyData);

	$("#ap-table + button").remove();
	
	if($(".table tbody tr").length < $(result).find("totalCount").text()){
		$("#ap-table").after("<button class='btn btn-dark w-100' onclick='getMoreXmlData("+(parseInt($(result).find("pageNo").text())+1)+")'>더보기</button>");
		console.log($(result).find("pageNo").text());
	}
}