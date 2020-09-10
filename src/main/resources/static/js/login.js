
const API_VERIFY_CODE = "/api/verify_code"
const API_LOGIN = "/api/user"

/**
 * Get verify code
 */
$("#btn-code").click(function (){
    let username = $("#input-username").val()

    if (username == null || username == "")
    {
        alert("请输入手机号码")
        return
    }

    let postData = {
        "username": username
    }

    $.ajax({
        url:API_VERIFY_CODE,
        type: "POST",
        data: postData,
        dataType: "json",
        success: (res) => {
            if (res.code == 0) {
                $("#text-code").text(res.content.code)
            }else if(res.code == 1001) {
                alert("请填写正确的手机号码")
            }else if(res.code == 1002) {
                alert("获取太频繁，请稍后再试")
            }else{
                alert(res.message)
            }

            return
        }
    })
})

/**
 * Login
 */
$("#btn-login").click(function (){
    let username = $("#input-username").val()
    let code = $("#input-code").val()

    if (username == null || username == "") {
        alert("请输入手机号码")
        return
    }

    if (code == null || code == "") {
        alert("请输入验证码")
        return
    }

    let postData = {
        "username": username,
        "code": code
    }

    $.ajax({
        url:API_LOGIN,
        type: "POST",
        data: postData,
        dataType: "json",
        success: (res) => {
            if (res.code == 0) {
                localStorage.setItem("jwtToken", res.content.jwt_token)
                localStorage.setItem("userInfo", JSON.stringify(res.content.user_info))
                location.href = "/home"
            }else if(res.code == 1001) {
                alert("请填写正确的手机号码")
            }else if(res.code == 1003) {
                alert("验证码不正确")
            }else if(res.code == 1004) {
                alert("该手机已注册")
            }else{
                alert(res.message)
            }

            return
        }
    })
})