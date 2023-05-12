
document.querySelectorAll("#formExcluir").forEach(form => {
    form.addEventListener("submit", function(event) {
        event.preventDefault(); // Impede o envio do formulário padrão

        if (confirm("Tem certeza de que deseja excluir o jogo?")) {
            const url = this.getAttribute("action"); // Obtém a URL do formulário
            const formData = new FormData(this);

            fetch(url, {
                method: "DELETE",
                body: formData
            })
            .then(response => {
                if (response.ok) {
                    location.reload(); // Atualiza a página após a exclusão bem-sucedida
                } else {
                    throw new Error("Erro ao excluir o jogo.");
                }
            })
            .catch(error => {
                console.error(error);
                alert("Erro ao excluir o jogo. Por favor, tente novamente.");
            });
        }
    });
});
