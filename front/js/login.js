function login() {

    let user = document.getElementById("nome").value
    let senha = document.getElementById("senha").value


    let usuario = {
        racf: user,
        email: user,
        senha: senha
    }


    let mensagem = { //vamos mandar para backend este conteúdo
        method: 'POST', //no GET não precisa declarar, pois ele é o padrão
        body: JSON.stringify(usuario), //transformar objeto usuario em texto json
        headers: { //dizer para o backend o tipo de mensagem que estamos mandando. É uma mensagem para uma aplicação, num formato json
            'Content-type': 'application/json'
        }
    }


    fetch("http://localhost:8080/user/login", mensagem)
        .then(res => validaLogin(res))

}

function validaLogin(resultado) {
    if (nome.length < 7 || resultado.status != 200) {
        alert("Usuário ou senha inválido! Digite RACF/e-mail e senha para autenticação.")
        user.focus();
        return false
    }
    resultado.json().then(res => efetuaLogin(res))
}

function efetuaLogin(usuario) {

    localStorage.setItem("userLogged", JSON.stringify(usuario)) //cria no localstorage um espécie de um cookie com este nome e este conteúdo
    window.location = "agentes.html"
    

}

function getUser(params) {
    return document.getElementById("nome").innerHTML
     
    
}




