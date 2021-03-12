function validaLogin() {
    let usuario = localStorage.getItem("userLogged")

    if(!usuario) {
        window.location = "login.html"
    }
    let objUser = JSON.parse(usuario)

    document.getElementById("imgUser").innerHTML = `<img src="${objUser.linkFoto}" width="100" height="100">`
    document.getElementById("dadosUser").innerHTML = 'Usuário: <b>' + objUser.nome + '<br></b> RACF: <b>' + objUser.racf + ' <br></b>'

    consultaUsuario()
}

function logout() {
    localStorage.removeItem("userLogged");
    window.location = "login.html"
}

function consultaUsuario() {
    fetch("http://localhost:8080/agente/top10")
    .then(res => validaResposta(res))
}

    
function validaResposta(resultado) {

    if(resultado.status == 200) {
        resultado.json().then(res => exibirParceiros(res))
    } else {
        document.getElementById("saida").innerHTML = "Não encontrado"
    }
}


function exibirParceiros (parceiros) {
    let tabela = '<table border="1" width=100%> <tr> <th>Parceiro</th> <th align="right">Volume Transacional</th> </tr>'
    for (let index = 0; index < parceiros.length; index++) {
        let valorFormatado = parceiros[index].volumeTransacional.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' })

        tabela +=  `<tr> <td> ${parceiros[index].nomeAgente} </td> <td align="right"> ${valorFormatado} </td> </tr>`

        let drop = `<tr> <td> ${parceiros[index].nomeAgente} </td> </tr>`
        document.getElementById("drop"+index).innerHTML = drop
        
    }
    tabela += '</table>'

    document.getElementById("saida").innerHTML = tabela
    
}

