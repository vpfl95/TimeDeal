
let num = 0;
let flag = true;

function setThumbnail(event) {
    let reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
  
    reader.onload = function (event) {
        let div = document.createElement("div");
        div.setAttribute("style", "position : relative; margin-right: 20px;");

        let img = document.createElement("img");
        img.setAttribute("src", event.target.result);
        img.setAttribute("style", "width:135px; height:135px;");
        div.append(img);
        
        let i = document.createElement("i");
        i.setAttribute("class", "del fa-solid fa-xmark");
        i.setAttribute("style", "position: absolute; right:0; color:limegreen");
        div.append(i)
        
        $("#fileBox").append(div);
        num++;
        $("#num").text(num);

        if (1 <= num) {
            $("#files").attr("style", "display:none");
        }
       
    };
}

$("#fileBox").on("click",".del", function(){
    $(this).parent().remove()
    num--;
    console.log(  document.getElementById("files").files)
    $("#files").val("")
    console.log(  document.getElementById("files").files)
    if (num < 1) {
        $("#files").css("display", "block");
    }
})