window.addEventListener('load',function(){

    var btn =document.querySelector("button");
    btn.addEventListener('click',function(){
        var ajaxObj=null;
        try
        {
            ajaxObj = new XMLHttpRequest();
        }
        catch (e){
            try{
                ajaxObj = new ActiveXObject("Msxml2.XMLHTTP3.0"); }
            catch (e){
                alert("Your browser broke!");
                return false;
            }
        }

        let div=document.querySelector("#output");
         ;
        ajaxObj.onreadystatechange=function(){
            //alert("State changed");
            let userArray;
            let response;
            if ((ajaxObj.readyState == 4 && ajaxObj.status == 200)) {
                response = ajaxObj.responseText;
                userArray = JSON.parse(response);

                userArray.forEach(x => {
                    console.log(x.name, x.phone);
                    let element=document.createElement("p");
                    let br=document.createElement("br")
                    let textnode=document.createTextNode(x.name+","+x.phone);
                    element.appendChild(textnode);
                    div.appendChild(element);
                    div.appendChild(br);
                })

            }
        }
        ajaxObj.open("GET","https://jsonplaceholder.typicode.com/users",true);

        ajaxObj.send(null);
    })



})
