// ex 9
class Animal {
    som(): string {
        return "O animal faz um som";
    }
}

class Cachorro extends Animal {
    som(): string {
        return "gato mia";
    }
}

class Gato extends Animal {
    som(): string {
        return "cachorro late";
    }
}

const cachorro = new Cachorro();
const gato = new Gato();

console.log(cachorro.som());
console.log(gato.som());

// ex 10
class Funcionario {
    nome: string;
    salario: number;

    constructor(nome: string, salario: number) {
        this.nome = nome;
    }

    calcularSalario(): number {
        return this.salario;
    }
}

class FuncionarioHorista extends Funcionario {
    horasTrabalhadas: number;
    valorHora: number;

    constructor(nome: string, valorHora: number, horasTrabalhadas: number) {
        super(nome, valorHora * horasTrabalhadas);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    calcularSalario(): number {
        return this.horasTrabalhadas * this.valorHora;
    }
}

class FuncionarioAssalariado extends Funcionario {
    constructor(nome: string, salarioMensal: number) {
        super(nome, salarioMensal);
    }

    calcularSalario(): number {
        return this.salario;
    }
}

const horista = new FuncionarioHorista("Julia", 50, 160);
const assalariado = new FuncionarioAssalariado("João", 3000);

console.log(`${horista.nome}, salário R$${horista.calcularSalario()}`);
console.log(`${assalariado.nome}, salário R$${assalariado.calcularSalario()}`);
