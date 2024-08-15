class Produto {
    nome: string;
    preco: number;
    quantidade: number;
    categoria: string;
}

// ex 29
function calcularValorTotal(produtos: Produto[]): number {
    return produtos
        .filter(produto => produto.quantidade > 0)
        .reduce((total, produto) => total + (produto.preco * produto.quantidade), 0);
}

// ex 30
function procurarProdutosPorCategoria(produtos: Produto[], categoria: string): Produto[] {
    return produtos.reduce((resultado, produto) => {
        if (produto.categoria === categoria) {
            resultado.push(produto);
        }
        return resultado;
    }, [] as Produto[]);
}