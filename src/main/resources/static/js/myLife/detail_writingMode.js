// 이미지 파일 스크립트 추가 //
// $("#file").on('change', function() {
//     var fileName = $("#file").val();
//     $(".upload-name").val(fileName);
// });
document.getElementById('file').addEventListener('change', function(event) {
    const fileInput = event.target;
    const fileNamesDiv = document.getElementById('file-names');
    fileNamesDiv.innerHTML = '';

    const files = fileInput.files;
    if (files.length > 0) {
        const fileList = document.createElement('ul');
        for (let i = 0; i < files.length; i++) {
            const listItem = document.createElement('li');
            listItem.textContent = files[i].name;
            fileList.appendChild(listItem);
        }
        fileNamesDiv.appendChild(fileList);
    } else {
        fileNamesDiv.textContent = '';
    }
});