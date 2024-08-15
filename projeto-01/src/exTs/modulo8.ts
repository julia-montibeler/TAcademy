// ex 15
function minMax(numeros: number[]): [number, number] {
    const max = Math.max(...numeros);
    const min = Math.min(...numeros);
    return [max, min];
}

// ex 16
type Produto = {
    nome: string;
    preco: number;
};

function filtrarProdutosPorPreco(produtos: Produto[], valorMinimo: number): Produto[] {
    return produtos.filter(produto => produto.preco > valorMinimo);
}
