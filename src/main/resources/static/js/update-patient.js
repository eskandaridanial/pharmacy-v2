$(document).ready(function () {

    /* parse url id */
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');
    const pid = id;


    /* find patient */
    $.get({
        url: 'http://localhost:8080/patient/find/' + id ,
        data: { id:id } ,
        success: function (response) {
            populateTable(response.prescriptions);
            $('.add-patient-container').append(`<label for="firstname">First Name</label> <input class="form" id="firstname" type="text" value="${response.firstName}" readonly><br>
                <label for="lastname">Last Name</label> <input class="form" type="text" id="lastname" value="${response.lastName}" readonly><br>
                <hr>`);
        } ,
        error: function ($xhr) {
            if ($xhr.responseJSON.id  === 2)
                $('.error').html($xhr.responseJSON.message).css("color" , "red");
        }
    });

    /* populate data in the table */
    function populateTable(data) {
        let table = document.getElementById("tbody");

        for (let i = 0; i < data.length; i++) {
            let row = `<tr>
                                    <th>${data[i].code}</th>
                                    <th>${data[i].creationDate}</th>
                                    <th>${data[i].visitDate}</th>
                                    <th>
                                        <button class="remove-btn" type="submit"><input type="hidden" name="id" value="${data[i].id}" readonly>Remove</button>
                                    </th>
                                </tr>`

            table.innerHTML += row;
        }
    }

    /* remove button action */
    $(document).on('click' , '.remove-btn' , function () {

        if (confirm("Are you sure you want to Remove ?")) {
            const id = $(this).find('input').attr('value');

            $.post({
                url: 'http://localhost:8080/patient/remove/prescription' ,
                data: { id:id } ,
                success: function () {
                    location.replace('http://localhost:8080/patient-list.html')
                } ,
                error: function ($xhr) {
                    if ($xhr.responseJSON.id  === 2)
                        $('.error').html($xhr.responseJSON.message).css("color" , "red");
                }
            });
        }
    });
});