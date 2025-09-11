(function(){
$("#tabmateriasPrimas").on("click",".js-delete", function(){
    let botaoClicado = $(this);
        $("#btnsim")
            .attr("data-id", botaoClicado.attr("data-id"));
        $("#modalmateriaPrima").modal("show");
});

$("#btnsim").on("click",function(){
    let botaosim = $(this);
    let id = botaosim.attr("data-id");
    $.ajax(
        {
            url: "/materiasPrimas/remover/" + id,
            method: "GET",
            success: function(){
            window.location.href = "/materiasPrimas";
            }
        }
    )
});

})();

