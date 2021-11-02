<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ex09_session.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>


<%
	request.setCharacterEncoding("utf-8");
	String product = request.getParameter("product");  // select는 무조건 하나 받음 
	String quan = request.getParameter("quantity");    // 입력을 안할수도있기때문에 빈문자열 체크하기 
	
	int quantity = 0;
	if( quan.isEmpty() == false){
		quantity = Integer.parseInt(quan);
	}
	
	// cart에 저장될 한 항목 Product은 2개의 필드가 있지만 Product가 들어간 cart는 한개씩 product객체가 한개씩 들어가있음 모여서 카트는 product가진 arraylist!
	Product p = new Product();   
	p.setProduct(product);
	p.setQuantity(quantity);

	// cart[]의 타입 : Product[] 또는 ArrayList<Product>
	// cart는 session에 저장 
	// 1. session에 저장된 카트를 꺼낸다.
	// 2. cart가 없으면 새로운 cart를 만들어서 session에 저장한다.
	List<Product> cart = (ArrayList<Product>)session.getAttribute("cart");  // 세션에 약속된 상황이기 때문에 세션에 있는지 없는지 모르는상태로 꺼내는거고, 없으면 만들어 넣기 
	if(cart == null) {
		cart = new ArrayList<Product>();
		session.setAttribute("cart", cart); // "cart"라는 이름에 cart객체 저장   세션에는 "cart" 저장 - 식별자  
		
	}
	// cart에 Prdouct p 담기
	cart.add(p);	
	/*
	int cnt = 0;
	
	Product goodQnt = new Product();
	for(int i=0; i<cart.size(); i++){
		goodQnt = cart.get(i);
		if(goodQnt.getProduct().equals(product)){
			cnt++;
			int oriCnt = goodQnt.getQuantity()+1;
			
			goodQnt.setQuantity(oriCnt);
		}
		
		
	}
	cart.add(goodQnt);
	out.println(goodQnt);
	out.println(goodQnt.getQuantity());
*/
	
%>
<script>
	alert('<%=p.getProduct()%> 제품을 장바구니에 추가했습니다.');
	if ( confirm ('장바구니로 가려면 "확인", 계속 쇼핑하려면 "취소"를 누르세요.')){  // 확인 
		location.href = "04_cartC.jsp";
	} else { // 취소
		location.href = "04_cartA.jsp";
	}
</script>