(function(){
$("#tabferramentas").on("click",".js-delete", function(){
    let botaoClicado = $(this);
        $("#btnsim")
            .attr("data-id", botaoClicado.attr("data-id"));
        $("#modalferramenta").modal("show");
});

$("#btnsim").on("click",function(){
    let botaosim = $(this);
    let id = botaosim.attr("data-id");
    $.ajax(
        {
            url: "/ferramentas/remover/" + id,
            method: "GET",
            success: function(){
            window.location.href = "/ferramentas"; 
            }
        }
    )
});

})();

