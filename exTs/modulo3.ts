// ex 5
interface Pessoa {
    nome: string;
    idade: number;
    profissao: string;
}

function descreverPessoa(pessoa: Pessoa): string {
    return `${pessoa.nome} tem ${pessoa.idade} anos e trabalha como ${pessoa.profissao}.`;
}

// ex 6
interface Produto {
    nome: string;
    preco: number;
    categoria: string;
}

function filtrarPorCategoria(produtos: Produto[], categoria: string): Produto[] {
    return produtos.filter(produto => produto.categoria === categoria);
}