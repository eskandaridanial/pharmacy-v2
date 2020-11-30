$(document).ready(function () {

    let medicines = []

    /* retrieve medicine list */
    $.get({
        url: 'http://localhost:8080/medicine/list' ,
        success: function(response){
            medicines = response;
            populateTable(medicines);
        } ,
        error: function ($xhr) {
            if ($xhr.responseJSON.id  === 2)
                $('.error').html($xhr.responseJSON.message).css("color" , "red");
        }
    });

    /* populate data in the table */
    function populateTable(data) {
        let table = document.getElementById("tbody");

        for (let i = 0 ; i < data.length ; i++) {
            let row = `<tr>
                                    <th>${data[i].name}</th>
                                    <th>${data[i].code}</th>
                                    <th>${data[i].price} $</th>
                                    <th>${data[i].description}</th>
                                    <th>
                                        <button class="remove-btn" type="submit"><input type="hidden" name="id" value="${data[i].id}" readonly>Remove</button>
                                    </th>
                                    <th>
                                        <button class="update-btn" type="submit"><input type="hidden" name="id" value="${data[i].id}" readonly>Update</button>
                                    </th>
                                </tr>`

            table.innerHTML += row
        }
    }

    /* remove button action */
    $(document).on('click' , '.remove-btn' , function () {

        if (confirm("Are you sure you want to Remove ?")) {
            const id = $(this).find('input').attr('value');

            $.post({
                url: 'http://localhost:8080/medicine/remove' ,
                data: { id:id } ,
                success: function () {
                    location.replace('http://localhost:8080/medicine-list.html')
                } ,
                error: function ($xhr) {
                    if ($xhr.responseJSON.id  === 2)
                        $('.error').html($xhr.responseJSON.message).css("color" , "red");
                }
            });
        }
    });

    /* update button action */
    $(document).on('click' , '.update-btn' , function () {

        const id = $(this).find('input').attr('value');

        location.replace("/update-medicine.html?id=" + id);

    });
});