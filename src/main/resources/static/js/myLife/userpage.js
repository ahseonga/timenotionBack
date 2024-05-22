// ---- 좋아요 하트 구현 ---- //

const heartImage = document.getElementById('heart-image');
console.log("1");

heartImage.addEventListener('click', changeHeartColor);

function changeHeartColor() {
    if (heartImage.classList.contains('red')) {
      console.log("4");
        heartImage.classList.remove('red');
    } else {
        heartImage.classList.add('red');
    }
}