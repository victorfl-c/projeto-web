//Selecionando o que vou precisar usar
const campEscola = document.querySelector('.campoDasEscolas');
const escola = document.querySelector('.Escola');
const formEscola = document.querySelector('#formCriarEscola');
const inputFormEscl = document.querySelector('#nomeEscola');
const formTurma = document.querySelector('#formCriarTurm');
const inputFormTurm = document.querySelector('#nomeDaTurma');
const inputFormDiscpTurm = document.querySelector("#discpDaTurma");

var idEsclClicada = "Escola-0";

//Construindo a Escola ao Salvar
const salvarEscola = (text) => {

    //Gerando uma Id aleatória ao criar a Turma
    const IdEscola = Math.round(Math.random() * 10000);

    const scholl = document.createElement("div");
    scholl.classList.add("Escola", `Escola-${IdEscola}`, "d-md-flex", "align-items-md-center", "mt-2", "mb-2");

    const divScholl = document.createElement("div");
    divScholl.classList.add("col-sm-9", "ms-2", "me-5", "border", "border-primary", "rounded")
    scholl.appendChild(divScholl);

    const btnScholl = document.createElement("button");
    btnScholl.setAttribute("type", 'button')
    btnScholl.classList.add("btEscola","col-12", "btn", "btn-primary");
    btnScholl.innerHTML = text;
    divScholl.appendChild(btnScholl);

    //Construindo a Div onde ficará as turmas
    const turmsEscola = document.createElement('div');
    turmsEscola.classList.add("turmasDaEscola");
    divScholl.appendChild(turmsEscola);

        const tituloDaSecao = document.createElement('h5');
        tituloDaSecao.classList.add("mt-3", "mb-3", "ms-3");
        tituloDaSecao.innerText = 'Suas turmas:';
        turmsEscola.appendChild(tituloDaSecao);

        
        const divBtAddTurmas = document.createElement('div');
        divBtAddTurmas.classList.add("d-flex", "align-items-center", "justify-content-center", "mb-3", "mt-4");
        turmsEscola.appendChild(divBtAddTurmas);

        //Botão de adicionar turma
        const btnAdTurmas = document.createElement("button");
        btnAdTurmas.setAttribute("type",'button');
        btnAdTurmas.classList.add("col-md-5", "btn", "btn-success", "btn-sm");
        btnAdTurmas.setAttribute("data-bs-toggle",'modal');
        btnAdTurmas.setAttribute("data-bs-target",'#modalCriarTurma');
        btnAdTurmas.innerHTML = 'Adicionar nova Turma';
        divBtAddTurmas.appendChild(btnAdTurmas);

        //Determinar que o botão chame a Escola correta
        btnAdTurmas.onclick = () => {
            idEsclClicada = `Escola-${IdEscola}`
        }
    
    //Construindo os botões de edição da escola
    const btnEditEscol = document.createElement("button");
    btnEditEscol.setAttribute("type", 'button');
    btnEditEscol.classList.add("col-md-1", "me-2", "editEscola", "btn", "btn-warning", "btn-sm");
    btnEditEscol.setAttribute("data-bs-toggle",'modal');
    btnEditEscol.setAttribute("data-bs-target",'#modalEditScol');
    btnEditEscol.innerHTML = 'Editar';
    scholl.appendChild(btnEditEscol);

    const btnDelEscol = document.createElement("button");
    btnDelEscol.setAttribute("type", 'button');
    btnDelEscol.classList.add("col-md-1", "deleteEscola", "btn", "btn-danger", "btn-sm");
    btnDelEscol.innerHTML = 'Excluir'
    scholl.appendChild(btnDelEscol);


    //Determinando que as novas escolas serão criadas dentro da Div = campoDasEscolas
    campEscola.appendChild(scholl);
    
    //Zerando o input após criar Escola
    inputFormEscl.value = "";

}


//Construindo a Turma ao Salvar
const salvarTurma = (text) => {
    let divTurmas = document.querySelector(`.${idEsclClicada} .turmas`);

    //Analisar se a divTurmas existe, caso não, criará.
    if (divTurmas === null) {
        divTurmas = document.createElement('div');
        divTurmas.classList.add("turmas");
        document.querySelector(`.${idEsclClicada} .turmasDaEscola`)
        .insertBefore(divTurmas, document.querySelector(`.${idEsclClicada} .turmasDaEscola`).firstChild.nextSibling);
    }   
    
    const turm = document.createElement("div");
    turm.classList.add("Turma", "mb-3");
    divTurmas.appendChild(turm);

    const btnTurma = document.createElement("a");
    btnTurma.setAttribute("href", './aulas/aulas.html');
    btnTurma.setAttribute("type", 'button');
    btnTurma.classList.add("col-md-9", "btn", "btn-outline-secondary", "ms-2", "p-2", "text-start");
    btnTurma.innerHTML = text;
    turm.appendChild(btnTurma);

    const btnEditTurm = document.createElement("button");
    btnEditTurm.setAttribute("type", 'button');
    btnEditTurm.classList.add("col-md-1", "editTurma", "btn", "btn-warning", "btn-sm", "ms-4", "me-1");
    btnEditTurm.setAttribute("data-bs-toggle",'modal');
    btnEditTurm.setAttribute("data-bs-target",'#modalEditTurma');
    btnEditTurm.innerHTML = 'Editar'
    turm.appendChild(btnEditTurm);

    const btnDelTurm = document.createElement("button");
    btnDelTurm.setAttribute("type", 'button');
    btnDelTurm.classList.add("col-md-1", "removTurma", "btn", "btn-danger", "btn-sm");
    btnDelTurm.innerHTML = 'Excluir'
    turm.appendChild(btnDelTurm);

    //Zerando os inputs após criar
    inputFormTurm.value = "";
    inputFormDiscpTurm.value = "";
}


// Eventos

//Evento de Submit ao criar uma nova escola
formEscola.addEventListener("submit", (e) => {
    e.preventDefault();
  
    const nomeEscola = inputFormEscl.value;
  
    if (nomeEscola) {
      salvarEscola(nomeEscola);
    }
});

//Evento de Submit ao Criar uma nova turma
formTurma.addEventListener("submit", (e) => {
    e.preventDefault();
  
    const nomeTurma = inputFormTurm.value;
  
    if (nomeTurma) {
      salvarTurma(nomeTurma);
    }
});


//Eventos ao clicar nos botões da página
document.addEventListener("click", (e) => {
    const elementoDaAcao = e.target;
    const paiDoElemento = elementoDaAcao.parentNode;
    
    if (elementoDaAcao.classList.contains("deleteEscola")) {
        alert("Sua escola foi removida com sucesso");
        paiDoElemento.remove();
    }


    if (elementoDaAcao.classList.contains("removTurma")) {
        alert("Sua turma foi removida com sucesso");
        paiDoElemento.remove();
        
    }

});


