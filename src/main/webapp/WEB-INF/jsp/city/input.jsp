<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>Insert title here</title>
<base href="${ctx }/">
<link rel="stylesheet" type="text/css" href="resources/assets/libs/jquery-ui/jquery-ui.min.css">
<link rel="stylesheet" type="text/css" href="resources/assets/libs/jquery-ui/jquery-ui.structure.min.css">
<link rel="stylesheet" type="text/css" href="resources/assets/libs/jquery-ui/jquery-ui.theme.min.css">
<link rel="stylesheet" type="text/css" href="resources/assets/libs/plugins/cascade/css/city-picker.css">
		
<script type="text/javascript" src="resources/assets/libs/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="resources/assets/libs/jquery-ui/jquery-ui.min.js"></script>
<script type="text/javascript" src="resources/assets/libs/jquery-ui/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="resources/assets/libs/plugins/cascade/js/cityPicker-1.0.0.js"></script>
</head>
<body>
	<!-- <table>
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>PARENT_ID</th>
				<th>SHORT_NAME</th>
				<th>LETTER</th>
				<th>CITY_CODE</th>
				<th>PIN_YIN</th>
			</tr>
		</thead>
		<tbody id="city">
			
		</tbody>
	</table> -->
	<h2>模拟城市-无联动/无搜索</h2>
<div class="city-picker-selector" id="city-picker-selector">
	<div class="selector-item storey province">
		<a href="javascript:;" class="selector-name reveal">北京市</a>
		<input type="hidden" name="userProvinceId" class="input-price val-error" value="110000" data-required="userProvinceId">
		<div class="selector-list listing hide">
			<ul>
				<li>北京市</li>
				<li>天津市</li>
				<li>河北省</li>
				<li>山西省</li>
			</ul>
		</div>
	</div>
	<div class="selector-item storey city">
		<a href="javascript:;" class="selector-name reveal">北京市</a>
		<input type="hidden" name="userCityId" class="input-price val-error" value="110100" data-required="userCityId">
		<div class="selector-list listing hide">
			<ul>
				<li>北京市</li>
			</ul>
		</div>
	</div>
	<div class="selector-item storey district">
		<a href="javascript:;" class="selector-name reveal">海淀区</a>
		<input type="hidden" name="userDistrictId" class="input-price val-error" value="110108" data-required="userDistrictId">
		<div class="selector-list listing hide">
			<ul>
				<li>东城区</li>
				<li>西城区</li>
			</ul>
		</div>
	</div>
</div>
<!-- end .city-picker-selector -->

<h2>模拟城市-联动/搜索</h2>
<div class="city-picker-selector" id="city-picker-search">
	<div class="selector-item storey province">
		<a href="javascript:;" class="selector-name reveal df-color ">请选择省份</a>
		<input type="hidden" name="userProvinceId" class="input-price val-error" value="" data-required="userProvinceId">
		<div class="selector-list listing hide">
			<div class="selector-search">
				<input type="text" class="input-search" value="" placeholder="拼音、中文搜索">
			</div>
			<ul>
				<li>北京市</li>
				<li>天津市</li>
			</ul>
		</div>
	</div>
	<div class="selector-item storey city">
		<a href="javascript:;" class="selector-name reveal df-color forbid">请选择城市</a>
		<input type="hidden" name="userCityId" class="input-price val-error" value="" data-required="userCityId">
		<div class="selector-list listing hide">
			<div class="selector-search">
				<input type="text" class="input-search" value="" placeholder="拼音、中文搜索">
			</div>
			<ul></ul>
		</div>
	</div>
	<div class="selector-item storey district">
		<a href="javascript:;" class="selector-name reveal df-color forbid">请选择区县</a>
		<input type="hidden" name="userDistrictId" class="input-price val-error" value="" data-required="userDistrictId">
		<div class="selector-list listing hide">
			<div class="selector-search">
				<input type="text" class="input-search" value="" placeholder="拼音、中文搜索">
			</div>
			<ul></ul>
		</div>
	</div>
</div>
<!-- end .city-picker-selector -->

<h2>原生城市-无联动</h2>
<div class="city-picker-select"></div>
<script type="text/javascript">
	
	
	var cityData;
	
	$(document).ready(function(){

		$.ajax({
			url:'${ctx}/city/list',
			type:'POST',
			dataType:'json',
			success:function(data,status){
				
				cityData = data;
				//模拟城市-无联动/无搜索
				var selector = $('#city-picker-selector').cityPicker({
					dataJson: data,
					params:'',
					renderMode: true,
					search: false,
					linkage: false,
					
				});
				$('#city-picker-selector').on('choose-province.citypicker', function(event, tagert, storage) {
					console.log(storage);
				});

				//设置城市
				selector.setCityVal([{
					'id': '110000',
					'name': '北京市'
				}, {
					'id': '110100',
					'name': '北京市'
				}, {
					'id': '110108',
					'name': '海淀区'
				}]);
			}
		});
		
		
		
		

		/* //模拟城市-联动/搜索
		$('#city-picker-search').cityPicker({
			dataJson: cityData,
			renderMode: true,
			search: true,
			linkage: true
		});

		//原生城市-无联动
		var select = $('.city-picker-select').cityPicker({
			dataJson: cityData,
			renderMode: false,
			linkage: false
		});

		//设置城市
		select.setCityVal([{
			'id': '140000',
			'name': '山西省'
		}, {
			'id': '140100',
			'name': '太原市'
		}, {
			'id': '140105',
			'name': '小店区'
		}]); */
		
	});
	
	
</script>
</body>

</html>