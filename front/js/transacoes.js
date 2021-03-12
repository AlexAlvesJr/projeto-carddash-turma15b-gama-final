function validaLogin() {
    let usuario = localStorage.getItem("userLogged")
    
    if(!usuario) {
        window.location = "login.html"
    }

    consultaAgente()

    let objUser = JSON.parse(usuario)
 

/*
    document.getElementById("imgUser").innerHTML = `<img src="${objUser.linkFoto}" width="100" height="100">`
    document.getElementById("dadosUser").innerHTML = 'Usuário: <b>' + objUser.nome + '</b> - (' + objUser.racf + ') <br>'
*/

}

function consultaAgente() {
    let url = window.location.href;
    let res = url.split('?');
    let agente = res[1].split('=')
    let id = agente[1]
    console.log(id)
    //alert(id)
    fetch("http://localhost:8080/agente/count/"+id)
    .then(res => validaResposta(res))

    
}

    
function validaResposta(resultado) {

    if(resultado.status == 200) {
        resultado.json().then(res => exibirParceiros(res))
    } else {
        document.getElementById("saida").innerHTML = "Não encontrado"
    }
}

function logout() {
    localStorage.removeItem("userLogged");
    localStorage.removeItem("parceiroSelecionado");
    window.location = "login.html"
}

function exibirParceiros (parceiros) {
    

    //localStorage.setItem("parceiroSelecionado", JSON.stringify(parceiros))
    

    for (let index = 0; index < parceiros.length; index++) {

        //let objAgente = JSON.parse(parceiro)
        
        let count = parceiros[index].count
        let nome = parceiros[index].agente
        let volume = parceiros[index].volumeTransacional
        document.getElementById("nome").innerHTML = nome + " / R$ " + volume 

        document.getElementById("saida"+index).innerHTML = count
        
    }


    
}