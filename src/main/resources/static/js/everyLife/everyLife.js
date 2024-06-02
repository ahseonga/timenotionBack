//검색창 기능 구현 //
function filterContent() {
    const keyword = document.querySelector('input[name="searchKeyword"]').value.toLowerCase();
    const contents = document.querySelectorAll('.everyLife-content-box');

    contents.forEach(content => {
        const title = content.querySelector('.everyLife-content-title').innerText.toLowerCase();
        const detail = content.querySelector('.everyLife-content-detail').innerText.toLowerCase();
        const nickname = content.querySelector('.everyLife-writer-nickname').innerText.toLowerCase();

        if (title.includes(keyword) || detail.includes(keyword) || nickname.includes(keyword)) {
            content.style.display = "";
        } else {
            content.style.display = "none";
        }
    });
}

// 최신순, 인기순 , 조회순 페이징 변경 //
document.addEventListener('DOMContentLoaded', (event) => {
    const sortSelect = document.getElementById('sortOption');
    sortSelect.addEventListener('change', function() {
        document.getElementById('sortForm').submit();
    });
});







