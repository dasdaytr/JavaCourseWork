let urlMain = 'http://localhost:8080/api/publishing'
function getPublishing(){
    $.get(urlMain).done(function (data){
        setSubMenuList(data)
    })
}
function setSubMenuList(data){
    for(let i in data){
        $(".sub-menu-list").append(
            "<li>" +
                "<a href='/books/publishing?id="+data[i][0] + "' class='sub-menu-link'>" +data[i][1] + "</a>" +
            "</li>"
        )
    }
}
getPublishing()