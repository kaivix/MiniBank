function getCookie(name) {
    let cookieArr = document.cookie.split(";");
    for(let i = 0; i < cookieArr.length; i++) {
        let cookiePair = cookieArr[i].split("=");
        if(name == cookiePair[0].trim()) {
            return decodeURIComponent(cookiePair[1]);
        }
    }
    return null;
}

// Добавление токена в заголовок каждого запроса
let token = getCookie('token');
if(token) {
fetch(url, {
    method: 'POST', // или 'POST', в зависимости от вашего API
    headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + token // добавление токена в заголовок
    },
})
    .then(response => response.json())
    .then(data => {
        let username = data.username;
        let password = data.password;
        // Теперь вы можете использовать username и password
    })
    .catch((error) => console.error('Error:', error));}