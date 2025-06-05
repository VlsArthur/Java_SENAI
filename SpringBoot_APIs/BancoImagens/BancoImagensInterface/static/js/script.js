/*
<figure class="figure">
  <img src="..." class="figure-img img-fluid rounded" alt="...">
  <figcaption class="figure-caption">A caption for the above image.</figcaption>
</figure>
*/

fetch('http://localhost:8080/api/imagens', {
    method: 'GET',
    headers: { 'Content-Type': 'application/json' }
})
.then(response => response.json())
.then(data => {
    appendFigure(data);
})
.catch(error => {
    console.log(error);
});

function appendFigure(data) {
    data.forEach(element => {
        const figure = document.createElement('figure');
        figure.className = 'figure';
        figure.style.display = 'block';
        figure.style.margin = '0 auto';
        figure.style.width = 'fit-content';
        figure.style.marginTop = '2%'
        figure.innerHTML = `
            <img src="${element.url}" class="figure-img img-fluid rounded" alt="...">
            <figcaption style="margin-bottom: 0.5%; font-size: 18px" class="figure-caption">
                <span>${element.id}</span>
                <span> | </span>
                <span>${element.nome}</span> 
            </figcaption>
            <button type="button" class="btn btn-secondary" onclick="edit(this)">Edit</button>
            <button type="button" class="btn btn-danger" onclick="deleteImg(this)">Delete</button>
        `;
        document.getElementById('figureContainer').appendChild(figure);
    })
}

function save() {
    event.preventDefault();
    const name = document.getElementById('name').value;
    const url = document.getElementById('url').value;
    if (name && url) {
        document.getElementById('name').value = "";
        document.getElementById('url').value = "";
        fetch('http://localhost:8080/api/imagens', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json'},
            body: JSON.stringify({"nome":name, "url": url})
        })
        .then(response => response.json())
        .then(data => {
            console.log(data);
            this.appendFigure([{"id":data.id,"nome":data.nome,"url":data.url}])
        })
        .catch(error => {
            console.log(error);
        })

        Swal.fire ({
            icon: 'success',
            title: 'sucesso',
            text: 'Imagem cadastrada com sucesso'
        })
        
    }
}

function deleteImg(button) {
    Swal.fire ({
        icon: 'question',
        title: 'Are you sure?',
        showCancelButton: true,
        confirmButtonText: 'Yes',
        cancelbuttonText: 'no'
    }).then(result => {
        if (result.isConfirmed) {
            const figToBeRemoved = button.closest('figure');
            figToBeRemoved.remove();
            Swal.fire('Confirmed!', '', 'success');
            const url = "http://localhost:8080/api/imagens/" + figToBeRemoved.querySelector('span').textContent;
            fetch(url, {
                method: 'DELETE',
                headers: { 'Content-Type': 'application/json'}
            })
            .then(response => {
                if (response.ok) {
                    console.log(response);
                }
            })
            .catch(error => {
                console.log(error);
            })
        }
    })
}

function edit(button) {
    Swal.fire({
        title: 'Edit Image',
        html: `
            <form id="editForm" class="bg-white shadow-md rounded p-4">
                <div class="mb-3">
                    <label for="newName" class="form-label">Author's name</label>
                    <input type="text" class="form-control" id="newName" placeholder="Name" required>
                </div>
                <div class="mb-3">
                    <label for="newUrl" class="form-label">Image URL</label>
                    <input type="url" class="form-control" id="newUrl" placeholder="URL" required>
                </div>
            </form>
        `,
        showCancelButton: true,
        confirmButtonText: 'Save',
        cancelbuttonText: 'Cancel',
        didOpen: () => {
            const data = button.closest('figure').querySelectorAll('span');
            document.getElementById('newName').value = data[2].textContent;
            document.getElementById('newUrl').value = button.closest('figure').querySelector('img').src;
        },
        preConfirm: () => {
            if (!document.getElementById('editForm').checkValidity()) {
                document.getElementById('editForm').reportValidity();
                return false;
            }
            const newName = document.getElementById('newName').value;
            const newUrl = document.getElementById('newUrl').value;
            if (newName && newUrl) {
                const fetchUrl = "http://localhost:8080/api/imagens/" + button.closest('figure').querySelector('span').textContent;
                fetch(fetchUrl, {
                    method: 'PUT',
                    headers: { 'Content-Type': 'application/json'},
                    body: JSON.stringify({"nome":newName, "url":newUrl})
                })
                .then(response => response.json())
                .then(data => {
                    console.log(data);
                    button.closest('figure').querySelectorAll('span')[2].textContent = data.nome;
                    button.closest('figure').querySelector('img').src = data.url;
                })
                .catch(error => {
                    console.log(error);
                });
                Swal.fire({
                    icon: 'success',
                    title: 'Success!',
                    text: 'Image successful edited'
                });
            }
        }
    })
}

