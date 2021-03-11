/*function exibirParceiros (compras) {
    let tabela = '<table> <tr> <th>Descrição</th> - <th>valor</th> - <th>data</th> </tr>'
    for (let index = 0; index < compras.length; index++) {
        let data = new Date(compras[index].data) // transforma o texto em um objeto Date
        let dataFormatada = data.toLocaleDateString("pt-BR") // como agora é um objeto, consigo chamar um método para ele

        tabela += `<tr> <td> ${compras[index].descricao} </td><td> ${compras[index].valor} </td><td> ${dataFormatada} </td> </tr>`
        
    }
    tabela += '</table>'

    document.getElementById("saida").innerHTML = tabela

    //document.getElementById("saida").innerHTML = '<b>' + usuario.nome + '</b> <br>' + usuario.email
}*/

function exibirParceiros (compras) {
    let tabela = '<table> <tr> <th>Descrição</th> - <th>valor</th> - <th>data</th> </tr>'
    for (let index = 0; index < compras.length; index++) {

        tabela += `<tr> <td> ${compras[index].parceiro} </td><td> ${compras[index].volume} </td> </tr>`
        
    }
    tabela += '</table>'

    document.getElementById("saida").innerHTML = tabela

    //document.getElementById("saida").innerHTML = '<b>' + usuario.nome + '</b> <br>' + usuario.email
}