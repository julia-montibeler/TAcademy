// ex 11
function primeiroElemento<T>(array: T[]): T {
    return array[0];
}

const num = [1, 2, 3];
const str = ["a", "b", "c"];
const obj = [{ nome: "João" }, { nome: "Maria" }, { nome: "José" }];

console.log(primeiroElemento(num));
console.log(primeiroElemento(str));
console.log(primeiroElemento(obj));

// ex 12
class Caixa<T> {
    private valor: T;

    constructor(valor: T) {
        this.valor = valor;
    }

    armazenar(valor: T): void {
        this.valor = valor;
    }

    recuperar(): T {
        return this.valor;
    }
}

const caixaNumero = new Caixa<number>(1);
console.log(caixaNumero.recuperar());
caixaNumero.armazenar(2);
console.log(caixaNumero.recuperar());

const caixaString = new Caixa<string>("abc");
console.log(caixaString.recuperar());
caixaString.armazenar("def");
console.log(caixaString.recuperar());

const caixaObjeto = new Caixa<{ nome: string }>({ nome: "Julia" });
console.log(caixaObjeto.recuperar());
caixaObjeto.armazenar({ nome: "João" });
console.log(caixaObjeto.recuperar());

