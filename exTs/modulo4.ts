//ex 7 e 8
class Carro {
    marca: string;
    modelo: string;
    ano: number;
    private static contador: number = 0;

    constructor(marca: string, modelo: string, ano: number) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        Carro.contador++;
    }

    descricao(): string {
        return `Marca: ${this.marca}. Modelo: ${this.modelo}. Ano: (${this.ano})`;
    }

    static contarCarros(): number {
        return Carro.contador;
    }
}

const carro1 = new Carro("Toyota", "Corolla", 2020);
const carro2 = new Carro("Honda", "Civic", 2021);
const carro3 = new Carro("Ford", "Focus", 2019);

console.log(carro1.descricao());
console.log(carro2.descricao());
console.log(carro3.descricao());

console.log(`Número de carros criados: ${Carro.contarCarros()}`);