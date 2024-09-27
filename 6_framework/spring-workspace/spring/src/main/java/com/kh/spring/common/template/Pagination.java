package com.kh.spring.common.template;

import com.kh.spring.common.model.vo.PageInfo;

public class Pagination {
	
	// --------- 페이징 처리 ------------
	public static PageInfo getPageInfo(int listCount, int currentPage, int pageLimit, int boardLimit) {
		
		/*
		 * 가장 마지막 페이지는 listCount, boardLimit
		 * 
		 * (총 게시글 / boardLimit) 올림처리
		 */
		int maxPage = (int)Math.ceil((double)listCount / boardLimit);
		/*
		 * 페이징바의 시작번호 (pageLimit, currentPage)
		 * 페이징바의 목록 10개씩 표시한다는 가정 하에
		 * n*10+1
		 * 
		 * (currentPage-1)/10+1 내림처리
		 * 
		 * 
		 */
		int startPage = ((currentPage-1)/pageLimit) * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;
		
		endPage = endPage > maxPage ? maxPage : endPage;
		
		return new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
	}

}
