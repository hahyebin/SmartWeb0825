package common;

public class Page {
	
	private int totalRecord;   		 // 전체 게시글 수(DB에서 가져옴)
	private int recordPerPage = 10;   // 한 페이지에 표시하는 게시글 수(여기서 정함 . 여기선 한 페이지에 3개) 
	private int totalPage;      	 // 전체 페이지 수( totalRecord, recordPerPage 로 계산( 나누기 ))
	
	/*****************************************************
	    - 전체 11개 게시글 
	    - 한 페이지당 3개 게시글 
	    page = 1, beginRecord = 1,  endRecord = 3; 
	    page = 2, beginRecord = 4,  endRecord = 6; 
	    page = 3, beginRecord = 7,  endRecord = 9; 
	    page = 4, beginRecord = 10, endRecord = 11; 
	 *****************************************************/
	private int page; 			// 현재 페이지 번호(파라미터로 받아옴)
	private int beginRecord;  	// 각 페이지에 표시되는 시작 게시글 번호(page, recordPerPage 로 계산)
	private int endRecord;  	// 각 페이지에 표시되는 종료 게시글 번호(beginRecord, recordPerPage, totalRecor로 계산)
	
	/*******************************************************************
		- 전체 12 페이지 
		- 한 블록당 5개 페이지 
		 1block < 1 2 3 4 5 >   page=1~5,    beginPage=1,  endPage=5
		 2block < 6 7 8 9 10 >  page=6~10,   beginPage=6,  endPage=10
		 3block < 11 12 >       page=11~15,  beginPage=11, endPage=12
	 *******************************************************************/
	
	private int pagePerBlock = 5;   // 한 블록에 표시되는  페이지 수(여기서 정함) 
	private int beginPage;			// 각 블록에 표시하는 시작 페이지 번호(page, pagePerBlock로 계산)
	private int endPage;			// 각 블록에 표시하는 종료 페이지 번호(beginPage, pagePerBlock, totalPage로 계산)
	
	// notice  페이징 처리 방법 
	public void setPageEntity(int totalRecord, int page) {    // (전체 게시글 수, 현재 페이지)
		
		this.totalRecord = totalRecord;
		this.page = page;
		
		// totalPage 전체 페이지 수 
		totalPage = totalRecord / recordPerPage;
		if (totalRecord % recordPerPage != 0) {
			totalPage++;
		}
 	
		// beginRecord~endRecord   각 페이지의 첫 게시물번호~종료 게시물번호
		beginRecord = (page - 1) * recordPerPage + 1;
		endRecord = beginRecord + recordPerPage - 1;
		endRecord = (totalRecord < endRecord) ? totalRecord : endRecord;
		
		// beginPage, endPage
		beginPage = ((page - 1) / pagePerBlock) * pagePerBlock + 1;
		endPage = beginPage + pagePerBlock - 1;
		endPage = (totalPage < endPage) ? totalPage : endPage;
		
	}
									// 넘어온 path에 ?parameter가 있기 때문에 기존 ?page를 &page로 변경해야한다. 
	public String getPageEntity(String path) {
		StringBuilder sb = new StringBuilder();
		
		// path에 ?가 포함되어 있으면 path에 파라미터가 포함되어 있다는 의미임 .
		// ex
		// path = find.notice?column=WRITER&query=admin
		
		// 위와 같은 경우 page 파라미터는 &page로 path에 추가해야 한다.
		// path = find.notice?column=WRITER&query=admin&page=
		
		
		// 첫 페이지로 이동 : 1페이지는 링크가 필요없다. 
		if(page == 1) { 
			sb.append("◀◀&nbsp;");
		// 첫 페이지가 아닐때는 클릭하면 첫번째 페이지로 이동
		} else {
			if ( path.contains("?") ) {
				sb.append("<a href=\""+path+"&page=1\">◀◀</a>&nbsp;");
			} else {
				sb.append("<a href=\""+path+"?page=1\">◀◀</a>&nbsp;");
			}
		}
		
		String concat = path.contains("?") ? "&" : "?";
		// 이전 블록으로 이동 : 1블록은 링크가 필요 없다.
		 if (page <= pagePerBlock) {
			sb.append("◀&nbsp;");
		} else {
			sb.append("<a href=\"" + path + concat + "page=" + (beginPage - 1) + "\">◀</a>&nbsp;");
		}
		
		
		// 페이지 번호 : 현재 페이지는 링크가 필요 없다.
		for (int i = beginPage; i <= endPage; i++) {
			if (page == i) {
				sb.append(i + "&nbsp;");
			} else {
				if( path.contains("?")) {
					sb.append("<a href=\""+path+"&page=" + i + "\">" + i + "</a>&nbsp;");					
				} else {
					sb.append("<a href=\""+path+"?page=" + i + "\">" + i + "</a>&nbsp;");

				}
			}
		}
		
		
		// 다음 블록으로 이동 : 마지막 블록은 링크가 필요 없다. 
		if (endPage == totalPage) {
			sb.append("▶&nbsp;");
		} else {
			sb.append("<a href=\"" + path + concat + "page=" + (endPage + 1) + "\">▶</a>&nbsp;");
		}
		
		// 마지막 페이지로 이동 : 마지막 페이지는 링크가 필요 없다
		if (page == totalPage) {
			sb.append("▶▶");
		} else {
				sb.append("<a href=\""+path+ concat + "page=" + totalPage + "\">▶▶</a>");				
		}
		return sb.toString();
	}

	
	
	public int getPagePerBlock() {
		return pagePerBlock;
	}
	public void setPagePerBlock(int pagePerBlock) { 
		this.pagePerBlock = pagePerBlock;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage() {   /* 수정 */
		beginPage = ((page-1) / pagePerBlock) * pagePerBlock +1;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage() {     /* 수정 */
		endPage = beginPage + pagePerBlock -1;
		if ( endPage > totalPage ) {
			endPage = totalPage;
		}
	}

	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public int getBeginRecord() {
		return beginRecord;
	}
	public void setBeginRecord() {   /* 수정 */
		beginRecord = (page - 1)*recordPerPage+1;
	}
	public int getEndRecord() {
		return endRecord;
	}
	public void setEndRecord() {      /* 수정 */
		endRecord = beginRecord + recordPerPage -1;
		if( endRecord > totalRecord) {    //  endRecord 계산식을 이용하면 전체 게시글 수보다 초과될 수 있기 때문에 endRecord에 totalRecord로 대입해야한다!
			endRecord = totalRecord;
		}
	}
	
	
	public int getTotalRecord() {
		return totalRecord;
	}
	
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getRecordPerPage() {
		return recordPerPage;
	}
	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage() {  /* 수정 */
		totalPage = totalRecord / recordPerPage ;     
		if(totalRecord % recordPerPage != 0) {
			totalPage++;
		}
	}
	
	
	
	
	
	
}
