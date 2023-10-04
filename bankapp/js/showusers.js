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


        ajaxObj.onreadystatechange=function(){
            //alert("State changed");
            let userArray;
            let response;
            if ((ajaxObj.readyState == 4 && ajaxObj.status == 200)) {
                response = ajaxObj.responseText;
                userArray = JSON.parse(response);

                userArray.forEach(x => {
                    console.log(x.name, x.phone);
                })
            }
        }
        ajaxObj.open("GET","https://jsonplaceholder.typicode.com/users",true);

        ajaxObj.send(null);
    })



})
