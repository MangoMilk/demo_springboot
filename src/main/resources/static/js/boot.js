
function gotoLogin() {
    location.href = "/login"
}

function gotoHome() {
    location.href = "/home"
}

/**
 * Init
 */
(() => {
    let jwt = localStorage.getItem("jwtToken")
    if ((jwt == null || jwt == "") && window.location.pathname != "/login") {
        gotoLogin()
        return
    }

    if (jwt != null && jwt != "" && window.location.pathname == "/login") {
        gotoHome()
        return
    }
})()