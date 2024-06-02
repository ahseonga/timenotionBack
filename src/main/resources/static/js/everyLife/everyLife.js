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

//최신순, 인기순, 조회순 게시판 정렬
document.addEventListener('DOMContentLoaded', function () {
    // select 요소를 가져옵니다.
    const sortOption = document.getElementById('sortOption');

    // select 요소에 change 이벤트 리스너를 추가합니다.
    sortOption.addEventListener('change', function () {
        // 선택된 옵션 값을 가져옵니다.
        const selectedOption = sortOption.value;
        // 선택된 옵션에 따라 콘텐츠를 정렬하는 함수를 호출합니다.
        sortContent(selectedOption);
    });

    // 콘텐츠를 정렬하는 함수를 정의합니다.
    function sortContent(option) {
        // 콘텐츠를 담고 있는 박스를 가져옵니다.
        const contentBox = document.querySelector('.everyLife-content-wrap');
        // 콘텐츠 요소들을 배열로 변환합니다.
        const contents = Array.from(contentBox.querySelectorAll('.everyLife-content-box'));

        // 배열을 정렬합니다.
        contents.sort(function (a, b) {
            // 날짜 정보를 가져와서 비교합니다.
            const aDate = new Date(a.querySelector('.everyLife-content-date').textContent);
            const bDate = new Date(b.querySelector('.everyLife-content-date').textContent);

            switch (option) {
                case 'latest':
                    return bDate - aDate; // 최신순 정렬
                case 'popularity':
                    return parseInt(b.querySelector('.everyLife-content-views').textContent) - parseInt(a.querySelector('.everyLife-content-views').textContent); // 인기순 정렬
                case 'views':
                    return parseInt(a.querySelector('.everyLife-content-views').textContent) - parseInt(b.querySelector('.everyLife-content-views').textContent); // 조회순 정렬
                default:
                    return 0;
            }
        });

        // 기존 콘텐츠를 비우고 정렬된 콘텐츠를 새로 추가합니다.
        contentBox.innerHTML = '';
        contents.forEach(function (content) {
            contentBox.appendChild(content);
        });
    }
});







