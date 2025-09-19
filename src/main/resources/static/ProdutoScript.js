(function () {
    // SCRIPT DE DELETE
    const btnSim = document.getElementById("btnsim");

    if (btnSim) {
        $("#tabprodutos").on("click", ".js-delete", function () {
            let botaoClicado = $(this);
            $("#btnsim").attr("data-id", botaoClicado.attr("data-id"));
            $("#modalproduto").modal("show");
        });

        $("#btnsim").on("click", function () {
            let id = $(this).attr("data-id");
            $.ajax({
                url: "/produtos/remover/" + id,
                method: "GET",
                success: function () {
                    window.location.href = "/produtos";
                }
            });
        });
    }

    // SCRIPT DAS MATÉRIAS-PRIMAS
    const select = document.getElementById('selectMateriaPrima');
    const quantidadeInput = document.getElementById('quantidadeMateriaPrima');
    const btnAdicionar = document.getElementById('btnAdicionarMateria');
    const container = document.getElementById('materiasSelecionadas');

    const materiasAdicionadas = new Map();

    // Inicializa o Map com os MPs já renderizados pelo Thymeleaf
    document.querySelectorAll('#materiasSelecionadas input[name="materiaPrimasIds"]').forEach(input => {
        const id = input.value;
        const qtdInput = document.querySelector(`input[name="quantidades[${id}]"]`);
        if (qtdInput) {
            const quantidade = parseFloat(qtdInput.value);
            materiasAdicionadas.set(id, quantidade);
        }
    });

    if (btnAdicionar) {
        btnAdicionar.addEventListener('click', function () {
            const id = select.value;
            const nome = select.options[select.selectedIndex].text;
            const quantidade = parseFloat(quantidadeInput.value);

            if (!id || isNaN(quantidade) || quantidade <= 0) {
                alert("Selecione uma matéria-prima válida e insira uma quantidade maior que zero.");
                return;
            }

            if (materiasAdicionadas.has(id)) {
                alert("Essa matéria-prima já foi adicionada.");
                return;
            }

            materiasAdicionadas.set(id, quantidade);

            const wrapper = document.createElement("div");
            wrapper.classList.add("mb-2");

            const span = document.createElement("span");
            span.className = "badge bg-success me-2";
            span.textContent = `${nome} - ${quantidade}`;

            const btnRemover = document.createElement("button");
            btnRemover.className = "btn btn-sm btn-danger ms-2 btnRemoverMateria";
            btnRemover.textContent = "Remover";
            btnRemover.type = "button";
            btnRemover.setAttribute('data-id', id);

            // Remove item do map e do DOM ao clicar
            btnRemover.addEventListener("click", function () {
                materiasAdicionadas.delete(id);
                container.removeChild(wrapper);
            });

            // Campos hidden para envio no form
            const inputId = document.createElement("input");
            inputId.type = "hidden";
            inputId.name = "materiaPrimasIds";
            inputId.value = id;

            const inputQtd = document.createElement("input");
            inputQtd.type = "hidden";
            inputQtd.name = `quantidades[${id}]`;
            inputQtd.value = quantidade;

            wrapper.appendChild(span);
            wrapper.appendChild(btnRemover);
            wrapper.appendChild(inputId);
            wrapper.appendChild(inputQtd);

            container.appendChild(wrapper);

            // Limpa campos
            select.value = "";
            quantidadeInput.value = "";
        });
    }

    // Event delegation para remover botões já renderizados no carregamento
    container.addEventListener('click', function(event) {
        if (event.target.classList.contains('btnRemoverMateria')) {
            const id = event.target.getAttribute('data-id');
            materiasAdicionadas.delete(id);
            event.target.parentElement.remove();
        }
    });

})();
