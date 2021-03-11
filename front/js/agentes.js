


function exibirParceiros (parceiros) {
    let tabela = '<table> <tr> <th>Parceiro</th> - <th>Volume Transacional</th> </tr>'
    for (let index = 0; index < parceiros; index++) {

        tabela += `<tr> <td> ${parceiros[index].nome} </td><td> ${parceiros[index].volumeTransacional} </td> </tr>`
        
    }
    tabela += '</table>'

    document.getElementById("saida").innerHTML = tabela
    

}

