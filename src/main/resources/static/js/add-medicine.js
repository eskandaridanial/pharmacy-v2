$(document).ready(function () {

    $("#back-btn").click(function () {
        location.replace("https://localhost:8080/")
    });

    /* action on login button */
    $("#sub-btn").click(function () {

        /* get form values */
        const name = $('#name').val()
        const code = $('#code').val()
        const price = $('#price').val()
        const description = $('#description').val()

        /* apply validation on form data */
        if (name == null || code == null || price == null || description == null || code.length !== 5 || code <= 0 || price <= 0)
            location.replace("/add-medicine.html");
        else {
            /* ajax query */
            $.post({
                url: 'http://localhost:8080/medicine/add',
                data: {
                    name: name ,
                    code: code ,
                    price: price ,
                    description: description
                } ,
                success: function(){
                    $('.success').append(`<h5>Medicine Added Successfully</h5>`).css("color" , " green").delay(2000).fadeOut();
                } ,
                error: function($xhr) {
                    if ($xhr.responseJSON.id  === 1)
                        $('.error').append($xhr.responseJSON.message).css("color" , " red").delay(2000).fadeOut();
                }
            });
        }
    });
});