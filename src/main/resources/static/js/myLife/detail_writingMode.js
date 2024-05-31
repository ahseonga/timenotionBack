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

// 사용자의 생년을 서버로부터 받아옵니다.
const userBirthYear = [[${userBirthYear}]];

function validateForm(event) {
    // form 요소를 가져옵니다.
    const form = document.forms["boardForm"];
    const boardYear = form["boardYear"].value;

    // 사용자가 입력한 작성 년도가 생년보다 이전인 경우
    if (boardYear < userBirthYear) {
        // 오류 메시지를 표시하고
        document.getElementById("error-message").innerText = "게시물 작성 년도는 생년보다 이전일 수 없습니다.";
        // 폼 제출을 막습니다.
        event.preventDefault();
    }
}