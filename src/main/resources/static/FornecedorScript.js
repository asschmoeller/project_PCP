(function(){
$("#tabfornecedores").on("click",".js-delete", function(){
    let botaoClicado = $(this);
        $("#btnsim")
            .attr("data-id", botaoClicado.attr("data-id"));
        $("#modalfornecedor").modal("show");
});

$("#btnsim").on("click",function(){
    let botaosim = $(this);
    let id = botaosim.attr("data-id");
    $.ajax(
        {
            url: "/fornecedores/remover/" + id,
            method: "GET",
            success: function(){
            window.location.href = "/fornecedores";
            }
        }
    )
});

})();

