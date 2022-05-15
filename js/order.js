$(() => {
    let json = localStorage.getItem('shoppingCart');
    json = JSON.parse(json);
    let sum = 0;

    //$('#productBox').html('');
    for (let p of json.products) {
        const { img, name, amount, price } = p;
        $('#productBox').append(`
        <div class="itemBox">
            <div class="imageBox">
                <img src="${img}" alt="${name}">
                <div class="textBox">
                    <p>${amount}x ${name}</p>
                    <p style="margin-left:300px;">${price}</p>
                </div>
            </div>
        </div>
    `);

        sum += amount * parseInt(price);
    }
    $('#productBox').append(`
        <div id="priceBox">
            <p>Gesamt</p>
            <p id="shoppingCartPrice">${sum}€</p>
        </div>
    `);
});
