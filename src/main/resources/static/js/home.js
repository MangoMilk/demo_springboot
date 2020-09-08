
let userInfo = localStorage.getItem("userInfo")

if (userInfo != null || userInfo != "")
{
    userInfo = JSON.parse(userInfo)

    $("#text-username").text(userInfo.username)
    $("#text-phone").text(userInfo.phone)
}