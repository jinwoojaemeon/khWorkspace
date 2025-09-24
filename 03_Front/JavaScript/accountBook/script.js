// 전역 변수
let accList = JSON.parse(localStorage.getItem('accList'))||[];
let currentType = 'income';
let filterState = 'all'; 
// DOM 요소 
const historyList = document.getElementById('history-list');
const filterBtns = document.querySelectorAll('.filter-buttons button');
const currentCost = document.getElementById('current-cost');
const contents = document.getElementById('account-contents');
const cost = document.getElementById('account-cost');
const emptyE1 = document.createElement('div');

// 초기화 함수 
function init(){
    bindEvents();   
    render();
}

function bindEvents(){
    const resetBtn = document.querySelector('.reset-account');
    resetBtn.addEventListener('click', resetAccount);
    
    const addBtn = document.getElementById('account-add-btn');
    addBtn.addEventListener('click', addAccount);

    contents.addEventListener('keydown', function(e){
        if(e.key === 'Enter'){
            addAccount();
        }
    });
    cost.addEventListener('keydown', function(e){
        if(e.key === 'Enter'){
            addAccount();
        }
    });

    const incomeBtn = document.getElementById('income-btn');
    const expenseBtn = document.getElementById('expense-btn');
    
    incomeBtn.addEventListener('click', selectTypeIncome);
    expenseBtn.addEventListener('click', selectTypeExpense);

    //필터 버튼들을 가져와서 이벤트를 등록 
    filterBtns.forEach(function(btn){ // 필터 버튼 이벤트 등록 
        btn.addEventListener('click', function(ev){ // 버튼 클릭 이벤트 발생 시 setFilter 적용
           setFilter(ev.target.dataset.filter); 
        });
    })
}

// 데이터 조작 함수 
function addAccount(){
    if(!contents.value.trim() || !cost.value.trim()) return;
 
    // 금액이 숫자인지 확인
    const costNumber = Number(cost.value);
    if(isNaN(costNumber)) {
        alert('금액은 숫자로 입력해주세요.');
        return;
    }
    
    const account = {
        id: Date.now(),
        accContent: contents.value,  
        accCost: costNumber,     
        accType: currentType,
        createdAt: new Date().toLocaleDateString()
    }
    
    accList.push(account);
    
    // 입력값 초기화
    contents.value = '';
    cost.value = '';
    
    // 화면 업데이트
    saveAccount();
    render();
}

//내역 삭제 함수
function deleteAccount(id){
    let newAcc = [];
    for(let acc of accList){
        if(acc.id === id) continue;

        newAcc.push(acc);
    }

    accList = newAcc;
    saveAccount();
    render();
}

// 현재 타입버튼 업데이트 함수
function selectTypeIncome(){
    currentType = 'income';
    updateActiveButton();
}

function selectTypeExpense(){
    currentType = 'expense';
    updateActiveButton();
}

// 버튼 활성화 상태 업데이트
function updateActiveButton(){
    const incomeBtn = document.getElementById('income-btn');
    const expenseBtn = document.getElementById('expense-btn');
    
    // 모든 active 클래스 제거
    incomeBtn.classList.remove('active');
    expenseBtn.classList.remove('active');
    
    // 현재 선택된 버튼에 active 클래스 추가
    if(currentType === 'income'){
        incomeBtn.classList.add('active');
    } else {
        expenseBtn.classList.add('active');
    }
}

// 필터 버튼에 따른 필터링 함수
function getFilteredAccount(){
    const filteredAcc = []; 
    if(filterState === 'income'){     
        for(let acc of accList){   
            if(acc.accType === 'income'){   
                filteredAcc.push(acc);
            }
        }
    }else if(filterState === 'expense'){    
        for(let acc of accList){
            if(acc.accType === 'expense'){   
                filteredAcc.push(acc);
            }
        }
    }else{  
        return accList;  
    }
    return filteredAcc; 
}

