(function(){
    // SCRIPT DE DELETE
    const btnSim = document.getElementById("btnsim");

    if (btnSim) {
        $("#tabordensProducao").on("click", ".js-delete", function () {
            let botaoClicado = $(this);
            $("#btnsim").attr("data-id", botaoClicado.attr("data-id"));
            $("#modalordemProducao").modal("show");
        });

        $("#btnsim").on("click", function () {
            let id = $(this).attr("data-id");
            $.ajax({
                url: "/ordensProducao/remover/" + id,
                method: "GET",
                success: function () {
                    window.location.href = "/ordensProducao";
                }
            });
        });
    }

})();
