// ---- 좋아요 하트 구현 ---- //

const heartImage = document.getElementById('heart-image');
console.log("1");

heartImage.addEventListener('click', changeHeartColor);
let checkFollow = true;

function changeHeartColor() {

    if (heartImage.classList.contains('red')) {
        //언팔로우시
      console.log("4");
        heartImage.classList.remove('red');
        checkFollow = false;
    } else {
        // 팔로우 시
        heartImage.classList.add('red');
        checkFollow = true;
    }
    sendFollowStatus(checkFollow);
}