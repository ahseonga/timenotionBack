//rgb 재정의
function rgb(r, g, b) {
  return `rgb(${Math.round(r)}, ${Math.round(g)}, ${Math.round(b)})`;
}


//변수 생성 
const findInput = document.getElementById('find-input');
const findResult = document.getElementById('find-result');
//저장 버튼 
const findButton = document.getElementsByClassName("find-button")[0];
console.log(findButton);
// 변수생성
let findCount = 0 ;

//패스워드박스 focus blur 처리 
findInput.addEventListener('focus', findInputFocusFunction);
findInput.addEventListener('blur',findInputBlurFunction);
findInput.addEventListener('keydown',findInputKeydownFunction);

function findInputFocusFunction(){
  console.log("1");
  if(findCount ===0 ){
    console.log("1");
    findInput.style.outline = "none";
    findInput.style.borderWidth = "3px";
    findInput.style.borderColor = '#B2E8F7';
    findInput.style.opacity = 0.7;
  }else{
    findInput.style.outline = "none";
    findInput.style.borderWidth = "3px";
    findInput.style.borderColor = "#FEB7B1";
    findInput.style.borderWidth = "3px";
  }
  if(this.value !== ''){
    findInput.style.outline = "none";
    findInput.style.opacity = 0.7;
    findInput.style.borderWidth = "3px";
    findInput.style.borderColor = '#B2E8F7';
  }
  findCount++;
};
function findInputBlurFunction(){
 
  findResult.innerText = "필수 입력 항목입니다.";
  findResult.style.color = rgb(255, 119, 119);
  findResult.style.fontSize = "12px";
  findInput.style.borderColor =  rgb(255, 119, 119);
  findInput.style.borderWidth = "1px";
  findInput.style.marginBottom = "5px";
  // editNicknameParagraph.style.color =  rgb(255, 119, 119);
  if(this.value !== ''){
    findInput.style.opacity = 0.7;
    findInput.style.borderWidth = "1px";
    findInput.style.borderColor = 'gray';
    // editNicknameParagraph.style.color =  'black';
    findResult.innerText = " ";

  }

};

function findInputKeydownFunction(){
  findInput.style.outline = "none";
  findInput.style.opacity = 0.7;
  findInput.style.borderWidth = "3px";
  findInput.style.borderColor = '#B2E8F7';
  findResult.innerText = "";
  // editNicknameParagraph.style.color =  'black';
}


// for (let i = 0; i < editSaveButton.length; i++) {
  findButton.addEventListener('click',findButtonClickFunction);
// }

function findButtonClickFunction(){
 //비밀번호 
 if(findInput.value === ''){
  findResult.innerText = "필수 입력 항목입니다.";
  findResult.style.color = rgb(255, 119, 119);
  findResult.style.fontSize = "12px";
  findInput.style.borderColor =  rgb(255, 119, 119);
  findInput.style.borderWidth = "1px";
  findInput.style.marginBottom = "5px";
  // editNicknameParagraph.style.color =  rgb(255, 119, 119);
}
}
