function fileLoadChange(item) {
    if (item.files.length > 0)
        $('#buttonProcess').removeAttr('disabled');
    else
        $('#buttonProcess').attr('disabled', 'disabled');
}

function process() {
    var formData = new FormData();
    formData.append('loadFile', $('#loadFile')[0].files[0]);
    console.log("form data " + formData);
    $.ajax({
        url : 'formProcess',
        data : formData,
        processData : false,
        contentType : false,
        type : 'POST',
        success : function(data) {
            if (data != undefined) {
                $('#inputWalkResult').val(data.walkResult);
                fillTableFile(data.array);
            } else {
                processErrorStatus();
            }
        },
        error : function(err) {
            processErrorStatus();
        }
    });
}

function fillTableFile(walkField) {
    var tableHtml = '';
    for (i=0 ; i < walkField.length ; i++) {
        tableHtml += '<tr>';
        for (j=0 ; j < walkField[i].length ; j++) {
            tableHtml += '<td>' + walkField[i][j] + '</td>';
        }
        tableHtml += '</tr>';
    }

    $('#tableFile tbody').html(tableHtml);
}

function processErrorStatus() {
    $('#inputWalkResult').val("Failed to proceed!");
    $('#tableFile tbody').html('');
}