$(() => {
    $('#shoppingCartB').on('click', () => {
        $('#shoppingCartBody').toggle();
        if ($('#shoppingCartBody').css('display') == 'none') {
            $('body').css('overflow', 'auto');
        } else {
            $('body').css('overflow', 'hidden');

            $('.activeMenuItem').removeClass('activeMenuItem');
            $('#shoppingCartB').addClass('activeMenuItem');

            let json = localStorage.getItem('shoppingCart');
            json = JSON.parse(json);
            let sum = 0;

            $('#shoppingCart > #products').html('');
            for (let p of json.products) {
                const { img, name, amount, price } = p;
                $('#shoppingCart > #products').append(`
                <div class="product">
                    <img loading="lazy" src="${img}">
                    <div class="textBox">
                        <h3 class="productName" title="${name}">${name}</h5>
                        <div>
                            <p class="amount">${amount}x</p>
                            <p class="priceP">${p.price}</p>
                        </div>
                    </div>
                    <div class="borderBTW"></div>
                    <div class="modificationBox">
                        <div>
                            <button class="minusB">-</button>
                            <p class="productNumberP">${amount}</p>
                            <button class="plusB">+</button>
                        </div>
                        <img loading="lazy" class="deleteB" src="../img/trash-solid.svg">
                    </div>
                </div>
                `);

                sum += amount * parseFloat(price);
            }

            writeSum(sum);

            $('.minusB').on('click', (e) => {
                let pc = parseInt($(e.target).siblings('.productNumberP').text());
                if (pc > 1) {
                    let p = $(e.target).parents('.product');
                    pc = calcAmount(p, -1);

                    $(e.target).siblings('.productNumberP').text(pc);
                    $(p).find('.amount').text(pc + 'x')
                    calcSum();
                }
            });

            $('.plusB').on('click', (e) => {
                let pc = parseInt($(e.target).siblings('.productNumberP').text());
                if (pc < 100) {
                    let p = $(e.target).parents('.product');
                    pc = calcAmount(p, 1);

                    $(e.target).siblings('.productNumberP').text(pc);
                    $(p).find('.amount').text(pc + 'x')
                    calcSum();
                }
            });

            $('.deleteB').on('click', (e) => {
                let p = $(e.target).parents('.product');
                let name = $(p).find('.productName').text();
                let json = localStorage.getItem('shoppingCart');
                json = JSON.parse(json);

                for (let i = 0; i < json.products.length; i++) {
                    if (json.products[i].name == name) {
                        json.products.splice(i, 1);
                        localStorage.setItem('shoppingCart', JSON.stringify(json));

                        $(e.target).parents('.product').remove();
                        calcSum();
                        break;
                    }
                }
            });

            function calcSum() {
                let json = localStorage.getItem('shoppingCart');
                json = JSON.parse(json);
                sum = 0;
                for (let p of json.products) {
                    const { amount, price } = p;
                    sum += amount * parseFloat(price);
                }

                writeSum(sum);
            }

            function writeSum(sum) {
                sum = Math.round(sum * 100) / 100;
                $('#shoppingCartPrice').text(sum + '€');
            }
        }

        function calcAmount(p, x) {
            let name = $(p).find('.productName').text();
            let json = localStorage.getItem('shoppingCart');
            json = JSON.parse(json);

            for (let i = 0; i < json.products.length; i++) {
                if (json.products[i].name == name) {
                    json.products[i].amount += x;
                    localStorage.setItem('shoppingCart', JSON.stringify(json));

                    return json.products[i].amount;
                }
            }
        }
    });

    $('#shoppingCartBody').on('click', (e) => {
        var container = $('#shoppingCart');
        let db = $('.deleteB');


        console.log(!container.is(e.target));
        console.log(container.has(e.target).length === 0);
        console.log(db);
        console.log(e);
        if (!container.is(e.target) && container.has(e.target).length === 0 && e.target.className != 'deleteB') {
            $('#shoppingCartBody').hide();

            if ($('body').css('overflow') == 'hidden') {
                $('body').css('overflow', 'auto');
            } else {
                $('body').css('overflow', 'hidden');
            }
        }
    });

    $('#preferedTime').on('change', () => {
        let i = $('#preferedTime option:selected').index();

        if (i == 0) {
            $('#preferedTimePicker').remove();
            $('#orderInfo').html('Wenn sie jetzt bestellen, können Sie Ihre Bestellung um <span>14:30 Uhr</span> abholen.');
        } else if (i == 1) {
            $('#preferedTimeBox').append(`
                <input type="datetime-local" id="preferedTimePicker">
            `);

            $('#preferedTimePicker').on('change', () => {
                let dateTime = new Date($('#preferedTimePicker').val());
                let date = `${dateTime.getDate()}.${dateTime.getMonth()}.`;
                let time = `${dateTime.getHours()}:${dateTime.getMinutes() < 10 ? '0' : ''}${dateTime.getMinutes()}`;
                // $('#datePickerBox').remove();

                $('#orderInfo').html('Sie können Ihre Bestellung am <span>' + date + ' um ' + time + ' Uhr</span> abholen.');
            });

            // $('#datePickerB').on('click', () => {
            //     let dateTime = new Date($('#preferedTimePicker').val());
            //     let date = `${dateTime.getDate()}.${dateTime.getMonth()}.`;
            //     let time = dateTime.toLocaleTimeString().toLowerCase();
            //     // $('#datePickerBox').remove();

            //     $('#orderInfo').html('Sie können Ihre Bestellung am <span>' + date + ' um ' + time + ' Uhr</span> abholen.');
            // });
        }
    });

    $('.speisenProdukt button').on('click', (e) => {
        let p = $(e.target).parents('.speisenProdukt');
        let name = $(p).children('.productName').text();
        let json = localStorage.getItem('shoppingCart');
        json = JSON.parse(json);

        if (json == null) {
            json = { 'products': [] };
        }

        if (json.products.length <= 0) {
            let data = getProductData();
            data = { ...data, 'name': name, 'amount': 1 };
            pushToProducts(data);
        } else {
            for (let i = 0; i < json.products.length; i++) {
                if (json.products[i].name == name) {
                    json.products[i].amount++;
                    break;
                } else if (i >= json.products.length - 1) {
                    let data = getProductData();
                    data = { ...data, 'name': name, 'amount': 1 };
                    pushToProducts(data);
                    break;
                }
            }
        }

        function getProductData() {
            let img = $(p).find('.productImg').attr('src');
            let price = $(p).children('.productPrice').text();
            return { 'img': img, 'price': price };
        }

        function pushToProducts(p) {
            json.products.push({
                'name': p.name,
                'price': p.price,
                'amount': p.amount,
                'img': p.img
            });
        }

        localStorage.setItem('shoppingCart', JSON.stringify(json));
    });
});
