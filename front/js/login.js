function login(event) {
    event.preventDefault()

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
        .then(console.log(mensagem)).then(res => validaLogin(res))

}

function validaLogin(resultado) {
    if (resultado.status == 200) {
        resultado.json().then(res => efetuaLogin(res))
    } else {
        //console.log("Senha inválida")
        alert("Usuário ou senha inválido! Digite RACF/e-mail e senha para autenticação.")
        //document.getElementById("msgError").innetHTML = "Usuário ou senha inválido! Digite RACF/e-mail e senha para autenticação."
    }
    
}

function efetuaLogin(usuario) {

    localStorage.setItem("userLogged", JSON.stringify(usuario)) //cria no localstorage um espécie de um cookie com este nome e este conteúdo
    window.location = "agentes.html"
    

}




