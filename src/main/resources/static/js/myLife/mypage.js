const infancy = document.querySelector('#infancy');
const babyhood = document.querySelector('#babyhood');
const childhood = document.querySelector('#childhood');
const adolescence = document.querySelector('#adolescence');
const adult = document.querySelector('#adult');
const middleAge = document.querySelector('#middle-age');
const oldAge = document.querySelector('#old-age');



async function sendDataToServer(cycle) {
    try {
        const response = await fetch("/myLife", {
            method: "POST", // POST 메소드를 사용합니다.
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ cycle: cycle })

        });
        console.log(cycle);
        if (!response.ok) {
            throw new Error("cycle 전송 실패");
        }

        console.log("cycle 전송 성공");
    } catch (error) {
        console.error(error.message);
    }
}

infancy.addEventListener('click', () => {
    sendDataToServer("유아기");
});

babyhood.addEventListener('click', () => {
    sendDataToServer("유년기");
});

childhood.addEventListener('click', () => {
    sendDataToServer("아동기");
});

adolescence.addEventListener('click', () => {
    sendDataToServer("청소년기");
});

adult.addEventListener('click', () => {
    sendDataToServer("성인기");
});

middleAge.addEventListener('click', () => {
    sendDataToServer("중년기");
});

oldAge.addEventListener('click', () => {
    sendDataToServer("노년기");
});
