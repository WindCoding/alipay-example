 //控制层 
app.controller('payController' ,function($scope,payService){	
		 $scope.qrPay=function(){
			 payService.qrPay().success(function(response){
				var code =  response.qr_code;
				alert(code);
				 	var qr = new QRious({
				 		   element:document.getElementById('qrious'),
				 		   size:250,
				 		   level:'H',
				 		   value:response.qr_code
				 		});	
			 });
		 };
});	
