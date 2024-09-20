let rows = document.querySelectorAll(".row");

for (let i = 0; i < rows.length; i++) {
    let cells = rows[i].querySelectorAll(".clickable_cell");
    let id = rows[i].querySelector(".row_id").textContent;

    for (let i = 0; i < cells.length; i++) {
        cells[i].addEventListener("click", () => prevent_default_click())
        cells[i].addEventListener('dblclick', () => show_store_info(id));
    }
}

function show_store_info(id) {
    document.location.replace(`http://localhost:8000/store?id=${id}`);
}

function prevent_default_click() {
    event.preventDefault();
}