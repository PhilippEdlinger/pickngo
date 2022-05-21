$(() => {
    let json = localStorage.getItem('shoppingCart');
    json = JSON.parse(json);
    let sum = 0;

    $('#orderProduct').html('');
    for (let p of json.products) {
        const { img, name, amount, price } = p;
        $('#orderProduct').append(`
        <div class="itemBox">
            <div class="imageBox">
                <img src="${img}" alt="${name}">
                <div class="textBox">
                    <p>${amount}x ${name}</p>
                    <p>${price}</p>
                </div>
            </div>
        </div>
    `);

        sum += amount * parseInt(price);
    }
    $('#orderPrice').append(`
        <h5>Gesamt</h5>
        <p id="shoppingCartPrice">${sum}€</p>
    `);
});
