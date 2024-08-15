// ex 27
function verificarTipo(param: string | number): string {
    if (typeof param === 'string') {
        return `Você forneceu uma string: ${param}`;
    } else if (typeof param === 'number') {
        return `Você forneceu um número: ${param}`;
    }
    return 'Tipo desconhecido';
}


// ex 28
class Pessoa {
    constructor(public nome: string, public idade: number) {}
}

class Empresa {
    constructor(public nome: string, public cnpj: string) {}
}

function verificarObjeto(obj: Pessoa | Empresa): string {
    if (obj instanceof Pessoa) {
        return `Pessoa: ${obj.nome}, Idade: ${obj.idade}`;
    } else if (obj instanceof Empresa) {
        return `Empresa: ${obj.nome}, CNPJ: ${obj.cnpj}`;
    }
    return 'Tipo desconhecido';
}
