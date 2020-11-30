$(document).ready(function () {

     /* parse url id */
     const urlParams = new URLSearchParams(window.location.search);
     const id = urlParams.get('id');

     let code;

     /* find medicine */
     $.get({
        url: 'http://localhost:8080/medicine/find/' + id ,
        data: { id:id } ,
        success: function (response) {
            $('.update-medicine-container').append(`<input class="form" type="text" value="${response.name}" id="name" name="name" minlength="4" maxlength="16"><br>
                                                  <input class="form" type="number" value="${response.code}" id="code" name="code" minlength="5" maxlength="5" readonly><br>
                                                  <input class="form" type="number" value="${response.price}" id="price" name="price" minlength="0" maxlength="10"><br>
                                                  <textarea class="form" id="description">${response.description}</textarea><br>
                                                  <button class="form-btn" type="submit" id="sub-btn">Update</button>
                                                  <button class="form-btn" type="submit" id="back-btn">Back</button>`);
            code = response.code;
        } ,
        error: function ($xhr) {
            if ($xhr.responseJSON.id  === 2)
                $('.error').html($xhr.responseJSON.message).css("color" , "red");
        }
     });


     /* update medicine action */
    $(document).on('click' , '#sub-btn' , function () {

        /* get form values */
        const name = $('#name').val()
        const code = $('#code').val()
        const price = $('#price').val()
        const description = $('#description').val()


            /* update query */
            $.post({
               url: 'http://localhost:8080/medicine/update/' + id ,
                data: {
                    name:name ,
                    code:code ,
                    price:price ,
                    description:description
                } ,
                success: function () {
                   location.replace("http://localhost:8080/medicine-list.html")
                } ,
                error: function ($xhr) {
                    if ($xhr.responseJSON.id  === 2)
                        $('.error').html($xhr.responseJSON.message).css("color" , "red");
                }
            });
    })
});