// 가계부 초기화
function resetAccount(){
    while (accList.length > 0) {
        accList.pop();
    }
    saveAccount();
    render();
}

function saveAccount(){
     localStorage.setItem('accList', JSON.stringify(accList)); 
}

function render(){
    historyList.innerHTML ="";
    updateActiveButton();

    const filteredAcc = getFilteredAccount();

    if(filteredAcc.length === 0){ // 필터링 된 할 일 목록이 비어있다면 
        emptyStateRender();  //  빈 상태의 렌더링 
    } else { // 내역 목록이 있는 경우 
        filteredAcc.forEach(function(account){ // 목록의 전체를 렌더링 시키기
            accItemRender(account);
        })
    }
    updateBoard();
}

function emptyStateRender(){    // 내역이 비어있을 경우 화면 출력 관련 함수    
    emptyE1.className = 'empty-state';      
    emptyE1.innerHTML = '가계부를 입력해보세요!';  
    historyList.appendChild(emptyE1);   
}

function accItemRender(account){
    const accItem = document.createElement('div'); // ul 영역 안에 새로운 div 생성
    accItem.className = account.accType === 'income' ? 'income-item' : 'expense-item'; // 수입/지출에 따라 다른 클래스
    // 부호 결정
    const sign = account.accType === 'income' ? '+' : '-';
    // 타입클래스 결정
    const amountClass = account.accType === 'income' ? 'income-amount' : 'expense-amount';
    
    accItem.innerHTML = `   <div class="item-left">
                                <div class="history-date">${account.createdAt}</div>
                                <div class="history-content">${account.accContent}</div>
                            </div>
                            <div class="item-right">
                                <span class="amount ${amountClass}">${sign}${account.accCost.toLocaleString()}원</span>
                                <button class="delete-btn">삭제</button>
                            </div>`; 
    
    // 새로 생성된 요소들 중에서 이벤트가 필요한 부분만 가져오기.
    const deleteBtn = accItem.querySelector('.delete-btn'); // accItem 내부에 있는 deleteBtn요소
    deleteBtn.addEventListener('click', function(){ // 삭제 버튼의 클릭 이벤트 추가
        deleteAccount(account.id); // 눌러진 영역의 내역을 accList에서 삭제
    })
    
    historyList.appendChild(accItem); // 추가되거나 삭제된 내역 목록을 최종적으로 DOM 트리에 업데이트
}

function updateBoard(){
    const allIncome = document.querySelector('.all-income');
    const allExpense = document.querySelector('.all-expense');
    const allAccount = document.querySelector('.account');
    let income = 0;
    let expense = 0;
    let extra = 0;

    for(let acc of accList){
        if(acc.accType === 'income'){
            extra += acc.accCost;
            income += acc.accCost;
        }else if(acc.accType === 'expense'){
            extra -= acc.accCost;
            expense += acc.accCost;
        }
    }
    setCurrentCost(extra);
    allIncome.innerHTML = `${income.toLocaleString()}원`;
    allExpense.innerHTML = `${expense.toLocaleString()}원`;
    allAccount.innerHTML = `${extra.toLocaleString()}원`;
}

function setCurrentCost(extra){
    currentCost.innerHTML = `${extra.toLocaleString()}원`;
}

function setFilter(filter){
    filterState = filter; // 전역 상태에 필터 상태를 변경

    // 모든 필터 버튼의 active클래스를 조회해서 수정
    filterBtns.forEach(function(btn){  //버튼 클릭 이벤트 발생 시 누른 버튼일 경우 className을 active로, 아니라면 ""으로 설정 
        btn.className = (btn.dataset.filter === filter ? "active" : "");   // >> 토글 버튼처럼 설정되는 효과가 있다
    });

    render();  // 필터링 상태 변경이 되었으므로 화면 렌더링
}

document.addEventListener('DOMContentLoaded', init);