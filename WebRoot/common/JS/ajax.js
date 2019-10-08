function getRequestBody(oForm) {      
			var aParams = new Array();      
			for (var i = 0; i < oForm.elements.length; i++) {     
				var sParam = encodeURIComponent(oForm.elements[i].name);     
				sParam += "=";     
				sParam += encodeURIComponent(oForm.elements[i].value);     
				aParams.push(sParam);     
			} 
			return aParams.join("&");     
		}    
		function createXMLHttp(){   
			if (typeof XMLHttpRequest != "undefined"){   
				return new XMLHttpRequest();   
			}
			else if (window.ActiveXObject) {   
				var aVersions = ["MSXML2.XMLHttp.5.0","MSXML2.XMLHttp.4.0","MSXML2.XMLHttp.3.0","MSXML2.XMLHttp","Microsoft.XMLHttp"];   
				for (var i=0;i<aVersions.length;i++){   
					try{   
						var oXMLHttp = new ActiveXObject(aVersions[i]);   
						return oXMLHttp;   
					}catch(oError){   
						//do nothing           
					}   
				}   
			}   
		} 
		function getRequestBody(oForm) {      
			var aParams = new Array();      
			for (var i = 0; i < oForm.elements.length; i++) {     
				var sParam = encodeURIComponent(oForm.elements[i].name);     
				sParam += "=";     
				sParam += encodeURIComponent(oForm.elements[i].value);     
				aParams.push(sParam);     
			} 
			return aParams.join("&");     
		}   