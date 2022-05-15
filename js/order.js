let json = localStorage.getItem('shoppingCart');
json = JSON.parse(json);
let sum = 0;

$('#shoppingCart > #products').html('');
for (let p of json.products) {
    const { img, name, amount, price } = p;
    $('#shoppingCart > #products').append(`
    <div class="product">
        <img src="${img}">
        <div class="textBox">
            <h3 class="productName" title="${name}">${name}</h5>
            <div>
            <p>${amount}x</p>
            <p class="priceP">${p.price}€</p>
            </div>
        </div>
        <div class="borderBTW"></div>
        <div class="modificationBox">
            <div>
                <button class="minusB">-</button>
                <p class="productNumberP">${amount}</p>
                <button class="plusB">+</button>
            </div>
            <img class="deleteB" src="../img/trash-solid.svg">
        </div>
    </div>
    `);

    sum += amount * parseInt(price);
}