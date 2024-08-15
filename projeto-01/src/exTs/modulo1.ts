// ex 1
let str: string = "texto";
let num: number = 1;
let bool: boolean = true;
let array: number[] = [1, 2, 3, 4, 5];

function imprimir(str: string, num: number, booleano: boolean, array: number[]): string {
    return `String: ${str}, Número: ${num}, Booleano: ${booleano}, Array: ${array.join(', ')}`;
}

// ex 2
interface Livro {
    titulo: string;
    autor: string;
    numPag: number;
    disponivel: boolean;
}

function descreverLivro(livro: Livro): string {
    return `Livro: ${livro.titulo}. Autor: ${livro.autor}. Número de páginas: ${livro.numPag}. ` +
           `Disponível: ${livro.disponivel ? "Sim" : "Não"}.`;
}