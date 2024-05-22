// 이미지 파일 스크립트 추가 //
$("#file").on('change', function() {
    var fileName = $("#file").val();
    $(".upload-name").val(fileName);
});