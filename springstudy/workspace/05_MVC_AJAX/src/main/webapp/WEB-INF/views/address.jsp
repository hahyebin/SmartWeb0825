<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
 <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=4lnq99nnpg&submodules=geocoder"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function(){

		var map = new naver.maps.Map("map", {
		  center: new naver.maps.LatLng(37.55415109162072, 126.93582461156707),
		  zoom: 15,
		  mapTypeControl: true
		});

		var infoWindow = new naver.maps.InfoWindow({
		  anchorSkew: true
		});

		map.setCursor('pointer');

		function searchCoordinateToAddress(latlng) {

		  infoWindow.close();

		  naver.maps.Service.reverseGeocode({
		    coords: latlng,
		    orders: [
		      naver.maps.Service.OrderType.ADDR,
		      naver.maps.Service.OrderType.ROAD_ADDR
		    ].join(',')
		  }, function(status, response) {
		    if (status === naver.maps.Service.Status.ERROR) {
		      if (!latlng) {
		        return alert('ReverseGeocode Error, Please check latlng');
		      }
		      if (latlng.toString) {
		        return alert('ReverseGeocode Error, latlng:' + latlng.toString());
		      }
		      if (latlng.x && latlng.y) {
		        return alert('ReverseGeocode Error, x:' + latlng.x + ', y:' + latlng.y);
		      }
		      return alert('ReverseGeocode Error, Please check latlng');
		    }

		    var address = response.v2.address,
		        htmlAddresses = [];
		    
			
		    document.addr.answer.value = address.roadAddress;
		    var sub = address.roadAddress.split(' ');
		    var ss = sub[0]+" "+sub[1];
		    document.addr.aa.value = ss;
		    

		    if (address.jibunAddress !== '') {
		        htmlAddresses.push('[지번 주소] ' + address.jibunAddress);
		    }

		    if (address.roadAddress !== '') {
		        htmlAddresses.push('[도로명 주소] ' + address.roadAddress);
		    }

		    infoWindow.setContent([
		      '<div style="padding:10px;min-width:200px;line-height:150%;">',
		      '<h5 style="margin-top:5px;">검색 좌표</h5><br />',
		      htmlAddresses.join('<br />'),
		      '</div>'
		    ].join('\n'));

		    infoWindow.open(map, latlng);
		  });
		}

		function searchAddressToCoordinate(address) {
		  naver.maps.Service.geocode({
		    query: address
		  }, function(status, response) {
		    if (status === naver.maps.Service.Status.ERROR) {
		      if (!address) {
		        return alert('Geocode Error, Please check address');
		      }
		      return alert('Geocode Error, address:' + address);
		    }

		    if (response.v2.meta.totalCount === 0) {
		      return alert('No result.');
		    }

		    var htmlAddresses = [],
		      item = response.v2.addresses[0],
		      point = new naver.maps.Point(item.x, item.y);

		    if (item.roadAddress) {
		      htmlAddresses.push('[도로명 주소] ' + item.roadAddress);
		    }

		    if (item.jibunAddress) {
		      htmlAddresses.push('[지번 주소] ' + item.jibunAddress);
		    }

		    if (item.englishAddress) {
		      htmlAddresses.push('[영문명 주소] ' + item.englishAddress);
		    }

		    infoWindow.setContent([
		      '<div style="padding:10px;min-width:100px;line-height:150%;">',
		      '<h5 style="margin-top:5px;">검색 주소 : '+ address +'</h5><br />',
		      htmlAddresses.join('<br />'),
		      '</div>'
		    ].join('\n'));
			
		    map.setCenter(point);
		    infoWindow.open(map, point);
		  });
		}

		function initGeocoder() {
		  if (!map.isStyleMapReady) {
		    return;
		  }

		  map.addListener('click', function(e) {
		    searchCoordinateToAddress(e.coord);
		    alert(e.coord.lat() + ', ' + e.coord.lng());
		  });

		  $('#address').on('keydown', function(e) {
		    var keyCode = e.which;

		    if (keyCode === 13) { // Enter Key
		      searchAddressToCoordinate($('#address').val());
		    }
		  });

		  $('#submit').on('click', function(e) {
		    e.preventDefault();

		    searchAddressToCoordinate($('#address').val());
		  });

		  searchAddressToCoordinate('노고산동 106-1');
		}

		naver.maps.onJSContentLoaded = initGeocoder;
		naver.maps.Event.once(map, 'init_stylemap', initGeocoder);
	
		
		

		
		
	})

</script>
<style>

.search { position:absolute;z-index:1000;top:20px;left:20px; }
.search #address { width:150px;height:20px;line-height:20px;border:solid 1px #555;padding:5px;font-size:12px;box-sizing:content-box; }
.search #submit { height:30px;line-height:30px;padding:0 10px;font-size:12px;border:solid 1px #555;border-radius:3px;cursor:pointer;box-sizing:content-box; }


</style>



</head>
<body>
  
<div id="wrap" class="section">
    <h2>주소와 좌표 검색 API 사용하기</h2>

    <div id="map" style="width:50%;height:400px;">
        <div class="search" style="">
            <input id="address" type="text" placeholder="검색할 주소"  />
            <input id="submit" type="button" value="주소 검색" />
        </div>
    </div>
    <code id="snippet" class="snippet"></code>
</div>
		<form name="addr">
			<input type="text" name="answer" id="answer" value="">
			<input type="text" name="aa" id="aa" value="">
		</form>
</body>
</html>