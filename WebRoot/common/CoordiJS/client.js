function getXMLHttpRequest(){     
    var client = getXMLHttpRequestFromIE();
    if(client == null){
        client = new XMLHttpRequest();
    }
    
    return client;
}

function getXMLHttpRequestFromIE(){
    var namePrefixes = ["Msxml3", "Msxml2", "Msxml", "Microsoft"];
    for(var i = 0; i < namePrefixes.length; i++){
        var name = namePrefixes[i] + ".XMLHTTP";
        try{
          return new ActiveXObject(name);
        }catch(e){
        }
    }
    
    return null;
}