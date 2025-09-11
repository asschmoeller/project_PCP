(function(){
$("#tabequipamentos").on("click",".js-delete", function(){
    let botaoClicado = $(this);
        $("#btnsim")
            .attr("data-id", botaoClicado.attr("data-id"));
        $("#modalequipamento").modal("show");
});

$("#btnsim").on("click",function(){
    let botaosim = $(this);
    let id = botaosim.attr("data-id");
    $.ajax(
        {
            url: "/equipamentos/remover/" + id,
            method: "GET",
            success: function(){
            window.location.href = "/equipamentos";
            }
        }
    )
});

// SCRIPT DOS PRODUTOS
    const select = document.getElementById('produtos');
    const selecionadasDiv = document.getElementById('produtosSelecionados');

    if (select && selecionadasDiv) {
        function atualizarSelecionadas() {
            selecionadasDiv.innerHTML = "";

            const selectedOptions = Array.from(select.selectedOptions);

            selectedOptions.forEach(option => {
                const tag = document.createElement("span");
                tag.textContent = option.text;
                tag.classList.add("badge", "bg-primary", "me-2", "mb-2");
                tag.style.cursor = "pointer";

                const closeBtn = document.createElement("span");
                closeBtn.textContent = " ❌";
                closeBtn.style.marginLeft = "5px";
                closeBtn.style.color = "white";

                closeBtn.addEventListener("click", () => {
                    option.selected = false;
                    atualizarSelecionadas();
                });

                tag.appendChild(closeBtn);
                selecionadasDiv.appendChild(tag);
            });
        }

        select.addEventListener("change", atualizarSelecionadas);
        window.addEventListener("load", atualizarSelecionadas);
    }

})();

