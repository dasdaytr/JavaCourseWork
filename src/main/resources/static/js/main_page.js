let url = 'http://localhost:8080/api/publishing'
function getPublishingMain(){
    $.get(url).done(function (data){
        setSub(data)
    })
}
function setSub(data){
    console.log(data)
    for(let i in data){
        $(".texnika").append(
            "<div class=\"url-2\">\n" +
            "   <a href='/books/publishing?id="+data[i][0] + "' class=\"tex\">\n" +
                "<img src='" +data[i][2] +"' alt=''>"+
            "   </a>\n" +
            "   <div class=\"url-3\">"+data[i][1]+ "</div>\n" +
            "</div>"
        )
    }
}
getPublishingMain()