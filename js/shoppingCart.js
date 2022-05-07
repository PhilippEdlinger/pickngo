$(() => {
    $('#theButton').on('click', () => {
        $('#shoppingCartBody').toggle();
    });

    $('#shoppingCartBody').on('click', (e) => {
        var container = $('#shoppingCart');

        if (!container.is(e.target) && container.has(e.target).length === 0) 
        {
            $('#shoppingCartBody').hide();
        }        
    });

    $('.minusB').on('click', (event) => {
        let pc = parseInt($(event.target).siblings('.productNumberP').text());
        if (pc > 1) {
            pc--;
        }
        $(event.target).siblings('.productNumberP').text(pc);
    });

    $('.plusB').on('click', (event) => {
        let pc = parseInt($(event.target).siblings('.productNumberP').text());
        if (pc < 100) {
            pc++;
        }
        $(event.target).siblings('.productNumberP').text(pc);
    });
    
    $('.deleteB').on('click', (event) => {
        $(event.target).parents('.product').remove();
    });

    $('#preferedTime').on('change', () => {
        let i = $('#preferedTime option:selected').index();

        if (i == 0) {
            $('#datePickerBox').remove();
            $('#orderInfo').html('Wenn sie jetzt bestellen, können Sie Ihre Bestellung um <span>14:30 Uhr</span> abholen.');
        } else if (i == 1) {
            $('#preferedTimeBox').append(`
                <div id="datePickerBox">
                    <input type="datetime-local" id="preferedTimePicker">
                    <button id="datePickerB">Bestätigen</button>
                </div>
            `);

            $('#datePickerB').on('click', () => {
                let dateTime = new Date($('#preferedTimePicker').val());
                let date = `${dateTime.getDate()}.${dateTime.getMonth()}.`;
                let time = dateTime.toLocaleTimeString().toLowerCase();
                // $('#datePickerBox').remove();

                $('#orderInfo').html('Sie können Ihre Bestellung am <span>' + date + ' um ' + time + ' Uhr</span> abholen.');
            });
        }
    });
});