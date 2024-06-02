import * as reply from "./module.js";
let page = 1;
let hasNext = true;
/* boardId
 <input type="hidden" id="boardId" th:value="${boards.boardId}"> 이런식으로 아무데나 갖다놔야함 */
let boardId = document.querySelector('#boardId').value;

// ♡♡ 댓글 목록 감싸는 div
let $replyListWrap = document.querySelector('.wrapper-reply');
/* 1. 댓글 목록 클릭, 댓글 상태 바꾸기 -----------------
*  추후 작성 -- -- --     */

/* 2. 댓글 등록 ----------------------------------------*/
{
    //  댓글 작성 완료 버튼 //
    let $btnWriteReply = document.querySelector('.box-btn-reply-btn');
    /* 2-1. */
    $btnWriteReply?.addEventListener('click', function (){
        /* 1 ) 입력할 댓글 내용 가져옴 */
        // 입력한 댓글 내용(컨텐츠) //
        let content = document.querySelector('#comment-content').value;
        if(!content){alert("댓글 입력"); return;}
        // ♡♡  댓글 아이디, 컨텐츠 정보 담는 변수 선언
        /* 여기 이름이 내 DTO의 필드명이랑 일치해야함 */
        let replyInfo = { boardId: boardId, commentContent: content }; // content 변수를 사용하여 수정

        /* 2 ) 댓글 등록 함수 호출
            댓 입력창 초기화 / 페이지 초기화 / 댓 리스트 뿌려줌
            function getList2(boardId, page, callback)호출 -> boardId, page 넣어줌
            - 특정 게시물의 댓글목록을 page 단위로 가져옴
            - 서버에 Get 요청 -> JSON형식으로 파싱
            - 파싱된 데이터를 콜백함수에 전달  */
        reply.register(replyInfo, () => {
            document.querySelector('#comment-content').value = '';
            console.log("ㅎㅎ 여기까진 오냐?");
            page = 1;
            reply.getList2(boardId, page, function (data){
                hasNext = data.hasNext;
                displayComment(data.contentList);
            });
        });
    });

    /*2-2. */
    reply.getList2(boardId, page, function (data){
        hasNext = data.hasNext;
        displayComment(data.contentList);
    });

    /*2-3.*/
    window.addEventListener('scroll', function (){
        if(!hasNext)return;
        // ♡♡  documentElement 객체에서 3개의 프로퍼티를 동시에 가져온다.
        let {scrollTop, scrollHeight, clientHeight} = document.documentElement;
        console.log("scrollTop(스크롤 상단의 현재 위치) : ", scrollTop);
        console.log("scrollHeight(전체 문서의 높이) : ", scrollHeight);
        console.log("clientHeight(클라이언트[웹브라우저]의 화면 높이) : ", clientHeight);
        if(clientHeight + scrollTop >= scrollHeight - 5){
            console.log("바닥~~!!");
            page++;
            /* 여기 찾아봐야함 ☆☆☆☆☆☆ */
            reply.getList2(boardId, page, function (data){
                hasNext = data.hasNext;
                appendReply(data.contentList);
            });
        }
    });

} // 2.close

/* 3. 기존 댓글 지우고 새로운 댓글 목록 씌우는 함수
   innserHTML : 기존 내용 유지 x, 새롭게 덮어 씌임 */
function displayComment(commentList){
    let $commentWrap = document.querySelector('.wrapper-reply');
    let tags = '';
    commentList.forEach(r => {
        tags +=  `
             <div class="reply" data-id="${r.replyId}">
            <div class="reply-box">
            <div class="reply-box__writer">${r.loginId}</div>
        <div class="reply-box__content">${r.content}</div>
    </div>

        <div class="reply-time">
            ${reply.timeForToday(r.modifiedDate)}
        </div>

        <div class="reply-btn-box">
            <span class="reply-btns"></span>
            <div class="reply-btns__box none">
                <div class="reply-remove-btn">삭제</div>
                <div class="reply-modify-btn">수정</div>
            </div>
        </div>
    </div>
        `;
    }); // 댓글목록 순회
    $commentWrap.innerHTML = tags;
} // 3.close

/* 4. 기존 댓글목록 유지하고 새로운 댓글 추가하는 함수
   insertAdjacentHTML : 새로운 html 내용을 기존 내용 뒤에 삽입 */
function appendReply(commentList){
    let $commentWrap = document.querySelector('.wrapper-reply');
    let tags = '';

    commentList.forEach(r => {
        tags += `
             <div class="reply" data-id="${r.replyId}">
            <div class="reply-box">
            <div class="reply-box__writer">${r.loginId}</div>
        <div class="reply-box__content">${r.content}</div>
    </div>

        <div class="reply-time">
            ${reply.timeForToday(r.modifiedDate)}
        </div>

        <div class="reply-btn-box">
            <span class="reply-btns"></span>
            <div class="reply-btns__box none">
                <div class="reply-remove-btn">삭제</div>
                <div class="reply-modify-btn">수정</div>
            </div>
        </div>
    </div>
        `;
    }); // 댓글 목록 순회
    $commentWrap.insertAdjacentHTML("beforeend", tags);
} // 4.close



























