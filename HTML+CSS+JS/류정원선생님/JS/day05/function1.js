function getPresent() {
    console.log('μ λ¬Ό π');
}

function setJumsu(jumsu) {
    console.log(`μ λ¬λ°μ μ μλ ${jumsu} μλλ€`);
}

function getTotal(start = 0, end = 0) {
    let sum = 0;
    for (let i = start; i <= end; i++) {
        sum += i;
    }
    console.log(`${start}λΆν° ${end}κΉμ§μ μ΄ν©μ ${sum}μλλ€`);
}

function setNumbers(num1, ...num2) {
    console.log(`num1μ κ° : ${num1}`);
    console.log(`num2μ κ° : ${num2}`);
}

function setMath(...math) {
    for (let i of math) {
        console.log(i);
    }
}

function getDonut() {
    return 'π©';
}