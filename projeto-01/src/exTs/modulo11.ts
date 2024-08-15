// ex 21
function adicionarDiv(texto: string): void {
    const div = document.createElement('div');
    div.textContent = texto;
    document.body.appendChild(div);
}

// ex 22
function adicionarItensALista(listaDeItens: string[]): void {
    const ul = document.querySelector('ul');
    if (ul) {
        listaDeItens.forEach(item => {
            const li = document.createElement('li');
            li.textContent = item;
            ul.appendChild(li);
        });
    }
}
