// ex 19
async function buscarDados(): Promise<string> {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            const sucesso = Math.random() > 0.5;
            if (sucesso) {
                resolve("Dados retornados");
            } else {
                reject("Erro");
            }
        }, 2000);
    });
}


async function busca() {
    try {
        const resultado = await buscarDados();
        console.log(resultado);
    } catch (erro) {
        console.error(erro);
    }
}

busca();

// ex 20
async function buscarDados1(): Promise<string> {
    return new Promise((resolve) => {
        setTimeout(() => resolve("Resultado 1"), 1000);
    });
}

async function buscarDados2(): Promise<string> {
    return new Promise((resolve) => {
        setTimeout(() => resolve("Resultado 2"), 2000);
    });
}

async function combinarResultados(): Promise<{ r1: string; r2: string }> {
    try {
        const [r1, r2] = await Promise.all([buscarDados1(), buscarDados2()]);
        return {r1, r2};
    } catch (erro) {
        throw new Error("Erro ao combinar");
    }
}

