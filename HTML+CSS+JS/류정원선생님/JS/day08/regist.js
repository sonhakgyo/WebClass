const sendit = function () {
    // alert('sendit() 호출!');
    const userid = document.getElementById('userid');
    const userpw = document.getElementById('userpw');
    const userpw_re = document.getElementById('userpw_re');
    const name = document.getElementById('name');
    const hp = document.getElementById('hp');
    const email = document.getElementById('email');
    const hobby = document.getElementsByName('hobby'); // 일반 변수가 아닌 배열
    const isssn = document.getElementById('isssn');

    /* '정규식' 혹은 '정규 표현식' 혹은 '정규식 패턴' */
    /* 이름 */
    // [] 안은 범위이고, / /; 안에 입력해준다.
    // 한글의 시작 글자는 '가'이고, 마지막 글자는 '힣'이다. = '가'부터 '힣'까지
    const expNameText = /[가-힣]+$/;

    /* 휴대폰 번호 */
    // '^\d{3}'에서 
    // '^(지수 표시)'은 '\d{3}로 시작하라'는 의미이다.
    // '\d'는 d = 'decimal(정수)만 들어갈 수 있다'는 의미이다.
    // '{3}'은 '세자리(3)만 들어갈 수 있다'는 의미이다.
    // 그리고 '-'이 꼭 들어가야 한다는 의미이다.
    const expHpText = /^\d{3}-\d{3,4}-\d{4}$/;

    /* 이메일 apple1011@gmail.com */
    // ① /^[A-Za-z0-9\.\-]+, ② @[A-Za-z0-9\.\-]+, ③ \.[A-Za-z0-9\.\-]+$/;
    const expEmailText = /^[A-Za-z0-9\.\-]+@[A-Za-z0-9\.\-]+\.[A-Za-z0-9\.\-]+$/;


    /* 아이디를 입력하지 않았다면 */
    if (userid.value == '') {
        alert('아이디를 입력하세요');
        userid.focus();
        return false;
    }

    /* 아이디는 4자 이상 20자 이하 */
    if (userid.value.length < 4 || userid.value.length > 20) {
        alert('아이디를 4자이상 20자 이하로 입력하세요');
        userid.focus();
        return false;
    }

    /* 비밀번호를 입력하지 않았을 때 */
    if (userpw.value == '') {
        alert('비밀번호를 입력하세요');
        userpw.focus();
        return false;
    }

    /* 비밀번호는 4자 이상 20자 이하 */
    if (userpw.value.length < 4 || userpw.value.length > 20) {
        alert('비밀번호를 4자이상 20자 이하로 입력하세요');
        userpw.focus();
        return false;
    }

    /* 비밀번호 창과 비밀번호 확인 창이 다르다면 */
    if (userpw.value != userpw_re.value) {
        alert('비밀번호와 비밀번호 확인의 값이 서로 다릅니다');
        userpw_re.focus();
        return false;
    }

    /* expNameText는 정규 표현식 이름을 담은 변수이다. */
    /* test() 함수 */
    /* 정규식에 대입한 문자열이 부합하면 true 아니면 false를 반환한다. */
    /* 정규식객체.test('비교할 문자열') -> true or false */
    if (!expNameText.test(name.value)) { // 이름
        alert('이름 형식을 확인하세요\n한글만 입력 가능합니다'); 
        name.focus();
        return false;
    }
    if (!expHpText.test(hp.value)) { // 휴대폰번호
        alert('휴대폰번호 형식을 확인하세요');
        hp.focus();
        return false;
    }
    if (!expEmailText.test(email.value)) { // 이메일
        alert('이메일 형식을 확인하세요');
        email.focus();
        return false;
    }

    /* 취미가 체크가 되었는가 */ 
    let count = 0;
    for (let i in hobby) {
        if (hobby[i].checked) {
            count++;
        }
    }

    if (count == 0) {
        alert('취미는 적어도 1개 이상 선택하세요');
        return false;
    }

    if (isssn.value == 'n') {
        alert('주민등록번호 검증버튼을 눌러주세요');
        return false;
    }

    return true;
}

const moveFocus = function () {
    const ssn1 = document.getElementById('ssn1');
    if (ssn1.value.length >= 6) {
        document.getElementById('ssn2').focus();
    }
}

const ssnCheck = function () {
    const ssn1 = document.getElementById('ssn1');
    const ssn2 = document.getElementById('ssn2');
    const isssn = document.getElementById('isssn');

    if (ssn1.value == "" || ssn2.value == "") {
        alert('주민등록번호를 입력하세요');
        ssn1.focus();
        return false;
    }

    // 001011 3068518
    const ssn = ssn1.value + ssn2.value;
    const s1 = Number(ssn.substr(0, 1)) * 2;
    const s2 = Number(ssn.substr(1, 1)) * 3;
    const s3 = Number(ssn.substr(2, 1)) * 4;
    const s4 = Number(ssn.substr(3, 1)) * 5;
    const s5 = Number(ssn.substr(4, 1)) * 6;
    const s6 = Number(ssn.substr(5, 1)) * 7;
    const s7 = Number(ssn.substr(6, 1)) * 8;
    const s8 = Number(ssn.substr(7, 1)) * 9;
    const s9 = Number(ssn.substr(8, 1)) * 2;
    const s10 = Number(ssn.substr(9, 1)) * 3;
    const s11 = Number(ssn.substr(10, 1)) * 4;
    const s12 = Number(ssn.substr(11, 1)) * 5;
    const s13 = Number(ssn.substr(12, 1));

    let result = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11 + s12;
    result = result % 11;
    result = 11 - result;
    if (result >= 10) result = result % 10;

    if (result == s13) {
        alert('유효한 주민등록번호입니다');
        isssn.value = 'y';

    } else {
        alert('유효하지 않은 주민등록번호입니다');
    }
}