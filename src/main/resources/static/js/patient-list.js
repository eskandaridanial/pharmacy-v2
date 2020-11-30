$(document).ready(function () {

    let patients = []

    /* retrieve patient list */
    $.get({
        url: 'http://localhost:8080/patient/list' ,
        success: function(response){
            patients = response;
            populateTable(patients);
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
                                    <th>${data[i].firstName}</th>
                                    <th>${data[i].lastName}</th>
                                    <th>${data[i].gender}</th>
                                    <th>
                                        <button class="remove-btn" type="submit"><input type="hidden" name="id" value="${data[i].id}" readonly>Remove</button>
                                    </th>
                                    <th>
                                        <button class="update-btn" type="submit"><input type="hidden" name="id" value="${data[i].id}" readonly>Update</button>
                                    </th>
                                    <th>
                                        <button class="info-btn" type="submit"><input type="hidden" name="id" value="${data[i].id}" readonly>Information</button>
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
                url: 'http://localhost:8080/patient/remove' ,
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

    /* update button action */
    $(document).on('click' , '.update-btn' , function () {

        const id = $(this).find('input').attr('value');

        location.replace("/update-patient.html?id=" + id);

    });

    /* information button action */
    $(document).on('click' , '.info-btn' , function () {

        const id = $(this).find('input').attr('value');

        location.replace("/patient-info.html?id=" + id);

    });
});