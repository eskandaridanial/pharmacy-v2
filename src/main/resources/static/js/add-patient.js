$(document).ready(function(){

    /* populate prescription form dynamicallty */
    $("#add_prescription").click(function () {

        let total_element = $(".added").length;

        let lastid = $(".added:last").attr("id");
        let split_id = lastid.split("_");
        let nextindex = Number(split_id[1]) + 1;


        $("#prescription").append("<div class=\"added\" id=\"added_" + nextindex + "\">\n" +
            "                    <input class=\"form\" type=\"number\" id='code' name=\"code\" placeholder=\"code\" required>\n" +
            "                    <input class=\"form\" type=\"date\" id='creationDate' name=\"creationDate\" placeholder=\"Creation Date\" required>\n" +
            "                    <input class=\"form\" type=\"date\" id='visitDate' name=\"visitDate\" placeholder=\"Visit Date\" required>\n" +
            "                    <button class=\"remove\" id=\"remove_" + nextindex + "\" type=\"button\">-</button>\n" +
            "                </div>")
    });

    /* remove appended prescription form */
    $("#prescription").on('click' , '.remove' , function () {
        let id = this.id;
        let split_id = id.split("_");
        let deleteindex = split_id[1];

        $("#added_" + deleteindex).remove()
    });

    /* action for sub btn */
    $('#sub-btn').click(function (){

        let code = [];
        let creationDate = [];
        let visitDate = [];
        /*let prescriptionDetailsList = []*/

        /* retrieve patient data */
        const firstName = $('#firstName').val();
        const lastName = $('#lastName').val();
        const gender = $("input[name='gender']:checked").val();

        $('.added').each(function () {
            const code_val = $(this).find("input[name='code']").val();
            const creationDate_val = $(this).find("input[name='creationDate']").val();
            const visitDate_val = $(this).find("input[name='visitDate']").val();

            /*let prescription = {
                code: code_val ,
                creationDate: creationDate_val ,
                visitDate: visitDate_val
            }
            prescriptionDetailsList.push(prescription)*/
            code.push(code_val);
            creationDate.push(creationDate_val);
            visitDate.push(visitDate_val);
        });

        $.post({
            url: 'http://localhost:8080/patient/add' ,
            data: {
                firstName: firstName ,
                lastName: lastName ,
                gender: gender ,
                code: JSON.stringify(code) ,
                creationDate: JSON.stringify(creationDate) ,
                visitDate: JSON.stringify(visitDate)
            } ,
            success: function () {
                $('.error').append(`<h5>Patient Added Successfully</h5>`).css("color" , " green").delay(2000).fadeOut();
            } ,
            error: function () {
                $('.error').append(`<h5>Something Went Wrong</h5>`).css("color" , " red").delay(2000).fadeOut();
            }
        });

        /*$.ajax({
            async: true ,
            type: 'POST' ,
            dataType: 'JSON' ,
            contentType: 'application/json; charset=utf-8' ,
            url: 'http://localhost:8080/patient/add' ,
            data: JSON.stringify(prescriptionDetailsList) ,
            success: function () {
                alert("succeed")
            } ,
            error: function(){
                alert("error")
            }
        })*/
    });
});