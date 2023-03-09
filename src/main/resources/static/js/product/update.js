
let num=1


$("#fileAdd").click(function(){
    console.log("인풋")
    let input = '<div id="file' + num + '">';
        input = input + '<input type="file" name="files" id="files' + num + '" accept="image/*" onchange="setThumbnail(event);" style="display:none;">';
        input = input + '</div>';
        $("#fileBox").append(input);

        $("#fileAdd").attr("for", "files" + num);
})

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
        $("#fileAdd").children().remove()
        $("#fileAdd").append(div);

       
    };
}

$("#image").on("click",".del", function(){
    alert("파일이 삭제되면 복원이 불가합니다")
    let fileNum = $(this).attr("data-fileNum")
    console.log(fileNum)
    $.ajax({
        type:"DELETE",
        url:"/product/"+fileNum,
        dataType:"text",
        success:function(data){
            console.log(data)
        }
    })
    $(this).parent().children().remove()
    $("#fileBox").children().remove()
})